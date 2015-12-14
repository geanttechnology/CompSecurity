// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a
    implements android.view.ner
{

    private View a;
    private MotionFragment b;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(b.getActivity()).track(new com.socialin.android.apiv3.events.lMotionTryEvent(e.a().e.a, "info_click"));
        MotionFragment.a(b, (FrameLayout)a);
    }

    MotionTryEvent(MotionFragment motionfragment, View view)
    {
        b = motionfragment;
        a = view;
        super();
    }
}
