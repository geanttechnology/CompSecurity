// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.editorialreview;

import gu;
import java.io.Serializable;

public class EditorialReview
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String renderedHtml;

    public EditorialReview()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getRenderedHtml()
    {
        return renderedHtml;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setRenderedHtml(String s)
    {
        renderedHtml = s;
    }
}
