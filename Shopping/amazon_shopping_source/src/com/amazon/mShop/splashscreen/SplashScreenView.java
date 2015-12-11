// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.splashscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.amazon.mShop.startup.StartupSequenceMediator;

// Referenced classes of package com.amazon.mShop.splashscreen:
//            StartupActivity

public class SplashScreenView extends RelativeLayout
{

    public SplashScreenView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Context context = getContext();
        if (context instanceof StartupActivity)
        {
            ((StartupActivity)context).getStartupMediator().start();
        }
    }
}
