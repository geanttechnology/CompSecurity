// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class c
    implements Runnable
{

    private HashMap a;
    private int b;
    private String c;
    private DrawingActivity d;

    public final void run()
    {
        AnalyticUtils.getInstance(d).track(new com.socialin.android.apiv3.events.ayerAddedEvent("photo"));
        if (a != null)
        {
            DrawingActivity.b(d).c.a(a, b);
            return;
        } else
        {
            DrawingActivity.b(d).c.a(c, b);
            return;
        }
    }

    wLayerAddedEvent(DrawingActivity drawingactivity, HashMap hashmap, int i, String s)
    {
        d = drawingactivity;
        a = hashmap;
        b = i;
        c = s;
        super();
    }
}
