// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import com.amazon.gallery.framework.model.media.MultipartUpload;
import java.util.List;

public interface RemoteStorageDao
{

    public abstract MultipartUpload getMultipartUpload(String s);

    public abstract List getMultipartUploadParts(String s);

    public abstract void putMultipartUpload(MultipartUpload multipartupload);

    public abstract void putMultipartUploadParts(List list);

    public abstract void removeMultipartUpload(String s);

    public abstract void storeMultipartETag(String s, int i, String s1);
}
