// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;


public class ProductSpecificBinaryDataHolder
{

    private byte mData[];
    private String mMimeType;
    private String mName;

    ProductSpecificBinaryDataHolder(String s, String s1, byte abyte0[])
    {
        mName = s;
        mMimeType = s1;
        mData = abyte0;
    }

    public byte[] getData()
    {
        return mData;
    }

    public String getMimeType()
    {
        return mMimeType;
    }

    public String getName()
    {
        return mName;
    }
}
