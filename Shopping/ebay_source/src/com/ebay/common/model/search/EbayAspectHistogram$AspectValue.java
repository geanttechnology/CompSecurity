// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;


// Referenced classes of package com.ebay.common.model.search:
//            EbayAspectHistogram

public static final class serviceValue
    implements Cloneable
{

    public boolean checked;
    public int count;
    public String serviceValue;
    public String value;

    public serviceValue clone()
    {
        serviceValue servicevalue;
        try
        {
            servicevalue = (serviceValue)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return servicevalue;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof clone))
        {
            obj = (clone)obj;
            if ((value != null ? value.equals(((value) (obj)).value) : ((value) (obj)).value == null) && (serviceValue != null ? serviceValue.equals(((serviceValue) (obj)).serviceValue) : ((serviceValue) (obj)).serviceValue == null) && (count == ((count) (obj)).count && checked == ((checked) (obj)).checked))
            {
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        if (count != 0)
        {
            return (new StringBuilder()).append(value).append(" (").append(count).append(')').toString();
        } else
        {
            return value;
        }
    }

    public ()
    {
        value = null;
        count = 0;
        checked = false;
        serviceValue = null;
    }
}
