// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import hz;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements hz
{

    final ProEditFontActivity a;

    public void a(com.fotoable.fotoproedit.activity.font.OMBOTTOMBTN ombottombtn)
    {
        ProEditFontActivity.a(a, ombottombtn);
        [ombottombtn.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 49
    //                   2 138
    //                   3 224
    //                   4 350;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (!ProEditFontActivity.h(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.i(a);
            ProEditFontActivity.c(a, true);
            ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
            ProEditFontActivity.k(a);
        } else
        {
            ProEditFontActivity.a(a, ProEditFontActivity.l(a));
        }
        ProEditFontActivity.m(a).hiddenAll();
        return;
_L3:
        a.hideSoftKeyborad(ProEditFontActivity.l(a));
        if (!ProEditFontActivity.h(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.i(a);
            ProEditFontActivity.c(a, false);
            ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
            ProEditFontActivity.k(a);
        }
        ProEditFontActivity.m(a).showFontView();
        return;
_L4:
        a.hideSoftKeyborad(ProEditFontActivity.l(a));
        if (!ProEditFontActivity.h(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.i(a);
            ProEditFontActivity.c(a, false);
            ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
            ProEditFontActivity.k(a);
        }
        ProEditFontActivity.m(a).showStyleView();
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.m(a).setStyleFontAndTxt(ProEditFontActivity.n(a).labelinfo(), ProEditFontActivity.n(a).fontInfo());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        a.hideSoftKeyborad(ProEditFontActivity.l(a));
        if (!ProEditFontActivity.h(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.i(a);
            ProEditFontActivity.c(a, false);
            ProEditFontActivity.a(a, ProEditFontActivity.j(a), 0x7f040009, 300L, false);
            ProEditFontActivity.k(a);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    Bar.COMBOTTOMBTN(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }
}
