// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.ViewAnimationUtils;
import com.cyberlink.youcammakeup.utility.cg;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryView;
import com.cyberlink.youcammakeup.widgetpool.foundationtouchview.FoundationView;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.WigView;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar, TopToolBar, NewIconCtrl

abstract class h
    implements android.view.View.OnClickListener
{

    final MakeupMenuBottomToolbar e;

    private h(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        e = makeupmenubottomtoolbar;
        super();
    }

    h(MakeupMenuBottomToolbar makeupmenubottomtoolbar, MakeupMenuBottomToolbar._cls1 _pcls1)
    {
        this(makeupmenubottomtoolbar);
    }

    public abstract Fragment a();

    public void onClick(View view)
    {
        if (StatusManager.j().E().booleanValue()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        obj = e.getFragmentManager();
        if (obj != null)
        {
            obj = (TopToolBar)((FragmentManager) (obj)).findFragmentById(0x7f0c00be);
            if (obj != null)
            {
                ((TopToolBar) (obj)).a(Boolean.valueOf(true));
            }
        }
        StatusManager.j().a(Boolean.valueOf(false));
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(e).a(view);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(e, false);
        view = a();
        if (view == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = e.getActivity().findViewById(0x7f0c00c9);
        obj1 = e.getActivity().findViewById(0x7f0c00c5);
        ((View) (obj1)).clearAnimation();
        Object obj2 = ViewAnimationUtils.a(com.cyberlink.youcammakeup.utility.ViewAnimationUtils.SlideDirection.d);
        ((Animation) (obj2)).setDuration(300L);
        ((Animation) (obj2)).setAnimationListener(new cg(((View) (obj)), ((View) (obj1))) {

            final View a;
            final View b;
            final h c;

            public void onAnimationEnd(Animation animation)
            {
                a.setVisibility(8);
                if (b.getAnimation() == animation)
                {
                    b.clearAnimation();
                }
            }

            
            {
                c = h.this;
                a = view;
                b = view1;
                super();
            }
        });
        ((View) (obj1)).startAnimation(((Animation) (obj2)));
        ((a)view).a(e);
        obj = (ImageViewer)e.getActivity().findViewById(0x7f0c0720);
        e.g();
        StatusManager.j().a(-1, 4, -1, -1, -1, 4, 4, -1);
        e.c(new ch(view) {

            final Fragment a;
            final h b;
            private Runnable c;

            public void onAnimationEnd(Animator animator)
            {
                animator = b.e.getActivity();
                if (animator instanceof BaseActivity)
                {
                    ((BaseActivity)animator).a(c);
                }
            }

            
            {
                b = h.this;
                a = fragment;
                super();
                c = new _cls1(this);
            }
        });
        obj1 = StatusManager.j().s();
        if (obj1 != BeautyMode.z && obj1 != BeautyMode.A && obj1 != BeautyMode.B && obj1 != BeautyMode.C)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = e.getActivity();
        if (obj2 != null)
        {
            obj1 = new AccessoryView(((android.content.Context) (obj2)));
            ((AccessoryView) (obj1)).setImageViewer(((ImageViewer) (obj)));
            ((AccessoryView) (obj1)).setToolPanel(view);
            view = (FrameLayout)((Activity) (obj2)).findViewById(0x7f0c00c0);
            view.removeAllViews();
            view.addView(((View) (obj1)), new android.widget.FrameLayout.LayoutParams(-1, -1));
            AccessoryDrawingCtrl.a(((AccessoryView) (obj1)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (obj1 != BeautyMode.x)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = e.getActivity();
        if (obj1 != null)
        {
            view = new WigView(((android.content.Context) (obj1)));
            view.setImageViewer(((ImageViewer) (obj)));
            obj = (FrameLayout)((Activity) (obj1)).findViewById(0x7f0c00c0);
            ((FrameLayout) (obj)).removeAllViews();
            ((FrameLayout) (obj)).addView(view, new android.widget.FrameLayout.LayoutParams(-1, -1));
            c.h().a(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (obj1 != BeautyMode.b) goto _L1; else goto _L4
_L4:
        Activity activity = e.getActivity();
        if (activity != null)
        {
            FoundationView foundationview = new FoundationView(activity);
            foundationview.setToolPanel(view);
            view = (FrameLayout)activity.findViewById(0x7f0c00c0);
            view.removeAllViews();
            view.addView(foundationview, new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/h$2$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls2 a;

        public void run()
        {
            StatusManager.j().M();
            a.b.e.a(a.a);
            if (MakeupMenuBottomToolbar.e(a.b.e).getVisibility() == 0)
            {
                return;
            } else
            {
                Globals.d(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
    class _cls1
        implements Runnable
    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(a.a.b.e, StatusManager.j().r());
                        MakeupMenuBottomToolbar.e(a.a.b.e).setVisibility(0);
                        StatusManager.j().a(Boolean.valueOf(true));
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                return;
            }
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}
