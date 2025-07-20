package com.nexfincorp.mms.service.audit;

import com.nexfincorp.mms.dto.UserPrincipal;
import com.nexfincorp.mms.util.Constants;
import java.util.Optional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

  @Autowired
  private ObjectProvider<UserPrincipal> userPrincipalProvider;

  @Override
  public Optional<Long> getCurrentAuditor() {
    try {
      final UserPrincipal principal = userPrincipalProvider.getIfAvailable();
      return Optional.ofNullable(principal)
          .map(UserPrincipal::getId)
          .or(() -> Optional.of(Constants.SYSTEM_USER_ID));
    } catch (Exception ex) {
      return Optional.of(Constants.SYSTEM_USER_ID);
    }
  }
}
