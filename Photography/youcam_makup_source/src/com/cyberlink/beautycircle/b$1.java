// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;


// Referenced classes of package com.cyberlink.beautycircle:
//            b, BaseActivity

class a
    implements Runnable
{

    final b a;

    public void run()
    {
        if (BaseActivity.c(a.a) != null)
        {
            a.a.a(BaseActivity.c(a.a), true);
            return;
        } else
        {
            a.a.m();
            return;
        }
    }

    Activity(b b1)
    {
        a = b1;
        super();
    }
}
