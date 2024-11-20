public class PiattoDAO implements GenericDAO<Piatto, Long> {
    private EntityManager em;

    public PiattoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Piatto> findAll() {
        return em.createQuery("SELECT p FROM Piatto p", Piatto.class).getResultList();
    }

    @Override
    public Piatto findById(Long id) {
        return em.find(Piatto.class, id);
    }

    @Override
    public Piatto create(Piatto piatto) {
        em.getTransaction().begin();
        em.persist(piatto);
        em.getTransaction().commit();
        return piatto;
    }

    @Override
    public Piatto update(Piatto piatto) {
        em.getTransaction().begin();
        Piatto updated = em.merge(piatto);
        em.getTransaction().commit();
        return updated;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Piatto piatto = em.find(Piatto.class, id);
        if (piatto != null) {
            em.remove(piatto);
        }
        em.getTransaction().commit();
    }
}

