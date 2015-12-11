// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.List;
import org.apache.http.NameValuePair;

final class ec
{

    public ec()
    {
    }

    public static String g(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            StringBuilder stringbuilder1 = new StringBuilder();
            NameValuePair namevaluepair = (NameValuePair)list.get(i);
            stringbuilder.append(stringbuilder1.append((new StringBuilder()).append(namevaluepair.getName()).append("=").append(namevaluepair.getValue()).toString().replaceAll(" ", "%20")).append("/").toString());
        }

        return stringbuilder.toString();
    }
}
