// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import com.pipcamera.application.PIPCameraApplication;
import hb;
import is;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements is
{

    final hb a;
    final ProEditFontActivity b;

    public void a()
    {
        Toast.makeText(PIPCameraApplication.a, PIPCameraApplication.a.getResources().getString(0x7f0600d7), 0).show();
    }

    public void a(Typeface typeface)
    {
        Log.e("ProEditFontActivity", (new StringBuilder()).append("Font_").append(ProEditFontActivity.F(b).f).append("_installed").toString());
        if (ProEditFontActivity.n(b) != null)
        {
            ProEditFontActivity.n(b).setFontLabelFontInfo(a);
            ProEditFontActivity.n(b).onTextCreate();
            ProEditFontActivity.a(b, ProEditFontActivity.n(b));
            ProEditFontActivity.g(b);
        }
        ProEditFontActivity.m(b).refreshFontList();
    }

    mView(ProEditFontActivity proeditfontactivity, hb hb1)
    {
        b = proeditfontactivity;
        a = hb1;
        super();
    }
}
