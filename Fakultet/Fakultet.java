package Fakultet;

import java.io.*;

public class Fakultet implements SGFakultet, Serializable {
	protected String universityName;
	protected String fakultetName;
	protected int codeFakultet;

	public Fakultet() {
		universityName = "DefaultNameUniversity";
		fakultetName = "DefaultNameFakultet";
		codeFakultet = 1;
	}

	public Fakultet(Fakultet fakultet) {
		universityName = fakultet.universityName;
		fakultetName = fakultet.fakultetName;
		codeFakultet = fakultet.codeFakultet;
	}

	public Fakultet(String uName, String fName, int codeF) {
		universityName = uName;
		fakultetName = fName;
		codeFakultet = codeF;
	}

	public void setUniversityName(String args) {
		universityName = args;
	}

	public void setFakultetName(String args) {
		fakultetName = args;
	}

	public void setCodeFakultet(int code) {
		codeFakultet = code;
	}

	public String getUniversityName() {
		return universityName;
	}

	public String getFakultetName() {
		return fakultetName;
	}

	public int getCodeFakultet() {
		return codeFakultet;
	}

	@Override
	public Fakultet getFakultet() {
		return this;
	}

	@Override
	public void setFakultet(String arg1, String arg2, int arg3) {
		universityName = arg1;
		fakultetName = arg2;
		codeFakultet = arg3;
	}

	@Override
	public void setFakultet(Fakultet f) {
		universityName = f.universityName;
		fakultetName = f.fakultetName;
		codeFakultet = f.codeFakultet;
	}
}
