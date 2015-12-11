// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSEGraphic, CameraPreview

public class TrackingDotsGraphic extends FSEGraphic
{

    private static Bitmap mTrackingDotBitmap = null;
    private List mPoints;

    public TrackingDotsGraphic(Context context, List list)
    {
        mPoints = list;
        if (mTrackingDotBitmap == null)
        {
            mTrackingDotBitmap = BitmapFactory.decodeResource(context.getResources(), com.amazon.mShop.android.lib.R.drawable.view_it_tracker_dot);
        }
    }

    public void draw(Canvas canvas, CameraPreview camerapreview)
    {
        if (mPoints != null && mPoints.size() >= 2)
        {
            Iterator iterator = mPoints.iterator();
            while (iterator.hasNext()) 
            {
                PointF pointf = camerapreview.translatePoint((PointF)iterator.next());
                canvas.drawBitmap(mTrackingDotBitmap, pointf.x, pointf.y, null);
            }
        }
    }

    public void setCenterPoint(PointF pointf)
    {
    }

}
