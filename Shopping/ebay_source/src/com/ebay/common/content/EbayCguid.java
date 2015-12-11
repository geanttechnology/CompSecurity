// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.Date;

public class EbayCguid
{

    private final String cguidStr;
    private final String expiration;

    public EbayCguid(String s, String s1)
    {
        cguidStr = s;
        expiration = s1;
    }

    public String getExpirationDate()
    {
        return expiration;
    }

    public boolean isExpired()
    {
        Date date;
        Date date1;
        boolean flag;
        flag = true;
        date1 = new Date();
        date = date1;
        Date date2 = EbayDateUtils.parseIso8601DateTime(expiration);
        date = date2;
_L2:
        if (date.after(date1))
        {
            flag = false;
        }
        return flag;
        ParseException parseexception;
        parseexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Integer toInt()
    {
        int i;
        try
        {
            i = Integer.parseInt(cguidStr);
        }
        catch (NumberFormatException numberformatexception)
        {
            return null;
        }
        return Integer.valueOf(i);
    }

    public String toString()
    {
        if (cguidStr == null)
        {
            return "";
        } else
        {
            return cguidStr;
        }
    }
}
