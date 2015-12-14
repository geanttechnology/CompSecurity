// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

public class aic
    implements Runnable
{

    final ProEditNewStretchActivity a;

    public aic(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void run()
    {
        ProEditNewStretchActivity.a(a, uv.c().i());
        if (ProEditNewStretchActivity.a(a) == null)
        {
            a.runOnUiThread(new aid(this));
            return;
        } else
        {
            a.runOnUiThread(new aie(this));
            return;
        }
    }
}
