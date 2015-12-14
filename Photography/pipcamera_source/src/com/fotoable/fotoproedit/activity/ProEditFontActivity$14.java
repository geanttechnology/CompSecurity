// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RelativeLayout;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.activity.font.TProEditTextBottomBar;
import la;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements android.view.alLayoutListener
{

    final ProEditFontActivity a;

    public void onGlobalLayout()
    {
        if (ProEditFontActivity.B(a).getVisibility() == 0)
        {
            Rect rect = new Rect();
            ProEditFontActivity.B(a).getWindowVisibleDisplayFrame(rect);
            int j = a.getResources().getDisplayMetrics().heightPixels - (rect.bottom - rect.top);
            if (j != ProEditFontActivity.C(a) && j > 100)
            {
                la.b(a, ProEditFontActivity.D(a), j);
                ProEditFontActivity.a(a, j);
                android.widget.s s = (android.widget.s)ProEditFontActivity.m(a).getLayoutParams();
                s.height = j;
                int i;
                if (s.bottomMargin < 0)
                {
                    i = j;
                } else
                {
                    i = s.bottomMargin;
                }
                s.bottomMargin = i;
                ProEditFontActivity.m(a).requestLayout();
                ((android.widget.s)ProEditFontActivity.v(a).getLayoutParams()).bottomMargin = j;
                ProEditFontActivity.v(a).requestLayout();
            }
            Log.e("ProEditFontActivity", (new StringBuilder()).append("heightDifference\uFF1A").append(j).toString());
        }
    }

    Bar(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }
}
