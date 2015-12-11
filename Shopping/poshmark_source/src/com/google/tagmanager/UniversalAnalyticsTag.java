// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.tracking.android.Tracker;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            TrackingTag, TrackerProvider, DataLayer, Log, 
//            Types

class UniversalAnalyticsTag extends TrackingTag
{

    private static final String ACCOUNT;
    private static final String ANALYTICS_FIELDS;
    private static final String ANALYTICS_PASS_THROUGH;
    private static final String DEFAULT_TRACKING_ID = "_GTM_DEFAULT_TRACKER_";
    private static final String ID;
    private static final String TRACK_TRANSACTION;
    private static final String TRANSACTION_DATALAYER_MAP;
    private static final String TRANSACTION_ITEM_DATALAYER_MAP;
    private static Map defaultItemMap;
    private static Map defaultTransactionMap;
    private final DataLayer mDataLayer;
    private final TrackerProvider mTrackerProvider;
    private final Set mTurnOffAnonymizeIpValues;

    public UniversalAnalyticsTag(Context context, DataLayer datalayer)
    {
        this(context, datalayer, new TrackerProvider(context));
    }

    UniversalAnalyticsTag(Context context, DataLayer datalayer, TrackerProvider trackerprovider)
    {
        super(ID, new String[0]);
        mDataLayer = datalayer;
        mTrackerProvider = trackerprovider;
        mTurnOffAnonymizeIpValues = new HashSet();
        mTurnOffAnonymizeIpValues.add("");
        mTurnOffAnonymizeIpValues.add("0");
        mTurnOffAnonymizeIpValues.add("false");
    }

    private void addParam(Map map, String s, String s1)
    {
        if (s1 != null)
        {
            map.put(s, s1);
        }
    }

    private boolean checkBooleanProperty(Map map, String s)
    {
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(s);
        if (map == null)
        {
            return false;
        } else
        {
            return map.getBoolean();
        }
    }

    private Map convertToGaFields(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        if (value == null || value.getType() != com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP)
        {
            value = new HashMap();
        } else
        {
            Map map = valueToMap(value);
            String s = (String)map.get("&aip");
            value = map;
            if (s != null)
            {
                value = map;
                if (mTurnOffAnonymizeIpValues.contains(s.toLowerCase()))
                {
                    map.remove("&aip");
                    return map;
                }
            }
        }
        return value;
    }

    private String getDataLayerString(String s)
    {
        s = ((String) (mDataLayer.get(s)));
        if (s == null)
        {
            return null;
        } else
        {
            return s.toString();
        }
    }

    public static String getFunctionId()
    {
        return ID;
    }

    private Map getTransactionFields(Map map)
    {
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(TRANSACTION_DATALAYER_MAP);
        if (map != null)
        {
            return valueToMap(map);
        }
        if (defaultTransactionMap == null)
        {
            map = new HashMap();
            map.put("transactionId", "&ti");
            map.put("transactionAffiliation", "&ta");
            map.put("transactionTax", "&tt");
            map.put("transactionShipping", "&ts");
            map.put("transactionTotal", "&tr");
            map.put("transactionCurrency", "&cu");
            defaultTransactionMap = map;
        }
        return defaultTransactionMap;
    }

    private Map getTransactionItemFields(Map map)
    {
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(TRANSACTION_ITEM_DATALAYER_MAP);
        if (map != null)
        {
            return valueToMap(map);
        }
        if (defaultItemMap == null)
        {
            map = new HashMap();
            map.put("name", "&in");
            map.put("sku", "&ic");
            map.put("category", "&iv");
            map.put("price", "&ip");
            map.put("quantity", "&iq");
            map.put("currency", "&cu");
            defaultItemMap = map;
        }
        return defaultItemMap;
    }

    private List getTransactionItems()
    {
        Object obj = mDataLayer.get("transactionProducts");
        if (obj == null)
        {
            return null;
        }
        if (!(obj instanceof List))
        {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Iterator iterator = ((List)obj).iterator(); iterator.hasNext();)
        {
            if (!(iterator.next() instanceof Map))
            {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }

        return (List)obj;
    }

    private void sendTransaction(Tracker tracker, Map map)
    {
        String s;
        ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ACCOUNT)).getString();
        s = getDataLayerString("transactionId");
        if (s != null) goto _L2; else goto _L1
_L1:
        Log.e("Cannot find transactionId in data layer.");
_L4:
        return;
_L2:
        LinkedList linkedlist;
        Object obj;
        linkedlist = new LinkedList();
        try
        {
            obj = convertToGaFields((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ANALYTICS_FIELDS));
            ((Map) (obj)).put("&t", "transaction");
            java.util.Map.Entry entry;
            for (Iterator iterator = getTransactionFields(map).entrySet().iterator(); iterator.hasNext(); addParam(((Map) (obj)), (String)entry.getValue(), getDataLayerString((String)entry.getKey())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Tracker tracker)
        {
            Log.e("Unable to send transaction", tracker);
            return;
        }
        linkedlist.add(obj);
        obj = getTransactionItems();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        obj = ((List) (obj)).iterator();
_L3:
        Map map1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_358;
        }
        map1 = (Map)((Iterator) (obj)).next();
        if (map1.get("name") == null)
        {
            Log.e("Unable to send transaction item hit due to missing 'name' field.");
            return;
        }
        Map map2;
        map2 = convertToGaFields((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ANALYTICS_FIELDS));
        map2.put("&t", "item");
        map2.put("&ti", s);
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = getTransactionItemFields(map).entrySet().iterator(); iterator1.hasNext(); addParam(map2, (String)entry1.getValue(), (String)map1.get(entry1.getKey())))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        linkedlist.add(map2);
          goto _L3
        map = linkedlist.iterator();
        while (map.hasNext()) 
        {
            tracker.send((Map)map.next());
        }
          goto _L4
    }

    private Map valueToMap(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        if (value.getType() == com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Map) (obj));
_L2:
        HashMap hashmap = new HashMap(value.getMapKeyCount());
        int i = 0;
        do
        {
            obj = hashmap;
            if (i >= value.getMapKeyCount())
            {
                continue;
            }
            hashmap.put(Types.valueToString(value.getMapKey(i)), Types.valueToString(value.getMapValue(i)));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void evaluateTrackingTag(Map map)
    {
        Tracker tracker = mTrackerProvider.getTracker("_GTM_DEFAULT_TRACKER_");
        if (checkBooleanProperty(map, ANALYTICS_PASS_THROUGH))
        {
            tracker.send(convertToGaFields((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ANALYTICS_FIELDS)));
        } else
        if (checkBooleanProperty(map, TRACK_TRANSACTION))
        {
            sendTransaction(tracker, map);
        } else
        {
            Log.w("Ignoring unknown tag.");
        }
        mTrackerProvider.close(tracker);
    }

    static 
    {
        ID = FunctionType.UNIVERSAL_ANALYTICS.toString();
        ACCOUNT = Key.ACCOUNT.toString();
        ANALYTICS_PASS_THROUGH = Key.ANALYTICS_PASS_THROUGH.toString();
        ANALYTICS_FIELDS = Key.ANALYTICS_FIELDS.toString();
        TRACK_TRANSACTION = Key.TRACK_TRANSACTION.toString();
        TRANSACTION_DATALAYER_MAP = Key.TRANSACTION_DATALAYER_MAP.toString();
        TRANSACTION_ITEM_DATALAYER_MAP = Key.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    }
}
