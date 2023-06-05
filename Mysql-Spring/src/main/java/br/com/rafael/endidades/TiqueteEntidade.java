package br.com.rafael.endidades;

import br.com.rafael.enums.TipoVeiculo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tiquete")
public class TiqueteEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipoVeiculo;

    @Column(name = "fim_atendimento")
    private LocalDateTime fimAtendimento;

    @Column(name = "inicio_atendimento")
    private LocalDateTime inicioAtendimento;

    private BigDecimal valor;

    private String placa;

    private String cor;

}