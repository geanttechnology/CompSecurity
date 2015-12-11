// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class this._cls0
    implements android.view.ment._cls16
{

    final NearbyDealsFragment this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i != 66) goto _L2; else goto _L1
_L1:
        NearbyDealsFragment.access$1400(NearbyDealsFragment.this).dismiss();
        view = Strings.toString(NearbyDealsFragment.access$1800(NearbyDealsFragment.this).getText());
        if (!NearbyDealsFragment.access$1900(NearbyDealsFragment.this).getCurrentCountry().isLocationsAutocompleteEnabledCountry()) goto _L4; else goto _L3
_L3:
        setLocationAndReload(NearbyDealsFragment.access$2000(NearbyDealsFragment.this).getTopListSearchLocation(), oadReason.locationSet);
_L5:
        NearbyDealsFragment.access$1800(NearbyDealsFragment.this).clearFocus();
        return true;
_L4:
        if (Strings.equalsIgnoreCase(CURRENT_LOCATION, view))
        {
            setLocationAndReload(NearbyDealsFragment.access$2000(NearbyDealsFragment.this).getCurrentLocationOrDivisionPlace(), oadReason.locationSet);
        } else
        if (Strings.notEmpty(view))
        {
            NearbyDealsFragment.access$2100(NearbyDealsFragment.this, view);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    oadReason()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }
}
