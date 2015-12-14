// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Process;
import com.fotoable.comlib.util.AsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class zb extends zi
{

    final AsyncTask a;

    public zb(AsyncTask asynctask)
    {
        a = asynctask;
        super(null);
    }

    public Object call()
    {
        AsyncTask.access$300(a).set(true);
        Process.setThreadPriority(10);
        return AsyncTask.access$400(a, a.doInBackground(b));
    }
}
