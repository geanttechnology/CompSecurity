// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontKeyBoardBottomView;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar;

public class agk
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ProEditFontActivity a;

    public agk(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void onGlobalLayout()
    {
        if (ProEditFontActivity.B(a).getVisibility() == 0)
        {
            Rect rect = new Rect();
            ProEditFontActivity.B(a).getWindowVisibleDisplayFrame(rect);
            int j = a.getResources().getDisplayMetrics().heightPixels - (rect.bottom - rect.top);
            if (j != ProEditFontActivity.C(a) && j > 100)
            {
                aqx.b(a, ProEditFontActivity.D(a), j);
                ProEditFontActivity.a(a, j);
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ProEditFontActivity.m(a).getLayoutParams();
                layoutparams.height = j;
                int i;
                if (layoutparams.bottomMargin < 0)
                {
                    i = j;
                } else
                {
                    i = layoutparams.bottomMargin;
                }
                layoutparams.bottomMargin = i;
                ProEditFontActivity.m(a).requestLayout();
                ((android.widget.FrameLayout.LayoutParams)ProEditFontActivity.v(a).getLayoutParams()).bottomMargin = j;
                ProEditFontActivity.v(a).requestLayout();
            }
        }
    }
}
