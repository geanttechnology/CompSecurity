// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import android.os.Process;
import fh;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.fotoable.comlib.util:
//            AsyncTask

class a extends fh
{

    final AsyncTask a;

    public Object call()
    {
        AsyncTask.access$300(a).set(true);
        Process.setThreadPriority(10);
        return AsyncTask.access$400(a, a.doInBackground(b));
    }

    lean(AsyncTask asynctask)
    {
        a = asynctask;
        super(null);
    }
}
