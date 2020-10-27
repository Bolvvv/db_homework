package org.scu_db.demo.service.impl;

import org.scu_db.demo.Repository.TitleRepository;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TitleService")
public class TitleServiceImpl implements TitleService {
    @Autowired
    private TitleRepository titleRepository;


}
