package br.com.springbatch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.springbatch.entity.Cliente;

@Configuration
public class LeituraArquivoDelimitadoWriterConfig {
	@Bean
	public ItemWriter<Cliente> leituraArquivoDelimitadoWriter() {
		return items -> items.forEach(System.out::println);
	}
}
