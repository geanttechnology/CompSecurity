// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.view.View;
import com.amazon.mShop.DelayedInitView;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarHelper

static final class val.webGatewayBar
    implements Runnable
{

    final View val$webGatewayBar;

    public void run()
    {
        ((DelayedInitView)val$webGatewayBar).onPushViewCompleted();
    }

    (View view)
    {
        val$webGatewayBar = view;
        super();
    }
}
