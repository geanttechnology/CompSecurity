// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import com.picsart.studio.editor.view.TiltShiftEditorView;
import com.picsart.studio.view.FloatSeekBar;
import com.picsart.studio.view.c;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            TiltShiftFragment

final class a extends c
{

    private TiltShiftFragment a;

    public final void a(FloatSeekBar floatseekbar)
    {
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.getActivity());
        String s = com.picsart.studio.editor.fragment.TiltShiftFragment.c;
        TiltShiftEditorView tiltshifteditorview = TiltShiftFragment.d(a);
        int i = tiltshifteditorview.l + 1;
        tiltshifteditorview.l = i;
        analyticutils.track((new com.socialin.android.apiv3.events.iftTryEvent(s, "blur_slider_change", i, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).k)).setBlurSliderValue((int)floatseekbar.a()));
    }

    public final void a(FloatSeekBar floatseekbar, float f, boolean flag)
    {
        if (flag)
        {
            TiltShiftFragment.a(a, (int)f);
        }
    }

    ftTryEvent(TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
