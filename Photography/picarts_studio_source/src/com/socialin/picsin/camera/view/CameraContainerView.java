// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewGingerbread, CameraViewCupcake

public class CameraContainerView extends RelativeLayout
{

    public CameraContainerView(Context context)
    {
        super(context);
    }

    public CameraContainerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CameraContainerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        getContext();
    }

    public void setupSurfaceViewSize(int i, int j)
    {
        CameraViewGingerbread cameraviewgingerbread = (CameraViewGingerbread)findViewWithTag("CAMERA_VIEW_HONEYCOMB_TAG");
        Object obj = ((CameraViewCupcake) (cameraviewgingerbread)).o;
        float f = (float)i / (float)((Point) (obj)).x;
        float f1 = (float)j / (float)((Point) (obj)).y;
        if (f >= f1)
        {
            f = f1;
        }
        i = (int)((float)((Point) (obj)).x * f);
        j = (int)(f * (float)((Point) (obj)).y);
        cameraviewgingerbread.setFirstBestSize(new Point(i, j));
        obj = new android.widget.RelativeLayout.LayoutParams(i - 1, j - 1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        cameraviewgingerbread.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        requestLayout();
        cameraviewgingerbread.requestLayout();
    }
}
