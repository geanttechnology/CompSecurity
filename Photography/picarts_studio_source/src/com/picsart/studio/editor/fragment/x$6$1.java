// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            x

final class a extends ag
{

    private a a;

    public final void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        x.g(a.a).setVisibility(8);
        x.a(a.a, 3);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/x$6

/* anonymous class */
    final class x._cls6
        implements android.view.View.OnClickListener
    {

        final x a;

        public final void onClick(View view)
        {
            if (x.f(a) == 1)
            {
                x.a(a, 4);
                x.g(a).animate().alpha(0.0F).setListener(new x._cls6._cls1(this));
            } else
            if (x.f(a) == 3)
            {
                x.a(a, 2);
                x.g(a).setVisibility(0);
                x.g(a).animate().alpha(1.0F).setListener(new x._cls6._cls2());
                return;
            }
        }

            
            {
                a = x1;
                super();
            }

        // Unreferenced inner class com/picsart/studio/editor/fragment/x$6$2

/* anonymous class */
        final class x._cls6._cls2 extends ag
        {

            private x._cls6 a;

            public final void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                x.a(a.a, 1);
            }

                    
                    {
                        a = x._cls6.this;
                        super();
                    }
        }

    }

}
