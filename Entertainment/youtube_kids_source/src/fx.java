// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.MediaRouteActionProvider;
import java.lang.ref.WeakReference;

public final class fx extends is
{

    private final WeakReference a;

    public fx(MediaRouteActionProvider mediarouteactionprovider)
    {
        a = new WeakReference(mediarouteactionprovider);
    }

    private void e(ir ir1)
    {
        MediaRouteActionProvider mediarouteactionprovider = (MediaRouteActionProvider)a.get();
        if (mediarouteactionprovider != null)
        {
            MediaRouteActionProvider.a(mediarouteactionprovider);
            return;
        } else
        {
            ir1.a(this);
            return;
        }
    }

    public final void a(ir ir1)
    {
        e(ir1);
    }

    public final void a(ir ir1, iz iz)
    {
        e(ir1);
    }

    public final void b(ir ir1)
    {
        e(ir1);
    }

    public final void b(ir ir1, iz iz)
    {
        e(ir1);
    }

    public final void c(ir ir1)
    {
        e(ir1);
    }

    public final void d(ir ir1)
    {
        e(ir1);
    }
}
