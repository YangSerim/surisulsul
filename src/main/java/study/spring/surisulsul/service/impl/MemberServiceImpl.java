package study.spring.surisulsul.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import study.spring.surisulsul.model.Member;
import study.spring.surisulsul.service.MemberService;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	/** MyBatis 세션 객체 주입 설정 */
	@Autowired
	SqlSession sqlSession;

	/** 회원 정보 조회 (단일) **/
	@Override
	public Member getMemberItem(Member input) throws Exception {
		Member result = null;

		try {
			result = sqlSession.selectOne("MemberMapper.selectMember", input);

			if (result == null) {
				throw new NullPointerException("result=null");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	/** 이메일 찾기 시 회원 정보 조회 */
	@Override
	public Member getMemberEmail(Member input) throws Exception {
		Member result = null;

		try {
			result = sqlSession.selectOne("MemberMapper.findEmail", input);

			if (result == null) {
				throw new NullPointerException("result=null");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	/** 로그인 시 회원 정보 조회 */
	@Override
	public Member getMemberLogin(Member input) throws Exception {
		Member result = null;

		try {
			result = sqlSession.selectOne("MemberMapper.loginMember", input);

			if (result == null) {
				throw new NullPointerException("result=null");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	/** 회원 목록 조회 (관리자용) */
	@Override
	public List<Member> getMemberList(Member input) throws Exception {
		List<Member> result = null;

		try {
			result = sqlSession.selectList("MemberMapper.selectList", input);

			if (result == null) {
				throw new NullPointerException("result=null");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int addMember(Member input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert("MemberMapper.addMember", input);
			if (result == 0) {
				throw new NullPointerException("result = 0");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 저장에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int editMember(Member input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update("MemberMapper.updateMember", input);
			if (result == 0) {
				throw new NullPointerException("result = 0");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("수정된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 수정에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int deleteMember(Member input) throws Exception {
		int result = 0;

		try {
			// 회원 정보 삭제 전, 회원 정보를 참조하고 있는 데이터들의 삭제가 선행되어야 함
			// sqlSession.update("basketMapper.unsetProfessor",input);
			result = sqlSession.delete("MemberMapper.deleteMember", input);
			if (result == 0) {
				throw new NullPointerException("result = 0");
			}
		} catch (NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 삭제에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int getJoinEmailCount(Member input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("MemberMapper.chkEmailJoin", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int getPasswordCount(Member input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("MemberMapper.findPwCount", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int getLoginEmailCount(Member input) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("MemberMapper.chkEmailLogin", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

}
