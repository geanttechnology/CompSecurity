// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.service.startup.StartupDirector;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.activity:
//            Splash

class this._cls1
    implements Function0
{

    final is._cls0 this$1;

    public void execute()
    {
        Splash.access$1900(_fld0).addCoreServicesInitializerListener(Splash.access$2300(_fld0));
        Splash.access$1900(_fld0).startupCoreServices();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
