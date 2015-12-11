// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaRouter;

public final class ji extends jb
{

    public ji(jh jh1)
    {
        super(jh1);
    }

    public final void onRoutePresentationDisplayChanged(MediaRouter mediarouter, android.media.MediaRouter.RouteInfo routeinfo)
    {
        ((jh)a).f(routeinfo);
    }
}
