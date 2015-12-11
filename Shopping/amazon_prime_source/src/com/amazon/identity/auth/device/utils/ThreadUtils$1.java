// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            ThreadUtils

static final class _cls9 extends Thread
{

    public void run()
    {
        Looper.prepare();
        Handler _tmp = ThreadUtils.access$002(new Handler());
        Looper.loop();
    }

    _cls9()
    {
    }
}
