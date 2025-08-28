package com.ddu.member.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ddu.member.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired // DI -> 컨테이너에 생성된 bean(객체) 를 자동 주입
	JdbcTemplate jdbcTemplate;
	
	// INSERT문 구현 -> 회원 추가
	public void insertMember(String memberid, String memberpw, String membername, int memberage) {
		String sql = "INSERT INTO membertbl VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, memberid, memberpw, membername, memberage);
		// 정보 입력한 레코드 수를 반환( 성공 1, 실패 0)
	}
	public void deleteMember(String memberid) {
		String sql = "DLETE FROM membertbl WHERE memberid=?";
		jdbcTemplate.update(sql, memberid);
		// 정보 삭제한 레코드 수를 반환(기본키로 삭제 -> 성공 1, 실패 0)
	}
	public void updateMember(String memberid, String memberpw, String membername, int memberage) {
		String sql = "UPDATE membertbl SET memberpw=?, membername=?, memberage=? WHERE memberid=?";
		jdbcTemplate.update(sql, memberid,memberpw, membername, memberage);
		// 정보 수정한 레코드 수를 반환(기본키로 검색 -> 성공 1, 실패 0)
	}
	public MemberDto searchMember(String memberid) {
		String sql = "SELECT * FROM membertbl WHERE memberid=?";
		
		//MemberDto mDto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<MemberDto>(MemberDto.class), memberid );
		//return mDto;
		
		return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<MemberDto>(MemberDto.class), memberid );
	}
	public List<MemberDto> searchMembers() {
		String sql = "SELECT * FROM membertbl";
		
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<MemberDto>(MemberDto.class) );
	}
}
