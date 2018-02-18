package com.sapient.demo.parser;

import java.io.Serializable;

import com.sapient.demo.inputTransactions.Identifiable;
import com.sapient.demo.inputTransactions.Lookup;

public class FileType extends Lookup implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public FileType(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public enum Name implements Identifiable<FileType> {
		xlsx(1), PDF(2), txt(3);
		private long id;

		Name(int id) {
			this.id = id;
		}

		@Override
		public String constantName() {
			return this.name();
		}

		@Override
		public long id() {
			// TODO Auto-generated method stub
			return this.id();
		}

		@Override
		public FileType instance() {
			
			return new FileType(this.id);
		}

	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	
	

	
}
