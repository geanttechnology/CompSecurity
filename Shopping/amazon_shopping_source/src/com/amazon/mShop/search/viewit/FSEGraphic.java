// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.graphics.Canvas;
import android.graphics.PointF;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraPreview

public abstract class FSEGraphic
{

    public FSEGraphic()
    {
    }

    public abstract void draw(Canvas canvas, CameraPreview camerapreview);

    public abstract void setCenterPoint(PointF pointf);
}
