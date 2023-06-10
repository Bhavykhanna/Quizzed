package com.example.quizzed;

public class questions_C {
    private String des;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String ans;

    questions_C(String des,String opt1,String opt2,String opt3,String opt4,String ans){
        this.des=des;
        this.opt1=opt1;
        this.opt2=opt2;
        this.opt3=opt3;
        this.opt4=opt4;
        this.ans=ans;
    }
    public String getDes() {return des;}
    public String getOpt1() {return opt1;}
    public String getOtp2() {return opt2;}
    public String getOpt3() {return opt3;}
    public String getOtp4() {return opt4;}
    public String getAns() {return ans;}
}
