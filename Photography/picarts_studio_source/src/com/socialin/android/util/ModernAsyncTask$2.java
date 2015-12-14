// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.socialin.android.util:
//            r, ModernAsyncTask

final class b extends r
{

    private ModernAsyncTask b;

    public final Object call()
    {
        ModernAsyncTask.access$200(b).set(true);
        Process.setThreadPriority(10);
        return ModernAsyncTask.access$300(b, b.doInBackground(a));
    }

    (ModernAsyncTask modernasynctask)
    {
        b = modernasynctask;
        super((byte)0);
    }
}
