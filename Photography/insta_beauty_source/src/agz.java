// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;

public class agz
    implements akn
{

    final ProEditFontActivity a;

    public agz(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void a(FontTextLabelView fonttextlabelview)
    {
        if (ProEditFontActivity.g(a))
        {
            ProEditFontActivity.a(a, false);
            ProEditFontActivity.h(a);
        }
    }
}
