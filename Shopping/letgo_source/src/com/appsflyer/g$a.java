// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import java.util.Date;

// Referenced classes of package com.appsflyer:
//            g

public static class Time
{

    private String a;
    private long b;

    public (String s)
    {
        a = s;
        b = (new Date()).getTime();
    }
}
