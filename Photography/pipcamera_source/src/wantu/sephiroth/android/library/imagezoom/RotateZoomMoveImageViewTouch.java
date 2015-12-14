// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import aiv;
import aiw;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class RotateZoomMoveImageViewTouch extends ImageView
{

    static final int CLICK = 3;
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    Context context;
    PointF last;
    float m[];
    ScaleGestureDetector mScaleDetector;
    public Matrix matrix;
    public float maxScale;
    public float minScale;
    public int mode;
    int oldMeasuredHeight;
    int oldMeasuredWidth;
    public float origHeight;
    public float origWidth;
    public float saveScale;
    PointF start;
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
        mScaleDetector = new ScaleGestureDetector(context1, new aiw(this));
        context1 = new aiv(this);
        matrix = new Matrix();
        m = new float[9];
        setImageMatrix(matrix);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        setOnTouchListener(new android.view.View.OnTouchListener(context1) {

            final aiv a;
            final RotateZoomMoveImageViewTouch b;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                b.mScaleDetector.onTouchEvent(motionevent);
                a.a(motionevent);
                view = new PointF(motionevent.getX(), motionevent.getY());
                motionevent.getAction();
                JVM INSTR tableswitch 0 6: default 84
            //                           0 93
            //                           1 247
            //                           2 132
            //                           3 84
            //                           4 84
            //                           5 84
            //                           6 320;
                   goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
                b.invalidate();
                return true;
_L2:
                b.last.set(view);
                b.start.set(b.last);
                b.mode = 1;
                continue; /* Loop/switch isn't completed */
_L4:
                if (b.mode == 1)
                {
                    float f = ((PointF) (view)).x;
                    float f1 = b.last.x;
                    float f2 = ((PointF) (view)).y;
                    float f3 = b.last.y;
                    b.last.set(((PointF) (view)).x, ((PointF) (view)).y);
                    view = (android.widget.FrameLayout.LayoutParams)b.getLayoutParams();
                    view.setMargins((int)((f - f1) + (float)((android.widget.FrameLayout.LayoutParams) (view)).leftMargin), (int)((f2 - f3) + (float)((android.widget.FrameLayout.LayoutParams) (view)).topMargin), 0, 0);
                    b.setLayoutParams(view);
                }
                continue; /* Loop/switch isn't completed */
_L3:
                b.mode = 0;
                int i = (int)Math.abs(((PointF) (view)).x - b.start.x);
                int j = (int)Math.abs(((PointF) (view)).y - b.start.y);
                if (i < 3 && j < 3)
                {
                    b.performClick();
                }
                continue; /* Loop/switch isn't completed */
_L5:
                b.mode = 0;
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                b = RotateZoomMoveImageViewTouch.this;
                a = aiv1;
                super();
            }
        });
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

    public void setMaxZoom(float f)
    {
        maxScale = f;
    }
}
