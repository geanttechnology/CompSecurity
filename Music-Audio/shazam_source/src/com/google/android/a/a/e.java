// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.a.a.a.a;
import com.google.android.a.a.a.b;
import com.google.android.a.a.a.d;
import com.google.android.a.a.a.f;
import com.google.android.a.a.a.p;
import com.google.android.a.a.a.r;
import com.google.android.a.a.a.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.a.a:
//            b

public final class e extends ViewGroup
    implements c.c
{
    private final class a
        implements android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    {

        final e a;

        public final void onGlobalFocusChanged(View view, View view1)
        {
            if (com.google.android.a.a.e.d(a) == null || !e.j(a).contains(view1) || e.j(a).contains(view))
            {
                break MISSING_BLOCK_LABEL_59;
            }
            view = com.google.android.a.a.e.d(a);
            ((t) (view)).a.l();
            return;
            view;
            throw new r(view);
        }

        private a()
        {
            a = e.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    static interface b
    {
    }


    d a;
    t b;
    p c;
    c.c d;
    Bundle e;
    c.b f;
    boolean g;
    private final a h = new a((byte)0);
    private final Set i = new HashSet();
    private final b j;
    private View k;
    private boolean l;

    e(Context context, b b1)
    {
        super((Context)com.google.android.a.a.a.b.a(context, "context cannot be null"), null, 0);
        j = (b)com.google.android.a.a.a.b.a(b1, "listener cannot be null");
        if (getBackground() == null)
        {
            setBackgroundColor(0xff000000);
        }
        setClipToPadding(false);
        c = new p(context);
        requestTransparentRegion(c);
        addView(c);
    }

    static d a(e e1)
    {
        return e1.a;
    }

    private void a()
    {
        b = null;
        p p1 = c;
        p1.a.setVisibility(8);
        p1.b.setVisibility(0);
        if (f != null)
        {
            f.a();
            f = null;
        }
    }

    private void a(View view)
    {
        boolean flag;
        if (view == c || b != null && view == k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        } else
        {
            return;
        }
    }

    static void a(e e1, Activity activity)
    {
        try
        {
            activity = com.google.android.a.a.a.a.a().a(activity, e1.a, e1.g);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e("YouTubeAndroidPlayerAPI", "Error creating YouTubePlayerView", activity);
            activity = com.google.android.a.a.b.b;
            e1.a();
            return;
        }
        e1.b = new t(e1.a, activity);
        e1.k = e1.b.c();
        e1.addView(e1.k);
        e1.removeView(e1.c);
        if (e1.f != null)
        {
            boolean flag = false;
            if (e1.e != null)
            {
                flag = e1.b.a(e1.e);
                e1.e = null;
            }
            e1.f.a(e1.b, flag);
            e1.f = null;
        }
    }

    static d b(e e1)
    {
        e1.a = null;
        return null;
    }

    static boolean c(e e1)
    {
        return e1.l;
    }

    static t d(e e1)
    {
        return e1.b;
    }

    static p e(e e1)
    {
        return e1.c;
    }

    static View f(e e1)
    {
        return e1.k;
    }

    static View g(e e1)
    {
        e1.k = null;
        return null;
    }

    static t h(e e1)
    {
        e1.b = null;
        return null;
    }

    static void i(e e1)
    {
        e1.a();
    }

    static Set j(e e1)
    {
        return e1.i;
    }

    final void a(boolean flag)
    {
        l = true;
        if (b != null)
        {
            b.a(flag);
        }
    }

    public final void addFocusables(ArrayList arraylist, int i1)
    {
        ArrayList arraylist1 = new ArrayList();
        super.addFocusables(arraylist1, i1);
        arraylist.addAll(arraylist1);
        i.clear();
        i.addAll(arraylist1);
    }

    public final void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        ArrayList arraylist1 = new ArrayList();
        super.addFocusables(arraylist1, i1, j1);
        arraylist.addAll(arraylist1);
        i.clear();
        i.addAll(arraylist1);
    }

    public final void addView(View view)
    {
        a(view);
        super.addView(view);
    }

    public final void addView(View view, int i1)
    {
        a(view);
        super.addView(view, i1);
    }

    public final void addView(View view, int i1, int j1)
    {
        a(view);
        super.addView(view, i1, j1);
    }

    public final void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(view);
        super.addView(view, i1, layoutparams);
    }

    public final void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(view);
        super.addView(view, layoutparams);
    }

    public final void clearChildFocus(View view)
    {
        if (hasFocusable())
        {
            requestFocus();
            return;
        } else
        {
            super.clearChildFocus(view);
            return;
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag;
        flag = false;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        if (b.a(keyevent.getKeyCode(), keyevent) || super.dispatchKeyEvent(keyevent))
        {
            flag = true;
        }
_L4:
        return flag;
_L2:
        if (keyevent.getAction() != 1)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (!b.b(keyevent.getKeyCode(), keyevent) && !super.dispatchKeyEvent(keyevent)) goto _L4; else goto _L3
_L3:
        return true;
        return super.dispatchKeyEvent(keyevent);
    }

    public final void focusableViewAvailable(View view)
    {
        super.focusableViewAvailable(view);
        i.add(view);
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(h);
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        t t1;
        super.onConfigurationChanged(configuration);
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        t1 = b;
        t1.a.a(configuration);
        return;
        configuration;
        throw new r(configuration);
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(h);
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (getChildCount() > 0)
        {
            getChildAt(0).layout(0, 0, k1 - i1, l1 - j1);
        }
    }

    protected final void onMeasure(int i1, int j1)
    {
        if (getChildCount() > 0)
        {
            View view = getChildAt(0);
            view.measure(i1, j1);
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
            return;
        } else
        {
            setMeasuredDimension(0, 0);
            return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return true;
    }

    public final void requestChildFocus(View view, View view1)
    {
        super.requestChildFocus(view, view1);
        i.add(view1);
    }

    public final void setClipToPadding(boolean flag)
    {
    }

    public final void setPadding(int i1, int j1, int k1, int l1)
    {
    }

    // Unreferenced inner class com/google/android/a/a/e$1

/* anonymous class */
    final class _cls1
        implements com.google.android.a.a.a.u.a
    {

        final Activity a;
        final e b;

        public final void a()
        {
            if (com.google.android.a.a.e.a(b) != null)
            {
                com.google.android.a.a.e.a(b, a);
            }
            com.google.android.a.a.e.b(b);
        }

        public final void b()
        {
            if (!e.c(b) && com.google.android.a.a.e.d(b) != null)
            {
                Object obj = com.google.android.a.a.e.d(b);
                try
                {
                    ((t) (obj)).a.q();
                }
                catch (RemoteException remoteexception)
                {
                    throw new r(remoteexception);
                }
            }
            obj = e.e(b);
            ((p) (obj)).a.setVisibility(8);
            ((p) (obj)).b.setVisibility(8);
            if (b.indexOfChild(e.e(b)) < 0)
            {
                b.addView(e.e(b));
                b.removeView(com.google.android.a.a.e.f(b));
            }
            e.g(b);
            e.h(b);
            com.google.android.a.a.e.b(b);
        }

            
            {
                b = e.this;
                a = activity;
                super();
            }
    }


    // Unreferenced inner class com/google/android/a/a/e$2

/* anonymous class */
    final class _cls2
        implements com.google.android.a.a.a.u.b
    {

        final e a;

        public final void a()
        {
            e.i(a);
            com.google.android.a.a.e.b(a);
        }

            
            {
                a = e.this;
                super();
            }
    }

}
