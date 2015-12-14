// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class agv
    implements Runnable
{

    final ProEditFontActivity a;

    public agv(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void run()
    {
        for (int i = 0; ProEditFontActivity.b(a) == null && i < 6; ProEditFontActivity.a(a, uv.c().i()))
        {
            i++;
        }

        a.runOnUiThread(new agw(this));
    }
}
