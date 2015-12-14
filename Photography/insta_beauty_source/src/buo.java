// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Process;
import io.fabric.sdk.android.services.concurrency.AsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class buo extends buv
{

    final AsyncTask a;

    public buo(AsyncTask asynctask)
    {
        a = asynctask;
        super(null);
    }

    public Object call()
    {
        AsyncTask.a(a).set(true);
        Process.setThreadPriority(10);
        return AsyncTask.a(a, a.a(b));
    }
}
