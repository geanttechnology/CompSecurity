// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            cg, cf

public class ViewAnimationUtils
{

    public static android.view.View.OnLayoutChangeListener a = new android.view.View.OnLayoutChangeListener() {

        public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1)
        {
            while (i1 == 0 && j1 == 0 && k1 == 0 && l1 == 0 || i == i1 && j == j1 && k == k1 && l == l1) 
            {
                return;
            }
            view.setY(j1);
            view.animate().y(j);
        }

    };

    public static long a()
    {
        return 300L;
    }

    public static Animation a(SlideDirection slidedirection)
    {
        return SlideDirection.a(slidedirection);
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/utility/ViewAnimationUtils$1

/* anonymous class */
    final class _cls1 extends cg
    {

        final cf a;

        public void onAnimationEnd(Animation animation)
        {
            if (a != null)
            {
                a.c();
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
            if (a != null)
            {
                a.b();
            }
        }

        public void onAnimationStart(Animation animation)
        {
            if (a != null)
            {
                a.a();
            }
        }
    }


    private class SlideDirection extends Enum
    {

        public static final SlideDirection a;
        public static final SlideDirection b;
        public static final SlideDirection c;
        public static final SlideDirection d;
        private static final SlideDirection e[];

        public static Animation a(SlideDirection slidedirection)
        {
            slidedirection = slidedirection.a();
            slidedirection.setDuration(300L);
            return slidedirection;
        }

        public static SlideDirection valueOf(String s)
        {
            return (SlideDirection)Enum.valueOf(com/cyberlink/youcammakeup/utility/ViewAnimationUtils$SlideDirection, s);
        }

        public static SlideDirection[] values()
        {
            return (SlideDirection[])e.clone();
        }

        protected abstract Animation a();

        static 
        {
            a = new SlideDirection("UP_IN", 0) {

                protected Animation a()
                {
                    return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
                }

            };
            b = new SlideDirection("DOWN_IN", 1) {

                protected Animation a()
                {
                    return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1F, 1, 0.0F);
                }

            };
            c = new SlideDirection("UP_OUT", 2) {

                protected Animation a()
                {
                    return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1F);
                }

            };
            d = new SlideDirection("DOWN_OUT", 3) {

                protected Animation a()
                {
                    return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
                }

            };
            e = (new SlideDirection[] {
                a, b, c, d
            });
        }

        private SlideDirection(String s, int i)
        {
            super(s, i);
        }

    }

}
