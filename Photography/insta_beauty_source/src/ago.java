// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.widget.TextView;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import com.fotoable.fotoproedit.view.ui.FontPreViewDialog;

public class ago
    implements ajn
{

    final ProEditFontActivity a;

    public ago(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void a()
    {
        ProEditFontActivity.a(a, ProEditFontActivity.G(a), 0x7f04001e, 300L, false);
    }

    public void a(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setLabelStrokeSize(i);
            ProEditFontActivity.n(a).onTextCreate();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        ProEditFontActivity.G(a).setVisibility(0);
        ProEditFontActivity.G(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f0601ca)).append(":").append(String.valueOf(i)).toString());
        ProEditFontActivity.h(a);
    }

    public void a(ama ama1)
    {
        ProEditFontActivity.a(a, ama1);
        if (!ProEditFontActivity.F(a).a && !ProEditFontActivity.F(a).e)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        if (!alr.a().b(ProEditFontActivity.F(a))) goto _L2; else goto _L1
_L1:
        if (alr.a().a(ProEditFontActivity.F(a)) != null)
        {
            if (ProEditFontActivity.n(a) != null)
            {
                ProEditFontActivity.n(a).setFontLabelFontInfo(ProEditFontActivity.F(a));
                ProEditFontActivity.n(a).onTextCreate();
                ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                ProEditFontActivity.h(a);
            }
            apq.a(apq.d, ProEditFontActivity.F(a).f);
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
        apq.a(apq.d, ProEditFontActivity.F(a).f);
        return;
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
        apq.a(apq.g, (new StringBuilder()).append("style_").append(fonttextlabelinfo.a).toString());
        ProEditFontActivity.h(a);
    }

    public void b()
    {
        ProEditFontActivity.a(a, ProEditFontActivity.G(a), 0x7f04001e, 300L, false);
    }

    public void b(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setLabelStrokeColor(i);
            ProEditFontActivity.n(a).onTextCreate();
        }
    }

    public void b(FontTextLabelInfo fonttextlabelinfo)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setLabelTextImage(fonttextlabelinfo);
            ProEditFontActivity.n(a).onTextCreate();
        }
        if (fonttextlabelinfo.o)
        {
            apq.a(apq.f, fonttextlabelinfo.i);
            return;
        } else
        {
            apq.a(apq.e, String.format("#%06X", new Object[] {
                Integer.valueOf(0xffffff & fonttextlabelinfo.j)
            }));
            return;
        }
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
        ProEditFontActivity.G(a).setVisibility(0);
        ProEditFontActivity.G(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f0601c9)).append(":").append(String.valueOf(i)).toString());
        ProEditFontActivity.h(a);
    }

    public void d(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setShadowLabelColor(i);
            ProEditFontActivity.n(a).onTextCreate();
        }
    }

    public void e(int i)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setTextLabelAlpha(i);
            ProEditFontActivity.n(a).onTextCreate();
        }
    }
}
