// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;


public class AnalyticAttribute
{

    public static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
    public static final String APP_ID_ATTRIBUTE = "appId";
    public static final String APP_NAME_ATTRIBUTE = "appName";
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
    private float floatValue;
    private boolean isPersistent;
    private boolean isStringValue;
    private String name;
    private String stringValue;

    public AnalyticAttribute(AnalyticAttribute analyticattribute)
    {
        name = analyticattribute.name;
        floatValue = analyticattribute.floatValue;
        stringValue = analyticattribute.stringValue;
        isStringValue = analyticattribute.isStringValue;
        isPersistent = analyticattribute.isPersistent;
    }

    public AnalyticAttribute(String s, float f)
    {
        this(s, f, true);
    }

    public AnalyticAttribute(String s, float f, boolean flag)
    {
        name = s;
        floatValue = f;
        isStringValue = false;
        stringValue = null;
        isPersistent = flag;
    }

    public AnalyticAttribute(String s, String s1)
    {
        this(s, s1, true);
    }

    public AnalyticAttribute(String s, String s1, boolean flag)
    {
        name = s;
        stringValue = s1;
        isStringValue = true;
        floatValue = (0.0F / 0.0F);
        isPersistent = flag;
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

    public float getFloatValue()
    {
        return floatValue;
    }

    public String getName()
    {
        return name;
    }

    public String getStringValue()
    {
        return stringValue;
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean isPersistent()
    {
        return isPersistent;
    }

    public boolean isStringAttribute()
    {
        return isStringValue;
    }

    public void setFloatValue(float f)
    {
        floatValue = f;
        stringValue = null;
        isStringValue = false;
    }

    public void setPersistent(boolean flag)
    {
        isPersistent = flag;
    }

    public void setStringValue(String s)
    {
        stringValue = s;
        floatValue = (0.0F / 0.0F);
        isStringValue = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("AnalyticAttribute{name='").append(name).append('\'');
        String s;
        if (isStringAttribute())
        {
            s = (new StringBuilder()).append(", stringValue='").append(stringValue).append('\'').toString();
        } else
        {
            s = (new StringBuilder()).append(", floatValue=").append(floatValue).toString();
        }
        return stringbuilder.append(s).append(", isPersistent=").append(isPersistent).append('}').toString();
    }
}
