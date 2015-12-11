// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationContextBase, ExperimentationDataManager

private class currentCountry extends ExperimentationContextBase
{

    private EbayCountry currentCountry;
    private Authentication currentUserAuthentication;
    final ExperimentationDataManager this$0;
    private String userId;

    public List getContextDictionary(Context context)
    {
        ArrayList arraylist = new ArrayList();
        if (!TextUtils.isEmpty(userId))
        {
            arraylist.add(new Pair("un", userId));
        }
        arraylist.add(new Pair("aid", ((userId)getParams()).userId));
        arraylist.add(new Pair("mav", NautilusKernel.getAppVersionName(getContext())));
        String s1 = Build.MODEL;
        String s = s1;
        if (s1 != null)
        {
            s = s1.replace(" ", "_").replace(",", "_");
        }
        arraylist.add(new Pair("dn", s));
        context = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        if (!TextUtils.isEmpty(context))
        {
            arraylist.add(new Pair("carrier", context));
        }
        if (currentCountry != null)
        {
            arraylist.add(new Pair("site", currentCountry.getSiteGlobalId()));
            arraylist.add(new Pair("country", currentCountry.getCountryCode()));
            return arraylist;
        } else
        {
            arraylist.add(new Pair("site", EbaySite.US.idString));
            return arraylist;
        }
    }

    public Authentication getPrimaryAuthentication()
    {
        return currentUserAuthentication;
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (ebaycountry == null || ebaycountry.equals(currentCountry))
        {
            return;
        } else
        {
            currentCountry = ebaycountry;
            return;
        }
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        userId = s;
        currentUserAuthentication = usercontextdatamanager.getCurrentUser();
    }

    public void update()
    {
        NautilusKernel.verifyMain();
        currentCountry = ExperimentationDataManager.access$1000(ExperimentationDataManager.this);
    }

    public ()
    {
        this$0 = ExperimentationDataManager.this;
        super();
        userId = null;
        currentUserAuthentication = null;
        currentCountry = null;
    }
}
