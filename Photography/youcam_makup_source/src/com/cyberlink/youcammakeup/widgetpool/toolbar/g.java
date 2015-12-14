// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.app.Fragment;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class g
    implements a
{

    final MakeupLooksBottomToolbar a;

    private g(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        a = makeuplooksbottomtoolbar;
        super();
    }

    g(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, MakeupLooksBottomToolbar._cls1 _pcls1)
    {
        this(makeuplooksbottomtoolbar);
    }

    public void a(Fragment fragment)
    {
    }

    public void a(Long long1, boolean flag)
    {
    }

    public void b()
    {
        MakeupLooksBottomToolbar.b(a).a(false);
        a.c(new ch() {

            final g a;

            public void onAnimationEnd(Animator animator)
            {
                a.a.d();
            }

            
            {
                a = g.this;
                super();
            }
        });
    }

    public void c()
    {
        if (MakeupLooksBottomToolbar.h(a))
        {
            return;
        } else
        {
            MakeupLooksBottomToolbar.c(a, true);
            MakeupLooksBottomToolbar.b(a).a(false);
            a.c(new ch() {

                final g a;

                public void onAnimationEnd(Animator animator)
                {
                    a.a.c();
                    MakeupLooksBottomToolbar.c(a.a, false);
                }

            
            {
                a = g.this;
                super();
            }
            });
            return;
        }
    }

    public Long d()
    {
        return null;
    }
}
