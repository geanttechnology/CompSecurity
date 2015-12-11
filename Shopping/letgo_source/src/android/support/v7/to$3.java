// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Process;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

// Referenced classes of package android.support.v7:
//            to, ua, tg

static final class b
    implements Runnable
{

    final ua a;
    final Callable b;

    public void run()
    {
        try
        {
            Process.setThreadPriority(10);
            a.b(b.call());
            return;
        }
        catch (Exception exception)
        {
            zzp.zzbA().a(exception, true);
        }
        a.cancel(true);
    }

    lable(ua ua1, Callable callable)
    {
        a = ua1;
        b = callable;
        super();
    }
}
