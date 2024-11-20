public class RistoranteDAO implements GenericDAO<Ristorante, Long> {
    private EntityManager em;

    public RistoranteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Ristorante> findAll() {
        return em.createQuery("SELECT r FROM Ristorante r", Ristorante.class).getResultList();
    }

    @Override
    public Ristorante findById(Long id) {
        return em.find(Ristorante.class, id);
    }

    @Override
    public Ristorante create(Ristorante ristorante) {
        em.getTransaction().begin();
        em.persist(ristorante);
        em.getTransaction().commit();
        return ristorante;
    }

    @Override
    public Ristorante update(Ristorante ristorante) {
        em.getTransaction().begin();
        Ristorante updated = em.merge(ristorante);
        em.getTransaction().commit();
        return updated;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Ristorante ristorante = em.find(Ristorante.class, id);
        if (ristorante != null) {
            em.remove(ristorante);
        }
        em.getTransaction().commit();
    }
}
