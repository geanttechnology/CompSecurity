// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            av

private static final class > extends Handler
{

    private WeakReference a;

    public final void handleMessage(Message message)
    {
        av av1 = (av)a.get();
        if (av1 != null)
        {
            av1.a(message);
        }
    }

    public (av av1)
    {
        a = new WeakReference(av1);
    }
}
