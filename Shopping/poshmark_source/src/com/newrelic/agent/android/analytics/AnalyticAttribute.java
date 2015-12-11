// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonElement;
import java.util.HashSet;
import java.util.Set;

public class AnalyticAttribute
{
    public static final class AttributeDataType extends Enum
    {

        private static final AttributeDataType $VALUES[];
        public static final AttributeDataType BOOLEAN;
        public static final AttributeDataType FLOAT;
        public static final AttributeDataType STRING;
        public static final AttributeDataType VOID;

        public static AttributeDataType valueOf(String s)
        {
            return (AttributeDataType)Enum.valueOf(com/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType, s);
        }

        public static AttributeDataType[] values()
        {
            return (AttributeDataType[])$VALUES.clone();
        }

        static 
        {
            VOID = new AttributeDataType("VOID", 0);
            STRING = new AttributeDataType("STRING", 1);
            FLOAT = new AttributeDataType("FLOAT", 2);
            BOOLEAN = new AttributeDataType("BOOLEAN", 3);
            $VALUES = (new AttributeDataType[] {
                VOID, STRING, FLOAT, BOOLEAN
            });
        }

        private AttributeDataType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
    public static final String APP_ID_ATTRIBUTE = "appId";
    public static final String APP_INSTALL_ATTRIBUTE = "install";
    public static final String APP_NAME_ATTRIBUTE = "appName";
    public static final String APP_UPGRADE_ATTRIBUTE = "upgradeFrom";
    public static final int ATTRIBUTE_NAME_MAX_LENGTH = 256;
    public static final int ATTRIBUTE_VALUE_MAX_LENGTH = 4096;
    public static final String CAMPAIGN_ID_ATTRIBUTE = "campaignId";
    public static final String CARRIER_ATTRIBUTE = "carrier";
    public static final String DEVICE_MANUFACTURER_ATTRIBUTE = "deviceManufacturer";
    public static final String DEVICE_MODEL_ATTRIBUTE = "deviceModel";
    private static final String DOUBLE_ATTRIBUTE_FORMAT = "\"%s\"=%f";
    public static final String EVENT_CATEGORY_ATTRIBUTE = "category";
    public static final String EVENT_NAME_ATTRIBUTE = "name";
    public static final String EVENT_SESSION_ELAPSED_TIME_ATTRIBUTE = "sessionElapsedTime";
    public static final String EVENT_TIMESTAMP_ATTRIBUTE = "timestamp";
    public static final String EVENT_TIME_SINCE_LOAD_ATTRIBUTE = "timeSinceLoad";
    public static final String EVENT_TYPE_ATTRIBUTE = "eventType";
    public static final String EVENT_TYPE_ATTRIBUTE_MOBILE = "Mobile";
    public static final String INTERACTION_DURATION_ATTRIBUTE = "interactionDuration";
    public static final String MEM_USAGE_MB_ATTRIBUTE = "memUsageMb";
    public static final String NEW_RELIC_VERSION_ATTRIBUTE = "newRelicVersion";
    public static final String OS_MAJOR_VERSION_ATTRIBUTE = "osMajorVersion";
    public static final String OS_NAME_ATTRIBUTE = "osName";
    public static final String OS_VERSION_ATTRIBUTE = "osVersion";
    public static final String PURCHASE_EVENT_ATTRIBUTE = "Purchase";
    public static final String PURCHASE_EVENT_QUANTITY_ATTRIBUTE = "quantity";
    public static final String PURCHASE_EVENT_SKU_ATTRIBUTE = "sku";
    public static final String PURCHASE_EVENT_TOTAL_PRICE_ATTRIBUTE = "total";
    public static final String PURCHASE_EVENT_UNIT_PRICE_ATTRIBUTE = "unitprice";
    public static final String SESSION_DURATION_ATTRIBUTE = "sessionDuration";
    public static final String SESSION_ID_ATTRIBUTE = "sessionId";
    public static final String SESSION_REVENUE_ATTRIBUTE = "sessionRevenue";
    public static final String SESSION_TIME_SINCE_LOAD_ATTRIBUTE = "timeSinceLoad";
    private static final String STRING_ATTRIBUTE_FORMAT = "\"%s\"=\"%s\"";
    public static final String SUBSCRIPTION_ATTRIBUTE = "subscription";
    public static final String SUBSCRIPTION_REVENUE_ATTRIBUTE = "subscriptionRevenue";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String USERNAME_ATTRIBUTE = "username";
    public static final String USER_EMAIL_ATTRIBUTE = "email";
    public static final String USER_ID_ATTRIBUTE = "userId";
    public static final String UUID_ATTRIBUTE = "uuid";
    protected static Set blackList = new HashSet() {

            
            {
                add("install");
                add("upgradeFrom");
                add("sessionDuration");
            }
    };
    private AttributeDataType attributeDataType;
    private float floatValue;
    private boolean isPersistent;
    private String name;
    private String stringValue;

    protected AnalyticAttribute()
    {
        stringValue = null;
        floatValue = (0.0F / 0.0F);
        isPersistent = false;
        attributeDataType = AttributeDataType.VOID;
    }

    public AnalyticAttribute(AnalyticAttribute analyticattribute)
    {
        name = analyticattribute.name;
        floatValue = analyticattribute.floatValue;
        stringValue = analyticattribute.stringValue;
        isPersistent = analyticattribute.isPersistent;
        attributeDataType = analyticattribute.attributeDataType;
    }

    public AnalyticAttribute(String s, float f)
    {
        this(s, f, true);
    }

    public AnalyticAttribute(String s, float f, boolean flag)
    {
        name = s;
        setFloatValue(f);
        isPersistent = flag;
    }

    public AnalyticAttribute(String s, String s1)
    {
        this(s, s1, true);
    }

    public AnalyticAttribute(String s, String s1, boolean flag)
    {
        name = s;
        setStringValue(s1);
        isPersistent = flag;
    }

    public AnalyticAttribute(String s, boolean flag)
    {
        this(s, flag, true);
    }

    public AnalyticAttribute(String s, boolean flag, boolean flag1)
    {
        name = s;
        setBooleanValue(flag);
        isPersistent = flag1;
    }

    public static boolean isAttributeBlacklisted(AnalyticAttribute analyticattribute)
    {
        return blackList.contains(analyticattribute.getName());
    }

    public JsonElement asJsonElement()
    {
        static class _cls2
        {

            static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[];

            static 
            {
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType = new int[AttributeDataType.values().length];
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AttributeDataType.VOID.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AttributeDataType.STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AttributeDataType.FLOAT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AttributeDataType.BOOLEAN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType[attributeDataType.ordinal()])
        {
        default:
            return null;

        case 2: // '\002'
            return SafeJsonPrimitive.factory(getStringValue());

        case 3: // '\003'
            return SafeJsonPrimitive.factory(Float.valueOf(getFloatValue()));

        case 4: // '\004'
            return SafeJsonPrimitive.factory(Boolean.valueOf(getBooleanValue()));
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (AnalyticAttribute)obj;
            if (!name.equals(((AnalyticAttribute) (obj)).name))
            {
                return false;
            }
        }
        return true;
    }

    public AttributeDataType getAttributeDataType()
    {
        return attributeDataType;
    }

    public boolean getBooleanValue()
    {
        if (attributeDataType == AttributeDataType.BOOLEAN)
        {
            return Boolean.valueOf(stringValue).booleanValue();
        } else
        {
            return false;
        }
    }

    public float getFloatValue()
    {
        if (attributeDataType == AttributeDataType.FLOAT)
        {
            return floatValue;
        } else
        {
            return (0.0F / 0.0F);
        }
    }

    public String getName()
    {
        return name;
    }

    public String getStringValue()
    {
        if (attributeDataType == AttributeDataType.STRING)
        {
            return stringValue;
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean isBooleanAttribute()
    {
        return attributeDataType == AttributeDataType.BOOLEAN;
    }

    public boolean isFloatAttribute()
    {
        return attributeDataType == AttributeDataType.FLOAT;
    }

    public boolean isPersistent()
    {
        return isPersistent && !isAttributeBlacklisted(this);
    }

    public boolean isStringAttribute()
    {
        return attributeDataType == AttributeDataType.STRING;
    }

    public void setBooleanValue(boolean flag)
    {
        stringValue = Boolean.toString(flag);
        floatValue = (0.0F / 0.0F);
        attributeDataType = AttributeDataType.BOOLEAN;
    }

    public void setFloatValue(float f)
    {
        floatValue = f;
        stringValue = null;
        attributeDataType = AttributeDataType.FLOAT;
    }

    public void setPersistent(boolean flag)
    {
        isPersistent = flag;
    }

    public void setStringValue(String s)
    {
        stringValue = s;
        floatValue = (0.0F / 0.0F);
        attributeDataType = AttributeDataType.STRING;
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder("AnalyticAttribute{");
        stringbuilder.append((new StringBuilder()).append("name='").append(name).append("'").toString());
        _cls2..SwitchMap.com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType[attributeDataType.ordinal()];
        JVM INSTR tableswitch 1 4: default 88
    //                   1 88
    //                   2 129
    //                   3 166
    //                   4 203;
           goto _L1 _L1 _L2 _L3 _L4
_L1:
        stringbuilder.append((new StringBuilder()).append(",isPersistent=").append(isPersistent).toString());
        stringbuilder.append("}");
        return stringbuilder.toString();
_L2:
        stringbuilder.append((new StringBuilder()).append(",stringValue='").append(stringValue).append("'").toString());
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append((new StringBuilder()).append(",floatValue='").append(floatValue).append("'").toString());
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append((new StringBuilder()).append(",booleanValue=").append(Boolean.valueOf(stringValue).toString()).toString());
        if (true) goto _L1; else goto _L5
_L5:
    }

    public String valueAsString()
    {
        switch (_cls2..SwitchMap.com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType[attributeDataType.ordinal()])
        {
        default:
            return null;

        case 2: // '\002'
            return stringValue;

        case 3: // '\003'
            return Float.toString(floatValue);

        case 4: // '\004'
            return Boolean.valueOf(getBooleanValue()).toString();
        }
    }

}
