// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.animation.Animation;
import android.widget.ListView;
import com.socialin.android.util.af;

// Referenced classes of package myobfuscated.ck:
//            a

final class util.af extends af
{

    private a a;

    public final void onAnimationEnd(Animation animation)
    {
        super.onAnimationEnd(animation);
        animation = myobfuscated.ck.a.x(a);
        if (animation != null)
        {
            animation.setVisibility(8);
        }
    }

    n.Animation(a a1)
    {
        a = a1;
        super();
    }
}
