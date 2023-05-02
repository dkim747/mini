package com.codingrecipe.member;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEST {
    static String li = "";

    public static void main(String[] args) {
        String url = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern p = Pattern.compile(url);
        String http = "https://naver.com"; //여기에 링크를 넣고 검사

        String title = "";
        String content = "";
        String image = "";

        Matcher matcher = p.matcher(http); //위의 url 패턴과 맞는지 검사
        if (matcher.find()) { //패턴과 맞을 시 실행
            int startIndex = matcher.start(); //주소의 첫 번째 인덱스
            int endIndex = matcher.end(); //주소의 마지막 인덱스
            String exportUrl = http.substring(startIndex, endIndex); // 게시글 내용이 들어있는 변수에서 url만 짜르기

            try {
                Document doc = null;

                doc = Jsoup.connect(exportUrl).header("User-Agent", "Mozilla/5.0").get();
                //Jsoup은 데이터 크롤링 라이브러리 (라이브러리 필수 설치)
                //url주소를 가져와서 페이지 데이터를 수집
                System.out.println(doc); //데이터 출력해보기

                //"오픈그래프 태그에 작성된 타이틀, 내용, 이미지 가져와서 문자열에 담기
                title = doc.select("meta[property=og:title]").attr("content");  // 제목
                content = doc.select("meta[property=og:description]").attr("content"); // 내용
                image = doc.select("meta[property=og:image]").attr("content"); // 이미지

                //문자열 출력
                System.out.println(title); // 제목 출력
                System.out.println(content); // 내용 출력
                System.out.println(image); // 이미지 출력


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}