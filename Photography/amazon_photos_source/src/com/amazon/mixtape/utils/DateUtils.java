// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;

import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.Node;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.amazon.mixtape.utils:
//            ISO8601

public class DateUtils
{

    private static final Date NO_DATE_LOWER = new Date(0xfffffffffad9a401L);
    private static final Date NO_DATE_UPPER = new Date(0x5265bffL);

    private static String adjustDateFromLocalToUTC(String s)
        throws ParseException
    {
        long l = ISO8601.getUnixTimestampFromString(s);
        return ISO8601.getUTCString(new Date(l - (long)TimeZone.getDefault().getOffset(l)));
    }

    public static String getSortDate(Node node)
    {
        if (node.getContentProperties() != null) goto _L2; else goto _L1
_L1:
        String s = "0000-00-00T00:00:00.000Z";
_L4:
        return s;
_L2:
        String s1;
        Date date;
        try
        {
            s1 = node.getContentProperties().getContentDate();
            s = node.getCreatedDate();
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            return "0000-00-00T00:00:00.000Z";
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if ("".equals(s1) || s1.length() <= 4 || s1.charAt(4) != '-')
        {
            break MISSING_BLOCK_LABEL_98;
        }
        date = ISO8601.getDateFromString(s1);
        if (date.after(NO_DATE_LOWER) && date.before(NO_DATE_UPPER))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        s = s1;
        if (node.getContentProperties().getImage() == null) goto _L4; else goto _L3
_L3:
        return adjustDateFromLocalToUTC(s1);
        ISO8601.getDateFromString(s);
        return s;
    }

}
