package com.study.microservices.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
