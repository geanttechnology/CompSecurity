// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.error;

import android.app.Application;
import com.groupon.util.ObjectMapperWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.type.TypeReference;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.error:
//            GrouponException, ShippingException, TravelInventoryNotFoundException, OrderException, 
//            BreakdownException, GoogleAuthenticationException

public class ErrorConverter
{

    private static final String INVENTORY_UNAVAILABLE = "inventoryUnavailable";
    private static final String JSON_AMOUNT = "amount";
    private static final String JSON_BILLING_RECORD = "billingRecord";
    private static final String JSON_BREAKDOWN = "breakdown";
    private static final String JSON_BREAKDOWNS = "breakdowns";
    private static final String JSON_CODE = "code";
    private static final String JSON_DATA = "data";
    private static final String JSON_EMAIL = "email";
    private static final String JSON_ERROR = "error";
    private static final String JSON_ERRORS = "errors";
    private static final String JSON_ERROR_CODE = "errorCode";
    private static final String JSON_FAILED_BILLING_RECORD_REVALIDATION = "FAILED_BILLING_RECORD_REVALIDATION";
    private static final String JSON_HTTP_CODE_1 = "httpCode";
    private static final String JSON_HTTP_CODE_2 = "http_code";
    private static final String JSON_INVALID_ADDRESS = "INVALID_ADDRESS";
    private static final String JSON_INVALID_INVALID_POSTAL_CODE = "INVALID_POSTAL_CODE";
    private static final String JSON_INVALID_MAX_ITEM_QUANTITY = "INVALID_MAX_ITEM_QUANTITY";
    private static final String JSON_MESSAGE = "message";
    private static final String JSON_ORDER = "order";
    private static final String JSON_RAW_DATA = "rawData";
    private static final String JSON_REQUIRED_BILLING_RECORD_REVALIDATION = "REQUIRED_BILLING_RECORD_REVALIDATION";
    private static final String JSON_SCOPES = "scopes";
    private static final String JSON_SHIPPING_ADDRESS = "shippingAddress";
    private static final String JSON_SHIPPING_RUT = "shipping_rut";
    private static final String JSON_TAX_AMOUNT_CHANGED = "taxAmountChanged";
    private static final String JSON_TRAVEL_INVENTORY_NOT_FOUND = "travelInventoryNotFound";
    private static final String JSON_TRAVEL_SEGMENT_ID_EXPIRED = "travelSegmentIdExpired";
    private static final String JSON_ZIP = "zip";
    private Application application;
    private ObjectMapperWrapper om;

    public ErrorConverter()
    {
    }

    private GrouponException createBlankGrouponException(int i, String s, Map map)
    {
        Map map2 = createMapErrorFieldToErrorList(getAnonymousErrors(map));
        if (map.containsKey("rawData"))
        {
            s = (String)map.get("rawData");
            try
            {
                s = fromJson((Map)om.readValue(s, new TypeReference() {

                    final ErrorConverter this$0;

            
            {
                this$0 = ErrorConverter.this;
                super();
            }
                }));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = new GrouponException(400, "Unable to parse network errors.");
                s.mapErrorFieldToErrorList = map2;
                return s;
            }
            return s;
        }
        if (map.containsKey("order"))
        {
            Map map3 = (Map)map.get("order");
            Object obj = null;
            Object obj2 = map3.get("errors");
            if (obj2 instanceof Map)
            {
                map = (Map)obj2;
            } else
            {
                map = obj;
                if (obj2 instanceof List)
                {
                    obj2 = (List)obj2;
                    map = obj;
                    if (!((List) (obj2)).isEmpty())
                    {
                        map = (Map)((List) (obj2)).get(0);
                    }
                }
            }
            if (map != null)
            {
                if (map.containsKey("zip") || map.containsKey("shipping_rut"))
                {
                    s = new ShippingException(i, s);
                    s.mapErrorFieldToErrorList = map2;
                    return s;
                }
                if (Strings.notEmpty(map.get("travelInventoryNotFound")))
                {
                    s = new TravelInventoryNotFoundException(i, s);
                    s.mapErrorFieldToErrorList = map2;
                    return s;
                }
                if (!Strings.notEmpty(s))
                {
                    s = (String)map3.get("message");
                }
                s = new OrderException(i, s);
                s.mapErrorFieldToErrorList = map2;
                s.taxAmountChanged = (String)map.get("taxAmountChanged");
                s.travelSegmentIdExpired = (String)map.get("travelSegmentIdExpired");
                s.inventoryUnavailable = (String)map.get("inventoryUnavailable");
                s.requiredBillingRecordRevalidation = Strings.equals(map.get("code"), "REQUIRED_BILLING_RECORD_REVALIDATION");
                s.failedBillingRecordRevalidation = Strings.equals(map.get("code"), "FAILED_BILLING_RECORD_REVALIDATION");
                s.amount = (String)map.get("amount");
                s.invalidMaxItemQuantity = Strings.equals(map.get("code"), "INVALID_MAX_ITEM_QUANTITY");
                return s;
            } else
            {
                map = (Map)((Map)map3.get("billingRecord")).get("errors");
                if (!Strings.notEmpty(s))
                {
                    s = (String)map3.get("message");
                }
                s = new OrderException(i, s);
                s.mapErrorFieldToErrorList = map2;
                s.taxAmountChanged = (String)map.get("taxAmountChanged");
                s.travelSegmentIdExpired = (String)map.get("travelSegmentIdExpired");
                s.inventoryUnavailable = (String)map.get("inventoryUnavailable");
                s.requiredBillingRecordRevalidation = Strings.equals(map.get("code"), "REQUIRED_BILLING_RECORD_REVALIDATION");
                s.failedBillingRecordRevalidation = Strings.equals(map.get("code"), "FAILED_BILLING_RECORD_REVALIDATION");
                s.amount = (String)map.get("amount");
                s.invalidMaxItemQuantity = Strings.equals(map.get("code"), "INVALID_MAX_ITEM_QUANTITY");
                return s;
            }
        }
        if (map.containsKey("breakdown"))
        {
            Object obj1 = ((Map)map.get("breakdown")).get("errors");
            if (obj1 instanceof Map)
            {
                if (((Map)obj1).get("shippingAddress") != null)
                {
                    s = new ShippingException(i, s);
                } else
                {
                    s = new BreakdownException(i, s);
                }
                s.mapErrorFieldToErrorList = map2;
                return s;
            }
            if (obj1 instanceof List)
            {
                List list = (List)obj1;
                Map map4 = createMapErrorFieldToErrorList(list);
                map = s;
                if (Strings.isEmpty(s))
                {
                    map = (String)((Collection)map4.get("message")).iterator().next();
                }
                for (s = list.iterator(); s.hasNext();)
                {
                    if (Strings.equals(((Map)s.next()).get("code"), "INVALID_ADDRESS"))
                    {
                        s = new ShippingException(i, map);
                        s.mapErrorFieldToErrorList = map2;
                        return s;
                    }
                }

                s = (List)obj1;
                if (!s.isEmpty())
                {
                    s = (Map)s.get(0);
                    String s1 = (String)s.get("code");
                    if (Strings.equals(s1, "INVALID_ADDRESS") || Strings.equals(s1, "INVALID_POSTAL_CODE"))
                    {
                        s = new ShippingException(i, map);
                        s.mapErrorFieldToErrorList = map2;
                        return s;
                    }
                    if (Strings.equals(s1, "travelInventoryNotFound"))
                    {
                        s = new TravelInventoryNotFoundException(i, map);
                        s.mapErrorFieldToErrorList = map2;
                        return s;
                    } else
                    {
                        s = new BreakdownException(i, (String)s.get("message"));
                        s.mapErrorFieldToErrorList = map2;
                        return s;
                    }
                } else
                {
                    return new GrouponException(i, map);
                }
            } else
            {
                return new GrouponException(i, s);
            }
        } else
        {
            if (map.containsKey("breakdowns"))
            {
                Map map1 = (Map)((Map)map.get("breakdowns")).get("errors");
                if (map1 != null && !map1.isEmpty())
                {
                    if (map1.get("shippingAddress") != null)
                    {
                        s = new ShippingException(i, s);
                    } else
                    {
                        s = new BreakdownException(i, s);
                    }
                    s.mapErrorFieldToErrorList = map2;
                    return s;
                }
            }
            if (map.containsKey("shippingAddress"))
            {
                s = new ShippingException(i, s);
                s.mapErrorFieldToErrorList = map2;
                return s;
            }
            if (map.containsKey("errorCode") && map.containsKey("data"))
            {
                s = new GoogleAuthenticationException(i, s);
                s.mapErrorFieldToErrorList = map2;
                map = (Map)map.get("data");
                if (map.containsKey("scopes"))
                {
                    s.requiredScopes = (List)map.get("scopes");
                }
                if (map.containsKey("email"))
                {
                    s.email = (String)map.get("email");
                }
                return s;
            }
            s = new GrouponException(i, s);
            if (getAnonymousErrors(map) != null)
            {
                s.mapErrorFieldToErrorList = map2;
            }
            return s;
        }
    }

    private Map createMapErrorFieldToErrorList(List list)
    {
        HashMap hashmap = new HashMap();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((Map)iterator.next()).entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                String s = (String)entry.getKey();
                Collection collection = (Collection)hashmap.get(s);
                list = collection;
                if (collection == null)
                {
                    list = new ArrayList();
                    hashmap.put(s, list);
                }
                list.add(String.valueOf(entry.getValue()));
            }
        }

        return hashmap;
    }

    private Map createMapErrorFieldToErrorList(Map map)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put((String)entry.getKey(), Arrays.asList(new String[] {
    (String)entry.getValue()
})))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return hashmap;
    }

    private Map getAnonymousErrors(Map map)
    {
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = map.entrySet().iterator();
_L2:
        Iterator iterator1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_366;
            }
            map = (java.util.Map.Entry)iterator.next();
        } while (!(map.getValue() instanceof Map));
        iterator1 = ((Map)map.getValue()).entrySet().iterator();
_L4:
        while (iterator1.hasNext()) 
        {
            map = (java.util.Map.Entry)iterator1.next();
            if (!((String)map.getKey()).equals("errors"))
            {
                continue; /* Loop/switch isn't completed */
            }
            map = ((Map) (map.getValue()));
            if (map instanceof Map)
            {
                map = (Map)map;
            } else
            {
                map = (List)map;
                if (map.isEmpty())
                {
                    map = null;
                } else
                {
                    map = (Map)map.get(0);
                }
            }
            if (map != null)
            {
                map = map.entrySet().iterator();
                while (map.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                    hashmap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (!(map.getValue() instanceof Map)) goto _L4; else goto _L3
_L3:
        map = ((Map)map.getValue()).entrySet().iterator();
        while (map.hasNext()) 
        {
            Object obj = (java.util.Map.Entry)map.next();
            if (((String)((java.util.Map.Entry) (obj)).getKey()).equals("errors"))
            {
                obj = ((Map)((java.util.Map.Entry) (obj)).getValue()).entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                    hashmap.put(entry1.getKey(), String.valueOf(entry1.getValue()));
                }
            }
        }
          goto _L4
        return hashmap;
    }

    public GrouponException fromJson(Map map)
    {
        int j = 0;
        String s = "";
        if (map.containsKey("rawData"))
        {
            try
            {
                map = (String)map.get("rawData");
                map = fromJson((Map)om.readValue(map, new TypeReference() {

                    final ErrorConverter this$0;

            
            {
                this$0 = ErrorConverter.this;
                super();
            }
                }));
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                return new GrouponException(400, application.getString(0x7f0801a6));
            }
            return map;
        }
        Object obj = s;
        if (map.containsKey("error"))
        {
            obj = (Map)map.get("error");
            String s1;
            int i;
            if (((Map) (obj)).containsKey("httpCode"))
            {
                i = ((Integer)((Map) (obj)).get("httpCode")).intValue();
            } else
            {
                i = ((Integer)((Map) (obj)).get("http_code")).intValue();
            }
            s1 = (String)((Map) (obj)).get("message");
            obj = s;
            j = i;
            if (Strings.notEmpty(s1))
            {
                obj = s1;
                j = i;
            }
        }
        return createBlankGrouponException(j, ((String) (obj)), map);
    }
}
