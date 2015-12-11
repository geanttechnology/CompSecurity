// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.appnexus.opensdk:
//            t

static final class ce extends Handler
{

    WeakReference a;

    public final void handleMessage(Message message)
    {
        t t1 = (t)a.get();
        if (message.what == 8000 && t1 != null)
        {
            t1.f();
        }
    }

    public ce(t t1)
    {
        a = new WeakReference(t1);
    }
}
