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