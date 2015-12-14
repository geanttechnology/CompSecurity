// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.animation.Animator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.socialin.android.util.c;

// Referenced classes of package myobfuscated.ck:
//            d

final class it>
    implements android.animation.ator.AnimatorListener
{

    private d a;

    public final void onAnimationCancel(Animator animator)
    {
        a.f.setVisibility(4);
        d.o(a).setImageBitmap(null);
        if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).equals(d.k(a)))
        {
            c.a(myobfuscated.ck.d.c(a));
        }
        d.d(a, false);
    }

    public final void onAnimationEnd(Animator animator)
    {
        a.f.setVisibility(4);
        d.o(a).setImageBitmap(null);
        if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).equals(d.k(a)))
        {
            c.a(myobfuscated.ck.d.c(a));
        }
        d.d(a, false);
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
        d.d(a, true);
    }

    imator(d d1)
    {
        a = d1;
        super();
    }
}
