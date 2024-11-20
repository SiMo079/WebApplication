@Entity
public class Piatto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;
    private Double prezzo;

    @ManyToMany(mappedBy = "piatti", cascade = CascadeType.ALL)
    private Set<Ristorante> ristoranti = new HashSet<>();

    // Costruttori, getter e setter
}
