// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.userpreferences;

import com.amazon.retailsearch.android.ui.results.ViewType;

public interface UserPreferenceChangeListener
{

    public abstract void onViewTypeUpdated(ViewType viewtype);
}
