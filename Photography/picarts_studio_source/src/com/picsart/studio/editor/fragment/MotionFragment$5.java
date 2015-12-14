// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a
    implements android.view.ner
{

    private MotionFragment a;

    public final void onClick(View view)
    {
        if (a.g != null)
        {
            a.g.a(a);
        }
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lMotionCloseEvent(e.a().e.a, "cancel", (int)MotionFragment.d(a).d()));
    }

    MotionCloseEvent(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }
}
