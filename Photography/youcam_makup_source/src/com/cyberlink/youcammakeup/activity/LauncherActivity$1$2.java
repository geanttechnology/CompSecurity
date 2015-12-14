// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.pages.b.b;
import com.cyberlink.youcammakeup.utility.aa;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements android.animation.ener
{

    final a a;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        Globals.d(new Runnable() {

            final LauncherActivity._cls1._cls2 a;

            public void run()
            {
                LauncherActivity._cls1.a(a.a).setAlpha(1.0F);
                LauncherActivity._cls1.a(a.a).setVisibility(4);
            }

            
            {
                a = LauncherActivity._cls1._cls2.this;
                super();
            }
        });
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$1

/* anonymous class */
    class LauncherActivity._cls1
        implements b
    {

        final LauncherActivity a;
        private View b;
        private ImageView c;
        private View d;

        static View a(LauncherActivity._cls1 _pcls1)
        {
            return _pcls1.b;
        }

        private void a()
        {
            b.animate().alpha(1.0F).setDuration(1000L).setListener(new LauncherActivity._cls1._cls1()).start();
        }

        private void b()
        {
            b.animate().alpha(0.0F).setDuration(1000L).setListener(new LauncherActivity._cls1._cls2(this)).start();
        }

        static void b(LauncherActivity._cls1 _pcls1)
        {
            _pcls1.b();
        }

        public void a(Pair pair)
        {
            if (b == null)
            {
                b = a.findViewById(0x7f0c08e3);
                c = (ImageView)b.findViewById(0x7f0c08e4);
                d = a.findViewById(0x7f0c0142);
            }
            m.b("onGetBeautyCircleStatus::first", String.valueOf(pair.first));
            m.b("onGetBeautyCircleStatus::second", String.valueOf(pair.second));
            if (pair.first != null && ((Integer)pair.first).intValue() > 0)
            {
                d.setVisibility(0);
            } else
            {
                d.setVisibility(4);
            }
            if (aa.b((Bitmap)pair.second))
            {
                c.setImageBitmap((Bitmap)pair.second);
                b.setVisibility(0);
                b.clearAnimation();
                b.setAlpha(0.0F);
                a();
                return;
            } else
            {
                b.setVisibility(4);
                b.clearAnimation();
                return;
            }
        }

            
            {
                a = launcheractivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$1$1

/* anonymous class */
        class LauncherActivity._cls1._cls1
            implements android.animation.Animator.AnimatorListener
        {

            final LauncherActivity._cls1 a;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                Globals.d(new LauncherActivity._cls1._cls1._cls1(this));
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

                    
                    {
                        a = LauncherActivity._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$1$1$1

/* anonymous class */
        class LauncherActivity._cls1._cls1._cls1
            implements Runnable
        {

            final LauncherActivity._cls1._cls1 a;

            public void run()
            {
                LauncherActivity._cls1.a(a.a).setAlpha(1.0F);
                Globals.a(new LauncherActivity._cls1._cls1._cls1._cls1(this), 3000L);
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$1$1$1$1

/* anonymous class */
        class LauncherActivity._cls1._cls1._cls1._cls1
            implements Runnable
        {

            final LauncherActivity._cls1._cls1._cls1 a;

            public void run()
            {
                com.cyberlink.youcammakeup.activity.LauncherActivity._cls1.b(a.a.a);
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }

    }

}
