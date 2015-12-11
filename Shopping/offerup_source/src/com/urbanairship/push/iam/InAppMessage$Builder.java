// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import com.urbanairship.json.JsonMap;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessage

public class _cls200
{

    private String alert;
    private Map buttonActionValues;
    private String buttonGroupId;
    private Map clickActionValues;
    private Long durationMilliseconds;
    private Long expiryMS;
    private JsonMap extras;
    private String id;
    private int position;
    private Integer primaryColor;
    private Integer secondaryColor;

    public InAppMessage create()
    {
        return new InAppMessage(this, null);
    }

    public _cls200 setAlert(String s)
    {
        alert = s;
        return this;
    }

    public alert setButtonActionValues(String s, Map map)
    {
        if (map == null)
        {
            buttonActionValues.remove(s);
            return this;
        } else
        {
            buttonActionValues.put(s, new HashMap(map));
            return this;
        }
    }

    public buttonActionValues setButtonGroupId(String s)
    {
        buttonGroupId = s;
        return this;
    }

    public buttonGroupId setClickActionValues(Map map)
    {
        if (map == null)
        {
            clickActionValues = null;
            return this;
        } else
        {
            clickActionValues = new HashMap(map);
            return this;
        }
    }

    public clickActionValues setDuration(Long long1)
    {
        if (long1 != null && long1.longValue() <= 0L)
        {
            throw new IllegalArgumentException("Duration must be greater than 0 milliseconds");
        } else
        {
            durationMilliseconds = long1;
            return this;
        }
    }

    public durationMilliseconds setExpiry(Long long1)
    {
        expiryMS = long1;
        return this;
    }

    public expiryMS setExtras(JsonMap jsonmap)
    {
        extras = jsonmap;
        return this;
    }

    public extras setId(String s)
    {
        id = s;
        return this;
    }

    public id setPosition(int i)
    {
        if (i != 1 && i != 0)
        {
            throw new IllegalArgumentException("Position must be either InAppMessage.POSITION_BOTTOM or InAppMessage.POSITION_TOP.");
        } else
        {
            position = i;
            return this;
        }
    }

    public position setPrimaryColor(Integer integer)
    {
        primaryColor = integer;
        return this;
    }

    public primaryColor setSecondaryColor(Integer integer)
    {
        secondaryColor = integer;
        return this;
    }












    public ()
    {
        buttonActionValues = new HashMap();
        position = 0;
    }

    public position(InAppMessage inappmessage)
    {
        buttonActionValues = new HashMap();
        position = 0;
        id = InAppMessage.access$1200(inappmessage);
        buttonGroupId = InAppMessage.access$1300(inappmessage);
        alert = InAppMessage.access$1400(inappmessage);
        expiryMS = Long.valueOf(InAppMessage.access$1500(inappmessage));
        durationMilliseconds = InAppMessage.access$1600(inappmessage);
        position = InAppMessage.access$1700(inappmessage);
        clickActionValues = new HashMap(InAppMessage.access$1800(inappmessage));
        buttonActionValues = new HashMap(InAppMessage.access$1900(inappmessage));
        extras = InAppMessage.access$2000(inappmessage);
        primaryColor = InAppMessage.access$2100(inappmessage);
        secondaryColor = InAppMessage.access$2200(inappmessage);
    }
}
