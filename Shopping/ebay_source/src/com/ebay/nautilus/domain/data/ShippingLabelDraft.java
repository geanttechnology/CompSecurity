// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelDetails

public class ShippingLabelDraft extends BaseApiResponse
{
    public static class AdditionalData
    {

        public PSLEntry entry[];

        public AdditionalData()
        {
        }
    }

    public static class PSLEntry
    {

        public String key;
        public String value[];

        public PSLEntry()
        {
        }
    }


    public static final String PSLENTRY_KEY_FEDEX_TERMS_CONDITIONS_URL = "FEDEX_TC_URL";
    public AdditionalData additionalData;
    public String draftLabelId;
    public ShippingLabelDetails labelDetails;

    public ShippingLabelDraft()
    {
    }
}
