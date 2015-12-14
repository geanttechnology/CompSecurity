// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;

public class aha
    implements anl
{

    final ProEditFontActivity a;

    public aha(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void a(com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN combottombtn)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        ProEditFontActivity.a(a, combottombtn);
        agt.a[combottombtn.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 49
    //                   2 118
    //                   3 185;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (!ProEditFontActivity.i(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.j(a);
            ProEditFontActivity.c(a, true);
            ProEditFontActivity.k(a);
        } else
        {
            ProEditFontActivity.a(a, ProEditFontActivity.l(a));
        }
        ProEditFontActivity.m(a).hiddenAll();
        return;
_L3:
        a.hideSoftKeyborad(ProEditFontActivity.l(a));
        if (!ProEditFontActivity.i(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.j(a);
            ProEditFontActivity.c(a, false);
            ProEditFontActivity.k(a);
        } else
        {
            flag = true;
        }
        ProEditFontActivity.m(a).showFontView(flag);
        return;
_L4:
        a.hideSoftKeyborad(ProEditFontActivity.l(a));
        if (!ProEditFontActivity.i(a))
        {
            ProEditFontActivity.b(a, true);
            ProEditFontActivity.j(a);
            ProEditFontActivity.c(a, false);
            ProEditFontActivity.k(a);
            flag = flag1;
        } else
        {
            flag = true;
        }
        ProEditFontActivity.m(a).showStyleView(flag);
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.m(a).setStyleFontAndTxt(ProEditFontActivity.n(a).labelinfo(), ProEditFontActivity.n(a).fontInfo());
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
