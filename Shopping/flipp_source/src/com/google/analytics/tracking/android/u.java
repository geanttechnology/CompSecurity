// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.google.analytics.tracking.android:
//            s, ai

final class u
    implements android.os.Handler.Callback
{

    final s a;

    u(s s1)
    {
        a = s1;
        super();
    }

    public final boolean handleMessage(Message message)
    {
        if (1 == message.what && s.e().equals(message.obj))
        {
            ai.a().a(true);
            a.c();
            ai.a().a(false);
            if (s.b(a) > 0 && !s.c(a))
            {
                s.d(a).sendMessageDelayed(s.d(a).obtainMessage(1, s.e()), s.b(a) * 1000);
            }
        }
        return true;
    }
}
