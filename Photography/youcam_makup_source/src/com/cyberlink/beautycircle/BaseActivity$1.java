// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;


// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity

class a
    implements Runnable
{

    final BaseActivity a;

    public void run()
    {
        if (!a.isFinishing())
        {
            a.e();
        }
    }

    (BaseActivity baseactivity)
    {
        a = baseactivity;
        super();
    }
}
