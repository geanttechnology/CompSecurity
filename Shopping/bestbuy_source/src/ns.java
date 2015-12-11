// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Html;

public class ns
{

    public static String a(String s)
    {
        return Html.fromHtml(s.replace("\\u00BB", "&#187")).toString();
    }
}
