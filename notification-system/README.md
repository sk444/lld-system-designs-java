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
- User-specific channel preferences
- Strategy Pattern for pluggable channels
- Graceful fallback on failure
- Easily extendable (e.g., WhatsApp, Retry queue)

## 🧱 Class Design Highlights
- Follows SOLID principles
- Interface segregation via `NotificationChannel`
- Strategy Pattern for dynamic channel invocation
- Clean separation of model, channel, and service layers

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
