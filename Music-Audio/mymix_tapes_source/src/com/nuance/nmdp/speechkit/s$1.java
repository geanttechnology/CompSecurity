// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            s, x

final class c
    implements Runnable
{

    private String a;
    private int b;
    private String c;
    private s d;

    public final void run()
    {
        boolean flag1 = true;
        s s1 = d;
        s s2 = d;
        m m = s.a(d).c();
        String s3 = a;
        boolean flag;
        if (b == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (b != 2)
        {
            flag1 = false;
        }
        s.a(s1, s2.a(m, s3, flag, flag1, c, s.b(d), new <init>(d)));
    }

    (s s1, String s2, int i, String s3)
    {
        d = s1;
        a = s2;
        b = i;
        c = s3;
        super();
    }
}
