// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.os.Bundle;
import android.view.Menu;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.gno.GNODrawer;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOSplashScreenView

public class SSOSplashScreenActivity extends AmazonActivity
{

    public SSOSplashScreenActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getGNODrawer().lock(false);
        pushView(new SSOSplashScreenView(this), false);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }
}
