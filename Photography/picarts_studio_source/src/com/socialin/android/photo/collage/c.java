// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.fragment.v;
import com.socialin.android.apiv3.util.AnalyticUtils;

public class c
{

    public v a;

    public c(v v1)
    {
        a = v1;
        super();
    }

    public void a()
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropTryEvent(e.a().e.a, "resize"));
    }
}
