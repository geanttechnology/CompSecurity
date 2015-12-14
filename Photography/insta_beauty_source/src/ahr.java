// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

public class ahr
    implements Runnable
{

    final ProEditMosaicActivity a;

    public ahr(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void run()
    {
        ProEditMosaicActivity.a(a, uv.c().i());
        if (!ProEditMosaicActivity.h(a));
        if (ProEditMosaicActivity.i(a) == null)
        {
            a.runOnUiThread(new ahs(this));
            return;
        } else
        {
            a.runOnUiThread(new aht(this));
            return;
        }
    }
}
