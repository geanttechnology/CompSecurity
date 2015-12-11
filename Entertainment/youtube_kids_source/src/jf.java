// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class jf extends android.media.MediaRouter.VolumeCallback
{

    private je a;

    public jf(je je1)
    {
        a = je1;
    }

    public final void onVolumeSetRequest(android.media.MediaRouter.RouteInfo routeinfo, int i)
    {
        a.a(routeinfo, i);
    }

    public final void onVolumeUpdateRequest(android.media.MediaRouter.RouteInfo routeinfo, int i)
    {
        a.b(routeinfo, i);
    }
}
