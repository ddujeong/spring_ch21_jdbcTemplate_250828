package com.ddu.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private String memberid;
	private String memberpw;
	private String membername;
	private int memberage;
}
