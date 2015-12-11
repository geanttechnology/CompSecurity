// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel, PaymentSession

public final class PayPalCheckoutDetails extends JsonModel
    implements Serializable
{
    public static final class Account
        implements Serializable
    {

        public final String authToken;
        public final String userId;

        Account(JSONObject jsonobject)
            throws JSONException
        {
            userId = JsonModel.getString(jsonobject, "userIdentifier");
            authToken = JsonModel.getString(jsonobject, "authToken");
        }
    }

    public static final class CurrencyConversion
        implements Serializable
    {

        public final String currencyCodeFrom;
        public final String currencyCodeTo;
        public final Double exchangeRate;

        public String toString()
        {
            Object obj;
            try
            {
                obj = Currency.getInstance(currencyCodeFrom);
                Currency currency = Currency.getInstance(currencyCodeTo);
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append('(');
                stringbuilder.append(((Currency) (obj)).getSymbol());
                stringbuilder.append("1.00");
                stringbuilder.append(" = ");
                stringbuilder.append(currency.getSymbol());
                stringbuilder.append(exchangeRate);
                stringbuilder.append(')');
                obj = stringbuilder.toString();
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                return null;
            }
            return ((String) (obj));
        }

        CurrencyConversion(JSONObject jsonobject)
            throws JSONException
        {
            currencyCodeFrom = JsonModel.getString(jsonobject, "currencyFrom");
            currencyCodeTo = JsonModel.getString(jsonobject, "currencyTo");
            exchangeRate = JsonModel.getDouble(jsonobject, "exchangeRate");
        }
    }

    public static final class FundingSource
        implements Serializable
    {

        public final CurrencyAmount balance;
        public final String id;
        public final String name;

        FundingSource(JSONObject jsonobject)
            throws JSONException
        {
            name = JsonModel.getString(jsonobject, "name");
            id = JsonModel.getString(jsonobject, "id");
            balance = JsonModel.getCurrencyAmount(jsonobject, "balance");
        }
    }

    public static final class Incentive
        implements Serializable
    {

        public final CurrencyAmount balance;
        public final String code;
        public final String status;
        public final String type;

        public boolean isGiftCard()
        {
            return type.equalsIgnoreCase("GiftCard");
        }

        public boolean isGiftCertificate()
        {
            return type.equalsIgnoreCase("GiftCertificate");
        }

        Incentive(JSONObject jsonobject)
            throws JSONException
        {
            code = JsonModel.getString(jsonobject, "redemptionCode");
            type = JsonModel.getString(jsonobject, "incentiveType");
            status = JsonModel.getString(jsonobject, "status");
            balance = JsonModel.getCurrencyAmount(jsonobject, "balance");
        }
    }

    public static final class PayPalUrl
        implements Serializable
    {

        public final String name;
        public final String uri;

        PayPalUrl(JSONObject jsonobject)
            throws JSONException
        {
            String s1 = JsonModel.getString(jsonobject, "name");
            String s = s1;
            if (s1.equals("CFS"))
            {
                s = "Change Funding Source";
            }
            name = s;
            uri = JsonModel.getString(jsonobject, "url");
        }
    }


    public static final String TAG = "PayPalCheckoutDetails";
    public final String ECToken;
    public final Account account;
    public final String calLogInfo;
    public final CurrencyConversion currencyConversion;
    public final FundingSource fundingSources[];
    public Incentive incentives[];
    public final String sessionId;
    public final PayPalUrl urls[];
    public final String visitorId;

    public PayPalCheckoutDetails(JSONObject jsonobject, Object obj)
        throws JSONException
    {
        super(jsonobject, obj);
        ECToken = getString(jsonobject, "EC-Token");
        sessionId = getString(jsonobject, "sessionId");
        visitorId = getString(jsonobject, "visitorId");
        calLogInfo = getString(jsonobject, "calLogInfo");
        obj = jsonobject.optJSONObject("account");
        if (obj != null)
        {
            obj = new Account(((JSONObject) (obj)));
        } else
        {
            obj = null;
        }
        account = ((Account) (obj));
        obj = jsonobject.optJSONObject("currencyConversionDetails");
        if (obj != null)
        {
            obj = new CurrencyConversion(((JSONObject) (obj)));
        } else
        {
            obj = null;
        }
        currencyConversion = ((CurrencyConversion) (obj));
        obj = jsonobject.optJSONArray("fundingSources");
        if (obj != null)
        {
            fundingSources = new FundingSource[((JSONArray) (obj)).length()];
            for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                fundingSources[i] = new FundingSource(((JSONArray) (obj)).getJSONObject(i));
            }

        } else
        {
            fundingSources = null;
        }
        obj = jsonobject.optJSONArray("payPalUrls");
        if (obj != null)
        {
            urls = new PayPalUrl[((JSONArray) (obj)).length()];
            for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
            {
                urls[j] = new PayPalUrl(((JSONArray) (obj)).getJSONObject(j));
            }

        } else
        {
            urls = null;
        }
        jsonobject = jsonobject.optJSONArray("payPalIncentives");
        if (jsonobject != null)
        {
            incentives = new Incentive[jsonobject.length()];
            for (int k = 0; k < jsonobject.length(); k++)
            {
                incentives[k] = new Incentive(jsonobject.getJSONObject(k));
            }

        } else
        {
            incentives = null;
        }
    }

    private String findUrl(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (urls == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (urls.length <= 0) goto _L2; else goto _L3
_L3:
        PayPalUrl apaypalurl[];
        int i;
        int j;
        apaypalurl = urls;
        j = apaypalurl.length;
        i = 0;
_L8:
        obj = obj1;
        if (i >= j) goto _L2; else goto _L4
_L4:
        obj = apaypalurl[i];
        if (!TextUtils.equals(s, ((PayPalUrl) (obj)).name)) goto _L6; else goto _L5
_L5:
        obj = PaymentSession.shortCircuitRedirect(((PayPalUrl) (obj)).uri);
_L2:
        return ((String) (obj));
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String getChangeFundingSourceUrl()
    {
        return findUrl("Change Funding Source");
    }

    public String getCurrencyConversionString()
    {
        if (currencyConversion != null)
        {
            return currencyConversion.toString();
        } else
        {
            return null;
        }
    }

    public ArrayList getEbayResponseErrors()
    {
        if (errors != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ArrayList) (obj));
_L2:
        ArrayList arraylist = new ArrayList(errors.size());
        Iterator iterator = errors.iterator();
        do
        {
            obj = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (JsonModel.OperationError)iterator.next();
            com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails();
            longdetails.category = 1;
            longdetails.code = ((JsonModel.OperationError) (obj)).get("errorCode");
            int i;
            if (((JsonModel.OperationError) (obj)).isError())
            {
                i = 1;
            } else
            {
                i = 2;
            }
            longdetails.severity = i;
            longdetails.userDisplay = false;
            longdetails.domain = ((JsonModel.OperationError) (obj)).domain;
            longdetails.subdomain = ((JsonModel.OperationError) (obj)).subdomain;
            longdetails.userDisplay = false;
            longdetails.parameters = null;
            if (((JsonModel.OperationError) (obj)).parameters != null)
            {
                longdetails.parameters = new ArrayList(((JsonModel.OperationError) (obj)).parameters.size());
                com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;
                for (Iterator iterator1 = ((JsonModel.OperationError) (obj)).parameters.iterator(); iterator1.hasNext(); longdetails.parameters.add(parameter))
                {
                    Cart.Property property = (Cart.Property)iterator1.next();
                    parameter = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter();
                    parameter.name = property.name;
                    parameter.value = property.value;
                }

            }
            longdetails.longMessage = ((JsonModel.OperationError) (obj)).get("errorMsg");
            longdetails.shortMessage = ((JsonModel.OperationError) (obj)).message;
            arraylist.add(longdetails);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getRecoveryUrlString()
    {
        if (urls != null && urls.length > 0)
        {
            return PaymentSession.shortCircuitRedirect(urls[0].uri);
        } else
        {
            return null;
        }
    }

    public boolean isRecoverableError()
    {
        int i;
        try
        {
            i = Integer.parseInt(getErrorId());
        }
        catch (NumberFormatException numberformatexception)
        {
            return false;
        }
        while (i >= 500 && i <= 599 || i >= 100 && i <= 124) 
        {
            return true;
        }
        return false;
    }

    public boolean isSignedIn()
    {
        return account != null && !TextUtils.isEmpty(account.authToken);
    }
}
