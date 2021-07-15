# **cheerup-BE**

## **📕 개요**

- 명칭 : cheerup
- 개발 인원 : 5명
    - Front end: **노예찬, 박경준**
    - Back end: **박응수, 김선용, 이중원**
- 개발 기간 : 2021.07.09 ~ 2021.07.15
- 주요 기능
    - 유저가 고민을 적으면 랜덤으로 고민에 대한 해결책을 제시해줌. (마법의 고민해결책 컨셉 차용)
    - 게시글과 댓글에 대한 CRUD
    - JWT를 이용한 로그인
- 스택 : react/spring
- 형상 관리 툴 : git
- 협업 툴 : [notion](https://www.notion.so/22-1fc891afa24f457aac4aac2cb320a79f)
- 간단 소개 : 리액트 - 스프링 게시판 기능을 통한 고민해결 사이트.

## **☝🏻 프로젝트 특징**

- 프론트엔드와 백엔드를 분리하여 프로젝트 개발
    - 각 파트별로 Repository를 생성 후 작업
    - 프론트: AWS S3
    - 백엔드: AWS EC2
    - DB : AWS RDS
    - 빌드 후, S3와 EC2를 연동
        - API 명세서에 따라 API호출 및 응답 확인
    - 로그인 시 JWT, 쿠키 사용


## **🎈 개발 환경  **
    - 프론트: AWS S3
    - 백엔드: AWS EC2
    - DB : AWS RDS
 
   - Framwork : spring
   - IntelliJ Ultimate  
gradle-7.1.1  
Java 8  
SpringBoot 2.5.2  

 - 의존성 추가  
Lombok  
Web  
Security  
Jpa  
MySql  

📃 API 설계
| 페이지                 | URI                        | 기능                            | method | 요청                                                         | 응답                                                         |
| ---------------------- | -------------------------- | ------------------------------- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 메인                   | /saying                    | 명언 랜덤 가져오기              | GET    |                                                              | { "saying":"명언" }                                          |
| 메인                   | /article                   | 게시글 글쓰기                   | POST   | {     "username": "임꺽정",     "content": "내용",     "saying": "명언" } |                                                              |
| 게시판                 | /article                   | 게시글 가져오기                 | GET    |                                                              | {    "articles": [     {     "id": "123",     "username": "park",     "content": "내용",     "saying": "명언",     "commentsCount": 5     "createdAt": "12:33"      },      { ...}     ] } |
| 게시판                 | /article/{id}              | 게시글 삭제                     | DELETE |                                                              |                                                              |
| 게시판 ㅡ> 게시글 내부 | /article/{id}              | 특정 게시글 가져오기            | GET    |                                                              | {     "id": "123"     "username": "임꺽정",     "content": "내용",     "saying": "명언"     "createdAt": "12:33" } |
| 게시글 내부            | /comment/{articleId}       | 댓글 가져오기                   | GET    |                                                              | {    "comments": [     {     "_id": "124"     "username": "임꺽정",     "comment": "댓글",     "createdAt": "12:33"      },      { ...}     ] } |
| 게시글 내부            | /comment                   | 댓글 쓰기                       | POST   | {     "username": "임꺽정",     "comment": "댓글"     "articleId": "articleId" } |                                                              |
| 게시글 내부            | /comment/{id}              | 댓글 수정                       | PUT    | {     "username": "임꺽정",     "comment": "수정댓글"     "articleId": "articleId" } |                                                              |
| 게시글 내부            | /comment/{id}              | 댓글 삭제                       | DELETE |                                                              |                                                              |
| 로그인                 | /user/login                | 로그인                          | POST   | {     "username": "testID",     "password": "pAssword7@" }   | JWT토큰                                                      |
| 로그아웃               | /user/logout               | 로그아웃                        | GET    |                                                              |                                                              |
| 회원가입               | /user/signup               | 회원가입                        | POST   | {     "username": "testID",     "password": "pAssword7@",     "passwordChecker": "pAssword7@" } username 과 일치하는 password는 불가함 password 는 대,소문자,숫자,특수문자를 포함 |                                                              |
| 카카오                 | /user/kakao/callback       | 카카오 로그인                   | GET    |                                                              |                                                              |
| 게시글 좋아요          | /likeIt                    | 좋아요 전체 조회                | GET    |                                                              |                                                              |
| 게시글 좋아요          | /likeIt/{articleId}        | 게시글 Id 별 좋아요 조회        | GET    |                                                              |                                                              |
| 게시글 좋아요          | /likeItCounter             | 좋아요 총 개수                  | GET    |                                                              |                                                              |
| 게시글 좋아요          | /likeIt                    | 좋아요 입력, 취소               | POST   | { "username" : "이순신",    "articleId" :125  }              | Id likeIt / likeIt cancelled                                 |
| 댓글 좋아요            | /commentLikeIt             | (댓글 좋아요 전체 조회)         | GET    |                                                              | { "_id" : "125",    "username" : "장보고",    "commentId" : "231"  }... |
| 댓글 좋아요            | /commentLikeIt/{commentId} | (댓글 ID 별로 댓글 좋아요 조회) | GET    |                                                              | {"username":"임꺽정", "commentId":"24", }...                 |
| 댓글 좋아요            | /commentLikeItCounter      | (댓글 좋아요 총개수 조회)       | GET    |                                                              | 22                                                           |
| 댓글 좋아요            | /commentLikeIt             | ( 댓글 좋아요 입력, 취소)       | POST   | {"username":"임꺽정",  "commentId":"24",  }                  | {id commentLikeIt! id commentLikeIt cancelled!}              |

