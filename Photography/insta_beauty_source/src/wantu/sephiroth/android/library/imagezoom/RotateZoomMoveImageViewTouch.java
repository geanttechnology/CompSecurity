// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import cgi;
import cgj;
import cgk;
import com.wantu.model.res.TPhotoFreeComposeLayoutInfo;

public class RotateZoomMoveImageViewTouch extends ImageView
{

    static final int CLICK = 3;
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    Context context;
    public PointF last;
    float m[];
    public ScaleGestureDetector mScaleDetector;
    public Matrix matrix;
    public float maxScale;
    public float minScale;
    public int mode;
    int oldMeasuredHeight;
    int oldMeasuredWidth;
    public float origHeight;
    public float origWidth;
    public float saveScale;
    public PointF start;
    public int viewHeight;
    public int viewWidth;

    public RotateZoomMoveImageViewTouch(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        mode = 0;
        last = new PointF();
        start = new PointF();
        minScale = 1.0F;
        maxScale = 3F;
        saveScale = 1.0F;
        sharedConstructing(context1);
    }

    private void sharedConstructing(Context context1)
    {
        super.setClickable(true);
        context = context1;
        mScaleDetector = new ScaleGestureDetector(context1, new cgk(this, null));
        context1 = new cgj(this);
        matrix = new Matrix();
        m = new float[9];
        setImageMatrix(matrix);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        setOnTouchListener(new cgi(this, context1));
    }

    public void fixTrans()
    {
        matrix.getValues(m);
        float f1 = m[2];
        float f = m[5];
        f1 = getFixTrans(f1, viewWidth, origWidth * saveScale);
        f = getFixTrans(f, viewHeight, origHeight * saveScale);
        if (f1 != 0.0F || f != 0.0F)
        {
            matrix.postTranslate(f1, f);
        }
    }

    float getFixDragTrans(float f, float f1, float f2)
    {
        if (f2 <= f1)
        {
            f = 0.0F;
        }
        return f;
    }

    float getFixTrans(float f, float f1, float f2)
    {
        float f3 = 0.0F;
        if (f2 <= f1)
        {
            f1 -= f2;
            f2 = 0.0F;
        } else
        {
            f2 = f1 - f2;
            f1 = 0.0F;
        }
        if (f < f2)
        {
            f2 = -f + f2;
        } else
        {
            f2 = f3;
            if (f > f1)
            {
                return -f + f1;
            }
        }
        return f2;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        viewWidth = android.view.View.MeasureSpec.getSize(i);
        viewHeight = android.view.View.MeasureSpec.getSize(j);
        if ((oldMeasuredHeight != viewWidth || oldMeasuredHeight != viewHeight) && viewWidth != 0 && viewHeight != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        oldMeasuredHeight = viewHeight;
        oldMeasuredWidth = viewWidth;
        if (saveScale != 1.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = drawable.getIntrinsicWidth();
        j = drawable.getIntrinsicHeight();
        Log.d("bmSize", (new StringBuilder()).append("bmWidth: ").append(i).append(" bmHeight : ").append(j).toString());
        float f = Math.min((float)viewWidth / (float)i, (float)viewHeight / (float)j);
        float f3 = viewHeight;
        float f4 = j;
        float f1 = viewWidth;
        float f2 = i;
        f3 = (f3 - f4 * f) / 2.0F;
        f = (f1 - f2 * f) / 2.0F;
        origWidth = (float)viewWidth - f * 2.0F;
        origHeight = (float)viewHeight - f3 * 2.0F;
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        fixTrans();
        return;
    }

    public void setLayoutInfo(TPhotoFreeComposeLayoutInfo tphotofreecomposelayoutinfo, int i, Bitmap bitmap)
    {
        setMaxZoom(4F);
        getDrawable();
        float f = (float)i / 306F;
        float f1 = tphotofreecomposelayoutinfo.rotateRadius * 2.0F * 180F;
        Log.d("degree", (new StringBuilder()).append("").append(f1).toString());
        matrix.postRotate(f1);
        f1 = tphotofreecomposelayoutinfo.scale * (float)200 * f;
        float f2 = tphotofreecomposelayoutinfo.scale * (float)200 * f;
        matrix.postScale(f1, f2);
        setImageMatrix(matrix);
        i = (int)((float)(tphotofreecomposelayoutinfo.position.x / 2) * f + 0.5F);
        int j = (int)(f * (float)(tphotofreecomposelayoutinfo.position.y / 2) + 0.5F);
        tphotofreecomposelayoutinfo = new android.widget.FrameLayout.LayoutParams((int)f1, (int)f2);
        tphotofreecomposelayoutinfo.setMargins(i, j, 0, 0);
        tphotofreecomposelayoutinfo.gravity = 3;
        setLayoutParams(tphotofreecomposelayoutinfo);
    }

    public void setMaxZoom(float f)
    {
        maxScale = f;
    }
}
