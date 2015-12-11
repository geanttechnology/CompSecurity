// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AuthKeys
{

    private String consumerKey;
    private String consumerSecret;
    private String flags;
    private String greetingName;
    private String omnitureTrackingKey;

    public AuthKeys()
    {
    }

    public String getConsumerKey()
    {
        return consumerKey;
    }

    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    public String getFlags()
    {
        return flags;
    }

    public String getGreetingName()
    {
        return greetingName;
    }

    public String getOmnitureTrackingKey()
    {
        return omnitureTrackingKey;
    }

    public void setConsumerKey(String s)
    {
        consumerKey = s;
    }

    public void setConsumerSecret(String s)
    {
        consumerSecret = s;
    }

    public void setFlags(String s)
    {
        flags = s;
    }

    public void setGreetingName(String s)
    {
        greetingName = s;
    }

    public void setOmnitureTrackingKey(String s)
    {
        omnitureTrackingKey = s;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("consumerKey", consumerKey).append("consumerSecret", consumerSecret).append("greetingName", greetingName).append("omnitureTrackingKey", omnitureTrackingKey).append("flags", flags).toString();
    }
}
