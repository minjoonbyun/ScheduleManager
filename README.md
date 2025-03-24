# ScheduleManager

## 1. 개요
일정을 생성, 조회, 수정, 삭제할 수 있는 API입니다.

|기능|메소드|URL|Request|Response|
|------|---|---|---|------|
|일정등록|POST|/api/schedules|{<br/>"name":"변민준",<br/>"password":"1234",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|{<br/>"id":1,<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정조회|GET|/api/schedules/{id}| |{<br/>"id":1,<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정목록|GET|/api/schedules| |{<br/>"id":1,<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정수정|PUT|/api/schedules{id}|{<br/>"name":"변민준",<br/>"password":"1234",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|{<br/>"message":"수정성공",<br/>"name":"변민준",<br/>"todo":"코딩",<br/>"date":"2025-03-24"<br/>}|
|일정삭제|DELETE|/api/schedules{id}| |{<br/>"message":"수정성공"<br/>}|
 
