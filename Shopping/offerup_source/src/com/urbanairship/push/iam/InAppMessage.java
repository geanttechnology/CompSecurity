// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.Logger;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.DateUtils;
import com.urbanairship.util.UAStringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class InAppMessage
    implements Parcelable, JsonSerializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final long DEFAULT_EXPIRY_MS = 0x9a7ec800L;
    public static final int POSITION_BOTTOM = 0;
    public static final int POSITION_TOP = 1;
    private final String alert;
    private final Map buttonActionValues;
    private final String buttonGroupId;
    private final Map clickActionValues;
    private final Long durationMilliseconds;
    private final long expiryMS;
    private final JsonMap extras;
    private final String id;
    private final int position;
    private final Integer primaryColor;
    private final Integer secondaryColor;

    private InAppMessage(Parcel parcel)
    {
        id = parcel.readString();
        alert = parcel.readString();
        expiryMS = parcel.readLong();
        position = parcel.readInt();
        Object obj;
        JsonMap jsonmap;
        if (parcel.readByte() == 1)
        {
            obj = Long.valueOf(parcel.readLong());
        } else
        {
            obj = null;
        }
        durationMilliseconds = ((Long) (obj));
        if (parcel.readByte() == 1)
        {
            obj = Integer.valueOf(parcel.readInt());
        } else
        {
            obj = null;
        }
        primaryColor = ((Integer) (obj));
        if (parcel.readByte() == 1)
        {
            obj = Integer.valueOf(parcel.readInt());
        } else
        {
            obj = null;
        }
        secondaryColor = ((Integer) (obj));
        try
        {
            obj = JsonValue.parseString(parcel.readString()).getMap();
        }
        catch (JsonException jsonexception)
        {
            Logger.error("InAppMessage - unable to parse extras from parcel.");
            jsonexception = null;
        }
        jsonmap = ((JsonMap) (obj));
        if (obj == null)
        {
            jsonmap = new JsonMap(null);
        }
        extras = jsonmap;
        buttonGroupId = parcel.readString();
        buttonActionValues = new HashMap();
        parcel.readMap(buttonActionValues, com/urbanairship/actions/ActionValue.getClassLoader());
        clickActionValues = new HashMap();
        parcel.readMap(clickActionValues, com/urbanairship/actions/ActionValue.getClassLoader());
    }

    InAppMessage(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    private InAppMessage(Builder builder)
    {
        Object obj;
        long l;
        if (builder.expiryMS == null)
        {
            l = System.currentTimeMillis() + 0x9a7ec800L;
        } else
        {
            l = builder.expiryMS.longValue();
        }
        expiryMS = l;
        id = builder.id;
        if (builder.extras == null)
        {
            obj = new JsonMap(null);
        } else
        {
            obj = builder.extras;
        }
        extras = ((JsonMap) (obj));
        alert = builder.alert;
        durationMilliseconds = builder.durationMilliseconds;
        buttonGroupId = builder.buttonGroupId;
        buttonActionValues = builder.buttonActionValues;
        if (builder.clickActionValues == null)
        {
            obj = new HashMap();
        } else
        {
            obj = builder.clickActionValues;
        }
        clickActionValues = ((Map) (obj));
        position = builder.position;
        primaryColor = builder.primaryColor;
        secondaryColor = builder.secondaryColor;
    }

    InAppMessage(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    private static Integer parseColor(String s)
    {
        if (UAStringUtil.isEmpty(s))
        {
            return null;
        }
        int i;
        try
        {
            i = Color.parseColor(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Logger.warn((new StringBuilder("InAppMessage - Unable to parse color: ")).append(s).toString(), illegalargumentexception);
            return null;
        }
        return Integer.valueOf(i);
    }

    public static InAppMessage parseJson(String s)
    {
        JsonMap jsonmap;
        Object obj;
        obj = JsonValue.parseString(s).getMap();
        if (obj == null)
        {
            return null;
        }
        Object obj1 = ((JsonMap) (obj)).opt("display").getMap();
        jsonmap = ((JsonMap) (obj)).opt("actions").getMap();
        if (obj1 == null || !"banner".equals(((JsonMap) (obj1)).opt("type").getString()))
        {
            Logger.error((new StringBuilder("InAppMessage - Unable to parse json: ")).append(s).toString());
            return null;
        }
        s = new Builder();
        s.setId(((JsonMap) (obj)).opt("id").getString()).setExtras(((JsonMap) (obj)).opt("extra").getMap()).setAlert(((JsonMap) (obj1)).opt("alert").getString()).setPrimaryColor(parseColor(((JsonMap) (obj1)).opt("primary_color").getString())).setSecondaryColor(parseColor(((JsonMap) (obj1)).opt("secondary_color").getString()));
        java.util.Map.Entry entry;
        if (((JsonMap) (obj1)).containsKey("duration_ms"))
        {
            long l = ((JsonMap) (obj1)).get("duration_ms").getLong(0L);
            if (l > 0L)
            {
                s.setDuration(Long.valueOf(l));
            }
            break MISSING_BLOCK_LABEL_201;
        } else
        {
            long l1 = ((JsonMap) (obj1)).opt("duration").getLong(0L);
            if (l1 > 0L)
            {
                s.setDuration(Long.valueOf(TimeUnit.SECONDS.toMillis(l1)));
            }
            continue;
        }
        do
        {
            if (((JsonMap) (obj)).containsKey("expiry_ms"))
            {
                s.setExpiry(Long.valueOf(((JsonMap) (obj)).get("expiry_ms").getLong(System.currentTimeMillis() + 0x9a7ec800L)));
            } else
            if (((JsonMap) (obj)).containsKey("expiry"))
            {
                s.setExpiry(Long.valueOf(DateUtils.parseIso8601(((JsonMap) (obj)).opt("expiry").getString(), System.currentTimeMillis() + 0x9a7ec800L)));
            }
            if ("top".equalsIgnoreCase(((JsonMap) (obj1)).opt("position").getString()))
            {
                s.setPosition(1);
            } else
            {
                s.setPosition(0);
            }
            if (jsonmap != null)
            {
                obj1 = jsonmap.opt("on_click").getMap();
                if (obj1 != null)
                {
                    obj = new HashMap();
                    for (obj1 = ((JsonMap) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((Map) (obj)).put(entry.getKey(), new ActionValue((JsonValue)entry.getValue())))
                    {
                        entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                    }

                    s.setClickActionValues(((Map) (obj)));
                }
                s.setButtonGroupId(jsonmap.opt("button_group").getString());
                jsonmap = jsonmap.opt("button_actions").getMap();
                if (jsonmap != null)
                {
                    String s1;
                    HashMap hashmap;
                    for (Iterator iterator = jsonmap.entrySet().iterator(); iterator.hasNext(); s.setButtonActionValues(s1, hashmap))
                    {
                        s1 = (String)((java.util.Map.Entry)iterator.next()).getKey();
                        Object obj2 = jsonmap.opt(s1).getMap();
                        hashmap = new HashMap();
                        java.util.Map.Entry entry1;
                        for (obj2 = ((JsonMap) (obj2)).entrySet().iterator(); ((Iterator) (obj2)).hasNext(); hashmap.put(entry1.getKey(), new ActionValue((JsonValue)entry1.getValue())))
                        {
                            entry1 = (java.util.Map.Entry)((Iterator) (obj2)).next();
                        }

                    }

                }
            }
            return s.create();
        } while (true);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof InAppMessage))
            {
                return false;
            }
            obj = (InAppMessage)obj;
            if ((id != null ? !id.equals(((InAppMessage) (obj)).id) : ((InAppMessage) (obj)).id != null) || (alert != null ? !alert.equals(((InAppMessage) (obj)).alert) : ((InAppMessage) (obj)).alert != null) || (buttonGroupId != null ? !buttonGroupId.equals(((InAppMessage) (obj)).buttonGroupId) : ((InAppMessage) (obj)).buttonGroupId != null) || (!extras.equals(((InAppMessage) (obj)).extras) || !clickActionValues.equals(((InAppMessage) (obj)).clickActionValues) || !buttonActionValues.equals(((InAppMessage) (obj)).buttonActionValues)) || (primaryColor != null ? !primaryColor.equals(((InAppMessage) (obj)).primaryColor) : ((InAppMessage) (obj)).primaryColor != null) || (secondaryColor != null ? !secondaryColor.equals(((InAppMessage) (obj)).secondaryColor) : ((InAppMessage) (obj)).secondaryColor != null) || (durationMilliseconds != null ? !durationMilliseconds.equals(((InAppMessage) (obj)).durationMilliseconds) : ((InAppMessage) (obj)).durationMilliseconds != null) || (position != ((InAppMessage) (obj)).position || expiryMS != ((InAppMessage) (obj)).expiryMS))
            {
                return false;
            }
        }
        return true;
    }

    public String getAlert()
    {
        return alert;
    }

    public Map getButtonActionValues(String s)
    {
        if (buttonActionValues.containsKey(s))
        {
            return Collections.unmodifiableMap((Map)buttonActionValues.get(s));
        } else
        {
            return null;
        }
    }

    public String getButtonGroupId()
    {
        return buttonGroupId;
    }

    public Map getClickActionValues()
    {
        return Collections.unmodifiableMap(clickActionValues);
    }

    public Long getDuration()
    {
        return durationMilliseconds;
    }

    public long getExpiry()
    {
        return expiryMS;
    }

    public JsonMap getExtras()
    {
        return extras;
    }

    public String getId()
    {
        return id;
    }

    public int getPosition()
    {
        return position;
    }

    public Integer getPrimaryColor()
    {
        return primaryColor;
    }

    public Integer getSecondaryColor()
    {
        return secondaryColor;
    }

    public int hashCode()
    {
        int j1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int k1;
        int l1;
        int i2;
        if (id == null)
        {
            i = 0;
        } else
        {
            i = id.hashCode();
        }
        if (alert == null)
        {
            j = 0;
        } else
        {
            j = alert.hashCode();
        }
        if (buttonGroupId == null)
        {
            k = 0;
        } else
        {
            k = buttonGroupId.hashCode();
        }
        k1 = extras.hashCode();
        l1 = clickActionValues.hashCode();
        i2 = buttonActionValues.hashCode();
        if (secondaryColor == null)
        {
            l = 0;
        } else
        {
            l = secondaryColor.intValue();
        }
        if (primaryColor == null)
        {
            i1 = 0;
        } else
        {
            i1 = primaryColor.intValue();
        }
        if (durationMilliseconds != null)
        {
            j1 = durationMilliseconds.hashCode();
        }
        return (((i1 + (l + ((((k + (j + (i + 403) * 31) * 31) * 31 + k1) * 31 + l1) * 31 + i2) * 31) * 31) * 31 + j1) * 31 + position) * 31 + Long.valueOf(expiryMS).hashCode();
    }

    public boolean isExpired()
    {
        return System.currentTimeMillis() > expiryMS;
    }

    public JsonValue toJsonValue()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("id", id);
        hashmap.put("expiry_ms", Long.valueOf(expiryMS));
        hashmap.put("extra", extras);
        HashMap hashmap1 = new HashMap();
        hashmap.put("display", hashmap1);
        hashmap1.put("type", "banner");
        hashmap1.put("alert", alert);
        Object obj;
        if (position == 1)
        {
            obj = "top";
        } else
        {
            obj = "bottom";
        }
        hashmap1.put("position", obj);
        if (durationMilliseconds != null)
        {
            hashmap1.put("duration_ms", durationMilliseconds);
        }
        if (primaryColor != null)
        {
            hashmap1.put("primary_color", String.format(Locale.US, "#%06X", new Object[] {
                Integer.valueOf(primaryColor.intValue() & 0xffffff)
            }));
        }
        if (secondaryColor != null)
        {
            hashmap1.put("secondary_color", String.format(Locale.US, "#%06X", new Object[] {
                Integer.valueOf(secondaryColor.intValue() & 0xffffff)
            }));
        }
        obj = new HashMap();
        hashmap.put("actions", obj);
        ((Map) (obj)).put("on_click", clickActionValues);
        ((Map) (obj)).put("button_group", buttonGroupId);
        ((Map) (obj)).put("button_actions", buttonActionValues);
        return JsonValue.wrap(hashmap, JsonValue.NULL);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(alert);
        parcel.writeLong(expiryMS);
        parcel.writeInt(position);
        if (durationMilliseconds == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeLong(durationMilliseconds.longValue());
        }
        if (primaryColor == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeInt(primaryColor.intValue());
        }
        if (secondaryColor == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeInt(secondaryColor.intValue());
        }
        parcel.writeString(extras.toString());
        parcel.writeString(buttonGroupId);
        parcel.writeMap(buttonActionValues);
        parcel.writeMap(clickActionValues);
    }













    private class Builder
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

        public Builder setAlert(String s)
        {
            alert = s;
            return this;
        }

        public Builder setButtonActionValues(String s, Map map)
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

        public Builder setButtonGroupId(String s)
        {
            buttonGroupId = s;
            return this;
        }

        public Builder setClickActionValues(Map map)
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

        public Builder setDuration(Long long1)
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

        public Builder setExpiry(Long long1)
        {
            expiryMS = long1;
            return this;
        }

        public Builder setExtras(JsonMap jsonmap)
        {
            extras = jsonmap;
            return this;
        }

        public Builder setId(String s)
        {
            id = s;
            return this;
        }

        public Builder setPosition(int i)
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

        public Builder setPrimaryColor(Integer integer)
        {
            primaryColor = integer;
            return this;
        }

        public Builder setSecondaryColor(Integer integer)
        {
            secondaryColor = integer;
            return this;
        }












        public Builder()
        {
            buttonActionValues = new HashMap();
            position = 0;
        }

        public Builder(InAppMessage inappmessage)
        {
            buttonActionValues = new HashMap();
            position = 0;
            id = inappmessage.id;
            buttonGroupId = inappmessage.buttonGroupId;
            alert = inappmessage.alert;
            expiryMS = Long.valueOf(inappmessage.expiryMS);
            durationMilliseconds = inappmessage.durationMilliseconds;
            position = inappmessage.position;
            clickActionValues = new HashMap(inappmessage.clickActionValues);
            buttonActionValues = new HashMap(inappmessage.buttonActionValues);
            extras = inappmessage.extras;
            primaryColor = inappmessage.primaryColor;
            secondaryColor = inappmessage.secondaryColor;
        }
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final InAppMessage createFromParcel(Parcel parcel)
        {
            return new InAppMessage(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final InAppMessage[] newArray(int i)
        {
            return new InAppMessage[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
