// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSEGraphic, CameraPreview

public class BoxGraphic extends FSEGraphic
{

    private static Bitmap mCheckMark = null;
    private PointF mCenterPoint;
    private List mPoints;

    public BoxGraphic(Context context, List list, PointF pointf)
    {
        mPoints = list;
        mCenterPoint = pointf;
        if (mCheckMark == null)
        {
            mCheckMark = BitmapFactory.decodeResource(context.getResources(), com.amazon.mShop.android.lib.R.drawable.checkmark);
        }
    }

    public void draw(Canvas canvas, CameraPreview camerapreview)
    {
        if (mCenterPoint != null)
        {
            camerapreview = camerapreview.translatePoint(mCenterPoint);
            canvas.drawBitmap(mCheckMark, ((PointF) (camerapreview)).x - (float)(mCheckMark.getWidth() / 2), ((PointF) (camerapreview)).y - (float)(mCheckMark.getHeight() / 2), null);
        }
    }

    public void setCenterPoint(PointF pointf)
    {
        mCenterPoint = pointf;
    }

}
