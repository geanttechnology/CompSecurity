// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.appnexus.opensdk.a:
//            g, h

public final class e
    implements g
{

    private static final float c[] = {
        0.0F, 0.0F, 1.0F, 0.0F
    };
    private static final float d[] = {
        0.0F, 0.0F, -1F, 0.0F
    };
    private static final float e[] = {
        -1F, 0.0F, 0.0F, 0.0F
    };
    private static final float f[] = {
        1.0F, 0.0F, 0.0F, 0.0F
    };
    private static final float g[] = {
        0.0F, 0.0F, 0.0F, -1F
    };
    private static final float h[] = {
        0.0F, 0.0F, 0.0F, 1.0F
    };
    private static final float i[] = {
        0.0F, 1.0F, 0.0F, 0.0F
    };
    private static final float j[] = {
        0.0F, -1F, 0.0F, 0.0F
    };
    private Animation a;
    private Animation b;

    public e(long l, h h1)
    {
        AccelerateInterpolator accelerateinterpolator;
        accelerateinterpolator = new AccelerateInterpolator();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.appnexus.opensdk.a.h.values().length];
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
        JVM INSTR tableswitch 1 4: default 52
    //                   1 124
    //                   2 132
    //                   3 140
    //                   4 148;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        float af[] = c;
_L11:
        a = a(af, accelerateinterpolator, l);
        _cls1.a[h1.ordinal()];
        JVM INSTR tableswitch 1 4: default 108
    //                   1 156
    //                   2 163
    //                   3 170
    //                   4 177;
           goto _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_177;
_L6:
        h1 = g;
_L12:
        b = a(h1, accelerateinterpolator, l);
        return;
_L2:
        af = c;
          goto _L11
_L3:
        af = d;
          goto _L11
_L4:
        af = e;
          goto _L11
_L5:
        af = f;
          goto _L11
_L7:
        h1 = g;
          goto _L12
_L8:
        h1 = h;
          goto _L12
_L9:
        h1 = i;
          goto _L12
        h1 = j;
          goto _L12
    }

    private static Animation a(float af[], Interpolator interpolator, long l)
    {
        af = new TranslateAnimation(2, af[0], 2, af[1], 2, af[2], 2, af[3]);
        af.setInterpolator(interpolator);
        af.setDuration(l);
        return af;
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
