// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.AsyncTask;
import java.util.TimerTask;

// Referenced classes of package jumiomobile:
//            ab, ap

class as extends TimerTask
{

    final ap a;
    private final AsyncTask b;

    public as(ap ap, AsyncTask asynctask)
    {
        a = ap;
        super();
        b = asynctask;
    }

    public void run()
    {
        if (b != null && b.getStatus() != android.os.AsyncTask.Status.FINISHED && !b.isCancelled())
        {
            b.cancel(true);
            ab.d("DownloadTask", "timer fired - killing task");
        }
    }
}
