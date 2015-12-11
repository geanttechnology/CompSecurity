// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.text.TextUtils;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;

// Referenced classes of package com.ebay.common:
//            Preferences

public class PrefUserContext extends UserContext
{

    public PrefUserContext(EbayContext ebaycontext)
    {
        super(ebaycontext);
    }

    protected void notifyCurrentCountryChanged(EbayCountry ebaycountry)
    {
        Preferences preferences = MyApp.getPrefs();
        if (ebaycountry == null)
        {
            preferences.clearCurrentCountry();
        } else
        {
            preferences.setCurrentCountry(ebaycountry);
        }
        super.notifyCurrentCountryChanged(ebaycountry);
    }

    protected void notifyCurrentUserChanged(String s, String s1, boolean flag)
    {
        Preferences preferences = MyApp.getPrefs();
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            preferences.signOut();
        } else
        {
            preferences.signIn(s, s1);
        }
        super.notifyCurrentUserChanged(s, s1, flag);
    }

    protected EbayCountry onDefaultCountry()
    {
        return EbayCountryManager.detectCountry();
    }

    protected EbayCountry onInitializeCountry()
    {
        return MyApp.getPrefs().getCurrentCountry();
    }

    protected int onInitializeUser(List list)
    {
        com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            list.add(authentication);
            return 0;
        } else
        {
            return super.onInitializeUser(list);
        }
    }
}
