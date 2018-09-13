package mongodbreactivestockquoteservice.demo.repositories;

import mongodbreactivestockquoteservice.demo.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteRepositories extends ReactiveMongoRepository<Quote, String> {
}
