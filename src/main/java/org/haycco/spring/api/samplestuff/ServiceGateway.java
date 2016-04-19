package org.haycco.spring.api.samplestuff;

import java.util.List;

import org.haycco.spring.domain.DomainUser;
import org.haycco.spring.domain.Stuff;

public interface ServiceGateway {
    List<Stuff> getSomeStuff();

    void createStuff(Stuff newStuff, DomainUser domainUser);
}
