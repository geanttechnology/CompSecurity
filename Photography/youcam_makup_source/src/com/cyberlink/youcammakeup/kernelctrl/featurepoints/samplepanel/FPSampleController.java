// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel:
//            FeaturePointGuideView, a

public class FPSampleController extends FrameLayout
{

    private FeaturePointGuideView a;
    private View b;
    private View c;
    private boolean d;
    private PointF e;
    private android.widget.FrameLayout.LayoutParams f;
    private GestureDetector g;

    public FPSampleController(Context context)
    {
        super(context);
        d = false;
        e = new PointF();
        f = new android.widget.FrameLayout.LayoutParams(0, 0);
        g = null;
        a(context);
    }

    public FPSampleController(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = false;
        e = new PointF();
        f = new android.widget.FrameLayout.LayoutParams(0, 0);
        g = null;
        a(context);
    }

    public FPSampleController(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d = false;
        e = new PointF();
        f = new android.widget.FrameLayout.LayoutParams(0, 0);
        g = null;
        a(context);
    }

    static FeaturePointGuideView a(FPSampleController fpsamplecontroller)
    {
        return fpsamplecontroller.a;
    }

    private void a(Context context)
    {
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030184, this, true);
        a = (FeaturePointGuideView)findViewById(0x7f0c06a4);
        a.setControler(this);
        g = new GestureDetector(context, new a(this));
        b = findViewById(0x7f0c06a3);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final FPSampleController a;

            public void onClick(View view)
            {
                a.a();
            }

            
            {
                a = FPSampleController.this;
                super();
            }
        });
    }

    public void a()
    {
        b.setVisibility(4);
        a.b();
    }

    public void a(boolean flag)
    {
        a.d();
        if (!flag)
        {
            a.setVisibility(4);
            c = a;
            return;
        } else
        {
            a.setVisibility(0);
            c = null;
            return;
        }
    }

    public void b()
    {
        b.setVisibility(0);
    }

    public boolean c()
    {
        return a.f();
    }

    public void d()
    {
        a.e();
        a.setVisibility(4);
        b.setVisibility(4);
        c = null;
    }

    public void e()
    {
        while (a.getVisibility() == 4 && b.getVisibility() == 4 || c != null) 
        {
            return;
        }
        Object obj;
        if (a.getVisibility() == 0)
        {
            obj = a;
        } else
        {
            obj = b;
        }
        c = ((View) (obj));
        c.setVisibility(4);
    }

    public void f()
    {
        if (c == null)
        {
            return;
        } else
        {
            c.setVisibility(0);
            c = null;
            return;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams)a.getLayoutParams());
        i = z.b("KEY_FEATURE_POINT_GUIDE_TOP_MARGIN", -1, getContext());
        if (i <= -1 || layoutparams.height + i > j)
        {
            i = j - a.getHeight();
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams)a.getLayoutParams());
        layoutparams.topMargin = i;
        a.setLayoutParams(layoutparams);
        layoutparams = new android.widget.FrameLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams)b.getLayoutParams());
        layoutparams.topMargin = i;
        b.setLayoutParams(layoutparams);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        Object obj = null;
        if (a.getVisibility() == 0)
        {
            obj = a;
        }
        if (b.getVisibility() == 0)
        {
            obj = b;
        }
        if (obj == null)
        {
            d = false;
            return false;
        }
        g.onTouchEvent(motionevent);
        obj = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
        if (motionevent.getAction() == 0)
        {
            d = false;
            if ((new Rect(((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin + ((android.widget.FrameLayout.LayoutParams) (obj)).width, ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin + ((android.widget.FrameLayout.LayoutParams) (obj)).height)).contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                d = true;
            }
        }
        f.setMargins(((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).rightMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).bottomMargin);
        f.width = ((android.widget.FrameLayout.LayoutParams) (obj)).width;
        f.height = ((android.widget.FrameLayout.LayoutParams) (obj)).height;
        if (d && (motionevent.getAction() == 2 || motionevent.getAction() == 1))
        {
            float f1 = motionevent.getY();
            float f2 = e.y;
            f.topMargin = (int)(f1 - f2) + f.topMargin;
            if (f.topMargin < 0)
            {
                f.topMargin = 0;
            }
            if (f.topMargin + f.height > getHeight())
            {
                f.topMargin = getHeight() - f.height;
            }
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)a.getLayoutParams();
            layoutparams.topMargin = f.topMargin;
            a.setLayoutParams(layoutparams);
            layoutparams = (android.widget.FrameLayout.LayoutParams)b.getLayoutParams();
            layoutparams.topMargin = f.topMargin;
            b.setLayoutParams(layoutparams);
            z.a("KEY_FEATURE_POINT_GUIDE_TOP_MARGIN", f.topMargin, getContext());
        }
        if (d)
        {
            e.set(motionevent.getX(), motionevent.getY());
        }
        return d;
    }
}
