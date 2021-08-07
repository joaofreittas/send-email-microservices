package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "email")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(columnDefinition = "TEXT")
	private String text;

	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	private LocalDateTime sendDateEmail;
	private StatusEmail status;

}
