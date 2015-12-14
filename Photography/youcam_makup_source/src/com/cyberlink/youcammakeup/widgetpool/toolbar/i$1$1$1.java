// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.Globals;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            i

class a extends AnimatorListenerAdapter
{

    final a a;

    public void onAnimationEnd(Animator animator)
    {
        a.a.a.animate().setListener(null);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/i$1

/* anonymous class */
    class i._cls1 extends AnimatorListenerAdapter
    {

        final View a;
        final i b;

        public void onAnimationEnd(Animator animator)
        {
            a.animate().setListener(null);
            i.a(b);
            Globals.d(new i._cls1._cls1(this));
        }

            
            {
                b = j;
                a = view;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/i$1$1

/* anonymous class */
    class i._cls1._cls1
        implements Runnable
    {

        final i._cls1 a;

        public void run()
        {
            a.a.animate().translationY(0.0F).setDuration(300L).setListener(new i._cls1._cls1._cls1(this)).start();
        }

            
            {
                a = _pcls1;
                super();
            }
    }

}
