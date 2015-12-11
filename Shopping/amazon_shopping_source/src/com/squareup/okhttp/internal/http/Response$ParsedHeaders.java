// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Response, Headers, HttpDate

private static class <init>
{

    Date lastModified;
    private Set varyFields;


    private (Headers headers)
    {
        varyFields = Collections.emptySet();
        int i = 0;
        while (i < headers.size()) 
        {
            String s = headers.name(i);
            String s1 = headers.value(i);
            if ("Last-Modified".equalsIgnoreCase(s))
            {
                lastModified = HttpDate.parse(s1);
            } else
            if ("Vary".equalsIgnoreCase(s))
            {
                if (varyFields.isEmpty())
                {
                    varyFields = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                String as[] = s1.split(",");
                int k = as.length;
                int j = 0;
                while (j < k) 
                {
                    String s2 = as[j];
                    varyFields.add(s2.trim());
                    j++;
                }
            }
            i++;
        }
    }

    varyFields(Headers headers, varyFields varyfields)
    {
        this(headers);
    }
}
