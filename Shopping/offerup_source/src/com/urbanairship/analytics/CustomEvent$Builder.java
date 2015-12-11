// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.RichPushMessage;
import com.urbanairship.util.UAStringUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.urbanairship.analytics:
//            Analytics, CustomEvent

public class eventName
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

    public create addProperty(String s, double d)
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

    public properties addProperty(String s, int i)
    {
        properties.put(s, Integer.valueOf(i));
        return this;
    }

    public properties addProperty(String s, long l)
    {
        properties.put(s, Long.valueOf(l));
        return this;
    }

    public properties addProperty(String s, String s1)
    {
        properties.put(s, s1);
        return this;
    }

    public properties addProperty(String s, Collection collection)
    {
        properties.put(s, new ArrayList(collection));
        return this;
    }

    public properties addProperty(String s, boolean flag)
    {
        properties.put(s, Boolean.valueOf(flag));
        return this;
    }

    public CustomEvent create()
    {
        return new CustomEvent(this, null);
    }

    public properties setAttribution(PushMessage pushmessage)
    {
        if (pushmessage != null)
        {
            pushSendId = pushmessage.getSendId();
        }
        return this;
    }

    public pushSendId setEventValue(double d)
    {
        return setEventValue(BigDecimal.valueOf(d));
    }

    public setEventValue setEventValue(int i)
    {
        return setEventValue(new BigDecimal(i));
    }

    public setEventValue setEventValue(String s)
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

    public setEventValue setEventValue(BigDecimal bigdecimal)
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

    public value setInteraction(RichPushMessage richpushmessage)
    {
        if (richpushmessage != null)
        {
            interactionType = "ua_mcrap";
            interactionId = richpushmessage.getMessageId();
        }
        return this;
    }

    public ssageId setInteraction(String s, String s1)
    {
        interactionId = s1;
        interactionType = s;
        return this;
    }

    public interactionType setTransactionId(String s)
    {
        transactionId = s;
        return this;
    }








    public (String s)
    {
        properties = new HashMap();
        eventName = s;
    }
}
