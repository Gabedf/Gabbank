# Functional Requirements

## Introduction

This document describes the functional requirements of the Gabbank system.

Gabbank is a simplified digital wallet platform where users can store and transfer money internally within the system.

The purpose of these requirements is to define the initial system capabilities while allowing gradual domain and architectural evolution over time.

---

# User Management

## FR-01 — Create User

The system must allow the creation of users.

### Initial Data

* Full name
* Email
* Password
* User status

### Rules

* Email must be unique.
* Password must be stored securely.
* New users must start as ACTIVE.

---

## FR-02 — Get User Information

The system must allow querying registered user information.

---

## FR-03 — Deactivate User

The system must allow users to be marked as inactive.

### Rules

* Inactive users cannot perform financial operations.

---

# Wallet Management

## FR-04 — Create Wallet Automatically

The system must automatically create a wallet for a newly created user.

### Rules

* Each user must have exactly one wallet.
* A wallet must always belong to a valid user.

---

## FR-05 — Get Wallet Balance

The system must allow balance consultation for a wallet.

---

## FR-06 — Block Wallet

The system must allow a wallet to be blocked.

### Rules

* Blocked wallets cannot perform financial operations.

---

# Financial Operations

## FR-07 — Deposit Money

The system must allow deposits into a wallet.

### Rules

* Deposit amount must be greater than zero.
* The operation must be recorded in transaction history.

---

## FR-08 — Withdraw Money

The system must allow withdrawals from a wallet.

### Rules

* Withdrawal amount must be greater than zero.
* Wallet balance cannot become negative.
* The operation must be recorded in transaction history.

---

## FR-09 — Transfer Money

The system must allow transfers between wallets.

### Rules

* Origin wallet must have sufficient balance.
* Origin and destination wallets must be active.
* Transfers must be recorded in transaction history.
* The transfer operation must preserve financial consistency.

---

# Transaction History

## FR-10 — Get Transaction History

The system must allow transaction history consultation.

### Possible Filters

* Transaction type
* Date range
* Minimum amount
* Maximum amount

---

# Future Functional Possibilities

The following features are intentionally outside the current MVP scope but may be added in future evolutions:

* Authentication and authorization
* External bank integrations
* PIX-like transfers
* Scheduled transfers
* Notifications
* Fraud detection
* Idempotency keys
* Audit dashboards
* Event streaming
* Administrative panel
* Financial reports
* Currency support
* Multi-wallet support
* Rate limiting
* Transaction reversal flows
* Retry mechanisms
* Distributed processing
