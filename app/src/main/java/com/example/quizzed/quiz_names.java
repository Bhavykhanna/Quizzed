package com.example.quizzed;

import java.util.Map;

public class quiz_names {
    private String quiz_name_name;
    private String quiz_date;
    private String questions;
    public Map<String,questions_C> Map;

    public Map<String, questions_C> getMap() {
        return Map;
    }

    public String getQuestions(){return questions;}
    public String getQuiz_name() {
        return quiz_name_name;
    }
    public String getQuiz_date(){ return quiz_date;}



   quiz_names(String quiz_name_name,String quiz_date,String questions,Map mutablemap){
        this.questions=questions;
        this.quiz_name_name=quiz_name_name;
        this.quiz_date=quiz_date;
        this.Map=mutablemap;
   }
}
