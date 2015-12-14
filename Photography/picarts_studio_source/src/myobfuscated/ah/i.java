// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ah;

import android.view.View;
import android.view.animation.AlphaAnimation;

// Referenced classes of package myobfuscated.ah:
//            e, f, j

public final class i
    implements e
{

    private final j a;

    i(j j1)
    {
        a = j1;
    }

    public final boolean a(Object obj, f f1)
    {
        obj = f1.c();
        if (obj != null)
        {
            ((View) (obj)).clearAnimation();
            f1 = a;
            ((View) (obj)).getContext();
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(((j) (f1)).a);
            ((View) (obj)).startAnimation(alphaanimation);
        }
        return false;
    }
}
