// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent;


public final class SourceApp extends Enum
{

    private static final SourceApp $VALUES[];
    public static final SourceApp EBAY;
    public static final SourceApp MSDK;
    public static final SourceApp PAYPAL;
    public static final SourceApp UNKNOWN;
    private int version;

    private SourceApp(String s, int i, int j)
    {
        super(s, i);
        version = j;
    }

    public static SourceApp valueOf(String s)
    {
        return (SourceApp)Enum.valueOf(com/paypal/android/lib/riskcomponent/SourceApp, s);
    }

    public static SourceApp[] values()
    {
        return (SourceApp[])$VALUES.clone();
    }

    public int getVersion()
    {
        return version;
    }

    static 
    {
        UNKNOWN = new SourceApp("UNKNOWN", 0, 0);
        PAYPAL = new SourceApp("PAYPAL", 1, 10);
        EBAY = new SourceApp("EBAY", 2, 11);
        MSDK = new SourceApp("MSDK", 3, 12);
        $VALUES = (new SourceApp[] {
            UNKNOWN, PAYPAL, EBAY, MSDK
        });
    }
}
