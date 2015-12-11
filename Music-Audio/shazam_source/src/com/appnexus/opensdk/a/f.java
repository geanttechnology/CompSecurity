// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.appnexus.opensdk.a:
//            g, h

public final class f
    implements g
{

    private static final float c[] = {
        0.0F, 0.0F, 0.0F, -1F
    };
    private static final float d[] = {
        0.0F, 0.0F, 0.0F, 1.0F
    };
    private static final float e[] = {
        0.0F, 1.0F, 0.0F, 0.0F
    };
    private static final float f[] = {
        0.0F, -1F, 0.0F, 0.0F
    };
    private Animation a;
    private Animation b;

    public f(long l, h h1)
    {
        Object obj;
        obj = new AccelerateInterpolator();
        a = new AlphaAnimation(0.0F, 1.0F);
        a.setDuration(l);
        a.setInterpolator(((android.view.animation.Interpolator) (obj)));
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[h.values().length];
                try
                {
                    a[h.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[h.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[h.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[h.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[h1.ordinal()];
        JVM INSTR tableswitch 1 4: default 80
    //                   1 173
    //                   2 180
    //                   3 187
    //                   4 194;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        h1 = c;
_L7:
        h1 = new TranslateAnimation(2, h1[0], 2, h1[1], 2, h1[2], 2, h1[3]);
        h1.setInterpolator(((android.view.animation.Interpolator) (obj)));
        h1.setDuration(l);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(l);
        alphaanimation.setInterpolator(((android.view.animation.Interpolator) (obj)));
        obj = new AnimationSet(false);
        ((AnimationSet) (obj)).addAnimation(h1);
        ((AnimationSet) (obj)).addAnimation(alphaanimation);
        b = ((Animation) (obj));
        return;
_L2:
        h1 = c;
        continue; /* Loop/switch isn't completed */
_L3:
        h1 = d;
        continue; /* Loop/switch isn't completed */
_L4:
        h1 = e;
        continue; /* Loop/switch isn't completed */
_L5:
        h1 = f;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final Animation a()
    {
        return a;
    }

    public final Animation b()
    {
        return b;
    }

}
