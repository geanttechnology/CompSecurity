// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.WobbleSpaceshipCatAnimationListener;
import com.groupon.view.WobbleSpaceshipCatView;

// Referenced classes of package com.groupon.activity:
//            Splash

private class <init>
    implements WobbleSpaceshipCatAnimationListener
{

    final Splash this$0;

    public void onExitRightAnimationEnd()
    {
        wobbleSpaceshipCatView.setVisibility(8);
        startActivity(Splash.access$2800(Splash.this));
        overridePendingTransition(0, 0);
        finish();
    }

    private ()
    {
        this$0 = Splash.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
