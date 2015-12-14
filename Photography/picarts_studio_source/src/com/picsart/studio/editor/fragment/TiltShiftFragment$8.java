// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.editor.view.TiltShiftEditorView;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            TiltShiftFragment

final class a
    implements android.view.
{

    private TiltShiftFragment a;

    public final void onClick(View view)
    {
        view = AnalyticUtils.getInstance(a.getActivity());
        String s = TiltShiftFragment.c;
        TiltShiftEditorView tiltshifteditorview = TiltShiftFragment.d(a);
        int i = tiltshifteditorview.l + 1;
        tiltshifteditorview.l = i;
        view.track((new com.socialin.android.apiv3.events.iftTryEvent(s, "inverse_click", i, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).k)).setBlurSliderValue((int)TiltShiftFragment.k(a).a()));
        view = TiltShiftFragment.d(a);
        boolean flag;
        if (!TiltShiftFragment.d(a).j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setInverted(flag);
    }

    ftTryEvent(TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
