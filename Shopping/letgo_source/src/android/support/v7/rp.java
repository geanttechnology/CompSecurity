// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            rs, ul, tq, um

public abstract class rp extends rs
    implements um.a
{

    protected boolean a;
    private final um i;
    private boolean j;

    protected rp(Context context, te.a a1, ul ul1, ru.a a2)
    {
        super(context, a1, ul1, a2);
        a = false;
        j = false;
        i = ul1.i();
    }

    private boolean c(long l)
        throws rs.a
    {
        l = 60000L - (SystemClock.elapsedRealtime() - l);
        if (l <= 1L)
        {
            return false;
        }
        try
        {
            e.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new rs.a("Ad request cancelled.", -1);
        }
        return true;
    }

    protected void a(long l)
        throws rs.a
    {
        do
        {
            if (!c(l))
            {
                throw new rs.a("Timed out waiting for WebView to finish loading.", 2);
            }
            if (j)
            {
                throw new rs.a("Received cancellation request from creative.", 0);
            }
        } while (!a);
    }

    public void onStop()
    {
        synchronized (f)
        {
            d.stopLoading();
            zzp.zzbz().a(d.getWebView());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zza(ul ul1, boolean flag)
    {
        boolean flag1 = true;
        ul1 = ((ul) (e));
        ul1;
        JVM INSTR monitorenter ;
        zzb.zzaC("WebView finished loading.");
        a = true;
        Exception exception;
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        j = flag;
        e.notify();
        ul1;
        JVM INSTR monitorexit ;
        return;
        exception;
        ul1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
