// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextDataManager

public abstract class UserContextObservingDataManager extends DataManager
    implements UserContextDataManager.Observer
{
    public static abstract class KeyBase extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
    {

        protected abstract UserContextObservingDataManager create(EbayContext ebaycontext);

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public final UserContextObservingDataManager createManager(EbayContext ebaycontext)
        {
            ebaycontext = create(ebaycontext);
            ebaycontext.create();
            return ebaycontext;
        }

        public KeyBase()
        {
        }
    }


    private final KeyBase params;
    private UserContextDataManager userContextDataManager;

    protected UserContextObservingDataManager(EbayContext ebaycontext, Class class1, KeyBase keybase)
    {
        super(ebaycontext, class1);
        params = keybase;
    }

    protected void create()
    {
        userContextDataManager = (UserContextDataManager)observeDm(UserContextDataManager.KEY);
    }

    protected final EbayCountry getCurrentCountry()
    {
        NautilusKernel.verifyMain();
        return userContextDataManager.getCurrentCountry();
    }

    protected final Authentication getCurrentUser()
    {
        NautilusKernel.verifyMain();
        return userContextDataManager.getCurrentUser();
    }

    public final KeyBase getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
    }

    public void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2)
    {
    }
}
