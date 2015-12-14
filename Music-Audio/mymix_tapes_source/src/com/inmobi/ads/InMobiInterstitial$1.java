// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Message;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiInterstitial, i, InMobiAdRequestStatus

class a
    implements a
{

    final InMobiInterstitial a;

    public void a()
    {
        InMobiInterstitial.access$100(a).sendEmptyMessage(1);
    }

    public void a(InMobiAdRequestStatus inmobiadrequeststatus)
    {
        Message message = Message.obtain();
        message.what = 2;
        message.obj = inmobiadrequeststatus;
        InMobiInterstitial.access$100(a).sendMessage(message);
    }

    public void a(Map map)
    {
        Message message = Message.obtain();
        message.what = 5;
        message.obj = map;
        InMobiInterstitial.access$100(a).sendMessage(message);
    }

    public void b()
    {
        InMobiInterstitial.access$100(a).sendEmptyMessage(3);
    }

    public void b(Map map)
    {
        Message message = Message.obtain();
        message.what = 7;
        message.obj = map;
        InMobiInterstitial.access$100(a).sendMessage(message);
    }

    public void c()
    {
        i.a().b(InMobiInterstitial.access$200(a));
        InMobiInterstitial.access$100(a).sendEmptyMessage(4);
    }

    public void d()
    {
        InMobiInterstitial.access$100(a).sendEmptyMessage(6);
    }

    (InMobiInterstitial inmobiinterstitial)
    {
        a = inmobiinterstitial;
        super();
    }
}
