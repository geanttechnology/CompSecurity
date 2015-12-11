// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.externalwidgets;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidgetStateAccessor;

public class ExternalWidgetState
    implements ExternalSearchWidgetStateAccessor
{

    private String store;

    public ExternalWidgetState()
    {
    }

    public String getStore()
    {
        return store;
    }

    public boolean isValid()
    {
        return !TextUtils.isEmpty(store);
    }

    public void setStore(String s)
    {
        store = s;
    }
}
