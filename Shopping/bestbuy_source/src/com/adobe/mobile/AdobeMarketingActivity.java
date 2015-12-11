// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.app.Activity;
import android.os.Bundle;
import p;

// Referenced classes of package com.adobe.mobile:
//            Config

public abstract class AdobeMarketingActivity extends Activity
{

    public AdobeMarketingActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        Config.setContext(getApplicationContext());
    }

    protected void onDestroy()
    {
        super.onDestroy();
        p.d(this);
    }

    public void onPause()
    {
        p.g(this);
        super.onPause();
        Config.pauseCollectingLifecycleData();
    }

    protected void onRestart()
    {
        super.onRestart();
        p.e(this);
    }

    public void onResume()
    {
        p.f(this);
        super.onResume();
        Config.collectLifecycleData(this);
    }

    protected void onStart()
    {
        super.onStart();
        p.b(this);
    }

    protected void onStop()
    {
        super.onStop();
        p.c(this);
    }
}
