// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            EffectThumbLayout

class val.isClosing
    implements Runnable
{

    final EffectThumbLayout this$0;
    final int val$durationMs;
    final boolean val$isClosing;

    public void run()
    {
        animateView(val$durationMs, val$isClosing);
    }

    ()
    {
        this$0 = final_effectthumblayout;
        val$durationMs = i;
        val$isClosing = Z.this;
        super();
    }
}
