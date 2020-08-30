package br.com.springbatch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.springbatch.entity.Cliente;

@Configuration
public class LeituraArquivoDelimitadoReaderConfig {
	
	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
			System.out.println("Arquivo => " + arquivoClientes);
			if(arquivoClientes == null || !arquivoClientes.exists()) {
				throw new RuntimeException("Arquivo não encontrado");
			}
		
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoClientes)
				.delimited()
				.delimiter(";")
				.names(new String[] {"nome", "sobrenome", "idade", "email"})
				.targetType(Cliente.class)
				.build();
    }
}
