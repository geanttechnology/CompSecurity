// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.v4.view:
//            be

class bb
{

    public static void a(View view, be be)
    {
        view.animate().setUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(be, view) {

            final be a;
            final View b;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                a.a(b);
            }

            
            {
                a = be1;
                b = view;
                super();
            }
        });
    }
}
