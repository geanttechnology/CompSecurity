// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import android.view.View;
import android.widget.AdapterView;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.mobileads:
//            DebugSettingsActivityForAds

private class mAdsId
    implements android.widget.tedListener
{

    private final String mAdsId;
    final DebugSettingsActivityForAds this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        DebugSettingsActivityForAds.access$000().put(mAdsId, DebugSettingsActivityForAds.access$200()[i]);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public (String s)
    {
        this$0 = DebugSettingsActivityForAds.this;
        super();
        mAdsId = s;
    }
}
