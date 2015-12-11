// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.util.b;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.g;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.n;
import com.exacttarget.etpushsdk.util.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.data:
//            Attribute

public class Registration extends g
    implements Serializable
{

    private static final String ET_ATTRIBUTES_CACHE = "et_attributes_cache";
    public static final String ET_DEVICE_ID_CACHE = "et_device_id_cache";
    public static final String ET_MANUFACTURER_CACHE = "et_manufacturer_cache";
    public static final String ET_MODEL_CACHE = "et_model_cache";
    public static final String ET_PLATFORM_CACHE = "et_platform_cache";
    public static final String ET_PLATFORM_VERSION_CACHE = "et_platform_version_cache";
    private static final String ET_REGISTRATION_CACHE = "et_registration_cache";
    private static final String ET_SEPARATOR = "^|^";
    private static final String ET_SPLITTER = "\\^\\|\\^";
    public static final String ET_SUBSCRIBER_CACHE = "et_subscriber_cache";
    private static final String ET_TAGS_CACHE = "et_tags_cache";
    private static final String GEO_ENABLED_KEY = "et_geo_enabled_key";
    protected static final String JF_APP_VERSION = "app_version";
    protected static final String JF_ATTRIBUTES = "attributes";
    protected static final String JF_BADGE = "badge";
    protected static final String JF_DEVICE_ID = "deviceID";
    protected static final String JF_DEVICE_TOKEN = "device_Token";
    protected static final String JF_DST = "dST";
    protected static final String JF_ET_APP_ID = "etAppId";
    protected static final String JF_GCM_SENDER_ID = "gcmSenderId";
    protected static final String JF_HWID = "hwid";
    protected static final String JF_KEY = "key";
    protected static final String JF_LOCALE = "locale";
    protected static final String JF_LOCATION_ENABLED = "location_enabled";
    protected static final String JF_PLATFORM = "platform";
    protected static final String JF_PLATFORM_VERSION = "platform_Version";
    protected static final String JF_PUSH_ENABLED = "push_enabled";
    protected static final String JF_SDK_VERSION = "sdk_version";
    protected static final String JF_SUBSCRIBER_KEY = "subscriberKey";
    protected static final String JF_TAGS = "tags";
    protected static final String JF_TIME_ZONE = "timeZone";
    protected static final String JF_VALUE = "value";
    public static final String SYSTEM_TOKEN_KEY = "gcm_reg_id_key";
    public static final String TAG = "~!Registration";
    private static final long serialVersionUID = 1L;
    private ArrayList attributes;
    private Integer badge;
    private String deviceId;
    private Boolean dst;
    private String email;
    private String etAppId;
    private String gcmSenderId;
    private String hwid;
    private Integer id;
    private String language;
    private Long lastSent;
    private String locale;
    private Boolean locationEnabled;
    private String platform;
    private String platformVersion;
    private Boolean pushEnabled;
    private String subscriberKey;
    private TreeSet tags;
    private Integer timeZone;

    public Registration()
    {
        lastSent = Long.valueOf(0L);
        deviceId = uniqueDeviceIdentifier(ETPush.a());
        timeZone = Integer.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
        dst = Boolean.valueOf(TimeZone.getDefault().inDaylightTime(new Date()));
        locale = Locale.getDefault().toString();
        setEtAppId(d.b());
        setGcmSenderId(d.d());
        setLocationEnabled(Boolean.valueOf(((Boolean)d.a(ETPush.a(), "et_geo_enabled_key", Boolean.valueOf(true), new Object[0])).booleanValue()));
        tags = deserializeTags((String)d.a(ETPush.a(), "et_tags_cache", null, new Object[] {
            ETPush.a().getSharedPreferences("et_registration_cache", 0)
        }));
        Object obj;
        String s;
        if (b.a())
        {
            platform = "Amazon";
            tags.add("Amazon");
        } else
        {
            platform = "Android";
            tags.add("Android");
        }
        platformVersion = android.os.Build.VERSION.RELEASE;
        m.a("~!Registration", (new StringBuilder()).append("Platform: \"").append(platform).append("\", platformVersion: \"").append(platformVersion).append("\"").toString());
        obj = Build.MANUFACTURER;
        s = Build.MODEL;
        hwid = (new StringBuilder()).append(((String) (obj))).append(' ').append(s).toString();
        m.a("~!Registration", (new StringBuilder()).append("hwid: ").append(hwid).toString());
        d.a(ETPush.a(), "et_device_id_cache", deviceId);
        d.a(ETPush.a(), "et_manufacturer_cache", ((String) (obj)));
        d.a(ETPush.a(), "et_platform_cache", platform);
        d.a(ETPush.a(), "et_platform_version_cache", platformVersion);
        d.a(ETPush.a(), "et_model_cache", s);
        if (n.a(ETPush.a()))
        {
            tags.add("Debug");
        }
        tags.add("ALL");
        saveTagsToPrefs();
        attributes = deserializeAttributes((String)d.a(ETPush.a(), "et_attributes_cache", null, new Object[] {
            ETPush.a().getSharedPreferences("et_registration_cache", 0)
        }));
        obj = attributes.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Attribute attribute = (Attribute)((Iterator) (obj)).next();
            if (!attribute.getKey().equals("_ETSDKVersion"))
            {
                continue;
            }
            attributes.remove(attribute);
            break;
        } while (true);
        saveAttributesToPrefs();
        subscriberKey = (String)d.a(ETPush.a(), "et_subscriber_cache", null, new Object[] {
            ETPush.a().getSharedPreferences("et_registration_cache", 0)
        });
        m.a("~!Registration", "Registration() initialization complete");
    }

    public static ArrayList deserializeAttributes(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && !TextUtils.isEmpty(s))
        {
            s = s.split("\\^\\|\\^");
            int i = 0;
            while (i < s.length) 
            {
                for (; s[i] == null || s[i].isEmpty(); i++) { }
                if (i + 1 >= s.length)
                {
                    arraylist.add(new Attribute(s[i], ""));
                } else
                {
                    arraylist.add(new Attribute(s[i], s[i + 1]));
                }
                i += 2;
            }
        }
        return arraylist;
    }

    public static TreeSet deserializeTags(String s)
    {
        TreeSet treeset = new TreeSet();
        if (s != null && !TextUtils.isEmpty(s))
        {
            s = s.split("\\^\\|\\^");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = s[i];
                if (s1 != null && !s1.isEmpty())
                {
                    treeset.add(s1);
                }
            }

        }
        return treeset;
    }

    private void saveAttributesToPrefs()
    {
        d.a(ETPush.a(), "et_attributes_cache", serializeAttributes(attributes));
    }

    private void saveTagsToPrefs()
    {
        d.a(ETPush.a(), "et_tags_cache", serializeTags(tags));
    }

    public static String serializeAttributes(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); stringbuilder.append("^|^"))
        {
            Attribute attribute = (Attribute)arraylist.next();
            stringbuilder.append(attribute.getKey());
            stringbuilder.append("^|^");
            stringbuilder.append(attribute.getValue());
        }

        return stringbuilder.toString();
    }

    public static String serializeTags(TreeSet treeset)
    {
        if (treeset == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (treeset = treeset.iterator(); treeset.hasNext(); stringbuilder.append("^|^"))
        {
            stringbuilder.append((String)treeset.next());
        }

        return stringbuilder.toString();
    }

    public void addAttribute(Attribute attribute)
    {
        if (attributes.contains(attribute))
        {
            attributes.remove(attribute);
        }
        attributes.add(attribute);
        saveAttributesToPrefs();
    }

    public void addTag(String s)
    {
        tags.add(s);
        saveTagsToPrefs();
    }

    public ArrayList getAttributes()
    {
        return attributes;
    }

    public Integer getBadge()
    {
        return badge;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public Boolean getDst()
    {
        return dst;
    }

    public String getEmail()
    {
        return email;
    }

    public String getEtAppId()
    {
        return etAppId;
    }

    public String getGcmSenderId()
    {
        return gcmSenderId;
    }

    public String getHwid()
    {
        return hwid;
    }

    public Integer getId()
    {
        return id;
    }

    public String getLanguage()
    {
        return language;
    }

    public Long getLastSent()
    {
        return lastSent;
    }

    public String getLocale()
    {
        if (locale == null && language != null)
        {
            return language;
        } else
        {
            return locale;
        }
    }

    public Boolean getLocationEnabled()
    {
        return locationEnabled;
    }

    public String getPlatform()
    {
        return platform;
    }

    public String getPlatformVersion()
    {
        return platformVersion;
    }

    public Boolean getPushEnabled()
    {
        return pushEnabled;
    }

    public String getSubscriberKey()
    {
        return subscriberKey;
    }

    public String getSystemToken()
    {
        return getSystemTokenFromCache();
    }

    public String getSystemTokenFromCache()
    {
        return (String)d.a(ETPush.a(), "gcm_reg_id_key", null, new Object[] {
            ETPush.a().getSharedPreferences("~!Registration", 0)
        });
    }

    public TreeSet getTags()
    {
        return tags;
    }

    public Integer getTimeZone()
    {
        return timeZone;
    }

    public void removeAttribute(Attribute attribute)
    {
        if (attributes.contains(attribute))
        {
            attributes.remove(attribute);
        }
        saveAttributesToPrefs();
    }

    public void removeTag(String s)
    {
        tags.remove(s);
        saveTagsToPrefs();
    }

    public void setAttributes(ArrayList arraylist)
    {
        attributes = arraylist;
    }

    public void setBadge(Integer integer)
    {
        badge = integer;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setDst(Boolean boolean1)
    {
        dst = boolean1;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setEtAppId(String s)
    {
        etAppId = s;
    }

    public void setGcmSenderId(String s)
    {
        gcmSenderId = s;
    }

    public void setHwid(String s)
    {
        hwid = s;
    }

    public void setId(Integer integer)
    {
        id = integer;
    }

    public void setLanguage(String s)
    {
        language = s;
    }

    public void setLastSent(Long long1)
    {
        lastSent = long1;
    }

    public void setLocale(String s)
    {
        locale = s;
    }

    public void setLocationEnabled(Boolean boolean1)
    {
        locationEnabled = boolean1;
    }

    public void setPlatform(String s)
    {
        platform = s;
    }

    public void setPlatformVersion(String s)
    {
        platformVersion = s;
    }

    public void setPushEnabled(Boolean boolean1)
    {
        pushEnabled = boolean1;
    }

    public void setSubscriberKey(String s)
    {
        subscriberKey = s;
        d.a(ETPush.a(), "et_subscriber_cache", subscriberKey);
    }

    public void setSystemTokenInCache(String s)
    {
        int i = n.a();
        m.a("~!Registration", String.format("Saving regId and app version code : %1$s ", new Object[] {
            Integer.valueOf(i)
        }));
        d.a(ETPush.a(), "gcm_reg_id_key", s);
        d.a(ETPush.a(), "gcm_app_version_key", Integer.valueOf(i));
        d.a(ETPush.a(), "gcm_sender_id_key", d.d());
    }

    public void setTags(TreeSet treeset)
    {
        tags = treeset;
    }

    public void setTimeZone(Integer integer)
    {
        timeZone = integer;
    }

    public String toJson()
    {
        Object obj;
        JSONArray jsonarray;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("deviceID", deviceId);
            ((JSONObject) (obj)).put("device_Token", getSystemTokenFromCache());
            ((JSONObject) (obj)).put("sdk_version", o.a());
            ((JSONObject) (obj)).put("app_version", String.format("%1$s : %2$s", new Object[] {
                n.b(), Integer.valueOf(n.a())
            }));
            ((JSONObject) (obj)).put("gcmSenderId", gcmSenderId);
            ((JSONObject) (obj)).put("dST", dst);
            ((JSONObject) (obj)).put("location_enabled", locationEnabled);
            ((JSONObject) (obj)).put("platform_Version", platformVersion);
            ((JSONObject) (obj)).put("push_enabled", pushEnabled);
            ((JSONObject) (obj)).put("timeZone", timeZone);
            if (!TextUtils.isEmpty(subscriberKey))
            {
                ((JSONObject) (obj)).put("subscriberKey", subscriberKey);
            }
            ((JSONObject) (obj)).put("platform", platform);
            ((JSONObject) (obj)).put("hwid", hwid);
            ((JSONObject) (obj)).put("etAppId", etAppId);
            ((JSONObject) (obj)).put("badge", badge);
            ((JSONObject) (obj)).put("locale", locale);
            ((JSONObject) (obj)).put("tags", new JSONArray(tags));
            jsonarray = new JSONArray();
            JSONObject jsonobject;
            for (Iterator iterator = attributes.iterator(); iterator.hasNext(); jsonarray.put(jsonobject))
            {
                Attribute attribute = (Attribute)iterator.next();
                jsonobject = new JSONObject();
                jsonobject.put("key", attribute.getKey());
                jsonobject.put("value", attribute.getValue());
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            m.c("~!Registration", String.format("Error converting Registration to JSON: %1$s", new Object[] {
                ((Exception) (obj)).getMessage()
            }), ((Throwable) (obj)));
            return null;
        }
        ((JSONObject) (obj)).put("attributes", jsonarray);
        obj = ((JSONObject) (obj)).toString();
        return ((String) (obj));
    }
}
