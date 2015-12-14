// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.db;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package myobfuscated.db:
//            a

final class t>
    implements android.view.animation.tion.AnimationListener
{

    private View a;
    private a b;

    public final void onAnimationEnd(Animation animation)
    {
        a.setVisibility(8);
        myobfuscated.db.a.h(b);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    n.Animation(a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }
}
