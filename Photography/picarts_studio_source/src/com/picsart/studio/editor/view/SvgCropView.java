// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.brushlib.svg.e;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.l;
import myobfuscated.bk.a;

public class SvgCropView extends View
{

    public static final String a = com/picsart/studio/editor/view/SvgCropView.getSimpleName();
    public static final Paint b = new Paint(3);
    private static boolean k;
    private static float l = 4F;
    private static float m = 0.2F;
    public boolean c;
    public Bitmap d;
    public a e;
    public RectF f;
    public RectF g;
    public Matrix h;
    public ScaleRotateGestureDetector i;
    public RectF j;
    private int n;
    private Paint o;
    private Paint p;
    private Path q;
    private RectF r;
    private Matrix s;
    private boolean t;

    public SvgCropView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        o = new Paint();
        p = new Paint();
        q = new Path();
        f = new RectF();
        g = new RectF();
        r = new RectF();
        h = new Matrix();
        s = new Matrix();
        t = true;
        j = new RectF();
        context = getResources();
        float f1 = l;
        float f2 = m;
        boolean flag;
        if (!k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = new ScaleRotateGestureDetector(context, f1, f2, flag);
        o.setColor(0xbb000000);
        o.setStyle(android.graphics.Paint.Style.FILL);
        p.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        p.setStyle(android.graphics.Paint.Style.FILL);
        if (android.os.Build.VERSION.SDK_INT < 18 && 1 != getLayerType())
        {
            setLayerType(1, null);
        }
    }

    static int a(SvgCropView svgcropview)
    {
        return svgcropview.n;
    }

    public final Path a()
    {
        e e1 = new e();
        e1.a(getContext().getResources().openRawResource(n), "isFrame");
        return e1.a;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (c)
        {
            canvas.save();
            canvas.drawBitmap(d, i.f, b);
            canvas.saveLayer(f, o, 31);
            canvas.drawRect(f, o);
            canvas.concat(h);
            canvas.drawPath(q, p);
            canvas.restore();
            e.a(canvas, h);
            canvas.restore();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(((SavedState)parcelable).getSuperState());
        setSvgRes(com.picsart.studio.editor.view.SavedState.a(savedstate));
        if (SavedState.b(savedstate) != -256)
        {
            setSvgColor(SavedState.b(savedstate));
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        f.set(0.0F, 0.0F, i1, j1);
        if (t)
        {
            t = false;
            if (c)
            {
                s.setRectToRect(g, f, android.graphics.Matrix.ScaleToFit.CENTER);
                i.a(s);
                float f1 = com.socialin.android.util.l.a(s);
                if (m > f1)
                {
                    m = f1;
                }
                if (l < f1)
                {
                    l = f1;
                }
                i.a(l, m);
                h.setRectToRect(r, g, android.graphics.Matrix.ScaleToFit.CENTER);
                h.postConcat(s);
            }
            return;
        } else
        {
            Matrix matrix = new Matrix();
            matrix.setTranslate((i1 - k1) / 2, (j1 - l1) / 2);
            h.postConcat(matrix);
            s = i.f;
            s.postConcat(matrix);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        i.a(motionevent);
        invalidate();
        return true;
    }

    public void setImage(Bitmap bitmap)
    {
        d = bitmap;
        g.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        c = true;
    }

    public void setSvgColor(int i1)
    {
        e.a(i1);
        invalidate();
    }

    public void setSvgRes(int i1)
    {
        n = i1;
        e = new a(getContext(), i1);
        r.set(0.0F, 0.0F, e.a, e.b);
        s.setRectToRect(g, f, android.graphics.Matrix.ScaleToFit.CENTER);
        i.a(s);
        float f1 = com.socialin.android.util.l.a(s);
        if (m > f1)
        {
            m = f1;
        }
        if (l < f1)
        {
            l = f1;
        }
        i.a(l, m);
        h.setRectToRect(r, g, android.graphics.Matrix.ScaleToFit.CENTER);
        h.postConcat(s);
        q.set(a());
        invalidate();
    }

    static 
    {
        k = Build.MODEL.equals("Nexus One");
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        private int a;
        private int b;

        static int a(SavedState savedstate)
        {
            return savedstate.a;
        }

        static int b(SavedState savedstate)
        {
            return savedstate.b;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            parcel.writeInt(b);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
            b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, SvgCropView svgcropview)
        {
            super(parcelable);
            a = com.picsart.studio.editor.view.SvgCropView.a(svgcropview);
            b = svgcropview.e.c;
        }
    }

}
