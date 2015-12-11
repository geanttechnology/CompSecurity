// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

public static abstract class isConvertedToAlternateHttpFaultStatus extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.e
{

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.e
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public abstract void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException;

    public URL getRequestUrl()
    {
        ApiSettings apisettings;
        if (iafToken == null)
        {
            apisettings = ApiSettings.finding20Api;
        } else
        {
            apisettings = ApiSettings.finding20ApiSecure;
        }
        return ApiSettings.getUrl(apisettings);
    }

    public e getResponse()
    {
        return new e(null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected e(String s)
    {
        super("FindingService", false, s);
        isConvertedToAlternateHttpFaultStatus = true;
    }
}
