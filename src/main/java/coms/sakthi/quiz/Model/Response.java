package coms.sakthi.quiz.Model;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Response {
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	private Integer id;
    private String response;
}