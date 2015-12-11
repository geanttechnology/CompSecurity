// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            GetUserIncentives, EbayCartApi

public static final class incentiveType extends EbaySoaRequest
{

    private final getResponse incentiveType;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.incentiveType
    {
        try
        {
            JSONObject jsonobject1 = new JSONObject();
            JSONObject jsonobject;
            JSONArray jsonarray;
            if (incentiveType == null)
            {
                jsonobject1.put("incentiveType", .());
            } else
            {
                jsonobject1.put("incentiveType", incentiveType);
            }
            jsonobject = new JSONObject();
            jsonobject.put("includeIncentiveUsages", true);
            jsonobject.put("incentiveStatus", "ACTIVE");
            jsonarray = new JSONArray();
            jsonarray.put(jsonobject1);
            jsonobject.put("incentiveTypeList", jsonarray);
            jsonobject1 = new JSONObject();
            jsonobject1.put("getUserIncentivesRequest", jsonobject);
            return jsonobject1.toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.incentiveType(jsonexception);
        }
    }

    public URL getRequestUrl()
    {
        return EbayCartApi.getIncentiveServiceUrl();
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (EbayCartApi ebaycartapi,  )
    {
        super("CommonMobileAppService", false, "getUserIncentives");
        super.iafToken = ebaycartapi.iafToken;
        super.dataFormat = "JSON";
        super.soaContentType = "application/json";
        super.soaGlobalId = ebaycartapi.site.idString;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.bUseSoaServiceVersion = false;
        super.useSoaLocaleList = true;
        incentiveType = ;
    }
}
