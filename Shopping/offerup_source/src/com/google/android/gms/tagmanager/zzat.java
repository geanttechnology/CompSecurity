// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzas, zzbg, zzau

class zzat extends Thread
    implements zzas
{

    private static zzat zzaXf;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean zzNZ;
    private final LinkedBlockingQueue zzaXe = new LinkedBlockingQueue();
    private volatile zzau zzaXg;

    private zzat(Context context)
    {
        super("GAThread");
        zzNZ = false;
        mClosed = false;
        if (context != null)
        {
            mContext = context.getApplicationContext();
        } else
        {
            mContext = context;
        }
        start();
    }

    static zzau zza(zzat zzat1)
    {
        return zzat1.zzaXg;
    }

    static zzau zza(zzat zzat1, zzau zzau)
    {
        zzat1.zzaXg = zzau;
        return zzau;
    }

    static zzat zzaQ(Context context)
    {
        if (zzaXf == null)
        {
            zzaXf = new zzat(context);
        }
        return zzaXf;
    }

    static Context zzb(zzat zzat1)
    {
        return zzat1.mContext;
    }

    private String zzd(Throwable throwable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        printstream.flush();
        return new String(bytearrayoutputstream.toByteArray());
    }

    public void run()
    {
_L2:
        if (mClosed)
        {
            break; /* Loop/switch isn't completed */
        }
        Runnable runnable = (Runnable)zzaXe.take();
        if (!zzNZ)
        {
            runnable.run();
        }
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        try
        {
            zzbg.zzaG(interruptedexception.toString());
        }
        catch (Throwable throwable)
        {
            zzbg.e((new StringBuilder("Error on Google TagManager Thread: ")).append(zzd(throwable)).toString());
            zzbg.e("Google TagManager is shutting down.");
            zzNZ = true;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void zzeR(String s)
    {
        zzj(s, System.currentTimeMillis());
    }

    void zzj(String s, long l)
    {
        zzk(new _cls1(this, l, s));
    }

    public void zzk(Runnable runnable)
    {
        zzaXe.add(runnable);
    }

    private class _cls1
        implements Runnable
    {

        final zzas zzaXh;
        final long zzaXi;
        final zzat zzaXj;
        final String zzyc;

        public void run()
        {
            if (zzat.zza(zzaXj) == null)
            {
                zzcu zzcu1 = zzcu.zzDG();
                zzcu1.zza(zzat.zzb(zzaXj), zzaXh);
                zzat.zza(zzaXj, zzcu1.zzDJ());
            }
            zzat.zza(zzaXj).zzg(zzaXi, zzyc);
        }

        _cls1(zzas zzas1, long l, String s)
        {
            zzaXj = zzat.this;
            zzaXh = zzas1;
            zzaXi = l;
            zzyc = s;
            super();
        }
    }

}
