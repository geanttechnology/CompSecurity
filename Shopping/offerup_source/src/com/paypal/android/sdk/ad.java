// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.paypal.android.sdk:
//            z

final class ad extends Handler
{

    private final WeakReference a;

    public ad(z z1)
    {
        a = new WeakReference(z1);
    }

    public final void handleMessage(Message message)
    {
        z z1 = (z)a.get();
        if (z1 != null)
        {
            z1.a(message);
        }
    }
}
