// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class agq
    implements Runnable
{

    final ProEditFontActivity a;

    public agq(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void run()
    {
        a.b();
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.h(a);
            ProEditFontActivity.d(a, true);
        }
    }
}
