# 오늘의 식당 추천 서비스
- 사용자의 현재 위치를 기반으로 가장 가까운 식당 10곳을 지도에 시각화하여 추천

## 주요 기능
- 사용자의 현재 위치 기반 식당 추천
- Kakao 지도 위에 마커 및 인포윈도우 출력
- Python (KNN) + Spring Boot 연동을 통한 추천 로직
- 가상 환경 내 머신러닝 모델 실행 및 결과 파싱

## 사용 기술
- Back-end : Spring Boot, Thymeleaf, Lombok, Spring Data JDBC
- Front-end : JavaScript, Kakao Map SDK
- ML Recommendation : Python (Scikit-Learn), KNN, Pickle

## 핵심 구성 요소
1. 브라우저
- JS (DOMContentLoaded, mapLib)
  - 현재 위치 확인, 지도 렌더링

2. Controller
- RestaurantController
  - 요청 수신, 서비스 호출

3. Service
- RestaurantInfoService
  - Python 실행 및 결과 가공

4. Python
- search.py
  - 거리 기반 추천 ID 계산

5. DB
- RestaurantRepository
  - ID 기반 식당 정보 조회

6. Entity
- Restaurant
  - DB 매핑 모델

![대체 텍스트](images/restaurant.png)

# 당뇨 고위험군 진단 설문 서비스
- 개인의 건강 데이터를 기반으로 당뇨병 발병 위험도를 예측하여 조기 진단과 예방조치를 돕는 AI 기반 헬스케어 솔루션 개발

## 주요 기능
- 개인의 생활 습관, 유전자 정보 등 다양한 데이터를 수집 및 분석
- 머신러닝 기반 당뇨병 발병 위험도 예측 모델 개발

## 사용 기술
- Back-end : Spring Boot, Spring JPA, Lombok, Thymeleaf
- Front-end : JavaScript
- ML Recommendation : Python (Scikit-Learn), Logistic Regression, Random Forest, Pickle

## 핵심 구성 요소
1. 브라우저
- JS (사용자 입력)
  - 사용자 건강 데이터 입력 및 결과 시각화

2. Contoller
- DiabetesRiskController
  - 에측 요청 수신 및 결과 반환

3. Service
- RiskPredictionService
  - Python AI 모델 실행 및 예측 결과 가공

4. Python
- predict_diabetes.py
  - 건강 데이터를 바탕으로 당뇨 위험도 예측
  
5. Entity
- UserHealthData
  - 건강 정보 DB 매핑 모델

![대체 텍스트](images/diabetes_step1.png)
![대체 텍스트](images/diabetes_step2.png)