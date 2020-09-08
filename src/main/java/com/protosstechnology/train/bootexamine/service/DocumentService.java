package com.protosstechnology.train.bootexamine.service;

import com.protosstechnology.train.bootexamine.entity.Document;

public interface DocumentService {
    public void create(Document document);
    public Document read(Integer id);
    public Document update(Document document);
    public void delete(Integer id);
}
