// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.tremorvideo.sdk.android.videoad.ad;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            m, a

public class d extends View
{

    m a;

    public d(Context context, a a1)
    {
        super(context);
    }

    public void a(m m1)
    {
        a = m1;
    }

    protected int getSuggestedMinimumHeight()
    {
        return 0;
    }

    protected int getSuggestedMinimumWidth()
    {
        return 0;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        try
        {
            a.c(canvas);
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        canvas.restore();
    }
}
