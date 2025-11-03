# Spring Boot on AWS EKS

A production-ready Spring Boot application deployed on AWS EKS with complete CI/CD automation.

## Features

- Spring Boot 3.2 with Java 17
- MySQL Database (AWS RDS)
- Docker containerization
- Kubernetes orchestration (AWS EKS)
- Terraform infrastructure as code
- GitHub Actions CI/CD pipeline
- Auto-scaling with HPA
- Comprehensive logging

## Prerequisites

- AWS Account
- AWS CLI configured
- Terraform >= 1.0
- kubectl
- Docker
- Git

## Quick Start

See [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md) for detailed instructions.

## API Endpoints

- `GET /api/users` - List all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user
- `GET /actuator/health` - Health check

## License

MIT
# Deployed with GitHub Actions 🚀
