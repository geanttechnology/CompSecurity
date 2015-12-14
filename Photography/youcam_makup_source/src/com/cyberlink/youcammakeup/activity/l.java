// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.camera.u;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            GpuBenchmarkActivity

class l extends Thread
{

    final GpuBenchmarkActivity a;

    private l(GpuBenchmarkActivity gpubenchmarkactivity)
    {
        a = gpubenchmarkactivity;
        super();
    }

    l(GpuBenchmarkActivity gpubenchmarkactivity, GpuBenchmarkActivity._cls1 _pcls1)
    {
        this(gpubenchmarkactivity);
    }

    public void run()
    {
        try
        {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        a.runOnUiThread(new Runnable() {

            final l a;

            public void run()
            {
                GpuBenchmarkActivity.a(a.a).b();
            }

            
            {
                a = l.this;
                super();
            }
        });
    }
}
