// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.widget.Toast;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;

// Referenced classes of package com.groupon.fragment:
//            BaseSignUpFragment

class this._cls0
    implements Runnable
{

    final BaseSignUpFragment this$0;

    public void run()
    {
        Toast.makeText(getActivity().getApplicationContext(), getString(0x7f08017d, new Object[] {
            countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
        }), 1).show();
    }

    rentCountryManager()
    {
        this$0 = BaseSignUpFragment.this;
        super();
    }
}
