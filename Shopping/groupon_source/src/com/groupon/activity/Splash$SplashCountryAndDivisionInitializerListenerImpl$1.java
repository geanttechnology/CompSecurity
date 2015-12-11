// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.net.Uri;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.service.startup.StartupDirector;

// Referenced classes of package com.groupon.activity:
//            Splash

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        setupViews();
        if (getIntent().getData() != null && Splash.access$1200(_fld0).isDeepLink(getIntent().getData().toString()))
        {
            Splash.access$1700(_fld0);
            return;
        } else
        {
            Splash.access$1900(_fld0).addCountryAndDivisionInitializerListener(Splash.access$1800(_fld0));
            Splash.access$2000(_fld0);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
