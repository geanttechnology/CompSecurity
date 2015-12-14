// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            o

public class CameraZoomView extends View
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    private Camera a;
    private boolean b;
    private int c;
    private int d;
    private List e;
    private Runnable f;
    private Paint g;
    private Paint h;
    private int i;
    private int j;
    private float k;
    private float l;
    private float m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Rect s;
    private StringBuilder t;
    private boolean u;
    private boolean v;
    private boolean w;

    public CameraZoomView(Context context)
    {
        super(context);
        b = false;
        u = false;
        v = false;
        w = false;
        a(context);
    }

    public CameraZoomView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        u = false;
        v = false;
        w = false;
        a(context);
    }

    public CameraZoomView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = false;
        u = false;
        v = false;
        w = false;
        a(context);
    }

    private float a(float f1)
    {
        f1 = Math.max(l, f1);
        return Math.min(k, f1);
    }

    private float a(int i1)
    {
        return a(l + ((float)i1 * (k - l)) / (float)(c - d));
    }

    private String a()
    {
        t.setLength(0);
        t.append(p);
        t.append(".");
        if (q < 10)
        {
            t.append("0");
        }
        t.append(q);
        t.append("x");
        return t.toString();
    }

    private void a(Context context)
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            context = context.getResources();
            g = new Paint();
            g.setAntiAlias(true);
            g.setColor(-1);
            g.setStyle(android.graphics.Paint.Style.STROKE);
            h = new Paint(g);
            h.setStyle(android.graphics.Paint.Style.FILL);
            h.setTextSize(context.getDimensionPixelSize(0x7f0802cf));
            h.setTextAlign(android.graphics.Paint.Align.LEFT);
            h.setAlpha(192);
            n = context.getDimensionPixelSize(0x7f0802b6);
            o = context.getDimensionPixelSize(0x7f0802b7);
            l = context.getDimensionPixelSize(0x7f0802d0);
            s = new Rect();
            f = new Runnable() {

                final CameraZoomView a;

                public void run()
                {
                    CameraActivity.b(false);
                    CameraZoomView.a(a, false);
                    CameraZoomView.b(a, false);
                    a.invalidate();
                }

            
            {
                a = CameraZoomView.this;
                super();
            }
            };
            t = new StringBuilder();
            return;
        }
    }

    static boolean a(CameraZoomView camerazoomview, boolean flag)
    {
        camerazoomview.w = flag;
        return flag;
    }

    private void b(int i1)
    {
        if (a == null || r == i1)
        {
            return;
        } else
        {
            r = i1;
            android.hardware.Camera.Parameters parameters = a.getParameters();
            parameters.setZoom(r);
            com.cyberlink.youcammakeup.camera.o.a(a, parameters);
            setZoomValue(((Integer)e.get(r)).intValue());
            return;
        }
    }

    static void b(CameraZoomView camerazoomview, boolean flag)
    {
        camerazoomview.setVisible(flag);
    }

    private void setCameraZoom(boolean flag)
    {
        if (b && !v && a != null && (w || CameraActivity.a(false, true)))
        {
            w = true;
            android.hardware.Camera.Parameters parameters = a.getParameters();
            int k1 = parameters.getZoom();
            int j1 = parameters.getMaxZoom();
            int i1;
            if (flag)
            {
                i1 = j1;
                if (k1 + 1 < j1)
                {
                    i1 = k1 + 1;
                }
            } else
            if (k1 - 1 > 0)
            {
                i1 = k1 - 1;
            } else
            {
                i1 = 0;
            }
            m = a(i1 - d);
            setVisible(true);
            removeCallbacks(f);
            b(i1);
            invalidate();
            postDelayed(f, 1000L);
        }
    }

    private void setVisible(boolean flag)
    {
        u = flag;
    }

    private void setZoomMax(int i1)
    {
        c = i1;
        d = 0;
    }

    private void setZoomValue(int i1)
    {
        p = i1 / 100;
        q = i1 % 100;
    }

    protected void onDraw(Canvas canvas)
    {
        if (isInEditMode() || !u)
        {
            return;
        } else
        {
            g.setStrokeWidth(n);
            canvas.drawCircle(i, j, l, g);
            canvas.drawCircle(i, j, k, g);
            canvas.drawLine((float)i - l, j, (float)i - k - 4F, j, g);
            g.setStrokeWidth(o);
            canvas.drawCircle(i, j, m, g);
            String s1 = a();
            h.getTextBounds(s1, 0, s1.length(), s);
            canvas.drawText(s1, i - s.centerX(), j - s.centerY(), h);
            return;
        }
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        if (v)
        {
            float f1 = scalegesturedetector.getScaleFactor();
            m = a(f1 * (m * f1));
            b(d + (int)(((m - l) / (k - l)) * (float)(c - d)));
            invalidate();
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        if (b && !w && CameraActivity.a(false, true))
        {
            removeCallbacks(f);
            v = true;
            setVisible(true);
            invalidate();
        }
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        if (v)
        {
            CameraActivity.b(false);
        }
        v = false;
        if (!w)
        {
            setVisible(false);
            invalidate();
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        i = i1 / 2;
        j = j1 / 2;
        k = Math.min(i1, j1);
        k = (k - l) / 2.0F;
        m = a(r);
    }

    public void setCamera(Camera camera)
    {
        a = camera;
        if (camera == null)
        {
            b = false;
        } else
        {
            try
            {
                camera = camera.getParameters();
            }
            // Misplaced declaration of an exception variable
            catch (Camera camera)
            {
                com.pf.common.utility.m.b("CameraZoomView", "setCamera", camera);
                a = null;
                return;
            }
            b = camera.isZoomSupported();
            if (b)
            {
                r = camera.getZoom();
                e = camera.getZoomRatios();
                setZoomValue(((Integer)e.get(r)).intValue());
                setZoomMax(camera.getMaxZoom());
                m = a(r);
                return;
            }
        }
    }

    public void setZoomLevel(int i1)
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j1 = 0;
_L5:
        if (j1 >= e.size())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (((Integer)e.get(j1)).intValue() != i1) goto _L4; else goto _L3
_L3:
        if (j1 != -1)
        {
            try
            {
                android.hardware.Camera.Parameters parameters = a.getParameters();
                parameters.setZoom(j1);
                com.cyberlink.youcammakeup.camera.o.a(a, parameters);
                r = j1;
                setZoomValue(((Integer)e.get(r)).intValue());
                return;
            }
            catch (Exception exception)
            {
                com.pf.common.utility.m.b("CameraZoomView", "setZoomLevel", exception);
            }
            return;
        }
          goto _L1
_L4:
        j1++;
          goto _L5
        j1 = -1;
          goto _L3
    }
}
