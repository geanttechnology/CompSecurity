// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.content.SearchRecentSuggestionsProvider;

public class RecentLocationSearchProvider extends SearchRecentSuggestionsProvider
{

    public static final String AUTHORITY = "com.groupon.recent.locations.authority";
    private static final String AUTHORITY_SUFFIX = ".recent.locations.authority";
    public static final int MODE = 3;

    public RecentLocationSearchProvider()
    {
    }

    public boolean onCreate()
    {
        setupSuggestions("com.groupon.recent.locations.authority", 3);
        return super.onCreate();
    }
}
