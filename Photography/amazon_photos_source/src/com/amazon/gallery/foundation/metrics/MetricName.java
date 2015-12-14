// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;


public class MetricName
{

    private final String component;
    private final String domain;
    private final String event;
    private final String pageName;

    public MetricName(String s, String s1, String s2, String s3)
    {
        domain = s;
        component = s1;
        event = s2;
        if (s3 != null)
        {
            s1 = s3;
        }
        pageName = s1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MetricName)obj;
            if (!component.equals(((MetricName) (obj)).component))
            {
                return false;
            }
            if (!domain.equals(((MetricName) (obj)).domain))
            {
                return false;
            }
            if (!event.equals(((MetricName) (obj)).event))
            {
                return false;
            }
            if (!pageName.equals(((MetricName) (obj)).pageName))
            {
                return false;
            }
        }
        return true;
    }

    public String getComponent()
    {
        return component;
    }

    public String getEvent()
    {
        return event;
    }

    public String getPageName()
    {
        return pageName;
    }

    public int hashCode()
    {
        return ((domain.hashCode() * 31 + component.hashCode()) * 31 + event.hashCode()) * 31 + pageName.hashCode();
    }

    public String toString()
    {
        return domain + "." + component + "." + event + "." + pageName;
    }
}
