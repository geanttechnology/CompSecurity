// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;


// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements Runnable
{

    final ProEditFontActivity a;

    public void run()
    {
        a.a();
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.g(a);
            ProEditFontActivity.d(a, true);
        }
    }

    (ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }
}
