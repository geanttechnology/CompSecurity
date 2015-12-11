// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Html;

public class bs
{

    private static final String a = System.getProperty("line.separator");

    public static String a(String s, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null && !s.isEmpty())
        {
            stringbuilder.append((new StringBuilder()).append(s).append(a).append(a).toString());
        }
        if (as != null && as.length != 0)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                s = as[i];
                s = Html.fromHtml((new StringBuilder()).append("&#8226 ").append(s).toString());
                stringbuilder.append((new StringBuilder()).append("\t").append(s).append(a).append("<br/>").toString());
            }

        }
        return stringbuilder.toString();
    }

}
