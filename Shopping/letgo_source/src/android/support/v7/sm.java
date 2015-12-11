// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v7:
//            nn, nj, sl, vn

public final class sm
{
    private class a
    {

        public final long a = zzp.zzbB().a();
        public final sl b;
        final sm c;

        public boolean a()
        {
            long l = a;
            return ((Long)nn.ad.c()).longValue() + l < zzp.zzbB().a();
        }

        public a(sl sl)
        {
            c = sm.this;
            super();
            b = sl;
        }
    }


    private WeakHashMap a;

    public sm()
    {
        a = new WeakHashMap();
    }

    public sl a(Context context)
    {
        Object obj = (a)a.get(context);
        if (obj != null && !((a) (obj)).a() && ((Boolean)nn.ac.c()).booleanValue())
        {
            obj = (new sl.a(context, ((a) (obj)).b)).a();
        } else
        {
            obj = (new sl.a(context)).a();
        }
        a.put(context, new a(((sl) (obj))));
        return ((sl) (obj));
    }
}
