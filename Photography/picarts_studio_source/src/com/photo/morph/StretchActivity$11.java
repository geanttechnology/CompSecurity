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
//            StretchActivity, MorphGLSurfaceView

final class a
    implements android.view.r
{

    private StretchActivity a;

    public final void onClick(View view)
    {
        com.photo.morph.brushes.a a1 = StretchActivity.e(a).c;
        if (view.getId() == 0x7f100149)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "select"));
            if (a1 == StretchActivity.l(a) && StretchActivity.l(a).f == com.photo.morph.brushes.LECT)
            {
                StretchActivity.p(a);
                return;
            }
            StretchActivity.m(a);
        } else
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "deselect"));
            if (a1 == StretchActivity.l(a) && StretchActivity.l(a).f == com.photo.morph.brushes.SELECT)
            {
                StretchActivity.p(a);
                return;
            }
            if (StretchActivity.o(a) != null)
            {
                StretchActivity.o(a).setVisibility(8);
            }
            StretchActivity.a(a, a.findViewById(0x7f10014c));
            StretchActivity.q(a);
            a.g();
            StretchActivity.l(a).f = com.photo.morph.brushes.SELECT;
        }
        if (StretchActivity.n(a) != null)
        {
            StretchActivity.n(a).setChecked(false);
        }
        StretchActivity.o(a).setVisibility(0);
    }

    .Mode(StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
