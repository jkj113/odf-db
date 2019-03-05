package osf.vo;

public class StudentInfoVO {
	private Integer siNum;
	private String siId;
	private String siPwd;
	private String siName;
	private Integer siAge;
	private String siPhone;
	private Integer ciNum;
	public Integer getSiNum() {
		return siNum;
	}
	public void setSiNum(Integer siNum) {
		this.siNum = siNum;
	}
	public String getSiId() {
		return siId;
	}
	public void setSiId(String siId) {
		this.siId = siId;
	}
	public String getSiPwd() {
		return siPwd;
	}
	public void setSiPwd(String siPwd) {
		this.siPwd = siPwd;
	}
	public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
	public Integer getSiAge() {
		return siAge;
	}
	public void setSiAge(Integer siAge) {
		this.siAge = siAge;
	}
	public String getSiPhone() {
		return siPhone;
	}
	public void setSiPhone(String siPhone) {
		this.siPhone = siPhone;
	}
	public Integer getCiNum() {
		return ciNum;
	}
	public void setCiNum(Integer ciNum) {
		this.ciNum = ciNum;
	}
	@Override
	public String toString() {
		return "StudentInfoVO [siNum=" + siNum + ", siId=" + siId + ", siPwd=" + siPwd + ", siName=" + siName
				+ ", siAge=" + siAge + ", siPhone=" + siPhone + ", ciNum=" + ciNum + "]";
	}
}
