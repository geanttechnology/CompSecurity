// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import android.net.Uri;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiContext

public abstract class EcasApiRequest extends EbaySoaRequest
{

    private static final String COS_END_USER_CONTEXT_HEADER = "x-ebay-c-enduserctx";
    private static final String ECAS_VERSION_HEADER = "x-ebay-ecas-version";
    protected final String requestVersion;
    protected final boolean useBopis;

    protected EcasApiRequest(String s, EcasApiContext ecasapicontext)
    {
        super("CartApplicationService", true, s);
        iafToken = ecasapicontext.iafToken;
        soaGlobalId = ecasapicontext.site.idString;
        useBopis = ecasapicontext.useBopis;
        requestVersion = ecasapicontext.getRequestVersion();
        soaSoapAction = Uri.parse("http://www.ebay.com/marketplace/checkout/v1/services").buildUpon().appendPath(s).toString();
        isConvertedToAlternateHttpFaultStatus = true;
        useSoaLocaleList = true;
        super.dataFormat = "JSON";
        super.soaContentType = "application/json";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.shoppingCartApiUrl);
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-ecas-version", requestVersion);
        String s = NautilusDomain.getMachineGroupId(getContext());
        if (s != null)
        {
            iheaders.setHeader("x-ebay-c-enduserctx", (new StringBuilder()).append("deviceId=").append(s).append(",deviceIdType=IDREF").toString());
        }
    }
}
