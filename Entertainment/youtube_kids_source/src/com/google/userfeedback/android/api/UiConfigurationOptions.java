// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;


public class UiConfigurationOptions
{

    private int backgroundColor;
    private int headerBackgroundResourceId;
    private boolean hideTitleBar;
    private int sectionHeaderBackgroundResourceId;
    private int sectionHeaderFontColor;

    private UiConfigurationOptions()
    {
    }

    UiConfigurationOptions(_cls1 _pcls1)
    {
        this();
    }

    private void setBackgroundColor(int i)
    {
        backgroundColor = i;
    }

    private void setHeaderBackgroundResourceId(int i)
    {
        headerBackgroundResourceId = i;
    }

    private void setHideTitleBar(boolean flag)
    {
        hideTitleBar = flag;
    }

    private void setSectionHeaderBackgroundResourceId(int i)
    {
        sectionHeaderBackgroundResourceId = i;
    }

    private void setSectionHeaderFontColor(int i)
    {
        sectionHeaderFontColor = i;
    }

    public int getBackgroundColor()
    {
        return backgroundColor;
    }

    public int getHeaderBackgroundResourceId()
    {
        if (headerBackgroundResourceId != 0)
        {
            return headerBackgroundResourceId;
        } else
        {
            return R.color.gf_header_background;
        }
    }

    public boolean getHideTitleBar()
    {
        return hideTitleBar;
    }

    public int getSectionHeaderBackgroundResourceId()
    {
        if (sectionHeaderBackgroundResourceId != 0)
        {
            return sectionHeaderBackgroundResourceId;
        } else
        {
            return 0x10800a5;
        }
    }

    public int getSectionHeaderFontColor()
    {
        return sectionHeaderFontColor;
    }





}
