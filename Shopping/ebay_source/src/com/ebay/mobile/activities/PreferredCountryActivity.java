// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.settings.PreferredCountryFragment;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

public class PreferredCountryActivity extends BaseActivity
    implements android.widget.AdapterView.OnItemClickListener
{

    public static final String EXTRA_COUNTRY = "extraCountry";
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CountryAutoDetect", 3, "Country Auto-Detect mode");

    public PreferredCountryActivity()
    {
    }

    public String getTrackingEventName()
    {
        return "AddNewCountryAddress";
    }

    public void onCreate(Bundle bundle)
    {
        useMenuHandler = false;
        super.onCreate(bundle);
        setContentView(0x7f0300b2);
        setTitle(getString(0x7f0707ab));
        bundle = new PreferredCountryFragment();
        Intent intent = getIntent();
        if (intent.hasExtra("extraCountry"))
        {
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("extraCountry", intent.getParcelableExtra("extraCountry"));
            bundle.setArguments(bundle1);
        }
        getFragmentManager().beginTransaction().add(0x7f1001c9, bundle).commit();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = (com.ebay.common.view.util.EbayCountryManager.CountryResources)adapterview.getItemAtPosition(i);
        adapterview = new Intent();
        view = view.getCountry();
        adapterview.putExtra("extraCountry", view);
        setResult(-1, adapterview);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Manually selected country: ").append(view).toString());
        }
        finish();
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }

}
