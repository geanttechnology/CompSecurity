// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results;


public final class ResultsInfoBarWidgetType extends Enum
{

    private static final ResultsInfoBarWidgetType $VALUES[];
    public static final ResultsInfoBarWidgetType CUSTOM_VIEW;
    public static final ResultsInfoBarWidgetType DEFAULT_WIDGET;
    public static final ResultsInfoBarWidgetType STYLED_LABEL;

    private ResultsInfoBarWidgetType(String s, int i)
    {
        super(s, i);
    }

    public static ResultsInfoBarWidgetType valueOf(String s)
    {
        return (ResultsInfoBarWidgetType)Enum.valueOf(com/amazon/retailsearch/android/api/display/results/ResultsInfoBarWidgetType, s);
    }

    public static ResultsInfoBarWidgetType[] values()
    {
        return (ResultsInfoBarWidgetType[])$VALUES.clone();
    }

    static 
    {
        DEFAULT_WIDGET = new ResultsInfoBarWidgetType("DEFAULT_WIDGET", 0);
        STYLED_LABEL = new ResultsInfoBarWidgetType("STYLED_LABEL", 1);
        CUSTOM_VIEW = new ResultsInfoBarWidgetType("CUSTOM_VIEW", 2);
        $VALUES = (new ResultsInfoBarWidgetType[] {
            DEFAULT_WIDGET, STYLED_LABEL, CUSTOM_VIEW
        });
    }
}
