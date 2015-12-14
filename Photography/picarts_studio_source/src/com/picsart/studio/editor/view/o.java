// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.fragment.g;
import com.socialin.android.apiv3.util.AnalyticUtils;

public class o
{

    public g a;

    public o(g g1)
    {
        a = g1;
        super();
    }

    public void a()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesTryEvent(e.a().e.a, "red_change"));
    }

    public void b()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesTryEvent(e.a().e.a, "green_change"));
    }

    public void c()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesTryEvent(e.a().e.a, "blue_change"));
    }

    public void d()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCurvesTryEvent(e.a().e.a, "composite_change"));
    }
}
