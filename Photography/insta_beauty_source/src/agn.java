// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import com.instabeauty.application.InstaBeautyApplication;

public class agn
    implements alv
{

    final ama a;
    final ProEditFontActivity b;

    public agn(ProEditFontActivity proeditfontactivity, ama ama1)
    {
        b = proeditfontactivity;
        a = ama1;
        super();
    }

    public void a()
    {
        Toast.makeText(InstaBeautyApplication.a, InstaBeautyApplication.a.getResources().getString(0x7f0600e7), 0).show();
    }

    public void a(Typeface typeface)
    {
        if (ProEditFontActivity.n(b) != null)
        {
            ProEditFontActivity.n(b).setFontLabelFontInfo(a);
            ProEditFontActivity.n(b).onTextCreate();
            ProEditFontActivity.a(b, ProEditFontActivity.n(b));
            ProEditFontActivity.h(b);
        }
        apq.a(apq.d, ProEditFontActivity.F(b).f);
        ProEditFontActivity.m(b).refreshFontList();
    }
}
