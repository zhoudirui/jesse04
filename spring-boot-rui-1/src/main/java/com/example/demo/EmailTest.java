package com.example.demo;

/**
 * Created by kevin on 2017/12/25.
 */
public class EmailTest {

    private String form;
    private String to ;
    private String subject;
    private String content;
    public EmailTest(){}
    public EmailTest(String form,String to,String subject,String content){
        super();
        this.form = form;
        this.to= to ;
        this.subject = subject;
        this.content = content;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
