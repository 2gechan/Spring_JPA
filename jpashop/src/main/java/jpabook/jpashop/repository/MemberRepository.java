package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        // 영속성 컨텍스트에 member를 담고 insert 한다.
        em.persist(member);
    }

    public Member findOne(Long id) {
        // find : 단건 조회
        return em.find(Member.class, id);

    }

    public List<Member> findAll() {
        // jpql
        // jpql에서는 from의 대상이 테이블이 아닌 엔티티이다.
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {

        // setParameter를 통해 파라미터를 주입해준다.
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
    }
}
