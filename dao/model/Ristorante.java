@Entity
public class Ristorante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String indirizzo;
    private String telefono;

    @ManyToMany
    @JoinTable(
        name = "ristorante_piatto",
        joinColumns = @JoinColumn(name = "ristorante_id"),
        inverseJoinColumns = @JoinColumn(name = "piatto_id")
    )
    private Set<Piatto> piatti = new HashSet<>();

    // Costruttori, getter e setter
}
