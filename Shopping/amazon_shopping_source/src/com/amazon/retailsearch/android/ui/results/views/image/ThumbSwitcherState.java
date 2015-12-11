// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;


public class ThumbSwitcherState
{

    private int displayedImage;
    private int requestedImage;

    public ThumbSwitcherState()
    {
        displayedImage = -1;
        requestedImage = -1;
    }

    public int getDisplayedImage()
    {
        return displayedImage;
    }

    public int getRequestedImage()
    {
        return requestedImage;
    }

    public void setDisplayedImage(int i)
    {
        displayedImage = i;
    }

    public void setRequestedImage(int i)
    {
        requestedImage = i;
    }
}
