// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import java.util.List;

public interface ISuggestionDataProvider
{

    public abstract boolean deletePastSearches(String s, String s1);

    public abstract List getPastSearches(String s, String s1, boolean flag);

    public abstract List getSearchSuggestions(String s, String s1);

    public abstract List getSearchSuggestions(String s, String s1, boolean flag);

    public abstract List getSuggestions(String s);

    public abstract List getSuggestions(String s, String s1);

    public abstract List getSuggestions(String s, String s1, boolean flag);

    public abstract List getSuggestions(String s, String s1, boolean flag, boolean flag1);

    public abstract List getSuggestions(String s, boolean flag);
}
