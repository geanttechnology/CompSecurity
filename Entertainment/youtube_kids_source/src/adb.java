// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.ui.TimeBar;

final class adb
    implements agg
{

    private act a;

    adb(act act1)
    {
        a = act1;
        super();
    }

    public final void onScrubbingEnd(int i)
    {
        act.f(a).b = false;
        if (act.c(a) != null)
        {
            act.c(a).a(i);
        }
    }

    public final void onScrubbingStart()
    {
        a.d();
    }
}
