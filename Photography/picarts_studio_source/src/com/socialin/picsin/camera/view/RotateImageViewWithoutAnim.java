// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class RotateImageViewWithoutAnim extends ImageButton
{

    public RotateImageViewWithoutAnim(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        Matrix matrix = getImageMatrix();
        matrix.postRotate(0.0F, (float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
        setImageMatrix(matrix);
    }
}
