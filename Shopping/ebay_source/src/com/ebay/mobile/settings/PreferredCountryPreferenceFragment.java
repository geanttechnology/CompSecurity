// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.ebay.mobile.activities.PreferencesActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.shell.app.FwActivity;

// Referenced classes of package com.ebay.mobile.settings:
//            PreferredCountryFragment, CountryPreferencesFragment

public class PreferredCountryPreferenceFragment extends PreferredCountryFragment
    implements android.widget.AdapterView.OnItemClickListener
{

    private UserContextDataManager userContextDataManager;

    public PreferredCountryPreferenceFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        userContextDataManager = (UserContextDataManager)DataManager.get(getFwActivity().getEbayContext(), UserContextDataManager.KEY);
        userContextDataManager.loadData(null);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = (PreferencesActivity)getActivity();
        adapterview = ((com.ebay.common.view.util.EbayCountryManager.CountryResources)adapterview.getItemAtPosition(i)).getCountry();
        userContextDataManager.setCurrentCountry(adapterview);
        CountryPreferencesFragment.trackCountrySettingsChange(view, adapterview, false);
        Util.hideSoftInput(view, getView().findViewById(0x7f10015e));
        if (view.isDualPane())
        {
            getFragmentManager().popBackStack();
            return;
        } else
        {
            view.onBackPressed();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        Activity activity = getActivity();
        (new TrackingData("PreferredCountrySelection", TrackingType.PAGE_IMPRESSION)).addSourceIdentification(activity.getIntent()).send(activity);
    }
}
