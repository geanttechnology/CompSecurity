// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.view.TiltShiftEditorView;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            TiltShiftFragment

final class a
    implements android.view..TiltShiftFragment._cls11
{

    private TiltShiftFragment a;

    public final void onClick(View view)
    {
        if (TiltShiftFragment.b(a) != null)
        {
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ftCloseEvent(com.picsart.studio.editor.fragment.TiltShiftFragment.c, "cancel", TiltShiftFragment.n(a).name().toLowerCase(), String.valueOf(TiltShiftFragment.k(a).a()), TiltShiftFragment.d(a).l, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).j));
        }
        TiltShiftFragment.o(a);
        if (a.g != null)
        {
            a.g.a(a);
        }
    }

    tShiftMode(TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
