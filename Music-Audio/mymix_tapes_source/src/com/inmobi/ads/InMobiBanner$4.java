// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Message;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner, k, InMobiAdRequestStatus

class a
    implements a
{

    final InMobiBanner a;

    public void a()
    {
        if (InMobiBanner.access$800(a) == null || !InMobiBanner.access$800(a).z())
        {
            InMobiBanner.access$1100(a, new InMobiBanner.a() {

                final InMobiBanner._cls4 a;

                public void a()
                {
                    InMobiBanner.access$900(a.a).sendEmptyMessage(1);
                    InMobiBanner.access$1000(a.a);
                }

            
            {
                a = InMobiBanner._cls4.this;
                super();
            }
            });
        }
    }

    public void a(InMobiAdRequestStatus inmobiadrequeststatus)
    {
        Message message = Message.obtain();
        message.what = 2;
        message.obj = inmobiadrequeststatus;
        InMobiBanner.access$900(a).sendMessage(message);
        InMobiBanner.access$1000(a);
    }

    public void a(Map map)
    {
        Message message = Message.obtain();
        message.what = 5;
        message.obj = map;
        InMobiBanner.access$900(a).sendMessage(message);
    }

    public void b()
    {
        InMobiBanner.access$900(a).sendEmptyMessage(3);
    }

    public void b(Map map)
    {
        Message message = Message.obtain();
        message.what = 7;
        message.obj = map;
        InMobiBanner.access$900(a).sendMessage(message);
    }

    public void c()
    {
        InMobiBanner.access$1000(a);
        InMobiBanner.access$900(a).sendEmptyMessage(4);
    }

    public void d()
    {
        InMobiBanner.access$900(a).sendEmptyMessage(6);
    }

    _cls1.a(InMobiBanner inmobibanner)
    {
        a = inmobibanner;
        super();
    }
}
