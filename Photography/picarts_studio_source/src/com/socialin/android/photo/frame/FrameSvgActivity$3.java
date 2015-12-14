// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.view.View;
import android.widget.LinearLayout;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.view.ColorView;

// Referenced classes of package com.socialin.android.photo.frame:
//            FrameSvgActivity, a, FrameSvgView

final class a
    implements android.view.r
{

    private int a;
    private FrameSvgActivity b;

    public final void onClick(View view)
    {
        if (view == FrameSvgActivity.c(b) || FrameSvgActivity.d(b))
        {
            return;
        }
        AnalyticUtils.getInstance(b).trackLocalAction((new StringBuilder("frameSvgCategory:svg selected ")).append(a).toString());
        FrameSvgActivity.b(b).setSvgRes(a.f[a]);
        LinearLayout linearlayout = (LinearLayout)b.findViewById(0x7f100a92);
        linearlayout.removeAllViews();
        linearlayout.addView(new ColorView(b, 0));
        if (FrameSvgActivity.c(b) != null)
        {
            FrameSvgActivity.c(b).setSelected(false);
        }
        view.setSelected(true);
        FrameSvgActivity.a(b, view);
    }

    _cls9(FrameSvgActivity framesvgactivity, int i)
    {
        b = framesvgactivity;
        a = i;
        super();
    }
}
