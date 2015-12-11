// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;

// Referenced classes of package com.google.tagmanager:
//            ArbitraryPixelTag, DelayedHitSender, HitSender

class val.context
    implements tSenderProvider
{

    final Context val$context;

    public HitSender get()
    {
        return DelayedHitSender.getInstance(val$context);
    }

    tSenderProvider()
    {
        val$context = context1;
        super();
    }
}
