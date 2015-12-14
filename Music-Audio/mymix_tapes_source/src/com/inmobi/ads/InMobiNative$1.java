// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Message;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiNative, InMobiAdRequestStatus

class a
    implements a
{

    final InMobiNative a;

    public void a()
    {
        InMobiNative.access$100(a).sendEmptyMessage(1);
    }

    public void a(InMobiAdRequestStatus inmobiadrequeststatus)
    {
        Message message = Message.obtain();
        message.what = 2;
        message.obj = inmobiadrequeststatus;
        InMobiNative.access$100(a).sendMessage(message);
    }

    public void a(Map map)
    {
    }

    public void b()
    {
        InMobiNative.access$100(a).sendEmptyMessage(3);
    }

    public void b(Map map)
    {
    }

    public void c()
    {
        InMobiNative.access$100(a).sendEmptyMessage(4);
    }

    public void d()
    {
        InMobiNative.access$100(a).sendEmptyMessage(5);
    }

    Status(InMobiNative inmobinative)
    {
        a = inmobinative;
        super();
    }
}
