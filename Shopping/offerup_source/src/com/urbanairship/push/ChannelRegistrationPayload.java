// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.Logger;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

class ChannelRegistrationPayload
    implements JsonSerializable
{

    static final String ALIAS_KEY = "alias";
    static final String APID_KEY = "apid";
    static final String BACKGROUND_ENABLED_KEY = "background";
    static final String CHANNEL_KEY = "channel";
    static final String DEVICE_TYPE_KEY = "device_type";
    static final String IDENTITY_HINTS_KEY = "identity_hints";
    static final String OPT_IN_KEY = "opt_in";
    static final String PUSH_ADDRESS_KEY = "push_address";
    static final String SET_TAGS_KEY = "set_tags";
    static final String TAGS_KEY = "tags";
    static final String USER_ID_KEY = "user_id";
    private final String alias;
    private final String apid;
    private final boolean backgroundEnabled;
    private final String deviceType;
    private final boolean optIn;
    private final String pushAddress;
    private final boolean setTags;
    private final Set tags;
    private final String userId;

    private ChannelRegistrationPayload(Builder builder)
    {
        optIn = builder.optIn;
        backgroundEnabled = builder.backgroundEnabled;
        alias = builder.alias;
        deviceType = builder.deviceType;
        pushAddress = builder.pushAddress;
        setTags = builder.setTags;
        Set set;
        if (builder.setTags)
        {
            set = builder.tags;
        } else
        {
            set = null;
        }
        tags = set;
        userId = builder.userId;
        apid = builder.apid;
    }

    ChannelRegistrationPayload(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static ChannelRegistrationPayload parseJson(String s)
    {
        Object obj = null;
        JsonMap jsonmap = JsonValue.parseString(s).getMap();
        if (jsonmap == null || jsonmap.isEmpty())
        {
            return null;
        }
        Builder builder = new Builder();
        JsonMap jsonmap1 = jsonmap.opt("channel").getMap();
        if (jsonmap1 != null)
        {
            builder.setOptIn(jsonmap1.opt("opt_in").getBoolean(false)).setBackgroundEnabled(jsonmap1.opt("background").getBoolean(false)).setDeviceType(jsonmap1.opt("device_type").getString()).setPushAddress(jsonmap1.opt("push_address").getString()).setAlias(jsonmap1.opt("alias").getString()).setUserId(jsonmap1.opt("user_id").getString()).setApid(jsonmap1.opt("apid").getString());
            s = obj;
            if (jsonmap1.opt("tags").isJsonList())
            {
                s = new HashSet();
                Iterator iterator = jsonmap1.get("tags").getList().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    JsonValue jsonvalue = (JsonValue)iterator.next();
                    if (jsonvalue.isString())
                    {
                        s.add(jsonvalue.getString());
                    }
                } while (true);
            }
            builder.setTags(jsonmap1.opt("set_tags").getBoolean(false), s);
        }
        s = jsonmap.opt("identity_hints").getMap();
        if (s != null)
        {
            builder.setUserId(s.opt("user_id").getString()).setApid(s.opt("apid").getString());
        }
        return builder.build();
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof ChannelRegistrationPayload))
        {
            if (optIn == ((ChannelRegistrationPayload) (obj = (ChannelRegistrationPayload)obj)).optIn && backgroundEnabled == ((ChannelRegistrationPayload) (obj)).backgroundEnabled && (alias != null ? alias.equals(((ChannelRegistrationPayload) (obj)).alias) : ((ChannelRegistrationPayload) (obj)).alias == null) && (deviceType != null ? deviceType.equals(((ChannelRegistrationPayload) (obj)).deviceType) : ((ChannelRegistrationPayload) (obj)).deviceType == null) && (pushAddress != null ? pushAddress.equals(((ChannelRegistrationPayload) (obj)).pushAddress) : ((ChannelRegistrationPayload) (obj)).pushAddress == null) && setTags == ((ChannelRegistrationPayload) (obj)).setTags && (tags != null ? tags.equals(((ChannelRegistrationPayload) (obj)).tags) : ((ChannelRegistrationPayload) (obj)).tags == null) && (userId != null ? userId.equals(((ChannelRegistrationPayload) (obj)).userId) : ((ChannelRegistrationPayload) (obj)).userId == null) && (apid != null ? apid.equals(((ChannelRegistrationPayload) (obj)).apid) : ((ChannelRegistrationPayload) (obj)).apid == null))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j1 = 1;
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int k1;
        int l1;
        if (optIn)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (backgroundEnabled)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (alias == null)
        {
            k = 0;
        } else
        {
            k = alias.hashCode();
        }
        if (deviceType == null)
        {
            l = 0;
        } else
        {
            l = deviceType.hashCode();
        }
        if (pushAddress == null)
        {
            i1 = 0;
        } else
        {
            i1 = pushAddress.hashCode();
        }
        if (!setTags)
        {
            j1 = 0;
        }
        if (tags == null)
        {
            k1 = 0;
        } else
        {
            k1 = tags.hashCode();
        }
        if (userId == null)
        {
            l1 = 0;
        } else
        {
            l1 = userId.hashCode();
        }
        if (apid != null)
        {
            i2 = apid.hashCode();
        }
        return (l1 + (k1 + ((i1 + (l + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + j1) * 31) * 31) * 31 + i2;
    }

    public JsonValue toJsonValue()
    {
        Object obj = new HashMap();
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        hashmap1.put("device_type", deviceType);
        hashmap1.put("opt_in", Boolean.valueOf(optIn));
        hashmap1.put("background", Boolean.valueOf(backgroundEnabled));
        hashmap1.put("push_address", pushAddress);
        if (!UAStringUtil.isEmpty(alias))
        {
            hashmap1.put("alias", alias);
        }
        hashmap1.put("set_tags", Boolean.valueOf(setTags));
        if (setTags && tags != null)
        {
            hashmap1.put("tags", new JSONArray(tags));
        }
        ((Map) (obj)).put("channel", hashmap1);
        if (!UAStringUtil.isEmpty(userId))
        {
            hashmap.put("user_id", userId);
        }
        if (!UAStringUtil.isEmpty(apid))
        {
            hashmap.put("apid", apid);
        }
        if (!hashmap.isEmpty())
        {
            ((Map) (obj)).put("identity_hints", hashmap);
        }
        try
        {
            obj = JsonValue.wrap(obj);
        }
        catch (JsonException jsonexception)
        {
            Logger.error("ChannelRegistrationPayload - Failed to create channel registration payload as json", jsonexception);
            return JsonValue.NULL;
        }
        return ((JsonValue) (obj));
    }

    public String toString()
    {
        return toJsonValue().toString();
    }

    private class Builder
    {

        private String alias;
        private String apid;
        private boolean backgroundEnabled;
        private String deviceType;
        private boolean optIn;
        private String pushAddress;
        private boolean setTags;
        private Set tags;
        private String userId;

        ChannelRegistrationPayload build()
        {
            return new ChannelRegistrationPayload(this, null);
        }

        Builder setAlias(String s)
        {
            String s1 = s;
            if (s != null)
            {
                s1 = s.trim();
            }
            alias = s1;
            return this;
        }

        Builder setApid(String s)
        {
            apid = s;
            return this;
        }

        Builder setBackgroundEnabled(boolean flag)
        {
            backgroundEnabled = flag;
            return this;
        }

        Builder setDeviceType(String s)
        {
            deviceType = s;
            return this;
        }

        Builder setOptIn(boolean flag)
        {
            optIn = flag;
            return this;
        }

        Builder setPushAddress(String s)
        {
            pushAddress = s;
            return this;
        }

        Builder setTags(boolean flag, Set set)
        {
            setTags = flag;
            tags = set;
            return this;
        }

        Builder setUserId(String s)
        {
            userId = s;
            return this;
        }










        Builder()
        {
        }
    }

}
