// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import org.springframework.util.LinkedMultiValueMap;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPGeolocation, Configuration

class val.zipcode extends LinkedMultiValueMap
{

    final VPGeolocation this$0;
    final String val$latitude;
    final String val$longitude;
    final String val$zipcode;

    ()
    {
        this$0 = final_vpgeolocation;
        val$latitude = s;
        val$longitude = s1;
        val$zipcode = String.this;
        super();
        add("brand", VPGeolocation.access$000(VPGeolocation.this).getCurrentNetwork());
        add("device", VPGeolocation.access$000(VPGeolocation.this).getCurrentPartnerCode());
        add("type", "gt");
        add("latitude", val$latitude);
        add("longitude", val$longitude);
        add("zipcode", val$zipcode);
    }
}
