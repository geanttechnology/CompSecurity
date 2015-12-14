// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;


// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements Runnable
{

    final boolean a;
    final ProEditFontActivity b;

    public void run()
    {
        if (a)
        {
            ProEditFontActivity.a(b, ProEditFontActivity.l(b));
        }
        ProEditFontActivity.g(b);
    }

    (ProEditFontActivity proeditfontactivity, boolean flag)
    {
        b = proeditfontactivity;
        a = flag;
        super();
    }
}
