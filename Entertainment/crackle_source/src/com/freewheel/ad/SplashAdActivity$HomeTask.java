// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import com.gotv.crackle.Application;
import java.util.TimerTask;

// Referenced classes of package com.freewheel.ad:
//            SplashAdActivity

private class <init> extends TimerTask
{

    final SplashAdActivity this$0;

    public void run()
    {
        Application.getInstance().startHomeActivity(SplashAdActivity.this);
        finish();
    }

    private ()
    {
        this$0 = SplashAdActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
