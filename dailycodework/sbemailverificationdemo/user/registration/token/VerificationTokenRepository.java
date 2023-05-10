package com.dailycodework.sbemailverificationdemo.user.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;



public interface VerificationTokenRepository extends JpaRepository<Verificationtoken, Long> {
}
