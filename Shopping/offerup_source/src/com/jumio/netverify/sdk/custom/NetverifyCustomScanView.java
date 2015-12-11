// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import jumiomobile.cd;

public final class NetverifyCustomScanView extends cd
{

    public NetverifyCustomScanView(Context context)
    {
        super(context);
    }

    public NetverifyCustomScanView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public NetverifyCustomScanView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected final void init(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.jumio.mobile.sdk.R.styleable.NetverifyCustomScanView, 0, 0);
        ratio = context.getFloat(com.jumio.mobile.sdk.R.styleable.NetverifyCustomScanView_ratio, 0.0F);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }
}
