// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;


public class BarcodeScanUtil
{

    private static final String EAN = "EAN:";
    private static final String UPC = "UPC:";

    public BarcodeScanUtil()
    {
    }

    public static boolean isProductQuery(String s)
    {
        return s != null && s.length() > 4 && (s.startsWith("EAN:") || s.startsWith("UPC:"));
    }
}
