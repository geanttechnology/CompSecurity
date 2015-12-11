// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.api.addressbook.AddAddressResponse;
import com.ebay.nautilus.domain.net.api.addressbook.UpdateAddressResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.google.gson.Gson;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            ActionUrl

public abstract class JsonModel
{
    public static final class OperationError
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public final String category;
        public final String domain;
        public final String ebayItemId;
        public final String errorId;
        public final String exceptionId;
        public final String message;
        public final List parameters;
        public final String severity;
        public final String subdomain;

        public String get(String s)
        {
            Object obj1 = null;
            Iterator iterator = parameters.iterator();
            Object obj;
            do
            {
                obj = obj1;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (Cart.Property)iterator.next();
                if (((Cart.Property) (obj)).name == null || !((Cart.Property) (obj)).name.equalsIgnoreCase(s))
                {
                    continue;
                }
                obj = ((Cart.Property) (obj)).value;
                break;
            } while (true);
            return ((String) (obj));
        }

        public String getErrorCode()
        {
            return get("nativeErrorCode");
        }

        public String getMessage()
        {
            return get("nativeErrorMsg");
        }

        public boolean isError()
        {
            boolean flag = false;
            if (severity != null)
            {
                flag = severity.equalsIgnoreCase("error");
            }
            return flag;
        }

        public boolean isWarning()
        {
            boolean flag = false;
            if (severity != null)
            {
                flag = severity.equalsIgnoreCase("warning");
            }
            return flag;
        }

        public OperationError(EbayContext ebaycontext, com.ebay.nautilus.kernel.content.ResultStatus.Message message1)
        {
            errorId = Integer.toString(message1.getId());
            domain = message1.getDomain();
            subdomain = null;
            category = message1.getCategory();
            message = message1.getShortMessage(ebaycontext);
            severity = message1.getSeverity().name();
            exceptionId = null;
            parameters = null;
            ebayItemId = null;
        }

        public OperationError(JSONObject jsonobject)
            throws JSONException
        {
            errorId = JsonModel.getString(jsonobject, "errorId");
            domain = JsonModel.getString(jsonobject, "domain");
            subdomain = JsonModel.getString(jsonobject, "subdomain");
            severity = JsonModel.getString(jsonobject, "severity");
            category = JsonModel.getString(jsonobject, "category");
            message = JsonModel.getString(jsonobject, "message");
            exceptionId = JsonModel.getString(jsonobject, "exceptionId");
            Object obj = null;
            Object obj1 = null;
            parameters = new ArrayList();
            if (jsonobject.has("parameter"))
            {
                JSONArray jsonarray = jsonobject.getJSONArray("parameter");
                int i = 0;
                jsonobject = obj1;
                do
                {
                    obj = jsonobject;
                    if (i >= jsonarray.length())
                    {
                        break;
                    }
                    Cart.Property property = new Cart.Property(jsonarray.getJSONObject(i));
                    if ("baseIdentifier".equals(property.name))
                    {
                        obj = jsonobject;
                        if (!TextUtils.isEmpty(property.value))
                        {
                            obj = jsonobject;
                            if (property.value.startsWith("ItemId="))
                            {
                                obj = property.value.substring("ItemId=".length());
                            }
                        }
                    } else
                    {
                        parameters.add(property);
                        obj = jsonobject;
                    }
                    i++;
                    jsonobject = ((JSONObject) (obj));
                } while (true);
            }
            ebayItemId = ((String) (obj));
        }
    }


    private ArrayList actionUrls;
    public List errors;

    public JsonModel()
    {
        errors = null;
        actionUrls = null;
    }

    public JsonModel(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("operationErrors"))
        {
            jsonobject = jsonobject.getJSONObject("operationErrors");
            if (jsonobject.has("error"))
            {
                JSONArray jsonarray = jsonobject.getJSONArray("error");
                errors = new ArrayList();
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    errors.add(new OperationError(jsonarray.getJSONObject(i)));
                }

            }
            if (jsonobject.has("errorActionUrls"))
            {
                jsonobject = jsonobject.getJSONObject("errorActionUrls");
                if (jsonobject.has("url"))
                {
                    jsonobject = jsonobject.getJSONArray("url");
                    actionUrls = new ArrayList();
                    for (int j = 0; j < jsonobject.length(); j++)
                    {
                        Object obj = jsonobject.getJSONObject(j).toString();
                        obj = (ActionUrl)DataMapperFactory.getDefaultMapper().fromJson(((String) (obj)), com/ebay/common/model/cart/ActionUrl);
                        actionUrls.add(obj);
                    }

                }
            }
        } else
        {
            errors = null;
            actionUrls = null;
        }
    }

    public JsonModel(JSONObject jsonobject, Object obj)
        throws JSONException
    {
        if ((obj instanceof AddAddressResponse) || (obj instanceof UpdateAddressResponse))
        {
            if (jsonobject.has("errorMessage"))
            {
                errors = new ArrayList();
                jsonobject = jsonobject.getJSONObject("errorMessage").getJSONArray("error");
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    errors.add(new OperationError(jsonobject.getJSONObject(i)));
                }

            } else
            {
                errors = null;
                actionUrls = null;
            }
        } else
        if (obj instanceof com.ebay.common.net.api.cart.PayPalCheckout.PayPalCheckoutResponse)
        {
            if (jsonobject.has("operationErrors"))
            {
                errors = new ArrayList();
                jsonobject = jsonobject.getJSONArray("operationErrors");
                int j = 0;
                while (j < jsonobject.length()) 
                {
                    errors.add(new OperationError(jsonobject.getJSONObject(j)));
                    j++;
                }
            } else
            {
                errors = null;
                actionUrls = null;
                return;
            }
        } else
        {
            errors = null;
            actionUrls = null;
            return;
        }
    }

    static final transient JSONArray getArray(JSONObject jsonobject, String as[])
        throws JSONException
    {
        return getArray(jsonobject, as, 0);
    }

    static final JSONArray getArray(JSONObject jsonobject, String as[], int i)
        throws JSONException
    {
        String s;
label0:
        {
            Object obj = null;
            JSONArray jsonarray = obj;
            if (jsonobject != null)
            {
                s = as[i];
                i++;
                jsonarray = obj;
                if (jsonobject.has(s))
                {
                    if (i >= as.length)
                    {
                        break label0;
                    }
                    jsonarray = getArray(jsonobject.optJSONObject(s), as, i);
                }
            }
            return jsonarray;
        }
        return jsonobject.getJSONArray(s);
    }

    static final Boolean getBoolean(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Boolean boolean1 = obj;
        if (jsonobject != null)
        {
            boolean1 = obj;
            if (jsonobject.has(s))
            {
                boolean1 = Boolean.valueOf(jsonobject.getBoolean(s));
            }
        }
        return boolean1;
    }

    static final CurrencyAmount getCurrencyAmount(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        CurrencyAmount currencyamount = obj;
        if (jsonobject != null)
        {
            currencyamount = obj;
            if (jsonobject.has(s))
            {
                currencyamount = toCurrencyAmount(jsonobject.getJSONObject(s));
            }
        }
        return currencyamount;
    }

    static final Date getDate(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Date date = obj;
        if (jsonobject != null)
        {
            date = obj;
            if (jsonobject.has(s))
            {
                try
                {
                    date = EbayDateFormat.parse(jsonobject.getString(s));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new JSONException("Error parsing date time");
                }
            }
        }
        return date;
    }

    static final Date getDateAndZone(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Date date = obj;
        if (jsonobject != null)
        {
            date = obj;
            if (jsonobject.has(s))
            {
                try
                {
                    date = EbayDateUtils.parseDateOnly(jsonobject.getString(s));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new JSONException("Error parsing date");
                }
            }
        }
        return date;
    }

    static final Date getDateTimeAndZone(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Date date = obj;
        if (jsonobject != null)
        {
            date = obj;
            if (jsonobject.has(s))
            {
                try
                {
                    date = EbayDateUtils.parseIso8601DateTime(jsonobject.getString(s));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new JSONException("Error parsing date");
                }
            }
        }
        return date;
    }

    static final Double getDouble(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Double double1 = obj;
        if (jsonobject != null)
        {
            double1 = obj;
            if (jsonobject.has(s))
            {
                double1 = Double.valueOf(jsonobject.getDouble(s));
            }
        }
        return double1;
    }

    static final Integer getInteger(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Integer integer = obj;
        if (jsonobject != null)
        {
            integer = obj;
            if (jsonobject.has(s))
            {
                integer = Integer.valueOf(jsonobject.getInt(s));
            }
        }
        return integer;
    }

    static final Long getLong(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Long long1 = obj;
        if (jsonobject != null)
        {
            long1 = obj;
            if (jsonobject.has(s))
            {
                long1 = Long.valueOf(jsonobject.getLong(s));
            }
        }
        return long1;
    }

    static final transient JSONObject getObject(JSONObject jsonobject, int i, String as[])
        throws JSONException
    {
        String s;
label0:
        {
            Object obj = null;
            JSONObject jsonobject1 = obj;
            if (jsonobject != null)
            {
                s = as[i];
                i++;
                jsonobject1 = obj;
                if (jsonobject.has(s))
                {
                    if (i >= as.length)
                    {
                        break label0;
                    }
                    jsonobject1 = getObject(jsonobject.getJSONObject(s), i, as);
                }
            }
            return jsonobject1;
        }
        return jsonobject.getJSONObject(s);
    }

    static final transient JSONObject getObject(JSONObject jsonobject, String as[])
        throws JSONException
    {
        return getObject(jsonobject, 0, as);
    }

    static final String getString(JSONObject jsonobject, String s)
        throws JSONException
    {
        return getString(jsonobject, s, true);
    }

    static final String getString(JSONObject jsonobject, String s, boolean flag)
        throws JSONException
    {
        JSONObject jsonobject1;
label0:
        {
            Object obj = null;
            jsonobject1 = obj;
            if (jsonobject == null)
            {
                break label0;
            }
            jsonobject1 = obj;
            if (!jsonobject.has(s))
            {
                break label0;
            }
            jsonobject = jsonobject.getString(s);
            jsonobject1 = obj;
            if (TextUtils.equals(jsonobject, "_UAES_NULL_"))
            {
                break label0;
            }
            if (flag)
            {
                jsonobject1 = obj;
                if (TextUtils.isEmpty(jsonobject))
                {
                    break label0;
                }
            }
            jsonobject1 = jsonobject;
        }
        return jsonobject1;
    }

    static final Uri getUri(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = null;
        Uri uri = obj;
        if (jsonobject != null)
        {
            uri = obj;
            if (jsonobject.has(s))
            {
                uri = Uri.parse(jsonobject.getString(s));
            }
        }
        return uri;
    }

    static final CurrencyAmount toCurrencyAmount(JSONObject jsonobject)
        throws JSONException
    {
        CurrencyAmount currencyamount = null;
        if (jsonobject != null)
        {
            currencyamount = new CurrencyAmount(jsonobject.getString("__value__"), jsonobject.getString("@currencyId"));
        }
        return currencyamount;
    }

    public String getActionUrlForErrorAction(String s)
    {
label0:
        {
            if (actionUrls == null)
            {
                break label0;
            }
            Iterator iterator = actionUrls.iterator();
            ActionUrl actionurl;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                actionurl = (ActionUrl)iterator.next();
            } while (!actionurl.action.equals(s));
            return CartPaymentMethods.PaymentMethod.substitutePlaceHolders(actionurl);
        }
        return null;
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
            Object obj1 = (OperationError)iterator.next();
            obj = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails();
            obj.category = 1;
            obj.code = (new StringBuilder()).append(((OperationError) (obj1)).errorId).append(" : ").append(((OperationError) (obj1)).getErrorCode()).toString();
            int i;
            if (((OperationError) (obj1)).isError())
            {
                i = 1;
            } else
            {
                i = 2;
            }
            obj.severity = i;
            obj.userDisplay = false;
            obj.longMessage = ((OperationError) (obj1)).message;
            obj.shortMessage = ((OperationError) (obj1)).getMessage();
            obj.domain = ((OperationError) (obj1)).domain;
            obj.subdomain = ((OperationError) (obj1)).subdomain;
            obj.userDisplay = false;
            obj.parameters = null;
            if (((OperationError) (obj1)).parameters != null)
            {
                obj.parameters = new ArrayList(((OperationError) (obj1)).parameters.size());
                com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;
                for (obj1 = ((OperationError) (obj1)).parameters.iterator(); ((Iterator) (obj1)).hasNext(); ((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails) (obj)).parameters.add(parameter))
                {
                    Cart.Property property = (Cart.Property)((Iterator) (obj1)).next();
                    parameter = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter();
                    parameter.name = property.name;
                    parameter.value = property.value;
                }

            }
            arraylist.add(obj);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String getErrorId()
    {
label0:
        {
            if (errors == null || errors.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = errors.iterator();
            OperationError operationerror;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                operationerror = (OperationError)iterator.next();
            } while (TextUtils.isEmpty(operationerror.errorId));
            return operationerror.errorId;
        }
        return null;
    }

    public final String getErrorMessage()
    {
label0:
        {
            if (errors == null || errors.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = errors.iterator();
            OperationError operationerror;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                operationerror = (OperationError)iterator.next();
            } while (TextUtils.isEmpty(operationerror.message));
            return operationerror.message;
        }
        return null;
    }

    public final String getValueForErrorParamater(String s)
    {
label0:
        {
            if (errors == null || errors.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = errors.iterator();
            Cart.Property property;
label1:
            do
            {
                if (iterator.hasNext())
                {
                    Object obj = (OperationError)iterator.next();
                    if (TextUtils.equals("201", ((OperationError) (obj)).getErrorCode()))
                    {
                        continue;
                    }
                    obj = ((OperationError) (obj)).parameters.iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            continue label1;
                        }
                        property = (Cart.Property)((Iterator) (obj)).next();
                    } while (!property.name.equals(s) || "buyingErrorCode".equals(s) && "2028".equals(property.value));
                    break;
                }
                break label0;
            } while (true);
            return property.value;
        }
        return null;
    }

    public final String getValueForErrorParamaterOfItemId(String s, String s1)
    {
_L2:
        return null;
        if (TextUtils.isEmpty(s1) || errors == null || errors.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = errors.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        Cart.Property property;
        Object obj = (OperationError)iterator.next();
        if (!s1.equals(((OperationError) (obj)).ebayItemId) || TextUtils.equals("201", ((OperationError) (obj)).getErrorCode()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((OperationError) (obj)).parameters.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            property = (Cart.Property)((Iterator) (obj)).next();
        } while (!property.name.equals(s) || "buyingErrorCode".equals(s) && "2028".equals(property.value));
        break; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        return property.value;
    }
}
