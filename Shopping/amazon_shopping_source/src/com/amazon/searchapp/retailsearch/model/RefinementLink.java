// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface RefinementLink
{

    public abstract boolean getAvailability();

    public abstract String getBrowseUrl();

    public abstract List getCategories();

    public abstract long getCount();

    public abstract String getId();

    public abstract boolean getSelected();

    public abstract List getStyleText();

    public abstract String getText();

    public abstract String getUrl();
}
