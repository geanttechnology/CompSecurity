// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.apache.james.mime4j.stream:
//            NameValuePair

public final class RawBody
{

    private final List params;
    private final String value;

    RawBody(String s, List list)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Field value not be null");
        }
        value = s;
        if (list == null)
        {
            list = new ArrayList();
        }
        params = list;
    }

    public List getParams()
    {
        return new ArrayList(params);
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(value);
        stringbuilder.append("; ");
        NameValuePair namevaluepair;
        for (Iterator iterator = params.iterator(); iterator.hasNext(); stringbuilder.append(namevaluepair))
        {
            namevaluepair = (NameValuePair)iterator.next();
            stringbuilder.append("; ");
        }

        return stringbuilder.toString();
    }
}
