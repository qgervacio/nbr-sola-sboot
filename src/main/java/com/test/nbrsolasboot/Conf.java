// Copyright (c) 2020 Quirino Gervacio

package com.test.nbrsolasboot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Getter
@Component
@NoArgsConstructor
public class Conf {

    @Value("${app.queue.target}")
    private String[] queues;

    @Value("${app.queue.header.retry}")
    private String qHeaderRetry;

    @Value("${app.queue.postfix.park}")
    private String qPostfixPark;

    @Value("${app.queue.postfix.fail}")
    private String qPostfixFail;

    @Value("${app.queue.postfix.fail-retry}")
    private String qPostfixFailRetry;

    @Value("${app.retry.timings}")
    private int[] retryTimings;

    public String[] getFailRetryQueues() {
        return Arrays.stream(this.queues)
            .map(e -> e + this.qPostfixFailRetry)
            .toArray(String[]::new);
    }
}
