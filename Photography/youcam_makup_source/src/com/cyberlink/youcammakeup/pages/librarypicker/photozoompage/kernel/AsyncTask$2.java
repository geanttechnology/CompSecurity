// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            d, AsyncTask

class a extends d
{

    final AsyncTask a;

    public Object call()
    {
        AsyncTask.a(a).set(true);
        Process.setThreadPriority(10);
        return AsyncTask.a(a, a.a(b));
    }

    (AsyncTask asynctask)
    {
        a = asynctask;
        super(null);
    }
}
