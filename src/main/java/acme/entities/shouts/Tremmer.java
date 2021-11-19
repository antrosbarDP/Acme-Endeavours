package acme.entities.shouts;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tremmer extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotNull
	protected Date			deadline;

	@NotEmpty
	@Column(unique=true)
	protected String		tracker;
	
	@NotNull
	protected Money		budget;
	
	@NotNull
	protected Boolean		important;
	

	// Derived attributes -----------------------------------------------------
		
	// Relationships ----------------------------------------------------------
}
