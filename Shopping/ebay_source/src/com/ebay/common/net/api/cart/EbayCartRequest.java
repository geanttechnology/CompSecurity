// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.paypal.android.lib.riskcomponent.utils.Util;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public abstract class EbayCartRequest extends EbaySoaRequest
{

    private static final String COS_END_USER_CONTEXT = "x-ebay-c-enduserctx";
    private static final String X_EBAY_CART_SERVICE_VERSION = "x-ebay-c-version";
    private final URL cartServiceUrl;
    private final String riskCorrelationId;

    public EbayCartRequest(EbayCartApi ebaycartapi, String s)
    {
        super("CartService", true, s);
        super.iafToken = ebaycartapi.iafToken;
        super.dataFormat = "JSON";
        super.soaContentType = "application/json";
        super.soaGlobalId = ebaycartapi.site.idString;
        riskCorrelationId = ebaycartapi.riskCorrelationId;
        useSoaLocaleList = true;
        cartServiceUrl = ebaycartapi.getSoaCartServiceUrl();
    }

    protected void buildClientContext(JSONObject jsonobject)
        throws JSONException
    {
        if (!TextUtils.isEmpty(riskCorrelationId))
        {
            Object obj = (new JSONObject()).put("@name", "paymentRiskCorrelationId").put("__value__", riskCorrelationId);
            obj = (new JSONArray()).put(obj);
            obj = (new JSONObject()).put("clientContextAttributes", (new JSONObject()).put("attribute", obj));
            String s = Util.getLocalIpAddress();
            if (!TextUtils.isEmpty(s))
            {
                ((JSONObject) (obj)).put("connectionProperties", (new JSONObject()).put("IPAddress", s));
            }
            jsonobject.put("clientContext", obj);
        }
    }

    public URL getRequestUrl()
    {
        return cartServiceUrl;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-c-version", DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.S.ccsSupportedVersion));
        String s = NautilusDomain.getMachineGroupId(getContext());
        if (s != null)
        {
            iheaders.setHeader("x-ebay-c-enduserctx", (new StringBuilder()).append("deviceId=").append(s).append(",deviceIdType=IDREF").toString());
        }
    }
}
