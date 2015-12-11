// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            tl, ph, pi, tp, 
//            ul

public class pg extends tl
{

    final ul a;
    final pi b;
    private final String c;

    pg(ul ul, pi pi1, String s)
    {
        a = ul;
        b = pi1;
        c = s;
        zzp.zzbK().a(this);
    }

    public void onStop()
    {
        b.a();
    }

    public void zzdG()
    {
        b.a(c);
        tp.a.post(new Runnable() {

            final pg a;

            public void run()
            {
                zzp.zzbK().b(a);
            }

            
            {
                a = pg.this;
                super();
            }
        });
        return;
        Exception exception;
        exception;
        tp.a.post(new _cls1());
        throw exception;
    }
}
