// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import com.ebay.common.content.EbayCguidGetter;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

public class RtmNetLoader extends EbaySimpleNetLoader
{

    private final String campaignSelector;
    private final EbayCguidPersister cguidPersister;
    private final String clientVersion;
    private final int displayHeight;
    private final int displayWidth;
    private final String iafToken;
    private final String installedApps;
    private final String placementId;
    private final EbaySite site;

    public RtmNetLoader(EbayContext ebaycontext, String s, EbaySite ebaysite, String s1, EbayCguidPersister ebaycguidpersister, String s2, String s3, 
            int i, int j, String s4)
    {
        super(ebaycontext);
        iafToken = s;
        site = ebaysite;
        clientVersion = s1;
        cguidPersister = ebaycguidpersister;
        installedApps = s2;
        placementId = s3;
        displayWidth = i;
        displayHeight = j;
        campaignSelector = s4;
    }

    protected EbayRequest createRequest()
    {
        String s = EbayCguidGetter.get(getEbayContext(), cguidPersister, site, iafToken);
        return new GetRtm.GetRtmRequest(getContext(), iafToken, site, clientVersion, s, installedApps, placementId, displayWidth, displayHeight, campaignSelector);
    }
}
