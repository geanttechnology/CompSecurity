// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.TabActivity;
import android.os.Bundle;

// Referenced classes of package com.medialets.advertising:
//            AdManager

public abstract class AdTabActivity extends TabActivity
{

    private AdManager a;

    public AdTabActivity()
    {
    }

    public AdManager getAdManager()
    {
        return a;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = AdManager.getInstance();
        a.start(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        a.stop(this);
    }

    public void onResume()
    {
        super.onResume();
        a.resume(this);
    }
}
