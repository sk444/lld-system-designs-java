# 📩 Notification System (LLD in Java)

## 🧾 Problem Statement

Design a system that sends notifications to users via multiple channels (Email, SMS, Push), respecting user preferences and handling failures via retry mechanisms.

---

## ❓ Clarifying Questions

| Question | Why It's Important |
|----------|--------------------|
| What types of channels to support? | Impacts which strategies we implement |
| Should we support user preferences? | Decides if fallback is needed |
| Is retry required on failure? | Affects robustness and delivery guarantees |

---

A modular, extensible notification system built using clean code principles and design patterns in Java.

## ✅ Features
- Supports Email, SMS, and Push notifications
- Pluggable Retry Strategy (in-memory now, Kafka-ready later)
- User-specific channel preferences
- Strategy Pattern for pluggable channels
- Graceful fallback on failure
- Easily extendable (e.g., WhatsApp, Retry queue)
- Easily swap retry mechanism (e.g., Kafka, DB, Scheduler)

## 🧠 Pluggable Retry Strategy

The system uses a `RetryHandler` interface. You can swap retry logic easily:

```java
RetryHandler retryHandler = new InMemoryRetryHandler(3);
// OR in future:
// RetryHandler retryHandler = new KafkaRetryHandler();

## This makes it future-proof for:
- Kafka or SQS-based async retry
- Cron-based batch retry
- Circuit breaker integration

## 🧱 Class Design Highlights
- Follows SOLID principles
- Interface segregation via `NotificationChannel`
- Strategy Pattern for dynamic channel invocation
- Clean separation of model, channel, and service layers

📐 Extensibility Ideas
- Add Kafka-based retry queue
- Store user preferences in Redis or DB
- Track notification status in metrics system

## 🧱 Class Design

- `Notification`
- `UserPreference`
- `NotificationChannel` (interface)
- `EmailChannel`, `SMSChannel`, `PushChannel`
- `NotificationService`
- `RetryPolicy`

**Design Patterns Used:** Strategy Pattern, SRP(Single Responsibility Principal)

---

## 🧪 How to Run

```bash
javac src/*.java
java src.Main
