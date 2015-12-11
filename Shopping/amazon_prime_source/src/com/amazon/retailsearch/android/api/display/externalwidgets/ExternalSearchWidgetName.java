// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.externalwidgets;


public final class ExternalSearchWidgetName extends Enum
{

    private static final ExternalSearchWidgetName $VALUES[];
    public static final ExternalSearchWidgetName FRESH_NAV_BAR;

    private ExternalSearchWidgetName(String s, int i)
    {
        super(s, i);
    }

    public static ExternalSearchWidgetName valueOf(String s)
    {
        return (ExternalSearchWidgetName)Enum.valueOf(com/amazon/retailsearch/android/api/display/externalwidgets/ExternalSearchWidgetName, s);
    }

    public static ExternalSearchWidgetName[] values()
    {
        return (ExternalSearchWidgetName[])$VALUES.clone();
    }

    static 
    {
        FRESH_NAV_BAR = new ExternalSearchWidgetName("FRESH_NAV_BAR", 0);
        $VALUES = (new ExternalSearchWidgetName[] {
            FRESH_NAV_BAR
        });
    }
}
