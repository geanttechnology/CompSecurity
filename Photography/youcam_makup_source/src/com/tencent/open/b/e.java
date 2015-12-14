// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import com.tencent.open.utils.c;
import com.tencent.open.utils.g;

public class e
{

    public static int a()
    {
        int j = g.a(c.a(), null).a("Common_HttpRetryCount");
        int i = j;
        if (j == 0)
        {
            i = 2;
        }
        return i;
    }

    public static int a(String s)
    {
        int j = g.a(c.a(), s).a("Common_BusinessReportFrequency");
        int i = j;
        if (j == 0)
        {
            i = 100;
        }
        return i;
    }
}
