// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.ItemIncentives;
import com.ebay.common.net.JsonResponse;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class GetItemIncentives
{
    public static final class GetItemIncentivesRequest extends EbaySoaRequest
    {

        final String currency;
        final String itemId;
        final Integer quantity;
        final String transactionId;
        final ItemIncentiveType types[];
        final String variationId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            JSONObject jsonobject;
            byte abyte0[];
            Object obj;
            ItemIncentiveType aitemincentivetype[];
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
                aitemincentivetype = types;
                j = aitemincentivetype.length;
            }
            catch (JSONException jsonexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
            i = 0;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((JSONArray) (obj)).put(aitemincentivetype[i].name());
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

        public GetItemIncentivesResponse getResponse()
        {
            return new GetItemIncentivesResponse(currency);
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public GetItemIncentivesRequest(EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, Integer integer, Boolean boolean1, 
                boolean flag)
        {
            if (boolean1.booleanValue())
            {
                boolean1 = ItemIncentiveType.REWARD;
            } else
            {
                boolean1 = ItemIncentiveType.COUPON;
            }
            this(ebaycartapi, s, s1, s2, s3, integer, new ItemIncentiveType[] {
                boolean1
            }, flag);
        }

        public GetItemIncentivesRequest(EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, Integer integer, ItemIncentiveType aitemincentivetype[], 
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
            types = aitemincentivetype;
            if (flag)
            {
                setTimeout(10000);
            }
        }
    }

    public static final class GetItemIncentivesResponse extends JsonResponse
    {

        protected final String currency;
        protected ItemIncentives incentives;

        public ItemIncentives getItemIncentives()
        {
            return incentives;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            super.parse(inputstream);
            try
            {
                inputstream = body.getJSONObject("getItemIncentivesResponse");
                super.processAck(inputstream);
                incentives = new ItemIncentives(inputstream, currency);
                super.exportErrorsToResponse(incentives);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        GetItemIncentivesResponse(String s)
        {
            incentives = null;
            currency = s;
        }
    }

    public static final class ItemIncentiveType extends Enum
    {

        private static final ItemIncentiveType $VALUES[];
        public static final ItemIncentiveType COUPON;
        public static final ItemIncentiveType REWARD;

        public static ItemIncentiveType valueOf(String s)
        {
            return (ItemIncentiveType)Enum.valueOf(com/ebay/common/net/api/cart/GetItemIncentives$ItemIncentiveType, s);
        }

        public static ItemIncentiveType[] values()
        {
            return (ItemIncentiveType[])$VALUES.clone();
        }

        static 
        {
            COUPON = new ItemIncentiveType("COUPON", 0);
            REWARD = new ItemIncentiveType("REWARD", 1);
            $VALUES = (new ItemIncentiveType[] {
                COUPON, REWARD
            });
        }

        private ItemIncentiveType(String s, int i)
        {
            super(s, i);
        }
    }


    public GetItemIncentives()
    {
    }
}
