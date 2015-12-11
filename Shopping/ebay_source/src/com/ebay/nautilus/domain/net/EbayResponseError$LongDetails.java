// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponseError

public static class parameters extends EbayResponseError
{
    public static class Parameter
    {

        public String name;
        public String value;

        public Parameter()
        {
            name = null;
            value = null;
        }
    }


    public String domain;
    public String exceptionId;
    public ArrayList parameters;
    public String subdomain;

    public final String categoryDescription()
    {
        switch (category)
        {
        default:
            return null;

        case 1: // '\001'
            return "Application";

        case 2: // '\002'
            return "Request";

        case 3: // '\003'
            return "System";
        }
    }

    public String getDomain()
    {
        return domain;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        if (!TextUtils.isEmpty(domain))
        {
            stringbuilder.append(" (").append(domain);
            if (!TextUtils.isEmpty(subdomain))
            {
                stringbuilder.append(" - ").append(subdomain);
            }
            stringbuilder.append(')');
        }
        if (!TextUtils.isEmpty(exceptionId))
        {
            stringbuilder.append(" EX: ").append(exceptionId);
        }
        return stringbuilder.toString();
    }

    public Parameter.value()
    {
        domain = null;
        subdomain = null;
        exceptionId = null;
        parameters = null;
    }
}
