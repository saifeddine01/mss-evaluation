package mss.evoluation.util;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 5084080898724197164L;
	@Id
	@GeneratedValue(generator = "nano-generator")
	@GenericGenerator(name = "nano-generator", strategy = "mss.evoluation.util.NanoGenerator")
	private String code;

}
