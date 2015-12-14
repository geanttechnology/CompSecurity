// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SurfaceViewMainContainer extends RelativeLayout
{

    public SurfaceViewMainContainer(Context context)
    {
        super(context);
    }

    public SurfaceViewMainContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SurfaceViewMainContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        getContext();
    }
}
