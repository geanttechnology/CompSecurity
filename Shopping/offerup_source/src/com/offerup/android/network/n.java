// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.IndexedItemPostPhoto;
import com.offerup.android.dto.S3Photo;

final class n
{

    private final IndexedItemPostPhoto a;
    private final S3Photo b;

    private n(IndexedItemPostPhoto indexeditempostphoto, S3Photo s3photo)
    {
        b = s3photo;
        a = indexeditempostphoto;
    }

    n(IndexedItemPostPhoto indexeditempostphoto, S3Photo s3photo, byte byte0)
    {
        this(indexeditempostphoto, s3photo);
    }

    static S3Photo a(n n1)
    {
        return n1.b;
    }

    static IndexedItemPostPhoto b(n n1)
    {
        return n1.a;
    }
}
