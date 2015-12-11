// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import com.google.android.gms.cast.LaunchOptions;

final class ajw
    implements awk
{

    private aju a;

    ajw(aju aju1)
    {
        a = aju1;
        super();
    }

    public final void a(int i)
    {
        a.a((new StringBuilder(34)).append("onConnectionSuspended: ").append(i).toString());
        a.b.d();
    }

    public final void a(Bundle bundle)
    {
        bundle = a;
        Object obj = String.valueOf(((aju) (bundle)).h);
        bundle.a((new StringBuilder(String.valueOf(obj).length() + 31)).append("setup message listener, state: ").append(((String) (obj))).toString());
        boolean flag;
        if (((aju) (bundle)).h != aki.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!((aju) (bundle)).b.a("urn:x-cast:com.google.youtube.mdx", new ajz(bundle)))
        {
            bundle.a("can't set Cast message listener");
            bundle.c();
            return;
        }
        obj = new aut();
        if (!((aju) (bundle)).f)
        {
            bundle.a("no session join, relaunch the current application even if running");
            ((aut) (obj)).a.b = true;
        }
        obj = ((aut) (obj)).a;
        String s = ((aju) (bundle)).d;
        bundle.a((new StringBuilder(String.valueOf(s).length() + 33)).append("launch application ").append(s).append(", fling: ").append(flag).toString());
        ((aju) (bundle)).b.a(((aju) (bundle)).d, ((LaunchOptions) (obj)), new ajy(bundle, flag));
    }
}
