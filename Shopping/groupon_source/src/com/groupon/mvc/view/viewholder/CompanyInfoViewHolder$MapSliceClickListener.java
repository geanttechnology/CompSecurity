// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.callbacks.OnCompanyInfoEventListener;
import com.groupon.callbacks.OnMapSliceClickListener;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            CompanyInfoViewHolder

private class phone
    implements OnMapSliceClickListener
{

    private String address;
    private double lat;
    private double lng;
    private String phone;
    final CompanyInfoViewHolder this$0;
    private String vendorName;

    public void onViewClicked(View view, com.groupon.view.eClickListener eclicklistener)
    {
        if (callback == null) goto _L2; else goto _L1
_L1:
        on.view.MapSliceImprovedView.MapSliceViewType[eclicklistener.l()];
        JVM INSTR tableswitch 1 5: default 52
    //                   1 53
    //                   2 82
    //                   3 103
    //                   4 120
    //                   5 141;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return;
_L3:
        ((OnCompanyInfoEventListener)callback).onMapViewClick(view, lat, lng, vendorName);
        return;
_L4:
        ((OnCompanyInfoEventListener)callback).onAddressClick(view, address);
        return;
_L5:
        ((OnCompanyInfoEventListener)callback).onMultipleLocationsClick(view);
        return;
_L6:
        ((OnCompanyInfoEventListener)callback).onPhoneClick(view, phone);
        return;
_L7:
        ((OnCompanyInfoEventListener)callback).onWebsiteClick(view);
        return;
    }

    public Q(double d, double d1, String s, String s1, 
            String s2)
    {
        this$0 = CompanyInfoViewHolder.this;
        super();
        lat = d;
        lng = d1;
        vendorName = s;
        address = s1;
        phone = s2;
    }
}
