package br.com.jfive.fixture;

import br.com.jfive.model.Cliente;
import br.com.jfive.model.Endereco;
import br.com.jfive.model.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rodrigoalmeida
 * Date: 23/05/13
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */
public class Teste {


    @Test
    public void exampleOne() {

        Fixture.of(Cliente.class).addTemplate("geekCliente",new Rule(){{
            add("id", 1);
            add("nome","Rodrigo Almeida");
            add("email","${nome}@gmail.com");
            add("dataNascimento", new Date());
            add("dataCadastro", new Date());
        }}).addTemplate("nerdClient", new Rule(){{
            add("id", 2);
            add("nome","Luana Almeida");
            add("email","${nome}@gmail.com");
            add("dataNascimento", new Date());
            add("dataCadastro", new Date());
        }});

        Cliente cli = Fixture.from(Cliente.class).gimme("geekCliente");

    }


    @Test
    public void exemplo2() {

        Fixture.of(Telefone.class).addTemplate("brazilianPhoneNumber", new Rule(){{
            add("telefone","11 9999-9999");
        }});

        Fixture.of(Endereco.class).addTemplate("brazilianAddress", new Rule(){{
            add("id",1);
            add("endereco","Rua Martim Afonso de sousa");
            add("cidade", "Santo André");
            add("estado", "São Paulo");
            add("telefones",has(3).of(Telefone.class, "brazilianPhoneNumber"));
        }});


        Fixture.of(Cliente.class).addTemplate("geekCliente",new Rule(){{
            add("id", 1);
            add("nome","Rodrigo Almeida");
            add("email","${nome}@gmail.com");
            add("dataNascimento", new Date());
            add("dataCadastro", new Date());
            add("endereco",one(Endereco.class,"brazilianAddress"));
        }});

        Cliente cli = Fixture.from(Cliente.class).gimme("geekCliente");

    }

    @Test
    public void exemplo3() {

        Fixture.of(Telefone.class).addTemplate("brazilianPhoneNumber", new Rule(){{
            add("telefone",regex("(\\d{2}) (\\d{4}) - (\\d{4})"));
        }});

        Fixture.of(Endereco.class).addTemplate("brazilianAddress", new Rule(){{
            add("id",1);
            add("endereco","Rua Martim Afonso de sousa");
            add("cidade", "Santo André");
            add("estado", "São Paulo");
            add("telefones",has(3).of(Telefone.class, "brazilianPhoneNumber"));
        }});


        Fixture.of(Cliente.class).addTemplate("geekCliente",new Rule(){{
            add("id", 1);
            add("nome",firstName());
            add("email","${nome}@gmail.com");
            add("dataNascimento", new Date());
            add("dataCadastro", new Date());
            add("endereco",one(Endereco.class,"brazilianAddress"));
        }});

        Cliente cli = Fixture.from(Cliente.class).gimme("geekCliente");

    }

    @Test
    public void exemplo4() {

        Fixture.of(Telefone.class).addTemplate("brazilianPhoneNumber", new Rule(){{
            add("telefone",regex("(\\d{2}) (\\d{4}) - (\\d{4})"));
        }});

        Fixture.of(Endereco.class).addTemplate("brazilianAddress", new Rule(){{
            add("id",random(Integer.class,range(1,200)));
            add("endereco","Rua Martim Afonso de sousa");
            add("cidade", "Santo André");
            add("estado", "São Paulo");
            add("telefones",has(3).of(Telefone.class, "brazilianPhoneNumber"));
        }});


        Fixture.of(Cliente.class).addTemplate("geekCliente",new Rule(){{
            add("id", 1);
            add("nome",firstName());
            add("email","${nome}@gmail.com");
            add("dataNascimento", new Date());
            add("dataCadastro", new Date());
            add("endereco",one(Endereco.class,"brazilianAddress"));
        }});

        Cliente cli = Fixture.from(Cliente.class).gimme("geekCliente");

    }

}
