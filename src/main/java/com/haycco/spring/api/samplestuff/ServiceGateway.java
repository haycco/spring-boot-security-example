package com.haycco.spring.api.samplestuff;

import com.haycco.spring.domain.DomainUser;
import com.haycco.spring.domain.Stuff;

import java.util.List;

public interface ServiceGateway {
    List<Stuff> getSomeStuff();

    void createStuff(Stuff newStuff, DomainUser domainUser);
}
