public class RistoranteService {

    private final RistoranteDAO ristoranteDAO;
    private final PiattoDAO piattoDAO;

    public RistoranteService(RistoranteDAO ristoranteDAO, PiattoDAO piattoDAO) {
        this.ristoranteDAO = ristoranteDAO;
        this.piattoDAO = piattoDAO;
    }

    public void addPiattoToRistorante(Long ristoranteId, Long piattoId) {
        Ristorante ristorante = ristoranteDAO.findById(ristoranteId);
        Piatto piatto = piattoDAO.findById(piattoId);

        if (ristorante != null && piatto != null) {
            ristorante.getPiatti().add(piatto);
            piatto.getRistoranti().add(ristorante);

            ristoranteDAO.update(ristorante);
            piattoDAO.update(piatto);
        } else {
            throw new IllegalArgumentException("Ristorante o Piatto non trovato");
        }
    }

    public void removePiattoFromRistorante(Long ristoranteId, Long piattoId) {
        Ristorante ristorante = ristoranteDAO.findById(ristoranteId);
        Piatto piatto = piattoDAO.findById(piattoId);

        if (ristorante != null && piatto != null) {
            ristorante.getPiatti().remove(piatto);
            piatto.getRistoranti().remove(ristorante);

            ristoranteDAO.update(ristorante);
            piattoDAO.update(piatto);
        } else {
            throw new IllegalArgumentException("Ristorante o Piatto non trovato");
        }
    }
}
