// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;


// Referenced classes of package com.whatsapp:
//            ho, td

class ht extends ho
{

    final td c;

    ht(td td1, String s, boolean flag)
    {
        c = td1;
        super(s, flag);
    }

    public void a(int i)
    {
        super.a(i);
    }

    public void b(int i)
    {
        super.b(i);
        if (i > 0)
        {
            td.a(c, i);
        }
        td.c(c);
    }
}
