package hello.jdbc.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.jdbc.domain.Member;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberRepositoryV0Test {

	MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

	@Test
	void crud() throws SQLException {
		Member member = new Member("memberV4", 10000);
		repositoryV0.save(member);

		//findById
		Member findMember = repositoryV0.findById(member.getMemberId());
		log.info("findMember={}", findMember);
		assertThat(findMember).isEqualTo(member);
	}
}
