// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.services.k;

public class l extends k
{

    private static final String CHANNEL_MOBILE = "mobile";
    private static final String TRUE = "Y";
    private String mChannel;
    private String mFromCart;

    public l(boolean flag)
    {
        mChannel = "mobile";
        String s;
        if (flag)
        {
            s = "Y";
        } else
        {
            s = null;
        }
        mFromCart = s;
    }
}
