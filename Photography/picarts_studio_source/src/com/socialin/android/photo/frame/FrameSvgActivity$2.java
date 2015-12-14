// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.widget.LinearLayout;
import com.socialin.android.colorpicker.c;
import com.socialin.android.photo.view.ColorView;

// Referenced classes of package com.socialin.android.photo.frame:
//            FrameSvgActivity, FrameSvgView

final class a
    implements c
{

    private FrameSvgActivity a;

    public final void a(int i)
    {
        FrameSvgActivity.b(a).setSvgColor(i);
        LinearLayout linearlayout = (LinearLayout)a.findViewById(0x7f100a92);
        linearlayout.removeAllViews();
        linearlayout.addView(new ColorView(a, i));
    }

    _cls9(FrameSvgActivity framesvgactivity)
    {
        a = framesvgactivity;
        super();
    }
}
