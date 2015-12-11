// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CameraPreviewSurfaceView extends SurfaceView
{

    int height;
    int width;

    public CameraPreviewSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getSurfaceViewHeight()
    {
        return height;
    }

    public int getSurfaceViewWidth()
    {
        return width;
    }

    public void setScaledDimensions(int i, int j)
    {
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(i, j));
        width = i;
        height = j;
    }
}
