// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.picsart.studio.editor.view.b;
import com.socialin.android.util.ag;
import java.text.DecimalFormat;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            f

final class a extends ag
{

    private a a;

    public final void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        f.a(a.a, false);
    }

    b(b b)
    {
        a = b;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/f$1

/* anonymous class */
    final class f._cls1
        implements b
    {

        final f a;

        public final void a()
        {
            com.picsart.studio.editor.fragment.f.b(a).animate().alpha(0.0F).setListener(new f._cls1._cls2(this));
        }

        public final void a(float f1)
        {
            if (com.picsart.studio.editor.fragment.f.b(a).getVisibility() == 4 && Math.abs(f1) >= 0.1F)
            {
                f.a(a, true);
                com.picsart.studio.editor.fragment.f.b(a).setAlpha(0.0F);
                com.picsart.studio.editor.fragment.f.b(a).animate().alpha(1.0F).setListener(null);
            }
            f.d(a).setText((new StringBuilder()).append(f.c(a).format(f1)).append("\260").toString());
            f.a(a, f1);
        }

        public final void a(int i, int j)
        {
            if (f.a(a) != null)
            {
                f.a(a).post(new f._cls1._cls1(i, j));
            }
        }

            
            {
                a = f1;
                super();
            }

        // Unreferenced inner class com/picsart/studio/editor/fragment/f$1$1

/* anonymous class */
        final class f._cls1._cls1
            implements Runnable
        {

            private int a;
            private int b;
            private f._cls1 c;

            public final void run()
            {
                f.a(c.a).setText((new StringBuilder()).append(a).append("x").append(b).append(" ").toString());
            }

                    
                    {
                        c = f._cls1.this;
                        a = i;
                        b = j;
                        super();
                    }
        }

    }

}
