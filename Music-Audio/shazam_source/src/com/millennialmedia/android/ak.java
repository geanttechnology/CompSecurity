// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

// Referenced classes of package com.millennialmedia.android:
//            aa, al, an, a, 
//            y, e, ab, ac, 
//            ao, q, at, am

abstract class ak extends RelativeLayout
    implements aa
{
    private static final class a extends android.view.GestureDetector.SimpleOnGestureListener
    {

        WeakReference a;

        public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            while (motionevent == null || motionevent1 == null || Math.abs((int)(motionevent1.getX() - motionevent.getX())) <= 200 || Math.abs(f) <= Math.abs(f1)) 
            {
                return false;
            }
            if (f <= 0.0F) goto _L2; else goto _L1
_L1:
            if (an.a == 0)
            {
                al.c();
                an.a = 3;
            } else
            {
                al.c();
                an.a = 0;
            }
_L4:
            return true;
_L2:
            motionevent = (ak)a.get();
            if (motionevent != null)
            {
                an.a(((ak) (motionevent)).h);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a(ak ak1)
        {
            a = new WeakReference(ak1);
        }
    }

    class b extends ab
    {

        final ak p;

        public final void a(ao ao1)
        {
            p.removeView(ao1);
        }

        public final void a(ao ao1, android.widget.RelativeLayout.LayoutParams layoutparams)
        {
            (new StringBuilder("MMLayout adding view (")).append(ao1).append(") to ").append(this);
            al.d();
            p.addView(ao1, layoutparams);
        }

        public final void a(boolean flag)
        {
            p.setClickable(flag);
        }

        final volatile aa d()
        {
            return p;
        }

        final int f()
        {
            return p.getId();
        }

        public b(Context context)
        {
            p = ak.this;
            super(context);
        }
    }


    private static boolean b;
    private GestureDetector a;
    ab h;
    boolean i;
    View j;
    RelativeLayout k;
    y l;

    protected ak(Context context)
    {
        super(context);
        try
        {
            al.c();
            an.d(context);
            an.e(context);
        }
        catch (Exception exception)
        {
            al.a("MMLayout", "There was an exception initializing the MMAdView. ", exception);
            exception.printStackTrace();
        }
        a = new GestureDetector(context.getApplicationContext(), new a(this));
        if (!b)
        {
            al.b();
            an.c(context);
            al.b();
            al.b();
            al.b();
            com.millennialmedia.android.a.b(context);
            b = true;
        }
    }

    static void a(ak ak1, String s)
    {
        if (ak1.j != null) goto _L2; else goto _L1
_L1:
        android.widget.RelativeLayout.LayoutParams layoutparams;
        ak1.j = new View(ak1.getContext());
        float f = ak1.getContext().getResources().getDisplayMetrics().density;
        layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(50F * f), (int)(f * 50F));
        if (!"top-right".equals(s)) goto _L4; else goto _L3
_L3:
        layoutparams.addRule(11);
_L6:
        ak1.j.setOnClickListener(ak1. new android.view.View.OnClickListener() {

            final ak a;

            public final void onClick(View view)
            {
                a.a();
            }

            
            {
                a = ak.this;
                super();
            }
        });
        ak1.addView(ak1.j, layoutparams);
_L2:
        return;
_L4:
        if ("top-center".equals(s))
        {
            layoutparams.addRule(14);
        } else
        if ("bottom-left".equals(s))
        {
            layoutparams.addRule(12);
        } else
        if ("bottom-center".equals(s))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(14);
        } else
        if ("bottom-right".equals(s))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(11);
        } else
        if ("center".equals(s))
        {
            layoutparams.addRule(13);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void a()
    {
    }

    final void a(y.a a1)
    {
        d();
        l = new y(this, a1);
        a1 = l;
        addView(((y) (a1)).c, a1.a());
        a1 = (ak)((y) (a1)).b.get();
        if (!(a1 instanceof e))
        {
            al.d();
            return;
        } else
        {
            ((e)a1).c();
            return;
        }
    }

    final void a(String s)
    {
        if (an.a(getContext()))
        {
            if (h.l != null)
            {
                ac ac1 = h.l;
                if (!TextUtils.isEmpty(s) && ac1.b != null)
                {
                    ac1.b.loadUrl(s);
                }
            }
            return;
        } else
        {
            al.a("MMLayout", "No network available, can't load overlay.");
            return;
        }
    }

    final void d()
    {
        if (l != null)
        {
            y y1 = l;
            if (y1.c == null)
            {
                al.d();
            } else
            {
                android.view.ViewParent viewparent = y1.c.getParent();
                if (viewparent == null || !(viewparent instanceof ViewGroup))
                {
                    al.d();
                } else
                {
                    y1.stopPlayback();
                    ((ViewGroup)viewparent).removeView(y1.c);
                }
            }
            l = null;
        }
    }

    public String getApid()
    {
        return h.e;
    }

    public boolean getIgnoresDensityScaling()
    {
        return h.d;
    }

    public at getListener()
    {
        return h.c;
    }

    public am getMMRequest()
    {
        return h.e();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!isInEditMode())
        {
            (new StringBuilder("onAttachedToWindow for ")).append(h);
            al.b();
            if (getId() == -1)
            {
                al.d();
            }
            if (!i)
            {
                ac.a(h);
            }
            if (k != null)
            {
                k.bringToFront();
            }
            if (h != null && h.l != null && h.l.b != null)
            {
                h.l.b.d = true;
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        (new StringBuilder("onDetachedFromWindow for")).append(h);
        al.b();
        Context context = getContext();
        if (h.f == "i" && context != null && (context instanceof Activity) && ((Activity)context).isFinishing())
        {
            h.i = true;
        }
        if (!i)
        {
            ac.d(h);
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (Bundle)parcelable;
        long l1 = h.h;
        h.h = parcelable.getLong("MMAdImplId");
        h.o = parcelable.getLong("MMAdImplLinkedId");
        (new StringBuilder("onRestoreInstanceState replacing adImpl-")).append(l1).append(" with ").append(h).append(" id=").append(getId());
        al.b();
        String s = parcelable.getString("inlineVideoViewGson");
        if (s != null)
        {
            a(new y.a(s));
        }
        super.onRestoreInstanceState(parcelable.getParcelable("super"));
    }

    protected Parcelable onSaveInstanceState()
    {
        super.onSaveInstanceState();
        (new StringBuilder("onSaveInstanceState saving - ")).append(h).append(" id=").append(getId());
        al.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putLong("MMAdImplId", h.h);
        bundle.putLong("MMAdImplLinkedId", h.o);
        if (l != null)
        {
            bundle.putString("inlineVideoViewGson", l.a.a());
        }
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return a.onTouchEvent(motionevent) || !isClickable() || super.onTouchEvent(motionevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        String.format("Window Focus Changed. For %s, Window in focus?: %b Controllers: %s", new Object[] {
            h, Boolean.valueOf(flag), ac.b()
        });
        al.b();
        o.a a1;
        if (h != null && h.l != null && h.l.b != null)
        {
            if (flag)
            {
                h.l.b.j();
                h.l.b.n();
            } else
            {
                q.a();
                h.l.b.m();
                h.l.b.i();
            }
        }
        if (!flag && (getContext() instanceof Activity))
        {
            Activity activity = (Activity)getContext();
            if (activity == null || activity.isFinishing() && h != null)
            {
                h.i = true;
                if (h.l != null && h.l.b != null)
                {
                    h.l.b.l();
                    ac.d(h);
                }
            }
        }
        a1 = o.a.a(getContext());
        if (a1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        a1.b();
        this;
        JVM INSTR monitorexit ;
_L2:
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setApid(String s)
    {
        h.a(s);
    }

    void setCloseArea(String s)
    {
        post(new Runnable(s) {

            final String a;
            final ak b;

            public final void run()
            {
                ak.a(b, a);
            }

            
            {
                b = ak.this;
                a = s;
                super();
            }
        });
    }

    public void setIgnoresDensityScaling(boolean flag)
    {
        h.d = flag;
    }

    public void setListener(at at)
    {
        h.c = at;
    }

    public void setMMRequest(am am)
    {
        h.a(am);
    }

    void setMediaPlaybackRequiresUserGesture(boolean flag)
    {
        try
        {
            android/webkit/WebView.getMethod("setMediaPlaybackRequiresUserGesture", new Class[] {
                Boolean.TYPE
            }).invoke(this, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    void setVideoSource(String s)
    {
        if (l != null)
        {
            l.a(s);
        }
    }

    // Unreferenced inner class com/millennialmedia/android/ak$3

/* anonymous class */
    final class _cls3
        implements Runnable
    {

        final y.a a;
        final ak b;

        public final void run()
        {
            if (b.l != null)
            {
                b.l.a(a);
            }
        }

            
            {
                b = ak.this;
                a = a1;
                super();
            }
    }

}
