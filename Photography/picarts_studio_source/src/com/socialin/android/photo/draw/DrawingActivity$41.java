// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.content.Context;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.h;
import com.socialin.android.dialog.i;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b extends i
{

    private boolean a;
    private h b;
    private DrawingActivity d;

    public final String a()
    {
        return "";
    }

    public final void a(String s)
    {
        AnalyticUtils.getInstance(d).track(new com.socialin.android.apiv3.events.aveEvent("draft"));
        DrawingActivity.a(d, a, s, b);
    }

    wSaveEvent(DrawingActivity drawingactivity, Context context, boolean flag, h h)
    {
        d = drawingactivity;
        a = flag;
        b = h;
        super(context);
    }
}
