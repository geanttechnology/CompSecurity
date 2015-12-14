// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.view.animation.Animation;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner

class a
    implements android.view.animation.tionListener
{

    final on a;
    final InMobiBanner b;

    public void onAnimationEnd(Animation animation)
    {
        InMobiBanner.access$700(b);
        a.a();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    on(InMobiBanner inmobibanner, on on)
    {
        b = inmobibanner;
        a = on;
        super();
    }
}
