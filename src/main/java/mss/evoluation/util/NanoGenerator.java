package mss.evoluation.util;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

public class NanoGenerator implements IdentifierGenerator {
	public static final int NANOID_SIZE = 8;
	protected static final char[] DEFAULT_ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			.toCharArray();
	protected static final char[] NUMBER_ARRAY = "0123456789".toCharArray();

	public static String generateID() {
		return NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, NanoGenerator.DEFAULT_ALPHABET,
				NANOID_SIZE);
	}

	public String generate(SharedSessionContractImplementor session, Object obj) {
		Serializable id = session.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, session);
		/*
		 * Checks if the to be persisted object has an id else generates a new ID This
		 * is mainly for the first run initialization that have predefined IDs
		 */
		return id != null ? (String) id
				: NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, NanoGenerator.DEFAULT_ALPHABET,
						NANOID_SIZE);
	}

}
