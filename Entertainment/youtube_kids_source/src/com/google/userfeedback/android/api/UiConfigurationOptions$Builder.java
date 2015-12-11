// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;


// Referenced classes of package com.google.userfeedback.android.api:
//            UiConfigurationOptions

public class backgroundColor
{

    private int backgroundColor;
    private int headerBackgroundResourceId;
    private int sectionHeaderBackgroundResourceId;
    private int sectionHeaderFontColor;
    private boolean shouldHideTitleBar;

    public UiConfigurationOptions build()
    {
        UiConfigurationOptions uiconfigurationoptions = new UiConfigurationOptions(null);
        UiConfigurationOptions.access$100(uiconfigurationoptions, shouldHideTitleBar);
        UiConfigurationOptions.access$200(uiconfigurationoptions, headerBackgroundResourceId);
        UiConfigurationOptions.access$300(uiconfigurationoptions, sectionHeaderBackgroundResourceId);
        UiConfigurationOptions.access$400(uiconfigurationoptions, sectionHeaderFontColor);
        UiConfigurationOptions.access$500(uiconfigurationoptions, backgroundColor);
        return uiconfigurationoptions;
    }

    public backgroundColor hideTitleBar(boolean flag)
    {
        shouldHideTitleBar = flag;
        return this;
    }

    public shouldHideTitleBar setBackgroundColor(int i)
    {
        backgroundColor = i;
        return this;
    }

    public backgroundColor setHeaderBackground(int i)
    {
        headerBackgroundResourceId = i;
        return this;
    }

    public headerBackgroundResourceId setSectionHeaderBackground(int i)
    {
        sectionHeaderBackgroundResourceId = i;
        return this;
    }

    public sectionHeaderBackgroundResourceId setSectionHeaderFontColor(int i)
    {
        sectionHeaderFontColor = i;
        return this;
    }

    public ()
    {
        shouldHideTitleBar = false;
        headerBackgroundResourceId = 0;
        sectionHeaderBackgroundResourceId = 0;
        sectionHeaderFontColor = 0;
        backgroundColor = 0;
    }
}
