package br.com.springbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.springbatch.entity.Cliente;

@Configuration
public class ProcessoBatchDelimitedStepConfig {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step processoBatchDelimitedStep(ItemReader<Cliente> leituraArquivoDelimitadoReader, ItemWriter<Cliente> leituraArquivoDelimitadoWriter) {
		
		return stepBuilderFactory
				.get("processoBatchDelimitedStep")
				.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoDelimitadoReader)
				.writer(leituraArquivoDelimitadoWriter)
				.build();
		
		
	}
	
}
