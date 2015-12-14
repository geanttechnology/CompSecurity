// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a extends AnimatorListenerAdapter
{

    final View a;
    final _cls1 b;

    public void onAnimationEnd(Animator animator)
    {
        a.animate().setListener(null);
        StatusManager.j().a(MakeupMode.g);
        Globals.d(new Runnable() {

            final EditViewActivity._cls37._cls1 a;

            public void run()
            {
                a.a.animate().translationY(0.0F).setDuration(300L).setListener(new AnimatorListenerAdapter(this) {

                    final _cls1 a;

                    public void onAnimationEnd(Animator animator)
                    {
                        a.a.a.animate().setListener(null);
                    }

            
            {
                a = _pcls1;
                super();
            }
                }).start();
            }

            
            {
                a = EditViewActivity._cls37._cls1.this;
                super();
            }
        });
    }

    _cls1.a(_cls1.a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$37

/* anonymous class */
    class EditViewActivity._cls37
        implements android.view.View.OnClickListener
    {

        final EditViewActivity a;

        public void onClick(View view)
        {
            if (!StatusManager.j().E().booleanValue())
            {
                return;
            } else
            {
                StatusManager.j().a(Boolean.valueOf(false));
                view = a.findViewById(0x7f0c00c5);
                view.animate().translationY(view.getHeight()).setDuration(300L).setListener(new EditViewActivity._cls37._cls1(this, view)).start();
                EditViewActivity.f(a).c();
                StatusManager.j().a(Boolean.valueOf(true));
                return;
            }
        }

            
            {
                a = editviewactivity;
                super();
            }
    }

}
