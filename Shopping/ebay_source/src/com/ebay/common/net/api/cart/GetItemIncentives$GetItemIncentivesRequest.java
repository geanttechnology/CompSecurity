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
//            GetItemIncentives, EbayCartApi

public static final class setTimeout extends EbaySoaRequest
{

    final String currency;
    final String itemId;
    final Integer quantity;
    final String transactionId;
    final getResponse types[];
    final String variationId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.setTimeout
    {
        JSONObject jsonobject;
        byte abyte0[];
        Object obj;
        setTimeout asettimeout[];
        int i;
        int j;
        try
        {
            obj = new JSONArray();
            jsonobject = new JSONObject();
            jsonobject.put("itemId", itemId);
            if (variationId != null)
            {
                jsonobject.put("itemVariationId", variationId);
            }
            if (transactionId != null)
            {
                jsonobject.put("transactionID", transactionId);
            }
            if (quantity != null)
            {
                jsonobject.put("quantity", quantity);
            }
            jsonobject.put("entityType", "ITEM");
            ((JSONArray) (obj)).put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.put("items", obj);
            jsonobject.put("requester", "itemview");
            obj = new JSONArray();
            asettimeout = types;
            j = asettimeout.length;
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.types(jsonexception);
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((JSONArray) (obj)).put(asettimeout[i].types());
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_141;
_L1:
        jsonobject.put("incentiveTypeList", (new JSONObject()).put("incentiveType", obj));
        obj = new JSONObject();
        ((JSONObject) (obj)).put("getItemIncentivesRequest", jsonobject);
        abyte0 = ((JSONObject) (obj)).toString().getBytes();
        return abyte0;
    }

    public URL getRequestUrl()
    {
        return EbayCartApi.getIncentiveServiceUrl();
    }

    public  getResponse()
    {
        return new (currency);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, Integer integer, Boolean boolean1, 
            boolean flag)
    {
        if (boolean1.booleanValue())
        {
            boolean1 = ;
        } else
        {
            boolean1 = ;
        }
        this(ebaycartapi, s, s1, s2, s3, integer, new <init>[] {
            boolean1
        }, flag);
    }

    public <init>(EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, Integer integer, <init> a_3C_init>[], 
            boolean flag)
    {
        super("CommonMobileAppService", false, "getItemIncentives");
        super.iafToken = ebaycartapi.iafToken;
        super.dataFormat = "JSON";
        super.soaContentType = "application/json";
        super.soaGlobalId = ebaycartapi.site.idString;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaServiceVersion = "1.1.1";
        super.useSoaLocaleList = true;
        currency = s;
        itemId = s1;
        transactionId = s2;
        ebaycartapi = s3;
        if (s3 == null)
        {
            ebaycartapi = "0";
        }
        variationId = ebaycartapi;
        quantity = integer;
        types = a_3C_init>;
        if (flag)
        {
            setTimeout(10000);
        }
    }
}
