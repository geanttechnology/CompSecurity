// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

public class e
{

    CloneActivity a;

    e(CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }

    public void a()
    {
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(CloneActivity.a(a).a, "from_click"));
    }

    public void b()
    {
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(CloneActivity.a(a).a, "to_click"));
    }

    public void c()
    {
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCloneTryEvent(CloneActivity.a(a).a, "drag"));
    }
}
