// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.Attribute;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.event:
//            IEventFactory

public class RegistrationEvent extends Registration
    implements IEventFactory
{

    private static final String TAG = "~!RegistrationEvent";
    private static final long serialVersionUID = 1L;

    public RegistrationEvent()
    {
    }

    public RegistrationEvent fromJson(String s)
    {
        boolean flag = false;
        Object obj;
        Object obj1;
        s = new JSONObject(s);
        setPlatform(s.getString("platform"));
        setDeviceId(s.getString("deviceID"));
        setEtAppId(s.getString("etAppId"));
        setBadge(Integer.valueOf(s.getInt("badge")));
        setTimeZone(Integer.valueOf(s.getString("timeZone")));
        setDst(Boolean.valueOf(s.getBoolean("dST")));
        obj = new TreeSet();
        obj1 = s.getJSONArray("tags");
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        int j = ((JSONArray) (obj1)).length();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((TreeSet) (obj)).add(((JSONArray) (obj1)).get(i).toString());
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        setTags(((TreeSet) (obj)));
        obj = s.getJSONArray("attributes");
        obj1 = new ArrayList();
        if (obj == null) goto _L5; else goto _L4
_L4:
        j = ((JSONArray) (obj)).length();
        i = 0;
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = ((JSONArray) (obj)).optJSONObject(i);
        ((ArrayList) (obj1)).add(new Attribute(jsonobject.getString("key"), jsonobject.getString("value")));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        String as[];
        setAttributes(((ArrayList) (obj1)));
        if (s.has("subscriberKey"))
        {
            setSubscriberKey(s.getString("subscriberKey"));
        }
        setHwid(s.getString("hwid"));
        setPlatformVersion("1.0");
        as = new String[3];
        as[0] = "platformVersion";
        as[1] = "platform_Version";
        as[2] = "platform_version";
        j = as.length;
        i = 0;
_L18:
        if (i >= j) goto _L8; else goto _L7
_L7:
        obj1 = as[i];
        if (!s.has(((String) (obj1)))) goto _L10; else goto _L9
_L9:
        m.a("~!RegistrationEvent", String.format("Key: %s", new Object[] {
            obj1
        }));
        setPlatformVersion(s.getString(((String) (obj1))));
_L8:
        setPushEnabled(Boolean.valueOf(false));
        as = new String[3];
        as[0] = "pushEnabled";
        as[1] = "push_Enabled";
        as[2] = "push_enabled";
        j = as.length;
        i = 0;
_L16:
        if (i >= j) goto _L12; else goto _L11
_L11:
        obj1 = as[i];
        if (!s.has(((String) (obj1)))) goto _L14; else goto _L13
_L13:
        m.a("~!RegistrationEvent", String.format("Key: %s", new Object[] {
            obj1
        }));
        setPushEnabled(Boolean.valueOf(s.getBoolean(((String) (obj1)))));
_L12:
        setLocationEnabled(Boolean.valueOf(false));
        as = new String[3];
        as[0] = "locationEnabled";
        as[1] = "location_Enabled";
        as[2] = "location_enabled";
        j = as.length;
        String s1;
        for (i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_509;
        }

        s1 = as[i];
        if (!s.has(s1))
        {
            break MISSING_BLOCK_LABEL_606;
        }
        m.a("~!RegistrationEvent", String.format("Key: %s", new Object[] {
            s1
        }));
        setLocationEnabled(Boolean.valueOf(s.getBoolean(s1)));
        setLanguage("en_US");
        as = new String[2];
        as[0] = "language";
        as[1] = "locale";
        j = as.length;
        for (i = ((flag) ? 1 : 0); i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_586;
        }

        s1 = as[i];
        if (!s.has(s1))
        {
            break MISSING_BLOCK_LABEL_615;
        }
        m.a("~!RegistrationEvent", String.format("Key: %s", new Object[] {
            s1
        }));
        setLanguage(s.getString(s1));
        return this;
_L10:
        i++;
        continue; /* Loop/switch isn't completed */
_L14:
        i++;
        if (true) goto _L16; else goto _L15
_L15:
        s;
        m.c("~!RegistrationEvent", s.getMessage(), s);
        return null;
        if (true) goto _L18; else goto _L17
_L17:
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public void setDatabaseIds(RegistrationEvent registrationevent, List list)
    {
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((RegistrationEvent)obj, list);
    }
}
