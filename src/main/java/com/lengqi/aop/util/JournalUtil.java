package com.lengqi.aop.util;

import com.lengqi.aop.mapper.JournalMapper;
import com.lengqi.aop.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional
public class JournalUtil {

    @Autowired
    private JournalMapper journalMapper;

//    @Resource
//    private Journal journal;

    /**
     * 添加日志
     * @param modeularType
     * @param operationType
     * @param uid
     */
    public void addJournalInfo(int modeularType,int operationType,int uid){
        Journal journal = new Journal();
        journal.setModulartype(modeularType);
        journal.setOperationtype(operationType);
        journal.setUid(uid);
        journalMapper.insert(journal);
    }
}
