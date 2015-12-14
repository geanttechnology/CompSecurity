// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.View;
import com.socialin.android.brushlib.view.DrawingView;
import java.util.concurrent.Callable;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Callable
{

    private DrawingActivity a;

    public final Object call()
    {
        int i;
        if (a.getResources().getConfiguration().orientation == 2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            i = a.findViewById(0x7f10033c).getWidth();
            int j = a.findViewById(0x7f1003ac).getWidth();
            if (DrawingActivity.s(a))
            {
                return new RectF(0.0F, 0.0F, DrawingActivity.b(a).getWidth(), DrawingActivity.b(a).getHeight());
            } else
            {
                return new RectF(i, 0.0F, DrawingActivity.b(a).getWidth() - j, DrawingActivity.b(a).getHeight());
            }
        }
        i = a.findViewById(0x7f10033c).getHeight();
        int k = a.findViewById(0x7f1003ac).getHeight();
        if (DrawingActivity.s(a))
        {
            return new RectF(0.0F, 0.0F, DrawingActivity.b(a).getWidth(), DrawingActivity.b(a).getHeight());
        } else
        {
            return new RectF(0.0F, i, DrawingActivity.b(a).getWidth(), DrawingActivity.b(a).getHeight() - k);
        }
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
