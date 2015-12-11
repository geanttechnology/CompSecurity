// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.amazon.device.ads:
//            AdLayout, AmazonOOAdController, AdSize, AdController, 
//            IAdController

public class AmazonOOAdLayout extends AdLayout
{

    public AmazonOOAdLayout(Activity activity, AdSize adsize)
    {
        super(activity, adsize);
    }

    public AmazonOOAdLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AmazonOOAdLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected AdController createAdController(AdSize adsize, Context context)
    {
        return new AmazonOOAdController(this, adsize, context);
    }

    protected volatile IAdController createAdController(AdSize adsize, Context context)
    {
        return createAdController(adsize, context);
    }

    public void setShouldDisableWebViewHardwareAcceleration(boolean flag)
    {
        super.setShouldDisableWebViewHardwareAcceleration(flag);
    }
}
