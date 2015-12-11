// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushManager;
import com.urbanairship.util.UAStringUtil;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event, Analytics

public class CustomEvent extends Event
{

    public static final String CONVERSION_SEND_ID = "conversion_send_id";
    public static final String EVENT_NAME = "event_name";
    public static final String EVENT_VALUE = "event_value";
    public static final String INTERACTION_ID = "interaction_id";
    public static final String INTERACTION_TYPE = "interaction_type";
    public static final String LAST_RECEIVED_SEND_ID = "last_received_send_id";
    public static final int MAX_CHARACTER_LENGTH = 255;
    public static final int MAX_PROPERTIES = 20;
    public static final int MAX_PROPERTY_COLLECTION_SIZE = 20;
    private static final BigDecimal MAX_VALUE = new BigDecimal(0x7fffffff);
    public static final String MCRAP_TRANSACTION_TYPE = "ua_mcrap";
    private static final BigDecimal MIN_VALUE = new BigDecimal(0x80000000);
    public static final String PROPERTIES = "properties";
    public static final String TRANSACTION_ID = "transaction_id";
    private static final String TYPE = "custom_event";
    private final String eventName;
    private final BigDecimal eventValue;
    private final String interactionId;
    private final String interactionType;
    private final Map properties;
    private final String sendId;
    private final String transactionId;

    private CustomEvent(Builder builder)
    {
        Object obj = null;
        super();
        eventName = builder.eventName;
        eventValue = builder.value;
        String s;
        if (UAStringUtil.isEmpty(builder.transactionId))
        {
            s = null;
        } else
        {
            s = builder.transactionId;
        }
        transactionId = s;
        if (UAStringUtil.isEmpty(builder.interactionType))
        {
            s = null;
        } else
        {
            s = builder.interactionType;
        }
        interactionType = s;
        if (UAStringUtil.isEmpty(builder.interactionId))
        {
            s = obj;
        } else
        {
            s = builder.interactionId;
        }
        interactionId = s;
        sendId = builder.pushSendId;
        properties = new HashMap(builder.properties);
    }

    CustomEvent(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = new JSONObject();
        obj = UAirship.shared().getAnalytics().getConversionSendId();
        jsonobject.putOpt("event_name", eventName);
        jsonobject.putOpt("interaction_id", interactionId);
        jsonobject.putOpt("interaction_type", interactionType);
        jsonobject.putOpt("transaction_id", transactionId);
        if (eventValue != null)
        {
            jsonobject.putOpt("event_value", Long.valueOf(eventValue.movePointRight(6).longValue()));
        }
        if (UAStringUtil.isEmpty(sendId)) goto _L2; else goto _L1
_L1:
        jsonobject.putOpt("conversion_send_id", sendId);
_L8:
        Iterator iterator;
        obj = new JSONObject();
        iterator = properties.entrySet().iterator();
_L7:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (!(entry.getValue() instanceof Collection)) goto _L6; else goto _L5
_L5:
        ((JSONObject) (obj)).putOpt((String)entry.getKey(), new JSONArray((Collection)entry.getValue()));
          goto _L7
        obj;
        Logger.error("CustomEvent - Error constructing JSON data.", ((Throwable) (obj)));
_L10:
        return jsonobject;
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        jsonobject.putOpt("conversion_send_id", obj);
          goto _L8
        jsonobject.putOpt("last_received_send_id", UAirship.shared().getPushManager().getLastReceivedSendId());
          goto _L8
_L6:
        ((JSONObject) (obj)).putOpt((String)entry.getKey(), JsonValue.wrap(entry.getValue(), JsonValue.NULL).toString());
          goto _L7
_L4:
        if (((JSONObject) (obj)).length() <= 0) goto _L10; else goto _L9
_L9:
        jsonobject.putOpt("properties", obj);
        return jsonobject;
          goto _L7
    }

    public final String getType()
    {
        return "custom_event";
    }

    public boolean isValid()
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        if (UAStringUtil.isEmpty(eventName) || eventName.length() > 255)
        {
            Logger.error("Event name must not be null, empty, or larger than 255 characters.");
            flag1 = false;
        }
        flag = flag1;
        if (eventValue == null) goto _L2; else goto _L1
_L1:
        if (eventValue.compareTo(MAX_VALUE) <= 0) goto _L4; else goto _L3
_L3:
        Logger.error((new StringBuilder("Event value is bigger than ")).append(MAX_VALUE).toString());
        flag = false;
_L2:
        Iterator iterator;
        flag1 = flag;
        if (transactionId != null)
        {
            flag1 = flag;
            if (transactionId.length() > 255)
            {
                Logger.error("Transaction ID is larger than 255 characters.");
                flag1 = false;
            }
        }
        flag = flag1;
        if (interactionId != null)
        {
            flag = flag1;
            if (interactionId.length() > 255)
            {
                Logger.error("Interaction ID is larger than 255 characters.");
                flag = false;
            }
        }
        flag1 = flag;
        if (interactionType != null)
        {
            flag1 = flag;
            if (interactionType.length() > 255)
            {
                Logger.error("Interaction type is larger than 255 characters.");
                flag1 = false;
            }
        }
        if (properties.size() > 20)
        {
            Logger.error("Number of custom properties exceeds 20");
            flag1 = false;
        }
        iterator = properties.entrySet().iterator();
        flag = flag1;
_L6:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (((String)entry.getKey()).length() > 255)
        {
            Logger.error((new StringBuilder("The custom property ")).append((String)entry.getKey()).append(" is larger than 255").append(" characters.").toString());
            flag = false;
        }
        if (entry.getValue() instanceof Collection)
        {
            Object obj = (Collection)entry.getValue();
            if (((Collection) (obj)).size() > 20)
            {
                Logger.error((new StringBuilder("The custom property ")).append((String)entry.getKey()).append(" contains a Collection<String> that is larger than  20").toString());
                flag = false;
            }
            obj = ((Collection) (obj)).iterator();
            do
            {
                String s;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    s = String.valueOf(((Iterator) (obj)).next());
                } while (s == null || s.length() <= 255);
                Logger.error((new StringBuilder("The custom property ")).append((String)entry.getKey()).append(" contains a value that is larger than  255").append(" characters.").toString());
                flag = false;
            } while (true);
        }
        if ((entry.getValue() instanceof String) && ((String)entry.getValue()).length() > 255)
        {
            Logger.error((new StringBuilder("The custom property ")).append((String)entry.getKey()).append(" contains a value that is larger than  255").append(" characters.").toString());
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if (eventValue.compareTo(MIN_VALUE) < 0)
        {
            Logger.error((new StringBuilder("Event value is smaller than ")).append(MIN_VALUE).toString());
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        return flag;
        if (true) goto _L2; else goto _L7
_L7:
    }


    private class Builder
    {

        private String eventName;
        private String interactionId;
        private String interactionType;
        private Map properties;
        private String pushSendId;
        private String transactionId;
        private BigDecimal value;

        public CustomEvent addEvent()
        {
            CustomEvent customevent = create();
            UAirship.shared().getAnalytics().addEvent(customevent);
            return customevent;
        }

        public Builder addProperty(String s, double d)
        {
            if (Double.isNaN(d) || Double.isInfinite(d))
            {
                throw new NumberFormatException((new StringBuilder("Infinity or NaN: ")).append(d).toString());
            } else
            {
                properties.put(s, Double.valueOf(d));
                return this;
            }
        }

        public Builder addProperty(String s, int i)
        {
            properties.put(s, Integer.valueOf(i));
            return this;
        }

        public Builder addProperty(String s, long l)
        {
            properties.put(s, Long.valueOf(l));
            return this;
        }

        public Builder addProperty(String s, String s1)
        {
            properties.put(s, s1);
            return this;
        }

        public Builder addProperty(String s, Collection collection)
        {
            properties.put(s, new ArrayList(collection));
            return this;
        }

        public Builder addProperty(String s, boolean flag)
        {
            properties.put(s, Boolean.valueOf(flag));
            return this;
        }

        public CustomEvent create()
        {
            return new CustomEvent(this, null);
        }

        public Builder setAttribution(PushMessage pushmessage)
        {
            if (pushmessage != null)
            {
                pushSendId = pushmessage.getSendId();
            }
            return this;
        }

        public Builder setEventValue(double d)
        {
            return setEventValue(BigDecimal.valueOf(d));
        }

        public Builder setEventValue(int i)
        {
            return setEventValue(new BigDecimal(i));
        }

        public Builder setEventValue(String s)
        {
            if (UAStringUtil.isEmpty(s))
            {
                value = null;
                return this;
            } else
            {
                return setEventValue(new BigDecimal(s));
            }
        }

        public Builder setEventValue(BigDecimal bigdecimal)
        {
            if (bigdecimal == null)
            {
                value = null;
                return this;
            } else
            {
                value = bigdecimal;
                return this;
            }
        }

        public Builder setInteraction(RichPushMessage richpushmessage)
        {
            if (richpushmessage != null)
            {
                interactionType = "ua_mcrap";
                interactionId = richpushmessage.getMessageId();
            }
            return this;
        }

        public Builder setInteraction(String s, String s1)
        {
            interactionId = s1;
            interactionType = s;
            return this;
        }

        public Builder setTransactionId(String s)
        {
            transactionId = s;
            return this;
        }








        public Builder(String s)
        {
            properties = new HashMap();
            eventName = s;
        }
    }

}
