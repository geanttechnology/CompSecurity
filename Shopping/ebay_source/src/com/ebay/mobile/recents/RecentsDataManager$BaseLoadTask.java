// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import android.os.AsyncTask;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

private abstract class pref extends AsyncTask
{

    protected String cguid;
    protected final String iafToken;
    private Preferences pref;
    protected final EbaySite site;
    final RecentsDataManager this$0;

    protected final transient Object doInBackground(Object aobj[])
    {
        cguid = EbayCguidGetter.get(getEbayContext(), pref, site, iafToken);
        return startBackgroundTask(aobj);
    }

    protected abstract EbayRequest getRequest();

    protected transient abstract Object startBackgroundTask(Object aobj[]);

    (String s)
    {
        this$0 = RecentsDataManager.this;
        super();
        iafToken = s;
        pref = MyApp.getPrefs();
        site = pref.getCurrentSite();
    }
}
