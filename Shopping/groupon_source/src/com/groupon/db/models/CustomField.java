// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.util.QuotedStringTokenizer;
import java.util.ArrayList;

// Referenced classes of package com.groupon.db.models:
//            Option

public class CustomField
{

    public String label;
    public Option parentOption;
    public String possibleValues;
    public Long primaryKey;
    public boolean required;
    public String type;

    public CustomField()
    {
        label = "";
        type = "";
        possibleValues = "";
        required = false;
    }

    public String[] decodeStrings(String s, String s1)
    {
        if (s1 == null)
        {
            return (new String[] {
                s
            });
        }
        if (s == null)
        {
            return new String[0];
        }
        s = new QuotedStringTokenizer(s, s1);
        s1 = new ArrayList();
        for (; s.hasMoreTokens(); s1.add(s.nextToken())) { }
        return (String[])s1.toArray(new String[s1.size()]);
    }

    public String[] getPossibleValuesArray()
    {
        return decodeStrings(possibleValues, ",");
    }
}
