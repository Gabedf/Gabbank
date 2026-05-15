# Non-Functional Requirements

## Introduction

This document describes the non-functional requirements of the Gabbank system.

Non-functional requirements define quality attributes, operational constraints, and engineering expectations of the platform.

The purpose of these requirements is to guide system reliability, consistency, security, and maintainability while the platform evolves.

---

# API

## NFR-01 — REST API

The system must expose its functionalities through a RESTful API.

---

## NFR-02 — JSON Communication

The system must use JSON as the primary communication format.

---

# Persistence

## NFR-03 — Relational Database

The system must persist data using a relational database.

### Initial Technology

* PostgreSQL

---

## NFR-04 — Data Persistence

Financial and user data must remain persisted even after system restarts.

---

# Financial Consistency

## NFR-05 — Transactional Consistency

Financial operations must preserve consistency during failures or unexpected interruptions.

### Examples

* Avoid money duplication.
* Avoid lost transactions.
* Avoid partial transfers.

---

## NFR-06 — Atomic Operations

Critical financial operations should execute atomically whenever applicable.

---

# Security

## NFR-07 — Secure Password Storage

User passwords must never be stored in plain text.

---

## NFR-08 — Basic Data Protection

Sensitive information should be protected from unauthorized access.

---

# Observability

## NFR-09 — Logging

The system should generate logs for important operations and failures.

---

## NFR-10 — Error Visibility

Unexpected errors should be traceable for debugging and maintenance purposes.

---

# Maintainability

# Testing

## NFR-11 — Testability

The system architecture should allow automated testing.

---

## NFR-12 — Financial Operation Validation

Critical financial operations should be covered by automated tests.

---

# Performance

## NFR-13 — Acceptable Response Time

The system should maintain acceptable response times for basic financial operations.

---

# Scalability

## NFR-14 — Gradual Scalability

The system should support gradual scalability improvements over time.

### Possible Future Evolutions

* Caching
* Message queues
* Horizontal scaling
* Event-driven processing
* Read/write separation

---

# Deployment

---

# Documentation

## NFR-15 — Technical Documentation

The project should maintain basic technical documentation for architecture, decisions, and domain understanding.

---
