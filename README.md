# ScheduleManager

## 1. API
일정을 생성, 조회, 수정, 삭제할 수 있는 API입니다.

|기능|메소드|URL|Request|Response|
|------|---|---|---|------|
|일정등록|POST|/api/schedules|{<br/>"name":"변민준",<br/>"password":"1234",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|{<br/>"id":1,<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정조회|GET|/api/schedules/{id}| |{<br/>"id":1,<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정목록|GET|/api/schedules| |{<br/>"id":1,<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정수정|PUT|/api/schedules{id}|{<br/>"name":"변민준",<br/>"password":"1234",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|{<br/>"message":"수정성공",<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정삭제|DELETE|/api/schedules{id}| |{<br/>"message":"수정성공"<br/>}|

|기능|메소드|URL|Request|Response|
|------|---|---|---|------|
|유저 생성 (회원가입)|POST|/api/users|{<br/>"name":"변민준",<br/>"email":"bms0615@naver.com",<br/>"password":"1234"<br/>}|{<br/>"id":1,<br/>"name":"변민준",<br/>"email":"bms0615@naver.com",<br/>"createdAt":"2025-03-24 12:00:00",<br/>"updatedAt":"2025-03-24 12:00:00"<br/>}|
|유저 조회 (단건)|GET|/api/users/{id}| |{<br/>"id":1,<br/>"name":"변민준",<br/>"email":"bms0615@naver.com",<br/>"createdAt":"2025-03-24 12:00:00",<br/>"updatedAt":"2025-03-24 12:00:00"<br/>}|
|유저 목록 조회|GET|/api/users| |[{<br/>"id":1,<br/>"name":"변민준",<br/>"email":"bms0615@naver.com",<br/>"createdAt":"2025-03-24 12:00:00",<br/>"updatedAt":"2025-03-24 12:00:00"<br/>},<br/>{<br/>"id":2,<br/>"name":"홍길동",<br/>"email":"hong@example.com",<br/>"createdAt":"2025-03-24 12:10:00",<br/>"updatedAt":"2025-03-24 12:10:00"<br/>}]|
|유저 정보 수정|PUT|/api/users/{id}|{<br/>"name":"변민준 수정",<br/>"email":"bms0615@naver.com",<br/>"password":"5678"<br/>}|{<br/>"id":1,<br/>"name":"변민준 수정",<br/>"email":"bms0615@naver.com",<br/>"createdAt":"2025-03-24 12:00:00",<br/>"updatedAt":"2025-03-24 12:30:00"<br/>}|
|유저 삭제|DELETE|/api/users/{id}| |{<br/>"message":"유저 삭제 성공"<br/>}|


 
## 2. ERD
![image](https://github.com/user-attachments/assets/4b453e2d-bc50-46e2-a8d1-f064c3a097e1)

## 2-1 . ERD 수정

![image](https://github.com/user-attachments/assets/6ad351c1-fc84-495e-9dca-c0a6893845c8)

