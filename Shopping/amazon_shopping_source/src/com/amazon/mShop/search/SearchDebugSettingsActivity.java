// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.os.Bundle;
import android.widget.ScrollView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.retailsearch.android.api.debug.SearchDebugView;

public class SearchDebugSettingsActivity extends AmazonActivity
{

    public SearchDebugSettingsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new ScrollView(this);
        bundle.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        bundle.addView(new SearchDebugView(this));
        setRootView(bundle);
    }
}
