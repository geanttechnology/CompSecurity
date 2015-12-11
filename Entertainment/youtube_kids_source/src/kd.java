// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class kd extends im
{

    private final Object a;

    public kd(kc kc, Object obj)
    {
        a = obj;
    }

    public final void a(int i)
    {
        ((android.media.MediaRouter.RouteInfo)a).requestSetVolume(i);
    }

    public final void b(int i)
    {
        ((android.media.MediaRouter.RouteInfo)a).requestUpdateVolume(i);
    }
}
