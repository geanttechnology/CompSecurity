// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import jumiomobile.cd;

public final class NetswipeCustomScanView extends cd
{

    public NetswipeCustomScanView(Context context)
    {
        super(context);
    }

    public NetswipeCustomScanView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public NetswipeCustomScanView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected final void init(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.jumio.mobile.sdk.R.styleable.NetswipeCustomScanView, 0, 0);
        ratio = context.getFloat(com.jumio.mobile.sdk.R.styleable.NetswipeCustomScanView_ratio, 0.0F);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }
}
