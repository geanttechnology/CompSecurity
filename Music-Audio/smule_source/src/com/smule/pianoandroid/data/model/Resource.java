// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import java.util.Date;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            Product

public class Resource
{

    public static final String COLUMN_NAME_CONTENT_TYPE = "content_type";
    public static final String COLUMN_NAME_FILE_SIZE = "file_size";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_PRODUCT = "product";
    public static final String COLUMN_NAME_UID = "uid";
    public static final String COLUMN_NAME_URL = "url";
    public static final String COLUMN_NAME_URL_EXPIRES_AT = "url_expires_at";
    public int _id;
    public String contentType;
    public int fileSize;
    public String name;
    public Product product;
    public String uid;
    public String url;
    public Date urlExpiresAt;

    public Resource()
    {
    }

    public void copyLocal(Resource resource)
    {
        _id = resource._id;
        product = resource.product;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((Resource)obj);
    }

    public String equatableId()
    {
        return uid;
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }
}
