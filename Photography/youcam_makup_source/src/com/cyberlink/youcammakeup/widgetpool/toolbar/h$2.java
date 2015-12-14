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

class _cls1 extends ch
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

    _cls1.a(h h1, Fragment fragment)
    {
        b = h1;
        a = fragment;
        super();
        c = new Runnable() {

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
                    Globals.d(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            MakeupMenuBottomToolbar.a(a.a.b.e, StatusManager.j().r());
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
                a = h._cls2.this;
                super();
            }
        };
    }
}
