// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceView

class this._cls0
    implements android.widget.eListener
{

    final MarketPlaceView this$0;

    public void onTabChanged(String s)
    {
        String s1 = null;
        if (!"All Offers".equals(s)) goto _L2; else goto _L1
_L1:
        s1 = "dp_olp_a";
_L4:
        if (!Util.isEmpty(s1))
        {
            RefMarkerObserver.logRefMarker(s1);
        }
        return;
_L2:
        if ("New".equals(s))
        {
            s1 = "dp_olp_n";
        } else
        if ("Used".equals(s))
        {
            s1 = "dp_olp_u";
        } else
        if ("Refurbished".equals(s))
        {
            s1 = "dp_olp_r";
        } else
        if ("Collectible".equals(s))
        {
            s1 = "dp_olp_c";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = MarketPlaceView.this;
        super();
    }
}
