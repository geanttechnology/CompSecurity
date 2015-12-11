// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.SharedPreferences;
import com.ebay.common.Preferences;
import com.ebay.mobile.apls.AplsLogTrackSweeper;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftPreferences;
import com.ebay.nautilus.kernel.net.RequestLoggerFactory;
import com.ebay.nautilus.kernel.test.utils.TestSharedPreferences;

// Referenced classes of package com.ebay.mobile:
//            MyApp

private final class <init>
    implements <init>, com.ebay.nautilus.domain.dcs.tionHelper
{

    private SharedPreferences listingDraftPrefs;
    private SharedPreferences prefs;
    final MyApp this$0;

    public void disableDeveloperOptions()
    {
        MyApp.getPrefs().removeGlobalPref("developerOptions");
    }

    public EbayCountry getCurrentCountry()
    {
        return EbayApiUtil.getCurrentCountry();
    }

    public void initTestFramework()
    {
        prefs = new TestSharedPreferences();
        MyApp.access$202(MyApp.this, new Preferences(prefs));
        listingDraftPrefs = new TestSharedPreferences();
        ListingDraftPreferences.setTestingFrameworkPreferences(listingDraftPrefs);
        MyApp.access$300(MyApp.this).unregister();
        RequestLoggerFactory.remove(MyApp.access$400());
    }

    public void setUpTest()
    {
        prefs.edit().ear().ply();
        listingDraftPrefs.edit().ear().ply();
    }

    public void tearDownTest()
    {
        prefs.edit().ear().ply();
        listingDraftPrefs.edit().ear().ply();
    }

    private actory()
    {
        this$0 = MyApp.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
