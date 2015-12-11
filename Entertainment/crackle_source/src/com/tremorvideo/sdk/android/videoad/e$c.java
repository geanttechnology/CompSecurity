// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.Button;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e, u, bv

private class setFocusable extends Button
{

    final e a;

    public (e e1, Context context)
    {
        a = e1;
        super(context);
        e1 = e.a(e1).q().a(.v);
        setBackgroundDrawable(new BitmapDrawable(e1));
        setWidth(e1.getWidth());
        setHeight(e1.getHeight());
        setFocusable(false);
    }
}
