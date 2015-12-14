// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.edmodo.cropper.a.c;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.edge.Edge;

// Referenced classes of package com.edmodo.cropper:
//            d, c, b

public class CropImageView extends FrameLayout
{

    private static final Rect a = new Rect();
    private ImageView b;
    private CropOverlayView c;
    private Bitmap d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private PointF t;

    public CropImageView(Context context)
    {
        super(context);
        e = 0;
        h = 1;
        i = false;
        j = 1;
        k = 1;
        l = 0;
        m = 0;
        n = 0;
        o = 0;
        p = 0;
        q = 0;
        r = 0;
        s = false;
        t = new PointF();
        a(context);
    }

    public CropImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = 0;
        h = 1;
        i = false;
        j = 1;
        k = 1;
        l = 0;
        m = 0;
        n = 0;
        o = 0;
        p = 0;
        q = 0;
        r = 0;
        s = false;
        t = new PointF();
        attributeset = context.obtainStyledAttributes(attributeset, d.CropImageView, 0, 0);
        h = attributeset.getInteger(d.CropImageView_guidelines, 1);
        i = attributeset.getBoolean(d.CropImageView_fixAspectRatio, false);
        j = attributeset.getInteger(d.CropImageView_aspectRatioX, 1);
        k = attributeset.getInteger(d.CropImageView_aspectRatioY, 1);
        l = attributeset.getResourceId(d.CropImageView_imageResource, 0);
        m = attributeset.getResourceId(d.CropImageView_cornerResourceTopLeft, 0);
        n = attributeset.getResourceId(d.CropImageView_cornerResourceTopRight, 0);
        o = attributeset.getResourceId(d.CropImageView_cornerResourceBottomLeft, 0);
        p = attributeset.getResourceId(d.CropImageView_cornerResourceBottomRight, 0);
        q = attributeset.getInteger(d.CropImageView_cornerResourceWidth, 0);
        r = attributeset.getInteger(d.CropImageView_cornerResourceHeight, 0);
        s = attributeset.getBoolean(d.CropImageView_circleBackground, false);
        attributeset.recycle();
        a(context);
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    private static int a(int i1, int j1, int k1)
    {
        if (i1 == 0x40000000)
        {
            return j1;
        }
        if (i1 == 0x80000000)
        {
            return Math.min(k1, j1);
        } else
        {
            return k1;
        }
    }

    private void a(Context context)
    {
        context = LayoutInflater.from(context).inflate(c.crop_image_view, this, true);
        b = (ImageView)context.findViewById(b.ImageView_image);
        setImageResource(l);
        c = (CropOverlayView)context.findViewById(com.edmodo.cropper.b.CropOverlayView);
        c.a(h, i, j, k, m, n, o, p, q, r, s);
    }

    public void a(int i1)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(i1);
        d = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), matrix, true);
        setImageBitmap(d);
        e = e + i1;
        e = e % 360;
    }

    public void a(int i1, int j1)
    {
        j = i1;
        c.setAspectRatioX(j);
        k = j1;
        c.setAspectRatioY(k);
    }

    public void a(Bitmap bitmap, int i1)
    {
        Matrix matrix;
        if (bitmap == null)
        {
            return;
        }
        matrix = new Matrix();
        i1;
        JVM INSTR tableswitch 3 8: default 52
    //                   3 72
    //                   4 52
    //                   5 52
    //                   6 79
    //                   7 52
    //                   8 65;
           goto _L1 _L2 _L1 _L1 _L3 _L1 _L4
_L3:
        break MISSING_BLOCK_LABEL_79;
_L1:
        i1 = -1;
_L5:
        if (i1 == -1)
        {
            setImageBitmap(bitmap);
            return;
        } else
        {
            matrix.postRotate(i1);
            setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
            bitmap.recycle();
            return;
        }
_L4:
        i1 = 270;
          goto _L5
_L2:
        i1 = 180;
          goto _L5
        i1 = 90;
          goto _L5
    }

    public RectF getActualCropRect()
    {
        Rect rect = com.edmodo.cropper.a.c.a(d, b);
        float f1 = (float)d.getWidth() / (float)rect.width();
        float f2 = (float)d.getHeight() / (float)rect.height();
        float f7 = Edge.a.a();
        float f8 = rect.left;
        float f5 = Edge.b.a();
        float f6 = rect.top;
        float f3 = Edge.b();
        float f4 = Edge.c();
        f7 = (f7 - f8) * f1;
        f5 = (f5 - f6) * f2;
        return new RectF(Math.max(0.0F, f7), Math.max(0.0F, f5), Math.min(d.getWidth(), f1 * f3 + f7), Math.min(d.getHeight(), f2 * f4 + f5));
    }

    public Bitmap getCroppedImage()
    {
        Rect rect = com.edmodo.cropper.a.c.a(d, this);
        float f1 = (float)d.getWidth() / (float)rect.width();
        float f2 = (float)d.getHeight() / (float)rect.height();
        float f3 = Edge.a.a();
        float f4 = rect.left;
        float f5 = Edge.b.a();
        float f6 = rect.top;
        float f7 = Edge.b();
        float f8 = Edge.c();
        return Bitmap.createBitmap(d, (int)((f3 - f4) * f1), (int)((f5 - f6) * f2), (int)(f1 * f7), (int)(f2 * f8));
    }

    public int getImageResource()
    {
        return l;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        if (f > 0 && g > 0)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            layoutparams.width = f;
            layoutparams.height = g;
            setLayoutParams(layoutparams);
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int j2 = android.view.View.MeasureSpec.getMode(i1);
        int l1 = android.view.View.MeasureSpec.getSize(i1);
        int i2 = android.view.View.MeasureSpec.getMode(j1);
        int k1 = android.view.View.MeasureSpec.getSize(j1);
        if (d != null)
        {
            super.onMeasure(i1, j1);
            i1 = k1;
            if (k1 == 0)
            {
                i1 = d.getHeight();
            }
            double d1 = (1.0D / 0.0D);
            double d2 = (1.0D / 0.0D);
            if (l1 < d.getWidth())
            {
                d1 = (double)l1 / (double)d.getWidth();
            }
            if (i1 < d.getHeight())
            {
                d2 = (double)i1 / (double)d.getHeight();
            }
            Rect rect;
            if (d1 != (1.0D / 0.0D) || d2 != (1.0D / 0.0D))
            {
                if (d1 <= d2)
                {
                    j1 = (int)(d1 * (double)d.getHeight());
                    k1 = l1;
                } else
                {
                    k1 = (int)((double)d.getWidth() * d2);
                    j1 = i1;
                }
            } else
            {
                k1 = d.getWidth();
                j1 = d.getHeight();
            }
            k1 = a(j2, l1, k1);
            i1 = a(i2, i1, j1);
            f = k1;
            g = i1;
            rect = com.edmodo.cropper.a.c.a(d.getWidth(), d.getHeight(), f, g);
            c.setBitmapRect(rect);
            setMeasuredDimension(f, g);
            return;
        } else
        {
            c.setBitmapRect(a);
            setMeasuredDimension(l1, k1);
            return;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            if (d != null)
            {
                e = parcelable.getInt("DEGREES_ROTATED");
                int i1 = e;
                a(e);
                e = i1;
            }
            super.onRestoreInstanceState(parcelable.getParcelable("instanceState"));
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("DEGREES_ROTATED", e);
        return bundle;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (d != null)
        {
            Rect rect = com.edmodo.cropper.a.c.a(d, this);
            c.setBitmapRect(rect);
            return;
        } else
        {
            c.setBitmapRect(a);
            return;
        }
    }

    public void setCircleBackground(boolean flag)
    {
        s = flag;
        c.setCicleBackground(flag);
    }

    public void setEyeMidPoint(PointF pointf)
    {
        t = pointf;
        c.setEyeMidPoint(t);
    }

    public void setFixedAspectRatio(boolean flag)
    {
        c.setFixedAspectRatio(flag);
    }

    public void setGuidelines(int i1)
    {
        c.setGuidelines(i1);
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        d = bitmap;
        b.setImageBitmap(d);
        if (d != null)
        {
            bitmap = com.edmodo.cropper.a.c.a(d, this);
            c.setBitmapRect(bitmap);
            return;
        } else
        {
            c.setBitmapRect(a);
            return;
        }
    }

    public void setImageResource(int i1)
    {
        if (i1 != 0)
        {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), i1));
        }
    }

}
