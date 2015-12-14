// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.app.Fragment;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class a
    implements Runnable
{

    final ager.a a;

    public void run()
    {
        MakeupMenuBottomToolbar.a(a.a.a.e, StatusManager.j().r());
        MakeupMenuBottomToolbar.e(a.a.a.e).setVisibility(0);
        StatusManager.j().a(Boolean.valueOf(true));
    }

    nit>(nit> nit>)
    {
        a = nit>;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/h$2

/* anonymous class */
    class h._cls2 extends ch
    {

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
                b = h1;
                a = fragment;
                super();
                c = new h._cls2._cls1(this);
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/h$2$1

/* anonymous class */
    class h._cls2._cls1
        implements Runnable
    {

        final h._cls2 a;

        public void run()
        {
            StatusManager.j().M();
            a.b.e.a(a.a);
            if (MakeupMenuBottomToolbar.e(a.b.e).getVisibility() == 0)
            {
                return;
            } else
            {
                Globals.d(new h._cls2._cls1._cls1(this));
                return;
            }
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}
