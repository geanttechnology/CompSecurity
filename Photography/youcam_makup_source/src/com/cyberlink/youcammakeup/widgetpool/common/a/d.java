// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            c

public abstract class d extends Fragment
{

    protected View a;
    protected HorizontalGridView b;
    protected k c;
    protected EditViewActivity d;
    protected int e;
    protected int f;
    protected az g;
    protected boolean h;
    protected p i;
    private c j;

    public d()
    {
        d = null;
        e = -1;
        f = 0x7f0300f1;
        g = null;
        h = false;
        i = new p() {

            final d a;

            public void a(AdapterView adapterview, View view, int k, long l)
            {
                a.a(view, k);
            }

            
            {
                a = d.this;
                super();
            }
        };
    }

    static c a(d d1, c c1)
    {
        d1.j = c1;
        return c1;
    }

    protected c a(BeautyMode beautymode)
    {
        return null;
    }

    public void a()
    {
        Globals.d(new Runnable() {

            final d a;

            public void run()
            {
                a.c();
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    public void a(int k)
    {
        f = k;
    }

    protected void a(int k, boolean flag)
    {
        d();
        e = k;
        if (b != null)
        {
            b.a(e, true);
            if (flag)
            {
                Globals.d(new Runnable() {

                    final d a;

                    public void run()
                    {
                        a.b.setSelection(a.e);
                    }

            
            {
                a = d.this;
                super();
            }
                });
            }
        }
    }

    protected abstract void a(View view, int k);

    public void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask, boolean flag)
    {
    }

    public void a(at at, boolean flag)
    {
    }

    public void a(az az)
    {
        g = az;
    }

    public void a(k k)
    {
        c = k;
    }

    public void a(String s)
    {
        if (j != null)
        {
            j.a(s);
            j.notifyDataSetChanged();
        }
    }

    public void a(boolean flag)
    {
        j.a(false);
    }

    protected void b()
    {
        d = (EditViewActivity)getActivity();
        b = (HorizontalGridView)a.findViewById(0x7f0c054b);
        b.setChoiceMode(1);
        if (h && d != null && b != null)
        {
            GestureDetector gesturedetector = new GestureDetector(getActivity(), new android.view.GestureDetector.SimpleOnGestureListener() {

                final d a;

                public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
                {
                    if (Math.abs(f1) <= Math.abs(f2)) goto _L2; else goto _L1
_L1:
                    return false;
_L2:
                    if (f2 >= 0.0F) goto _L4; else goto _L3
_L3:
                    if (StatusManager.j().e().equalsIgnoreCase("default_original_wig")) goto _L1; else goto _L5
_L5:
                    a.d.p(true);
                    a.d.a(Boolean.valueOf(false), Boolean.valueOf(true));
                    a.d.b(0);
_L7:
                    return true;
_L4:
                    a.d.p(false);
                    a.d.a(Boolean.valueOf(false), Boolean.valueOf(false));
                    a.d.b(8);
                    if (true) goto _L7; else goto _L6
_L6:
                }

            
            {
                a = d.this;
                super();
            }
            });
            b.setOnTouchListener(new android.view.View.OnTouchListener(gesturedetector) {

                final GestureDetector a;
                final d b;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (a.onTouchEvent(motionevent))
                    {
                        motionevent.setAction(3);
                    }
                    return false;
                }

            
            {
                b = d.this;
                a = gesturedetector;
                super();
            }
            });
        }
        c();
        if (b != null)
        {
            b.setOnItemClickListener(i);
        }
    }

    public void b(int k)
    {
        d.findViewById(0x7f0c0854).setVisibility(k);
        d.findViewById(0x7f0c0854).requestLayout();
        d.findViewById(0x7f0c0683).setVisibility(k);
    }

    protected void b(BeautyMode beautymode)
    {
        b.setAlpha(0.0F);
        b.setVisibility(0);
        b.setAdapter(j);
        b.animate().alpha(1.0F);
    }

    public void b(boolean flag)
    {
        h = flag;
    }

    protected void c()
    {
        (new AsyncTask() {

            final d a;
            private BeautyMode b;

            protected transient Void a(Void avoid[])
            {
                d.a(a, a.a(b));
                return null;
            }

            protected void a(Void void1)
            {
                a.b(b);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            protected void onPreExecute()
            {
                b = StatusManager.j().s();
                a.c(b);
            }

            
            {
                a = d.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    protected void c(BeautyMode beautymode)
    {
    }

    public void d()
    {
        b.b();
        e = -1;
    }

    public void e()
    {
        if (j != null)
        {
            j.a();
            j.notifyDataSetChanged();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(f, viewgroup, false);
        return a;
    }

    public void onDestroyView()
    {
        if (j != null)
        {
            j.a();
        }
        b = null;
        j = null;
        d = null;
        e = -1;
        super.onDestroyView();
    }
}
