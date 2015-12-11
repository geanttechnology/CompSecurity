// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.IllegalFormatException;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.home:
//            SplashActivity

class this._cls0
    implements android.view.ner
{

    final SplashActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(SplashActivity.this, com/ebay/mobile/activities/ShowWebViewActivity);
        try
        {
            view.putExtra("url", String.format(DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.ourLink), new Object[] {
                Integer.valueOf(MyApp.getPrefs().getCurrentCountry().getSiteId()), Locale.getDefault().toString().toLowerCase(Locale.US).replaceAll("-", "_")
            }));
            startActivity(view);
            finish();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    figuration()
    {
        this$0 = SplashActivity.this;
        super();
    }
}
