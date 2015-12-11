// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;

class q
{

    private final String a = "Kahuna";
    private final String b;

    q(String s)
    {
        b = s;
    }

    protected transient void a(int i, String s, Object aobj[])
    {
        if (Log.isLoggable(a, i))
        {
            s = String.format(s, aobj);
            Log.println(i, a, (new StringBuilder()).append(b).append(s).toString());
        }
    }
}
