// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.a;

public final class g
    implements android.view.View.OnClickListener
{

    private a a;
    private Runnable b;

    public g(Runnable runnable, a a1)
    {
        b = runnable;
        a = a1;
    }

    public final void onClick(View view)
    {
        if (((CheckBox)view.getRootView().findViewById(0x7f100376)).isChecked() && a != null)
        {
            a.a("prefs.rec.size.donotshow", true);
            AnalyticUtils.getInstance(view.getContext()).track(new com.socialin.android.apiv3.events.EventsFactory.HighResDialogNotShowAgainEvent(true));
        } else
        {
            AnalyticUtils.getInstance(view.getContext()).track(new com.socialin.android.apiv3.events.EventsFactory.HighResDialogNotShowAgainEvent(false));
        }
        if (((RadioButton)view.getRootView().findViewById(0x7f100374)).isChecked())
        {
            PicsartContext.a(view.getContext(), PicsartContext.a.getMaxImageSizePixel());
        } else
        {
            PicsartContext.a(view.getContext(), PicsartContext.a.getRecomendedImageSizePixel());
        }
        if (b != null)
        {
            b.run();
        }
    }
}
