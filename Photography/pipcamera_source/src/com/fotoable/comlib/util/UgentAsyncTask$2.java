// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import android.os.Process;
import ga;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.fotoable.comlib.util:
//            UgentAsyncTask

class a extends ga
{

    final UgentAsyncTask a;

    public Object call()
    {
        UgentAsyncTask.a(a).set(true);
        Process.setThreadPriority(10);
        return UgentAsyncTask.a(a, a.b(b));
    }

    (UgentAsyncTask ugentasynctask)
    {
        a = ugentasynctask;
        super(null);
    }
}
