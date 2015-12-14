// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.edmodo.cropper.a.a;
import com.edmodo.cropper.a.b;
import com.edmodo.cropper.a.d;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.Handle;

public class CropOverlayView extends View
{

    private static final float a;
    private static final float b;
    private static final float c;
    private static final float d;
    private int A;
    private int B;
    private int C;
    private PointF D;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Rect i;
    private float j;
    private float k;
    private Pair l;
    private Handle m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    private int r;
    private boolean s;
    private boolean t;
    private float u;
    private float v;
    private float w;
    private int x;
    private int y;
    private int z;

    public CropOverlayView(Context context)
    {
        super(context);
        n = false;
        o = 1;
        p = 1;
        q = (float)o / (float)p;
        s = false;
        t = false;
        D = new PointF();
        a(context);
    }

    public CropOverlayView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        n = false;
        o = 1;
        p = 1;
        q = (float)o / (float)p;
        s = false;
        t = false;
        D = new PointF();
        a(context);
    }

    private int a(android.graphics.BitmapFactory.Options options, int i1, int j1)
    {
        int i2 = options.outHeight;
        int j2 = options.outWidth;
        int l1 = 1;
        int k1 = 1;
        if (i2 > j1 || j2 > i1)
        {
            i2 /= 2;
            j2 /= 2;
            do
            {
                l1 = k1;
                if (i2 / k1 <= j1)
                {
                    break;
                }
                l1 = k1;
                if (j2 / k1 <= i1)
                {
                    break;
                }
                k1 *= 2;
            } while (true);
        }
        return l1;
    }

    private Bitmap a(Resources resources, int i1, int j1, int k1)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i1, options);
        options.inSampleSize = a(options, j1, k1);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i1, options);
    }

    private void a(float f1, float f2)
    {
        float f3 = Edge.a.a();
        float f4 = Edge.b.a();
        float f5 = Edge.c.a();
        float f6 = Edge.d.a();
        m = com.edmodo.cropper.a.b.a(f1, f2, f3, f4, f5, f6, j);
        if (m == null)
        {
            return;
        } else
        {
            l = com.edmodo.cropper.a.b.a(m, f1, f2, f3, f4, f5, f6);
            invalidate();
            return;
        }
    }

    private void a(Context context)
    {
        android.util.DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        j = com.edmodo.cropper.a.b.a(context);
        k = TypedValue.applyDimension(1, 6F, displaymetrics);
        e = com.edmodo.cropper.a.d.a(context);
        f = com.edmodo.cropper.a.d.a();
        h = com.edmodo.cropper.a.d.b(context);
        g = com.edmodo.cropper.a.d.c(context);
        v = TypedValue.applyDimension(1, c, displaymetrics);
        u = TypedValue.applyDimension(1, d, displaymetrics);
        w = TypedValue.applyDimension(1, 20F, displaymetrics);
        r = 1;
    }

    private void a(Canvas canvas)
    {
        float f1 = Edge.a.a();
        float f4 = Edge.b.a();
        float f2 = Edge.c.a();
        float f3 = Edge.d.a();
        float f5 = Edge.b() / 3F;
        float f6 = f1 + f5;
        canvas.drawLine(f6, f4, f6, f3, f);
        f5 = f2 - f5;
        canvas.drawLine(f5, f4, f5, f3, f);
        f5 = Edge.c() / 3F;
        f4 += f5;
        canvas.drawLine(f1, f4, f2, f4, f);
        f3 -= f5;
        canvas.drawLine(f1, f3, f2, f3, f);
    }

    private void a(Canvas canvas, Rect rect)
    {
        float f1 = Edge.a.a();
        float f2 = Edge.b.a();
        float f3 = Edge.c.a();
        float f4 = Edge.d.a();
        canvas.drawRect(rect.left, rect.top, rect.right, f2, h);
        canvas.drawRect(rect.left, f4, rect.right, rect.bottom, h);
        canvas.drawRect(rect.left, f2, f1, f4, h);
        canvas.drawRect(f3, f2, rect.right, f4, h);
    }

    private void a(Rect rect)
    {
        if (!t)
        {
            t = true;
        }
        if (!n)
        {
            break MISSING_BLOCK_LABEL_487;
        }
        if (com.edmodo.cropper.a.a.a(rect) <= q) goto _L2; else goto _L1
_L1:
        Edge.b.a(rect.top);
        Edge.d.a(rect.bottom);
        float f1 = (float)getWidth() / 2.0F;
        float f10 = Math.max(40F, com.edmodo.cropper.a.a.a(Edge.b.a(), Edge.d.a(), q));
        if (f10 == 40F)
        {
            q = 40F / (Edge.d.a() - Edge.b.a());
        }
        float f6 = f10 / 2.0F;
        Edge.a.a(f1 - f6);
        Edge.c.a(f1 + f6);
        if (D.x != 0.0F && D.y != 0.0F)
        {
            int i1 = rect.width();
            f6 = ((float)rect.left + (float)i1 * D.x) - f6;
            float f2 = f6;
            if (f6 < (float)rect.left)
            {
                f2 = rect.left;
            }
            f6 = f2 + f10;
            if (f6 > (float)(rect.left + i1))
            {
                f2 -= f6 - (float)(i1 + rect.left);
                f6 = f2 + f10;
            }
            Edge.a.a(f2);
            Edge.c.a(f6);
        }
_L4:
        return;
_L2:
        float f11;
        Edge.a.a(rect.left);
        Edge.c.a(rect.right);
        float f3 = (float)getHeight() / 2.0F;
        f11 = Math.max(40F, com.edmodo.cropper.a.a.b(Edge.a.a(), Edge.c.a(), q));
        if (f11 == 40F)
        {
            q = (Edge.c.a() - Edge.a.a()) / 40F;
        }
        float f7 = f11 / 2.0F;
        Edge.b.a(f3 - f7);
        Edge.d.a(f3 + f7);
        if (D.x == 0.0F || D.y == 0.0F) goto _L4; else goto _L3
_L3:
        int j1 = rect.height();
        float f8 = ((float)rect.top + (float)j1 * D.y) - f11 / 3F;
        float f4 = f8;
        if (f8 < (float)rect.top)
        {
            f4 = rect.top;
        }
        f8 = f4 + f11;
        if (f8 > (float)(rect.top + j1))
        {
            f4 -= f8 - (float)(j1 + rect.top);
            f8 = f4 + f11;
        }
        Edge.b.a(f4);
        Edge.d.a(f8);
        return;
        float f5 = (float)rect.width() * 0.1F;
        float f9 = (float)rect.height() * 0.1F;
        Edge.a.a((float)rect.left + f5);
        Edge.b.a((float)rect.top + f9);
        Edge.c.a((float)rect.right - f5);
        Edge.d.a((float)rect.bottom - f9);
        return;
    }

    public static boolean a()
    {
        return Math.abs(Edge.a.a() - Edge.c.a()) >= 100F && Math.abs(Edge.b.a() - Edge.d.a()) >= 100F;
    }

    private void b()
    {
        if (m == null)
        {
            return;
        } else
        {
            m = null;
            invalidate();
            return;
        }
    }

    private void b(float f1, float f2)
    {
        if (m == null)
        {
            return;
        }
        f1 += ((Float)l.first).floatValue();
        f2 += ((Float)l.second).floatValue();
        if (n)
        {
            m.a(f1, f2, q, i, k);
        } else
        {
            m.a(f1, f2, i, k);
        }
        invalidate();
    }

    private void b(Canvas canvas)
    {
        if (x != 0 && y != 0 && z != 0 && A != 0)
        {
            if (!c(canvas))
            {
                d(canvas);
            }
            return;
        } else
        {
            d(canvas);
            return;
        }
    }

    private void b(Canvas canvas, Rect rect)
    {
        float f1 = Edge.a.a();
        float f2 = Edge.b.a();
        float f3 = Edge.c.a();
        float f4 = Edge.d.a();
        int i1 = rect.right - rect.left;
        int j1 = rect.bottom - rect.top;
        Bitmap bitmap = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        Object obj = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#B0000000"));
        ((Canvas) (obj)).drawRect(0.0F, 0.0F, i1, j1, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        float f5 = Math.min((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
        float f6 = rect.left;
        float f7 = rect.top;
        ((Canvas) (obj)).drawCircle((f1 - f6) + (f3 - f1) / 2.0F, (f2 - f7) + (f4 - f2) / 2.0F, f5, paint);
        obj = new Paint();
        canvas.drawBitmap(bitmap, rect.left, rect.top, ((Paint) (obj)));
    }

    private boolean c(Canvas canvas)
    {
        try
        {
            float f1 = Edge.a.a();
            float f2 = Edge.b.a();
            float f3 = Edge.c.a();
            float f4 = Edge.d.a();
            Bitmap bitmap = a(getResources(), x, B, C);
            int i1 = bitmap.getWidth() / 2;
            int j1 = bitmap.getHeight() / 2;
            canvas.drawBitmap(bitmap, f1 - (float)i1, f2 - (float)j1, g);
            bitmap = a(getResources(), y, B, C);
            i1 = bitmap.getWidth() / 2;
            j1 = bitmap.getHeight() / 2;
            canvas.drawBitmap(bitmap, f3 - (float)i1, f2 - (float)j1, g);
            bitmap = a(getResources(), z, B, C);
            i1 = bitmap.getWidth() / 2;
            j1 = bitmap.getHeight() / 2;
            canvas.drawBitmap(bitmap, f1 - (float)i1, f4 - (float)j1, g);
            bitmap = a(getResources(), A, B, C);
            i1 = bitmap.getWidth() / 2;
            j1 = bitmap.getHeight() / 2;
            canvas.drawBitmap(bitmap, f3 - (float)i1, f4 - (float)j1, g);
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            canvas.printStackTrace();
            return false;
        }
        return true;
    }

    private void d(Canvas canvas)
    {
        float f1 = Edge.a.a();
        float f2 = Edge.b.a();
        float f3 = Edge.c.a();
        float f4 = Edge.d.a();
        canvas.drawLine(f1 - v, f2 - u, f1 - v, f2 + w, g);
        canvas.drawLine(f1, f2 - v, f1 + w, f2 - v, g);
        canvas.drawLine(f3 + v, f2 - u, f3 + v, f2 + w, g);
        canvas.drawLine(f3, f2 - v, f3 - w, f2 - v, g);
        canvas.drawLine(f1 - v, f4 + u, f1 - v, f4 - w, g);
        canvas.drawLine(f1, f4 + v, f1 + w, f4 + v, g);
        canvas.drawLine(f3 + v, f4 + u, f3 + v, f4 - w, g);
        canvas.drawLine(f3, f4 + v, f3 - w, f4 + v, g);
    }

    public void a(int i1, boolean flag, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2, int i3, boolean flag1)
    {
        if (i1 < 0 || i1 > 2)
        {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        r = i1;
        n = flag;
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        o = j1;
        q = (float)o / (float)p;
        if (k1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else
        {
            p = k1;
            q = (float)o / (float)p;
            x = l1;
            y = i2;
            z = j2;
            A = k2;
            B = l2;
            C = i3;
            s = flag1;
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (s)
        {
            b(canvas, i);
        } else
        {
            a(canvas, i);
        }
        if (!a()) goto _L2; else goto _L1
_L1:
        if (r != 2) goto _L4; else goto _L3
_L3:
        a(canvas);
_L2:
        canvas.drawRect(Edge.a.a(), Edge.b.a(), Edge.c.a(), Edge.d.a(), e);
        b(canvas);
        return;
_L4:
        if (r == 1)
        {
            if (m != null)
            {
                a(canvas);
            }
        } else
        if (r != 0);
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        a(i);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled())
        {
            return false;
        }
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            a(motionevent.getX(), motionevent.getY());
            return true;

        case 1: // '\001'
        case 3: // '\003'
            getParent().requestDisallowInterceptTouchEvent(false);
            b();
            return true;

        case 2: // '\002'
            b(motionevent.getX(), motionevent.getY());
            break;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void setAspectRatioX(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        o = i1;
        q = (float)o / (float)p;
        if (t)
        {
            a(i);
            invalidate();
        }
    }

    public void setAspectRatioY(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        p = i1;
        q = (float)o / (float)p;
        if (t)
        {
            a(i);
            invalidate();
        }
    }

    public void setBitmapRect(Rect rect)
    {
        i = rect;
        a(i);
    }

    public void setCicleBackground(boolean flag)
    {
        s = flag;
        if (t)
        {
            a(i);
            invalidate();
        }
    }

    public void setEyeMidPoint(PointF pointf)
    {
        D = pointf;
    }

    public void setFixedAspectRatio(boolean flag)
    {
        n = flag;
        if (t)
        {
            a(i);
            invalidate();
        }
    }

    public void setGuidelines(int i1)
    {
        if (i1 < 0 || i1 > 2)
        {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        r = i1;
        if (t)
        {
            a(i);
            invalidate();
        }
    }

    static 
    {
        a = com.edmodo.cropper.a.d.b();
        b = com.edmodo.cropper.a.d.c();
        c = a / 2.0F - b / 2.0F;
        d = a / 2.0F + c;
    }
}
