package mongodbreactivestockquoteservice.demo;

import mongodbreactivestockquoteservice.demo.client.StockQuoteClient;
import mongodbreactivestockquoteservice.demo.domain.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class QuoteRunner implements CommandLineRunner {

    //This Clients talks to webflux stock quote services project.

    private final StockQuoteClient stockQuoteClient;

    @Autowired
    public QuoteRunner(StockQuoteClient stockQuoteClient) {
        this.stockQuoteClient = stockQuoteClient;
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();

        //Remove take(10) for infinite stream.
        quoteFlux.take(10).subscribe(System.out::println);
    }
}
