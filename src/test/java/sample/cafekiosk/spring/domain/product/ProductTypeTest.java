package sample.cafekiosk.spring.domain.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductTypeTest {

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containStockType() {
        //given
        ProductType givenType = ProductType.HANDMADE;

        //when
        Boolean result = ProductType.containStockType(givenType);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지 체크한다.")
    void containStockType2() {
        //given
        ProductType givenType = ProductType.BAKERY;

        //when
        Boolean result = ProductType.containStockType(givenType);

        //then
        assertThat(result).isTrue();
    }

}