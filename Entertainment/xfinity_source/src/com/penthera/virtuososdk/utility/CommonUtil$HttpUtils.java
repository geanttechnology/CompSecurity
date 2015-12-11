// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import org.apache.http.Header;

// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class 
{

    public static void dumpHeaders(Header aheader[])
    {
        if (aheader != null)
        {
            int j = aheader.length;
            int i = 0;
            while (i < j) 
            {
                Header header = aheader[i];
                ("HttpUtils", (new StringBuilder(String.valueOf(header.getName()))).append(" : ").append(header.getValue()).toString());
                i++;
            }
        }
    }
}
