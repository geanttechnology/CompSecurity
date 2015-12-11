// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.RemoteControlClient;

final class jw extends jv
{

    private final Object c;
    private final Object d;
    private final Object e;
    private boolean f;

    public jw(Context context, Object obj)
    {
        super(context, obj);
        c = context.getSystemService("media_router");
        d = a.a(c, "", false);
        e = a.b(c, d);
    }

    public final void a(jz jz1)
    {
        a.d(e, jz1.a);
        a.e(e, jz1.b);
        a.f(e, jz1.c);
        a.c(e, jz1.d);
        a.b(e, jz1.e);
        if (!f)
        {
            f = true;
            a.d(e, a.a(new jx(this)));
            jz1 = ((jz) (e));
            Object obj = a;
            ((android.media.MediaRouter.UserRouteInfo)jz1).setRemoteControlClient((RemoteControlClient)obj);
        }
    }
}
