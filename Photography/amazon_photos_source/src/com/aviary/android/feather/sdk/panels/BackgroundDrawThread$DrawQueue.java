// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.PointF;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BackgroundDrawThread

static class add extends LinkedBlockingQueue
{

    private static final long serialVersionUID = 1L;
    private volatile boolean completed;
    private com.aviary.android.feather.headless.filters.ted mode;
    private float radius;
    private PointF startPoint;

    public void end()
    {
        completed = true;
    }

    public com.aviary.android.feather.headless.filters.ted getMode()
    {
        return mode;
    }

    public PointF getOriginalPoint()
    {
        return startPoint;
    }

    public float getRadius()
    {
        return radius;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public e(com.aviary.android.feather.headless.filters. , float f, float af[])
    {
        mode = ;
        radius = f;
        completed = false;
        startPoint = new PointF();
        if (af != null && af.length >= 2)
        {
            startPoint.x = af[0];
            startPoint.y = af[1];
        }
        add(af);
    }
}
