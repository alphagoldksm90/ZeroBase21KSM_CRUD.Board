📎 ZeroBase 21TH KSM BOARD Project

들어가며
1. 프로젝트 소개
프로젝트를 시작하게 된 계기는 웹 프로그래밍의 기본 소양이라 할 수 있는 게시판을 직접 만들어보며 배우고자 시작하게 되었습니다.
독학으로 관련 기술들을 학습한 이후 제작한 개인 프로젝트이기 때문에 개인적인 만족감을 가지고 있는 프로젝트입니다.

2. 프로젝트 기능
프로젝트의 주요 기능은 다음과 같습니다.

게시판 - CRUD 기능, 조회수, 페이징 및 검색 처리
사용자 - Security 회원가입 및 로그인, OAuth 2.0 구글, 네이버 로그인, 회원정보 수정, 회원가입시 유효성 검사 및 중복 검사
댓글 - CRUD 기능

3. 사용 기술

3-1 백엔드
주요 프레임워크 / 라이브러리
Java 11
SpringBoot
JPA(Spring Data JPA)
Spring Security
OAuth 2.0
Build Tool
Gradle 7.2
DataBase
MySQL

3-2 프론트엔드

Html/Css
JavaScript
Mustache
Bootstrap

구조 및 설계

1. 패키지 구조
패키지 구조 보기

2. DB 설계
![erd 3차 2024-05-17 ~ ]
![posts 테이블 db 설계]
![user 테이블 db 설계]
![comment 테이블 db 설계] created_date와 modified_date는 날짜 포맷을 적용해주기 위해 datetime > varchar로 변경했습니다.


4. API 설계
![게시글 관련 API 설계]
![회원 관련 API 설계 (2)]
![댓글 관련 API 설계v2]

1. 프로젝트 보완사항
초기에 구상한 기능은 기본적인 CRUD 즉, 게시판에 올라오는 게시글을 대상으로 Create, Read, Update, Delete가 가능한 게시판이었습니다.
템플릿 엔진으로 Mustache를 선택했는데, 그 이유는 Mustache는 단순히 화면에 데이터를 렌더링 하는 엔진이고
Logic-less 하기 때문에 View의 역할과 서버의 역할이 명확하게 분리되어 OOP의 5원칙 중 하나인 SRP를 지킬 수 있어
MVC 설계에서 Model, View, Controller의 역할에 대한 구분도 명확하게 할 수 있겠다는 생각이 들었습니다.
또한, 다른 템플릿에 비해 빠른 로딩 속도를 자랑하며, xss를 기본적으로 이스케이프 할 수 있다는 장점들에 이끌려 Mustache를 사용하게 되었습니다.
그러나 게시판 CRUD 기능이 완성되어 갈 때 쯤, 아쉬운 부분이 계속해서 생겨 몇몇 기능들을 추가하게 되었습니다.
mustache는 로직을 넣을 수 없어 그 과정에 데이터를 렌더링 하기 전 서버에서 전처리를 하거나,
화면에 표시된 후에 자바스크립트로 후처리를 해줬지만 조금 아쉬운 부분이 몇 가지 남아있다고 생각합니다.

보완사항

페이징 처리 및 검색 페이징에서 페이지 번호 활성화
페이지 번호는 10페이지 단위로 보여주기
페이지 처음, 끝으로 이동하는 버튼
생성, 수정시간 format 설정 varchar > datetime
다른 사용자와 자신의 댓글이 댓글란에 있을때 자신의 댓글만 수정,삭제 버튼 보이기
