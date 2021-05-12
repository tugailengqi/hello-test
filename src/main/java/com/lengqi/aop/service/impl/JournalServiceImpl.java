package com.lengqi.aop.service.impl;

import com.lengqi.aop.service.JournalService;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl implements JournalService {
    @Override
    public boolean add() {
        return true;
    }
}
