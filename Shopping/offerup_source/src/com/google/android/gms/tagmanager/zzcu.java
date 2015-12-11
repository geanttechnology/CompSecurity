// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzct, zzbl, zzbg, zzas, 
//            zzby, zzau, zzav

class zzcu extends zzct
{

    private static final Object zzaYT = new Object();
    private static zzcu zzaZe;
    private boolean connected;
    private Handler handler;
    private Context zzaYU;
    private zzau zzaYV;
    private volatile zzas zzaYW;
    private int zzaYX;
    private boolean zzaYY;
    private boolean zzaYZ;
    private boolean zzaZa;
    private zzav zzaZb;
    private zzbl zzaZc;
    private boolean zzaZd;

    private zzcu()
    {
        zzaYX = 0x1b7740;
        zzaYY = true;
        zzaYZ = false;
        connected = true;
        zzaZa = true;
        zzaZb = new _cls1();
        zzaZd = false;
    }

    public static zzcu zzDG()
    {
        if (zzaZe == null)
        {
            zzaZe = new zzcu();
        }
        return zzaZe;
    }

    private void zzDH()
    {
        zzaZc = new zzbl(this);
        zzaZc.zzaR(zzaYU);
    }

    private void zzDI()
    {
        handler = new Handler(zzaYU.getMainLooper(), new _cls2());
        if (zzaYX > 0)
        {
            handler.sendMessageDelayed(handler.obtainMessage(1, zzaYT), zzaYX);
        }
    }

    static Object zzDK()
    {
        return zzaYT;
    }

    static boolean zza(zzcu zzcu1)
    {
        return zzcu1.connected;
    }

    static int zzb(zzcu zzcu1)
    {
        return zzcu1.zzaYX;
    }

    static boolean zzc(zzcu zzcu1)
    {
        return zzcu1.zzaZd;
    }

    static Handler zzd(zzcu zzcu1)
    {
        return zzcu1.handler;
    }

    static zzau zze(zzcu zzcu1)
    {
        return zzcu1.zzaYV;
    }

    public void dispatch()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaYZ) goto _L2; else goto _L1
_L1:
        zzbg.v("Dispatch call queued. Dispatch will run once initialization is complete.");
        zzaYY = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzaYW.zzk(new _cls3());
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    zzau zzDJ()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaYV != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (zzaYU == null)
        {
            throw new IllegalStateException("Cant get a store unless we have a context");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        zzaYV = new zzby(zzaZb, zzaYU);
        zzau zzau;
        if (handler == null)
        {
            zzDI();
        }
        zzaYZ = true;
        if (zzaYY)
        {
            dispatch();
            zzaYY = false;
        }
        if (zzaZc == null && zzaZa)
        {
            zzDH();
        }
        zzau = zzaYV;
        this;
        JVM INSTR monitorexit ;
        return zzau;
    }

    void zza(Context context, zzas zzas1)
    {
        this;
        JVM INSTR monitorenter ;
        Context context1 = zzaYU;
        if (context1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzaYU = context.getApplicationContext();
        if (zzaYW == null)
        {
            zzaYW = zzas1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    void zzat(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        zzd(zzaZd, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void zzd(boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaZd != flag) goto _L2; else goto _L1
_L1:
        boolean flag2 = connected;
        if (flag2 != flag1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!flag && flag1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (zzaYX > 0)
        {
            handler.removeMessages(1, zzaYT);
        }
        if (flag || !flag1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (zzaYX > 0)
        {
            handler.sendMessageDelayed(handler.obtainMessage(1, zzaYT), zzaYX);
        }
        StringBuilder stringbuilder = new StringBuilder("PowerSaveMode ");
        Object obj;
        if (!flag && flag1)
        {
            obj = "terminated.";
        } else
        {
            obj = "initiated.";
        }
        zzbg.v(stringbuilder.append(((String) (obj))).toString());
        zzaZd = flag;
        connected = flag1;
        if (true) goto _L3; else goto _L4
_L4:
        obj;
        throw obj;
    }

    void zzio()
    {
        this;
        JVM INSTR monitorenter ;
        if (!zzaZd && connected && zzaYX > 0)
        {
            handler.removeMessages(1, zzaYT);
            handler.sendMessage(handler.obtainMessage(1, zzaYT));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1
        implements zzav
    {

        final zzcu zzaZf;

        public void zzas(boolean flag)
        {
            zzaZf.zzd(flag, zzcu.zza(zzaZf));
        }

        _cls1()
        {
            zzaZf = zzcu.this;
            super();
        }
    }


    private class _cls2
        implements android.os.Handler.Callback
    {

        final zzcu zzaZf;

        public boolean handleMessage(Message message)
        {
            if (1 == message.what && zzcu.zzDK().equals(message.obj))
            {
                zzaZf.dispatch();
                if (zzcu.zzb(zzaZf) > 0 && !zzcu.zzc(zzaZf))
                {
                    zzcu.zzd(zzaZf).sendMessageDelayed(zzcu.zzd(zzaZf).obtainMessage(1, zzcu.zzDK()), zzcu.zzb(zzaZf));
                }
            }
            return true;
        }

        _cls2()
        {
            zzaZf = zzcu.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final zzcu zzaZf;

        public void run()
        {
            zzcu.zze(zzaZf).dispatch();
        }

        _cls3()
        {
            zzaZf = zzcu.this;
            super();
        }
    }

}
