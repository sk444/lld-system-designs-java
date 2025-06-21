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
