// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.brushlib.view.DrawingView;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.widget.electedListener
{

    private DrawingActivity a;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        view = (BlendMode)DrawingActivity.a(a).get(i);
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(a);
        if (view != null)
        {
            adapterview = view.toString();
        } else
        {
            adapterview = null;
        }
        analyticutils.track(new com.socialin.android.apiv3.events.ustomBlendEvent("drawing_layers", adapterview));
        DrawingActivity.b(a).setSelectedLayerBlendMode(view);
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    tCustomBlendEvent(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
