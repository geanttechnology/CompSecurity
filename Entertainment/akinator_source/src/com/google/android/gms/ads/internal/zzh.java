// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzic;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzq

class zzh
    implements zzaj, Runnable
{

    private final List zzoQ = new Vector();
    private final AtomicReference zzoR = new AtomicReference();
    CountDownLatch zzoS;
    private zzq zzot;

    public zzh(zzq zzq1)
    {
        zzoS = new CountDownLatch(1);
        zzot = zzq1;
        if (zzl.zzcF().zzgT())
        {
            zzic.zza(this);
            return;
        } else
        {
            run();
            return;
        }
    }

    private void zzbh()
    {
        if (zzoQ.isEmpty())
        {
            return;
        }
        Iterator iterator = zzoQ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object aobj[] = (Object[])iterator.next();
            if (aobj.length == 1)
            {
                ((zzaj)zzoR.get()).zza((MotionEvent)aobj[0]);
            } else
            if (aobj.length == 3)
            {
                ((zzaj)zzoR.get()).zza(((Integer)aobj[0]).intValue(), ((Integer)aobj[1]).intValue(), ((Integer)aobj[2]).intValue());
            }
        } while (true);
        zzoQ.clear();
    }

    private Context zzp(Context context)
    {
        Context context1;
        if (((Boolean)zzby.zzuw.get()).booleanValue())
        {
            if ((context1 = context.getApplicationContext()) != null)
            {
                return context1;
            }
        }
        return context;
    }

    public void run()
    {
        Exception exception;
        boolean flag;
        if (((Boolean)zzby.zzuI.get()).booleanValue() && !zzot.zzqj.zzJx)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        zza(zzb(zzot.zzqj.zzJu, zzp(zzot.context), flag));
        zzoS.countDown();
        zzot = null;
        return;
        exception;
        zzoS.countDown();
        zzot = null;
        throw exception;
    }

    public void zza(int i, int j, int k)
    {
        zzaj zzaj1 = (zzaj)zzoR.get();
        if (zzaj1 != null)
        {
            zzbh();
            zzaj1.zza(i, j, k);
            return;
        } else
        {
            zzoQ.add(((Object) (new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
            })));
            return;
        }
    }

    public void zza(MotionEvent motionevent)
    {
        zzaj zzaj1 = (zzaj)zzoR.get();
        if (zzaj1 != null)
        {
            zzbh();
            zzaj1.zza(motionevent);
            return;
        } else
        {
            zzoQ.add(((Object) (new Object[] {
                motionevent
            })));
            return;
        }
    }

    protected void zza(zzaj zzaj1)
    {
        zzoR.set(zzaj1);
    }

    protected zzaj zzb(String s, Context context, boolean flag)
    {
        return zzam.zza(s, context, flag);
    }

    public String zzb(Context context)
    {
        if (zzbg())
        {
            zzaj zzaj1 = (zzaj)zzoR.get();
            if (zzaj1 != null)
            {
                zzbh();
                return zzaj1.zzb(zzp(context));
            }
        }
        return "";
    }

    public String zzb(Context context, String s)
    {
        if (zzbg())
        {
            zzaj zzaj1 = (zzaj)zzoR.get();
            if (zzaj1 != null)
            {
                zzbh();
                return zzaj1.zzb(zzp(context), s);
            }
        }
        return "";
    }

    protected boolean zzbg()
    {
        try
        {
            zzoS.await();
        }
        catch (InterruptedException interruptedexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Interrupted during GADSignals creation.", interruptedexception);
            return false;
        }
        return true;
    }
}
