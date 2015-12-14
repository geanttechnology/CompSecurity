// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class agp
    implements Runnable
{

    final boolean a;
    final ProEditFontActivity b;

    public agp(ProEditFontActivity proeditfontactivity, boolean flag)
    {
        b = proeditfontactivity;
        a = flag;
        super();
    }

    public void run()
    {
        if (a)
        {
            ProEditFontActivity.a(b, ProEditFontActivity.l(b));
        }
        ProEditFontActivity.h(b);
    }
}
