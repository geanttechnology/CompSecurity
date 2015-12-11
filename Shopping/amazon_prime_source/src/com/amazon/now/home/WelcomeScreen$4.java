// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import com.amazon.now.platform.TaskCallback;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen

class this._cls0
    implements TaskCallback
{

    final WelcomeScreen this$0;

    public void failure()
    {
        WelcomeScreen.access$400(WelcomeScreen.this);
    }

    public void success()
    {
        AppUtils.goHome(WelcomeScreen.access$000(WelcomeScreen.this));
    }

    ()
    {
        this$0 = WelcomeScreen.this;
        super();
    }
}
