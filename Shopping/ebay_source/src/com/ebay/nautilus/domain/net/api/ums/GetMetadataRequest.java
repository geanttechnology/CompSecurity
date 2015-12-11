// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import android.net.Uri;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            GetMetadataResponse

public class GetMetadataRequest extends EbaySoaRequest
{

    private final transient String categoryId;
    private final transient EbaySite site;

    public GetMetadataRequest(EbaySite ebaysite, String s)
    {
        super("UnifiedMetadataServiceV1", true, "getMetadata");
        super.soaContentType = "application/json";
        super.responseDataFormat = "JSON";
        super.soaGlobalId = ebaysite.idString;
        categoryId = s;
        site = ebaysite;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.getUrl(ApiSettings.unifiedMetadataUrl).toString()).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("categoryId", categoryId);
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("siteId", site.id);
        try
        {
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj));
    }

    public GetMetadataResponse getResponse()
    {
        return new GetMetadataResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
