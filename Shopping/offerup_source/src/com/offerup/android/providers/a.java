// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.providers;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.SearchRecentSuggestions;

public final class a extends SearchRecentSuggestions
{

    public a(Context context, String s, int i)
    {
        super(context, s, 1);
    }

    protected final void truncateHistory(ContentResolver contentresolver, int i)
    {
        super.truncateHistory(contentresolver, 25);
    }
}
