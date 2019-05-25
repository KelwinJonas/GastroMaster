package br.com.ufrpeuag.gastromaster.dados.interfaces;

import br.com.ufrpeuag.gastromaster.negocio.modelo.classes.Garcom;

public interface GarcomDao extends Dao<Garcom> {

	public Garcom verificar(String identificador);

	public Garcom recuperar(String cpf);

}
