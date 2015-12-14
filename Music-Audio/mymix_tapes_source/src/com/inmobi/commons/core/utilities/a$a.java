// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.inmobi.commons.core.utilities:
//            a, Logger

static class a extends Handler
{

    boolean a;

    public void handleMessage(Message message)
    {
        if (!com.inmobi.commons.core.utilities.a.f())
        {
            if (message.what == 1001 && a)
            {
                a = false;
                com.inmobi.commons.core.utilities.a.a(false);
                Logger.a(er.InternalLogLevel.INTERNAL, com.inmobi.commons.core.utilities.a.g(), "App has gone to background.");
                return;
            }
            if (message.what == 1002 && !a)
            {
                a = true;
                com.inmobi.commons.core.utilities.a.a(true);
                Logger.a(er.InternalLogLevel.INTERNAL, com.inmobi.commons.core.utilities.a.g(), "App has come to foreground.");
                return;
            }
        }
    }

    public er(Looper looper)
    {
        super(looper);
        a = true;
    }
}
