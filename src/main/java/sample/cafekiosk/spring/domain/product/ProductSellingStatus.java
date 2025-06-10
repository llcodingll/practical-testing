package sample.cafekiosk.spring.domain.product;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductSellingStatus {

    SELLING("판매중"),
    HOLE("판매 보류"),
    STOP_SELLING("판매 중지");

    private final String text;

    public static List<ProductSellingStatus> forDisplay() {
        return List.of(SELLING, HOLE);
    }
}
