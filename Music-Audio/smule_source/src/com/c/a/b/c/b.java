// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.c;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.c.a.b.a.g;
import com.c.a.b.e.a;

// Referenced classes of package com.c.a.b.c:
//            a

public class b
    implements com.c.a.b.c.a
{

    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public b(int i)
    {
        this(i, true, true, true);
    }

    public b(int i, boolean flag, boolean flag1, boolean flag2)
    {
        a = i;
        b = flag;
        c = flag1;
        d = flag2;
    }

    public static void a(View view, int i)
    {
        if (view != null)
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(i);
            alphaanimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaanimation);
        }
    }

    public Bitmap a(Bitmap bitmap, a a1, g g1)
    {
        a1.a(bitmap);
        if (b && g1 == g.a || c && g1 == g.b || d && g1 == g.c)
        {
            a(a1.d(), a);
        }
        return bitmap;
    }
}
