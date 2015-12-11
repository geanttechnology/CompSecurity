// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;

public abstract class o extends e
{

    private final String c = "SafeDataBufferRef";

    public o(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    protected String a(String s, String s1)
    {
        String s2 = s1;
        if (a(s))
        {
            s2 = s1;
            if (!d(s))
            {
                s2 = c(s);
            }
        }
        return s2;
    }

    protected boolean a(String s, boolean flag)
    {
        boolean flag1 = flag;
        if (a(s))
        {
            flag1 = flag;
            if (!d(s))
            {
                flag1 = b(s);
            }
        }
        return flag1;
    }
}
