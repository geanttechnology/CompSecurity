// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.services.k;

public class m extends k
{

    private static final String TRUE = "Y";
    private String mFromCart;
    private String mToken;

    public m(boolean flag, String s)
    {
        String s1;
        if (flag)
        {
            s1 = "Y";
        } else
        {
            s1 = null;
        }
        mFromCart = s1;
        mToken = s;
    }
}
