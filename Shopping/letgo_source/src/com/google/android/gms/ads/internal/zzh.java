// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v7.ly;
import android.support.v7.mb;
import android.support.v7.nj;
import android.support.v7.nn;
import android.support.v7.to;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzq

class zzh
    implements ly, Runnable
{

    private final List zzoP = new Vector();
    private final AtomicReference zzoQ = new AtomicReference();
    CountDownLatch zzoR;
    private zzq zzos;

    public zzh(zzq zzq1)
    {
        zzoR = new CountDownLatch(1);
        zzos = zzq1;
        if (zzk.zzcE().zzgI())
        {
            to.a(this);
            return;
        } else
        {
            run();
            return;
        }
    }

    private void zzbh()
    {
        if (zzoP.isEmpty())
        {
            return;
        }
        Iterator iterator = zzoP.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object aobj[] = (Object[])iterator.next();
            if (aobj.length == 1)
            {
                ((ly)zzoQ.get()).zza((MotionEvent)aobj[0]);
            } else
            if (aobj.length == 3)
            {
                ((ly)zzoQ.get()).zza(((Integer)aobj[0]).intValue(), ((Integer)aobj[1]).intValue(), ((Integer)aobj[2]).intValue());
            }
        } while (true);
        zzoP.clear();
    }

    private Context zzp(Context context)
    {
        Context context1;
        if (((Boolean)nn.m.c()).booleanValue())
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
        if (((Boolean)nn.y.c()).booleanValue() && !zzos.zzqb.zzIC)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        zza(zzb(zzos.zzqb.zzIz, zzp(zzos.context), flag));
        zzoR.countDown();
        zzos = null;
        return;
        exception;
        zzoR.countDown();
        zzos = null;
        throw exception;
    }

    public void zza(int i, int j, int k)
    {
        ly ly1 = (ly)zzoQ.get();
        if (ly1 != null)
        {
            zzbh();
            ly1.zza(i, j, k);
            return;
        } else
        {
            zzoP.add(((Object) (new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
            })));
            return;
        }
    }

    protected void zza(ly ly1)
    {
        zzoQ.set(ly1);
    }

    public void zza(MotionEvent motionevent)
    {
        ly ly1 = (ly)zzoQ.get();
        if (ly1 != null)
        {
            zzbh();
            ly1.zza(motionevent);
            return;
        } else
        {
            zzoP.add(((Object) (new Object[] {
                motionevent
            })));
            return;
        }
    }

    protected ly zzb(String s, Context context, boolean flag)
    {
        return mb.a(s, context, flag);
    }

    public String zzb(Context context)
    {
        if (zzbg())
        {
            ly ly1 = (ly)zzoQ.get();
            if (ly1 != null)
            {
                zzbh();
                return ly1.zzb(zzp(context));
            }
        }
        return "";
    }

    public String zzb(Context context, String s)
    {
        if (zzbg())
        {
            ly ly1 = (ly)zzoQ.get();
            if (ly1 != null)
            {
                zzbh();
                return ly1.zzb(zzp(context), s);
            }
        }
        return "";
    }

    protected boolean zzbg()
    {
        try
        {
            zzoR.await();
        }
        catch (InterruptedException interruptedexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Interrupted during GADSignals creation.", interruptedexception);
            return false;
        }
        return true;
    }
}
