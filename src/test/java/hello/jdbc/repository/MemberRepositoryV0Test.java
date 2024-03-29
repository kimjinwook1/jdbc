package hello.jdbc.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import hello.jdbc.domain.Member;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberRepositoryV0Test {

	MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

	@Test
	void crud() throws SQLException {
		Member member = new Member("memberV100", 10000);
		repositoryV0.save(member);

		//findById
		Member findMember = repositoryV0.findById(member.getMemberId());
		log.info("findMember={}", findMember);
		assertThat(findMember).isEqualTo(member);

		//update: money: 10000 => 20000
		repositoryV0.update(member.getMemberId(), 20000);
		Member updateMember = repositoryV0.findById(member.getMemberId());
		assertThat(updateMember.getMoney()).isEqualTo(20000);

		//delete
		repositoryV0.delete(member.getMemberId());
		assertThatThrownBy(() -> repositoryV0.findById(member.getMemberId()))
			.isInstanceOf(NoSuchElementException.class);
	}
}
