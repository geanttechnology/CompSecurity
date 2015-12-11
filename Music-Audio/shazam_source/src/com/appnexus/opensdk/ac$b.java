// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.b.b;
import java.lang.ref.WeakReference;

// Referenced classes of package com.appnexus.opensdk:
//            ac, aq

static final class e extends Handler
{

    WeakReference a;

    public final void handleMessage(Message message)
    {
        Exception exception;
        message = (ac)a.get();
        if (message == null || ((ac) (message)).f)
        {
            return;
        }
        com.appnexus.opensdk.b.b.d(b.c, com.appnexus.opensdk.b.b.a(mediation_timeout));
        try
        {
            message.a(aq.f);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            message.d = null;
            message.b = null;
            message.c = null;
            return;
        }
        finally
        {
            message.d = null;
        }
        message.d = null;
        message.b = null;
        message.c = null;
        return;
        message.b = null;
        message.c = null;
        throw exception;
    }

    public xception(ac ac1)
    {
        a = new WeakReference(ac1);
    }
}
