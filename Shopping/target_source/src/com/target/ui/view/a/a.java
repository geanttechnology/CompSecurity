// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import java.lang.ref.WeakReference;

public class a
{

    private static final float ACCEPTABLE_SCALE_MIN = 1F;
    private static final float FADE_MAX = 1F;
    private static final float FADE_MIN = 0F;
    private static final int GRADIENT_END_COLOR = 0;
    private static final int GRADIENT_HEIGHT = 1;
    private static final int GRADIENT_NO_POSITION = 0;
    private static final float NO_SCALE = 1F;
    private Matrix mMatrix;
    private Paint mPaint;
    private Shader mShader;
    private int mShadowLength;
    private WeakReference mViewRef;

    public a(View view, Context context)
    {
        mMatrix = new Matrix();
        mPaint = new Paint();
        mViewRef = new WeakReference(view);
        view = context.getResources();
        mShadowLength = view.getDimensionPixelSize(0x7f0a02a3);
        mShader = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, view.getColor(0x7f0f00d3), 0, android.graphics.Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);
    }

    public int a()
    {
        return mShadowLength;
    }

    public void a(Canvas canvas, float f)
    {
        View view = (View)mViewRef.get();
        if (view != null)
        {
            int i = view.getScrollX();
            int j = view.getRight();
            int k = view.getLeft();
            int l = view.getScrollY();
            float f1 = mShadowLength;
            f = Math.max(0.0F, Math.min(1.0F, f)) * f1;
            if (f > 1.0F)
            {
                mMatrix.setScale(1.0F, f);
                mMatrix.postTranslate(i, l);
                mShader.setLocalMatrix(mMatrix);
                mPaint.setShader(mShader);
                canvas.drawRect(i, l, (j + i) - k, f1 + (float)l, mPaint);
                return;
            }
        }
    }
}
