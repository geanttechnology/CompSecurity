// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.util;


public class DescriptionConverter
{

    public static final int MAX_LENGTH_FOR_DISPLAY_EVENT = 250;
    private static final String patterns[] = {
        "\r", "", "\n", "", "( )+", " ", "(?i)<( )*head([^>])*>", "<head>", "(?i)(<( )*(/)( )*head( )*>)", "</head>", 
        "(<head>).*(</head>)", "", "(?i)<( )*script([^>])*>", "<script>", "(?i)(<( )*(/)( )*script( )*>)", "</script>", "(<script>).*?(</script>)", "", "(?i)<( )*xml([^>])*>", "<xml>", 
        "(?i)(<( )*(/)( )*xml( )*>)", "</xml>", "(<xml>).*?(</xml>)", "", "(?i)<( )*style([^>])*>", "<style>", "(?i)(<( )*(/)( )*style( )*>)", "</style>", "(<style>).*?(</style>)", "", 
        "(?i)<( )*td([^>])*>", "\t", "(?i)<( )*br( )*>", "\n", "(?i)<( )*li( )*>", "\n", "(?i)<( )*div([^>])*>", "\n", "(?i)<( )*tr([^>])*>", "\n", 
        "(?i)<( )*p([^>])*>", "\n\n", "<[^>]*>", "", "(?i)&bull;", " * ", "(?i)&lsaquo;", "<", "(?i)&rsaquo;", ">", 
        "(?i)&trade;", "(tm)", "(?i)&frasl;", "/", "(?i)&lt;", "<", "(?i)&gt;", ">", "(?i)&copy;", "(c)", 
        "(?i)&reg;", "(r)", "(?i)&amp;", "&", "(?i)&nbsp;", " ", "(?i)&(.{2,6});", "", "(\n)( )+(\n)", "\n\n", 
        "(\t)( )+(\t)", "\t\t", "(\t)( )+(\n)", "\t\n", "(\n)( )+(\t)", "\n\t", "(\n)(\t)+(\n)", "\n\n", "(\n)(\t)+", "\n\t", 
        "\n{3,}", "\n\n"
    };

    public DescriptionConverter()
    {
    }

    public static String toHtml(String s)
    {
        if (s == null)
        {
            return "";
        } else
        {
            return s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "\n<br>").replaceAll("\r", "\r<br>");
        }
    }

    public static String toPlainText(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L4:
        return s1;
_L2:
        int i = 0;
        do
        {
            s1 = s;
            if (i >= patterns.length - 1)
            {
                continue;
            }
            s = s.replaceAll(patterns[i], patterns[i + 1]);
            i += 2;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
