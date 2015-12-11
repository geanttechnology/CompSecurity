// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.b.b;
import java.lang.ref.WeakReference;

// Referenced classes of package com.appnexus.opensdk:
//            ag, aq

static final class e extends Handler
{

    WeakReference a;

    public final void handleMessage(Message message)
    {
        Exception exception;
        message = (ag)a.get();
        if (message == null || ((ag) (message)).d)
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
            message.b = null;
            return;
        }
        finally
        {
            message.b = null;
        }
        message.b = null;
        return;
        throw exception;
    }

    public xception(ag ag1)
    {
        a = new WeakReference(ag1);
    }
}
