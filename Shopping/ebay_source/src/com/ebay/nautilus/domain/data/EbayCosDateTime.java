// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.Date;

public class EbayCosDateTime
{

    private transient Date dateValue;
    public String formattedValue;
    public String value;

    public EbayCosDateTime(Date date)
    {
        dateValue = new Date(date.getTime());
        if (dateValue != null)
        {
            value = EbayDateUtils.formatIso8601DateTimeUtc(dateValue);
        }
    }

    public Date getValue()
    {
        if (dateValue == null)
        {
            try
            {
                dateValue = EbayDateUtils.parse(value);
            }
            catch (ParseException parseexception) { }
        }
        return dateValue;
    }
}
