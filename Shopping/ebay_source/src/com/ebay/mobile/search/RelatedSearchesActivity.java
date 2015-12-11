// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;

// Referenced classes of package com.ebay.mobile.search:
//            RelatedSearchesFragment

public class RelatedSearchesActivity extends BaseActivity
{

    public static final String EXTRA_RELATED_SEARCHES = "related_searches";

    public RelatedSearchesActivity()
    {
    }

    public String getTrackingEventName()
    {
        return "RelatedSearchScroll";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b2);
        if (bundle == null)
        {
            bundle = new RelatedSearchesFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("header", getString(0x7f07090e));
            bundle1.putStringArrayList("related_searches", getIntent().getStringArrayListExtra("related_searches"));
            bundle.setArguments(bundle1);
            getFragmentManager().beginTransaction().add(0x7f1001c9, bundle).commit();
        }
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }
}
