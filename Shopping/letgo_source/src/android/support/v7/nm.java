// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package android.support.v7:
//            nj, nl

public class nm
{

    private final Object a = new Object();
    private boolean b;
    private SharedPreferences c;

    public nm()
    {
        b = false;
        c = null;
    }

    public Object a(nj nj1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        nj1 = ((nj) (nj1.b()));
        return nj1;
        obj;
        JVM INSTR monitorexit ;
        return nj1.a(c);
        nj1;
        obj;
        JVM INSTR monitorexit ;
        throw nj1;
    }

    public void a(Context context)
    {
label0:
        {
            synchronized (a)
            {
                if (!b)
                {
                    break label0;
                }
            }
            return;
        }
        context = GooglePlayServicesUtil.getRemoteContext(context);
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        c = zzp.zzbE().a(context);
        b = true;
        obj;
        JVM INSTR monitorexit ;
    }
}
