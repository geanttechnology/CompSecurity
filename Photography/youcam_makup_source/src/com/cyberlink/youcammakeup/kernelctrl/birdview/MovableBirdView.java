// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.birdview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.i;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.w;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MovableBirdView extends View
{

    private List A;
    private Map B;
    private boolean C;
    private final float a;
    private final float b;
    private final float c;
    private final int d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private Bitmap k;
    private Bitmap l;
    private Bitmap m;
    private Bitmap n;
    private Bitmap o;
    private Bitmap p;
    private PointF q;
    private Path r;
    private Paint s;
    private Paint t;
    private Rect u;
    private RectF v;
    private Rect w;
    private RectF x;
    private Canvas y;
    private com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints z;

    public MovableBirdView(Context context)
    {
        super(context);
        a = 1.2F;
        b = 50F;
        c = 160F;
        d = 1080;
        e = 380;
        k = null;
        l = null;
        a(context);
    }

    public MovableBirdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 1.2F;
        b = 50F;
        c = 160F;
        d = 1080;
        e = 380;
        k = null;
        l = null;
        a(context);
    }

    public MovableBirdView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = 1.2F;
        b = 50F;
        c = 160F;
        d = 1080;
        e = 380;
        k = null;
        l = null;
        a(context);
    }

    private void a(Canvas canvas)
    {
        canvas.restore();
        canvas.drawBitmap(k, null, u, t);
    }

    private void a(Canvas canvas, float f1, float f2, float f3)
    {
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(Color.argb(ImageViewer.K[0], ImageViewer.K[1], ImageViewer.K[2], ImageViewer.K[3]));
        canvas.drawCircle(f1, f2, f3, paint);
    }

    private void a(Canvas canvas, float f1, int i1, int j1, Rect rect, RectF rectf, UIImageOrientation uiimageorientation, 
            Map map)
    {
        float f2;
        float f3;
        float f4;
        if (f1 > 1.0F)
        {
            f1 = 1.0F / f1;
        } else
        {
            f1 = 1.0F;
        }
        f2 = rect.left;
        f3 = rect.top;
        if (f2 == 0.0F)
        {
            f2 = ((float)i1 - (float)f / 1.2F / 2.0F) * f1;
        }
        if (f3 == 0.0F)
        {
            f3 = ((float)j1 - (float)f / 1.2F / 2.0F) * f1;
        }
        f4 = rect.right - rect.left;
        f4 = (rectf.right - rectf.left) / f4;
        rect = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[2];
        rect[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a;
        rect[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f;
        if (StatusManager.j().s() == BeautyMode.s)
        {
            i1 = 0;
            while (i1 < rect.length) 
            {
                rectf = (List)map.get(rect[i1]);
                if (rectf != null)
                {
                    rectf = (PointF)rectf.get(0);
                    if (rectf != null)
                    {
                        a(canvas, (((PointF) (rectf)).x * f1 - f2) * f4, (((PointF) (rectf)).y * f1 - f3) * f4, MotionControlHelper.e().P() * f4);
                    }
                }
                i1++;
            }
        }
        rect = map.entrySet().iterator();
        do
        {
            if (!rect.hasNext())
            {
                break;
            }
            uiimageorientation = (java.util.Map.Entry)rect.next();
            rectf = (PointF)((List)uiimageorientation.getValue()).get(0);
            uiimageorientation = (Bitmap)B.get(uiimageorientation.getKey());
            if (uiimageorientation != null)
            {
                float f5 = ((PointF) (rectf)).x;
                float f6 = ((PointF) (rectf)).y;
                a(canvas, s, (f5 * f1 - f2) * f4, (f6 * f1 - f3) * f4, ((Bitmap) (uiimageorientation)));
            }
        } while (true);
    }

    private void a(Canvas canvas, Paint paint, float f1, float f2, Bitmap bitmap)
    {
        float f3 = bitmap.getWidth();
        float f4 = bitmap.getHeight();
        f1 -= f3 / 2.0F;
        f2 -= f4 / 2.0F;
        v.left = f1;
        v.top = f2;
        v.right = f3 + f1;
        v.bottom = f4 + f2;
        canvas.drawBitmap(bitmap, null, v, paint);
    }

    private void a(Canvas canvas, i i1, float f1, Rect rect, RectF rectf)
    {
        if (1.2F * f1 > 1.0001F)
        {
            s.setFilterBitmap(true);
        }
        canvas.save();
        canvas.clipPath(r, android.graphics.Region.Op.INTERSECT);
        canvas.drawColor(0xff000000);
        if (i1.a == null || i1.a.isRecycled())
        {
            return;
        } else
        {
            canvas.drawBitmap(i1.a, rect, rectf, s);
            return;
        }
    }

    private void a(i i1, int j1, int k1, float f1, Rect rect, RectF rectf)
    {
        int l1 = f;
        int i2 = g;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        if (f1 > 1.0F)
        {
            f1 = 1.0F / f1;
        } else
        {
            f1 = 1.0F;
        }
        f8 = ((float)l1 * f1) / 1.2F;
        f10 = ((float)i2 * f1) / 1.2F;
        f4 = ((float)j1 - (float)l1 / 1.2F / 2.0F) * f1;
        f6 = ((float)k1 - (float)i2 / 1.2F / 2.0F) * f1;
        f9 = l1;
        f11 = i2;
        f3 = 0.0F;
        f5 = 0.0F;
        f2 = f4;
        if (f4 < 0.0F)
        {
            f3 = 0.0F - (f4 / f1) * 1.2F;
            f2 = 0.0F;
        }
        f4 = f6;
        if (f6 < 0.0F)
        {
            f5 = 0.0F - (f6 / f1) * 1.2F;
            f4 = 0.0F;
        }
        f7 = f9;
        f6 = f8;
        if (f2 + f8 > (float)i1.a.getWidth())
        {
            f7 = f9 - (Math.abs((f2 + f8) - (float)i1.a.getWidth()) * 1.2F) / f1;
            f6 = f8 - Math.abs((f2 + f8) - (float)i1.a.getWidth());
        }
        f9 = f11;
        f8 = f10;
        if (f4 + f10 > (float)i1.a.getHeight())
        {
            f9 = f11 - (Math.abs((f4 + f10) - (float)i1.a.getHeight()) * 1.2F) / f1;
            f8 = f10 - Math.abs((f4 + f10) - (float)i1.a.getHeight());
        }
        rect.left = (int)f2;
        rect.top = (int)f4;
        rect.right = (int)(f6 + f2);
        rect.bottom = (int)(f4 + f8);
        rectf.left = f3;
        rectf.top = f5;
        rectf.right = f3 + f7;
        rectf.bottom = f5 + f9;
    }

    public void a()
    {
        C = false;
        s.setFilterBitmap(false);
        Map map = B;
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints = z;
        Bitmap bitmap;
        if (A.contains(z))
        {
            bitmap = n;
        } else
        {
            bitmap = m;
        }
        map.put(featurepoints, bitmap);
        invalidate();
    }

    public void a(int i1)
    {
        h = i1;
    }

    public void a(Context context)
    {
        q = new PointF();
        C = false;
        k = BitmapFactory.decodeResource(getResources(), 0x7f02096c);
        context = (WindowManager)context.getSystemService("window");
        Object obj = new DisplayMetrics();
        context.getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        float f1 = (float)((DisplayMetrics) (obj)).widthPixels / 1080F;
        f = (int)(380F * f1);
        g = (int)(380F * f1);
        i = 160F * f1;
        j = f1 * 50F;
        l = Bitmap.createBitmap(f, g, android.graphics.Bitmap.Config.ARGB_8888);
        y = new Canvas(l);
        r = new Path();
        r.addCircle((float)f / 2.0F, (float)g / 2.0F, i, android.graphics.Path.Direction.CCW);
        s = new Paint();
        s.setColor(-1);
        s.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        s.setAntiAlias(false);
        t = new Paint();
        t.setAntiAlias(true);
        t.setFilterBitmap(true);
        u = new Rect(0, 0, f, g);
        v = new RectF();
        w = new Rect();
        x = new RectF();
        m = BitmapFactory.decodeResource(getResources(), 0x7f0206d1);
        n = BitmapFactory.decodeResource(getResources(), 0x7f0206d2);
        o = BitmapFactory.decodeResource(getResources(), 0x7f020899);
        p = BitmapFactory.decodeResource(getResources(), 0x7f020898);
        context = FeaturePointsDef.k();
        A = new ArrayList();
        A.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a);
        A.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f);
        A.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B);
        A.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C);
        A.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M);
        A.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N);
        B = new HashMap();
        obj = context.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints = (com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints)((Iterator) (obj)).next();
            if (A.contains(featurepoints))
            {
                context = n;
            } else
            {
                context = m;
            }
            B.put(featurepoints, context);
        }
    }

    public void a(PointF pointf, int i1, int j1, int k1, int l1, i i2, float f1, 
            w w1, UIImageOrientation uiimageorientation, Map map)
    {
        if (i2 == null || i2.a == null)
        {
            return;
        } else
        {
            C = true;
            q.set(pointf);
            i1 -= (int)(((float)k1 - w1.c()) / 2.0F);
            j1 -= (int)(((float)l1 - w1.d()) / 2.0F);
            l.eraseColor(0);
            a(i2, i1, j1, f1, w, x);
            a(y, i2, f1, w, x);
            a(y, f1, i1, j1, w, x, uiimageorientation, map);
            a(y);
            invalidate();
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        float f3 = 0.0F;
        super.onDraw(canvas);
        if (l != null && C)
        {
            float f4 = q.x - (float)f / 2.0F;
            float f7 = f;
            float f2 = q.y - (float)g - j;
            float f5 = q.y;
            float f6 = j;
            float f1;
            if (f4 < 0.0F)
            {
                f1 = 0.0F;
            } else
            {
                f1 = f4;
                if (f4 + f7 > (float)getWidth())
                {
                    f1 = getWidth() - f;
                }
            }
            if (f2 < 0.0F)
            {
                f4 = q.y + j;
                f2 = f4;
                if (f4 < 0.0F)
                {
                    f2 = f3;
                }
            } else
            if (f5 - f6 > (float)(getHeight() - h))
            {
                f2 = getHeight() - g - h;
            }
            canvas.drawBitmap(l, f1, f2, null);
        }
    }

    public void setTouchedPoint(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints)
    {
        z = featurepoints;
        Iterator iterator = B.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getKey() == z)
            {
                if (A.contains(z))
                {
                    featurepoints = p;
                } else
                {
                    featurepoints = o;
                }
                entry.setValue(featurepoints);
            }
        } while (true);
    }
}
