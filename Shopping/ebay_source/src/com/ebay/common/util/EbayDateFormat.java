// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.Date;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public final class EbayDateFormat
{

    private EbayDateFormat()
    {
    }

    public static final String format(Date date)
    {
        return EbayDateUtils.formatIso8601DateTime(date);
    }

    public static final long millisFromISO8601Duration(String s)
        throws SAXException
    {
        long l2 = 0L;
        int j = 0;
        if (s == null || s.length() < 4 || s.charAt(0) != 'P')
        {
            return 0L;
        }
        boolean flag = false;
        int l = 0;
        do
        {
            if (l < s.length())
            {
                char c = s.charAt(l);
                int k = j;
                if (Character.isDigit(c))
                {
                    k = j * 10 + (c - 48);
                }
                long l1 = l2;
                int i = k;
                if (!flag)
                {
                    if (c == 'Y')
                    {
                        l1 = l2 + (long)(k * 365 * 24 * 60 * 60);
                        i = 0;
                    } else
                    if (c == 'M' && !flag)
                    {
                        l1 = l2 + (long)(k * 30 * 24 * 60 * 60);
                        i = 0;
                    } else
                    {
                        l1 = l2;
                        i = k;
                        if (c == 'D')
                        {
                            l1 = l2 + (long)(k * 24 * 60 * 60);
                            i = 0;
                        }
                    }
                }
                if (c == 'T')
                {
                    flag = true;
                }
                l2 = l1;
                j = i;
                if (flag)
                {
                    if (c == 'H')
                    {
                        l2 = l1 + (long)(i * 60 * 60);
                        j = 0;
                    } else
                    if (c == 'M')
                    {
                        l2 = l1 + (long)(i * 60);
                        j = 0;
                    } else
                    {
                        l2 = l1;
                        j = i;
                        if (c == 'S')
                        {
                            l2 = l1 + (long)i;
                            j = 0;
                        }
                    }
                }
                l++;
                continue;
            }
            return 1000L * l2;
        } while (true);
    }

    public static final Date parse(String s)
        throws ParseException
    {
        String s1 = s;
        if (!s.contains("."))
        {
            s1 = s.concat(".000-00:00");
        }
        try
        {
            s = EbayDateUtils.parse(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new Date();
        }
        return s;
    }

    public static final Date parseInventoryDate(String s)
        throws SAXException
    {
        try
        {
            s = EbayDateUtils.parseIso8601Date(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
        return s;
    }

    public static final Date parseSaasDate(String s)
    {
        try
        {
            s = EbayDateUtils.parseIso8601DateTime(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new Date();
        }
        return s;
    }
}
