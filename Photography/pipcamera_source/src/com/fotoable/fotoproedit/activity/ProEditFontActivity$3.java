// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;
import com.fotoable.fotoproedit.activity.font.FontPreViewDialog;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import hb;
import hc;
import iq;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements hc
{

    final ProEditFontActivity a;

    public void a()
    {
        ProEditFontActivity.a(a, ProEditFontActivity.G(a), 0x7f040013, 300L, false);
    }

    public void a(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setLabelStrokeSize(i);
            ProEditFontActivity.n(a).onTextCreate();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        Log.e("ProEditFontActivity", "getFontStrokeNum");
        ProEditFontActivity.G(a).setVisibility(0);
        ProEditFontActivity.G(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f0601a8)).append(":").append(String.valueOf(i)).toString());
        ProEditFontActivity.g(a);
    }

    public void a(FontTextLabelInfo fonttextlabelinfo)
    {
        fonttextlabelinfo.r = 0;
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setFlip(false);
            ProEditFontActivity.n(a).setFontLabelInfo1(fonttextlabelinfo);
            ProEditFontActivity.n(a).onTextCreate();
        }
        Log.e("ProEditFontActivity", "getFontStyle");
        ProEditFontActivity.g(a);
    }

    public void a(hb hb1)
    {
        ProEditFontActivity.a(a, hb1);
        if (!ProEditFontActivity.F(a).a && !ProEditFontActivity.F(a).e)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (!iq.a().b(ProEditFontActivity.F(a))) goto _L2; else goto _L1
_L1:
        if (iq.a().a(ProEditFontActivity.F(a)) != null && ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setFontLabelFontInfo(ProEditFontActivity.F(a));
            ProEditFontActivity.n(a).onTextCreate();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
            ProEditFontActivity.g(a);
        }
_L4:
        return;
_L2:
        if (ProEditFontActivity.H(a) != null) goto _L4; else goto _L3
_L3:
        ProEditFontActivity.a(a, FontPreViewDialog.a());
        ProEditFontActivity.H(a).a(a);
        ProEditFontActivity.H(a).a(ProEditFontActivity.F(a));
        ProEditFontActivity.H(a).show(a.getSupportFragmentManager(), "preview");
        return;
        a.a(ProEditFontActivity.F(a));
        return;
    }

    public void b()
    {
        ProEditFontActivity.a(a, ProEditFontActivity.G(a), 0x7f040013, 300L, false);
    }

    public void b(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setLabelStrokeColor(i);
            ProEditFontActivity.n(a).onTextCreate();
        }
        Log.e("ProEditFontActivity", "getFontStrokeColor");
    }

    public void b(FontTextLabelInfo fonttextlabelinfo)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setLabelTextImage(fonttextlabelinfo);
            ProEditFontActivity.n(a).onTextCreate();
        }
        Log.e("ProEditFontActivity", "getFontForgroundColor");
    }

    public void c()
    {
        ProEditFontActivity.G(a).setVisibility(4);
    }

    public void c(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setShadowLabelVal(i);
            ProEditFontActivity.n(a).onTextCreate();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        Log.e("ProEditFontActivity", "getFontShadowNum");
        ProEditFontActivity.G(a).setVisibility(0);
        ProEditFontActivity.G(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f0601a7)).append(":").append(String.valueOf(i)).toString());
        ProEditFontActivity.g(a);
    }

    public void d(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setShadowLabelColor(i);
            ProEditFontActivity.n(a).onTextCreate();
        }
        Log.e("ProEditFontActivity", "getFontShadowColor");
    }

    public void e(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setTextLabelAlpha(i);
            ProEditFontActivity.n(a).onTextCreate();
        }
        Log.e("ProEditFontActivity", "getFontTranspareny");
    }

    (ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }
}
