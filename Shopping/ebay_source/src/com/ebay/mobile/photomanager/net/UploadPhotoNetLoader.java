// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import android.content.ContentResolver;
import android.net.Uri;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.photomanager.net:
//            UploadSiteHostedImageRequest

public class UploadPhotoNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final String customPictureSet;
    private final String extensionInDays;
    private final Uri image;
    private final ContentResolver resolver;

    public UploadPhotoNetLoader(EbayContext ebaycontext, ContentResolver contentresolver, Uri uri, EbayTradingApi ebaytradingapi, String s, String s1)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        resolver = contentresolver;
        image = uri;
        customPictureSet = s;
        extensionInDays = s1;
    }

    protected EbayRequest createRequest()
    {
        return new UploadSiteHostedImageRequest(api, resolver, image, customPictureSet, extensionInDays);
    }

    public boolean isHostError()
    {
        return getException() != null && (getException() instanceof com.ebay.nautilus.kernel.net.Connector.HostErrorException);
    }
}
