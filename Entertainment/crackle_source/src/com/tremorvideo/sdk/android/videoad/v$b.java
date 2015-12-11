// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.Button;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, u, bv

private class setHeight extends Button
{

    final v a;

    public (v v1, Context context)
    {
        a = v1;
        super(context);
        v1 = v.a(v1).q().a(.v);
        setBackgroundDrawable(new BitmapDrawable(v1));
        setWidth(v1.getWidth());
        setHeight(v1.getHeight());
    }
}
