// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util.g;

import android.content.Context;
import android.location.Geocoder;
import com.shazam.model.location.SimpleLocation;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Referenced classes of package com.shazam.android.util.g:
//            b, c

public final class com.shazam.android.util.g.a
    implements b
{
    private final class a
        implements Callable
    {

        final com.shazam.android.util.g.a a;
        private final double b;
        private final double c;
        private final Context d;

        public final Object call()
        {
            return com.shazam.android.util.g.c.a(b, c, new Geocoder(d, Locale.getDefault()));
        }

        public a(double d1, double d2, Context context)
        {
            a = com.shazam.android.util.g.a.this;
            super();
            b = d1;
            c = d2;
            d = context;
        }
    }


    private final ExecutorService b = Executors.newSingleThreadExecutor(com.shazam.i.q.a.b("LocationNameResolver-%d").b());
    private final Context c;
    private Future d;

    public com.shazam.android.util.g.a(Context context)
    {
        c = context;
    }

    public final String a()
    {
        if (d == null || !d.isDone())
        {
            break MISSING_BLOCK_LABEL_35;
        }
        String s = (String)d.get();
        return s;
        Object obj;
        obj;
_L2:
        return null;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(SimpleLocation simplelocation)
    {
        d = null;
        if (simplelocation != null)
        {
            simplelocation = new a(simplelocation.latitude, simplelocation.longitude, c);
            d = b.submit(simplelocation);
        }
    }
}
