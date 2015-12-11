// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear.shared;

import java.nio.charset.Charset;
import java.util.UUID;

public class StampedMessage
{

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public byte mData[];
    public String mId;

    public StampedMessage()
    {
        mId = UUID.randomUUID().toString();
        mData = null;
    }

    public StampedMessage(String s, byte abyte0[])
    {
        mId = UUID.randomUUID().toString();
        mData = null;
        mId = s;
        mData = abyte0;
    }

    public String dataAsString()
    {
        if (mData == null)
        {
            return null;
        } else
        {
            return new String(mData, UTF_8);
        }
    }

}
