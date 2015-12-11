// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.graphics.Bitmap;
import com.shazam.android.aa.c;

// Referenced classes of package com.shazam.android.receiver:
//            WearableTagMatchedReceiver

private final class b
    implements c
{

    final WearableTagMatchedReceiver a;
    private final String b;

    public final void a(Bitmap bitmap)
    {
        WearableTagMatchedReceiver.a(a, b, bitmap);
    }

    public (WearableTagMatchedReceiver wearabletagmatchedreceiver, String s)
    {
        a = wearabletagmatchedreceiver;
        super();
        b = s;
    }
}
