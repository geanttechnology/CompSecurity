// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.UserIncentives;
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

public class GetUserIncentives
{
    public static final class GetUserIncentivesRequest extends EbaySoaRequest
    {

        private final UserIncentiveType incentiveType;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            try
            {
                JSONObject jsonobject1 = new JSONObject();
                JSONObject jsonobject;
                JSONArray jsonarray;
                if (incentiveType == null)
                {
                    jsonobject1.put("incentiveType", UserIncentiveType.VOUCHER.name());
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
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
        }

        public URL getRequestUrl()
        {
            return EbayCartApi.getIncentiveServiceUrl();
        }

        public GetUserIncentivesResponse getResponse()
        {
            return new GetUserIncentivesResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public GetUserIncentivesRequest(EbayCartApi ebaycartapi, UserIncentiveType userincentivetype)
        {
            super("CommonMobileAppService", false, "getUserIncentives");
            super.iafToken = ebaycartapi.iafToken;
            super.dataFormat = "JSON";
            super.soaContentType = "application/json";
            super.soaGlobalId = ebaycartapi.site.idString;
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.bUseSoaServiceVersion = false;
            super.useSoaLocaleList = true;
            incentiveType = userincentivetype;
        }
    }

    public static final class GetUserIncentivesResponse extends JsonResponse
    {

        private UserIncentives incentives;

        public UserIncentives getUserIncentives()
        {
            return incentives;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            super.parse(inputstream);
            try
            {
                inputstream = body.optJSONObject("getUserIncentivesResponse");
                super.processAck(inputstream);
                incentives = new UserIncentives(inputstream);
                super.exportErrorsToResponse(incentives);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        public GetUserIncentivesResponse()
        {
            incentives = null;
        }
    }

    public static final class UserIncentiveType extends Enum
    {

        private static final UserIncentiveType $VALUES[];
        public static final UserIncentiveType COUPON;
        public static final UserIncentiveType GIFTCARD;
        public static final UserIncentiveType GIFTCERTIFICATE;
        public static final UserIncentiveType REWARD;
        public static final UserIncentiveType VOUCHER;

        public static UserIncentiveType valueOf(String s)
        {
            return (UserIncentiveType)Enum.valueOf(com/ebay/common/net/api/cart/GetUserIncentives$UserIncentiveType, s);
        }

        public static UserIncentiveType[] values()
        {
            return (UserIncentiveType[])$VALUES.clone();
        }

        static 
        {
            GIFTCERTIFICATE = new UserIncentiveType("GIFTCERTIFICATE", 0);
            VOUCHER = new UserIncentiveType("VOUCHER", 1);
            GIFTCARD = new UserIncentiveType("GIFTCARD", 2);
            COUPON = new UserIncentiveType("COUPON", 3);
            REWARD = new UserIncentiveType("REWARD", 4);
            $VALUES = (new UserIncentiveType[] {
                GIFTCERTIFICATE, VOUCHER, GIFTCARD, COUPON, REWARD
            });
        }

        private UserIncentiveType(String s, int i)
        {
            super(s, i);
        }
    }


    public GetUserIncentives()
    {
    }
}
