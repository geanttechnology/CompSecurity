// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.view.View;
import android.widget.RadioButton;
import com.photo.morph.brushes.SelectBrush;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.photo.morph:
//            StretchActivity, MorphGLSurfaceView, MorphRenderer

final class a
    implements android.view.r
{

    private StretchActivity a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "erase_select"));
        StretchActivity.e(a).b.setDefaultSelection();
        StretchActivity.k(a);
        if (StretchActivity.e(a).c == StretchActivity.l(a) && StretchActivity.l(a).f == com.photo.morph.brushes.SELECT)
        {
            StretchActivity.m(a);
            if (StretchActivity.n(a) != null)
            {
                StretchActivity.n(a).setChecked(false);
            }
            StretchActivity.o(a).setVisibility(0);
        }
    }

    .Mode(StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
