package sample.cafekiosk.spring.domain.product;

import static java.util.stream.Stream.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static sample.cafekiosk.spring.domain.product.ProductType.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductTypeTest {

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containStockType() {
        //given
        ProductType givenType = HANDMADE;

        //when
        Boolean result = ProductType.containStockType(givenType);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containStockType2() {
        //given
        ProductType givenType = BAKERY;

        //when
        Boolean result = ProductType.containStockType(givenType);

        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    @CsvSource({"HANDMADE, false", "BOTTLE, true", "BAKERY, true"})
    void containStockType3(ProductType productType, boolean expected) {
        //when
        boolean result = ProductType.containStockType(productType);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideProductTypesForCheckingStockType() {
        return of(
            Arguments.of(HANDMADE, false),
            Arguments.of(BOTTLE, true),
            Arguments.of(BAKERY, true)
        );
    }

    @ParameterizedTest
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    @MethodSource("provideProductTypesForCheckingStockType")
    void containStockType4(ProductType productType, boolean expected) {
        //when
        boolean result = ProductType.containStockType(productType);

        //then
        assertThat(result).isEqualTo(expected);
    }

}