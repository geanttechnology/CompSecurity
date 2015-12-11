// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.MediaRouter;

final class kh extends kg
{

    public kh(Context context, kl kl)
    {
        super(context, kl);
    }

    protected final void a(ke ke1, ig ig1)
    {
        super.a(ke1, ig1);
        ke1 = ((android.media.MediaRouter.RouteInfo)ke1.a).getDescription();
        if (ke1 != null)
        {
            ig1.a(ke1.toString());
        }
    }

    protected final void a(kf kf1)
    {
        super.a(kf1);
        Object obj = kf1.b;
        kf1 = kf1.a.d;
        ((android.media.MediaRouter.UserRouteInfo)obj).setDescription(kf1);
    }

    protected final boolean a(ke ke1)
    {
        return ((android.media.MediaRouter.RouteInfo)ke1.a).isConnecting();
    }

    protected final void b()
    {
        int i = 1;
        if (m)
        {
            a.a(this.i, this.j);
        }
        m = true;
        Object obj = this.i;
        int j = k;
        Object obj1 = this.j;
        if (!l)
        {
            i = 0;
        }
        ((MediaRouter)obj).addCallback(j, (android.media.MediaRouter.Callback)obj1, i | 2);
    }

    protected final Object d()
    {
        return ((MediaRouter)i).getDefaultRoute();
    }

    protected final void h(Object obj)
    {
        ((MediaRouter)i).selectRoute(0x800003, (android.media.MediaRouter.RouteInfo)obj);
    }
}
