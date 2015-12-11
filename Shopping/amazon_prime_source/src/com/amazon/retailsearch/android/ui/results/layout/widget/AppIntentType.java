// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;


public final class AppIntentType extends Enum
{

    private static final AppIntentType $VALUES[];
    public static final AppIntentType FILTER_BY_ID;
    private String value;

    private AppIntentType(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static AppIntentType fromTypeString(String s)
    {
        if (FILTER_BY_ID.getValue().equals(s))
        {
            return FILTER_BY_ID;
        } else
        {
            return null;
        }
    }

    public static AppIntentType valueOf(String s)
    {
        return (AppIntentType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/layout/widget/AppIntentType, s);
    }

    public static AppIntentType[] values()
    {
        return (AppIntentType[])$VALUES.clone();
    }

    public String getValue()
    {
        return value;
    }

    static 
    {
        FILTER_BY_ID = new AppIntentType("FILTER_BY_ID", 0, "filterById");
        $VALUES = (new AppIntentType[] {
            FILTER_BY_ID
        });
    }
}
