// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface LocationSuggestionGroup
{

    public abstract String getLabel();

    public abstract List getSuggestions();

    public abstract void setLabel(String s);

    public abstract void setSuggestions(List list);
}
