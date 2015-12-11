// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;
import java.util.Locale;

public class ErrorMessageDetails extends com.ebay.nautilus.domain.net.EbayResponseError.LongDetails
{

    public String altLongMessage;
    public String categoryCode;
    public String errorName;
    public String longMessage;
    public List parameters;
    public String severityCode;

    public ErrorMessageDetails()
    {
    }

    public String getCategory()
    {
        if (categoryCode != null)
        {
            return categoryCode.toLowerCase(Locale.US);
        } else
        {
            return null;
        }
    }

    public int getCategoryCode()
    {
        String s = categoryCode.toLowerCase(Locale.US);
        if (!"application".equals(s)) goto _L2; else goto _L1
_L1:
        category = 1;
_L4:
        return category;
_L2:
        if ("request".equals(s))
        {
            category = 2;
        } else
        if ("system".equals(s))
        {
            category = 3;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        if (!TextUtils.isEmpty(longMessage))
        {
            return longMessage;
        }
        if (!TextUtils.isEmpty(altLongMessage))
        {
            return altLongMessage;
        } else
        {
            return super.getLongMessage(ebaycontext);
        }
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        switch (getSeverityCode())
        {
        default:
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;

        case 2: // '\002'
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;

        case 1: // '\001'
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        }
    }

    public int getSeverityCode()
    {
        if (TextUtils.isEmpty(severityCode)) goto _L2; else goto _L1
_L1:
        String s;
        byte byte0;
        s = severityCode.toLowerCase(Locale.US);
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 52
    //                   96784904: 81
    //                   1124446108: 95;
           goto _L3 _L4 _L5
_L3:
        byte0;
        JVM INSTR tableswitch 0 1: default 76
    //                   0 109
    //                   1 117;
           goto _L2 _L6 _L7
_L2:
        return severity;
_L4:
        if (s.equals("error"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (s.equals("warning"))
        {
            byte0 = 1;
        }
          goto _L3
_L6:
        severity = 1;
          goto _L2
_L7:
        severity = 2;
          goto _L2
    }
}
