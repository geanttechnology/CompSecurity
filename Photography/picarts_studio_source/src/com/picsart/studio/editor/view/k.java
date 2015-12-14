// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.fragment.MotionFragment;
import com.socialin.android.apiv3.util.AnalyticUtils;

public class k
{

    public MotionFragment a;

    public k(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }

    public void a()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolMotionTryEvent(e.a().e.a, "drag_motion"));
    }

    public void b()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolMotionTryEvent(e.a().e.a, "select"));
    }
}
