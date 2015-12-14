// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import java.util.TimerTask;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity

class b extends TimerTask
{

    final BaseActivity a;

    private b(BaseActivity baseactivity)
    {
        a = baseactivity;
        super();
    }

    b(BaseActivity baseactivity, BaseActivity._cls1 _pcls1)
    {
        this(baseactivity);
    }

    public void run()
    {
        a.runOnUiThread(new Runnable() {

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

            
            {
                a = b.this;
                super();
            }
        });
    }
}
