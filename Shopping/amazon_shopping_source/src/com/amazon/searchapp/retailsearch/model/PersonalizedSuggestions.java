// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface PersonalizedSuggestions
{

    public abstract String getRequestId();

    public abstract List getSearchedText();

    public abstract void setSearchedText(List list);
}
