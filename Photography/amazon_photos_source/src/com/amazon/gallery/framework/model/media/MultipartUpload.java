// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import com.amazon.gallery.framework.model.ObjectID;

public class MultipartUpload
{

    private final String filePath;
    private final long lastModified;
    private final ObjectID objectId;
    private final String storageKey;
    private final String uploadId;

    public MultipartUpload(String s, ObjectID objectid, String s1, String s2, long l)
    {
        filePath = s;
        objectId = objectid;
        storageKey = s1;
        uploadId = s2;
        lastModified = l;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public long getLastModified()
    {
        return lastModified;
    }

    public ObjectID getObjectId()
    {
        return objectId;
    }

    public String getStorageKey()
    {
        return storageKey;
    }

    public String getUploadId()
    {
        return uploadId;
    }
}
