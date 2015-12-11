// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

public class listener
    implements android.widget.enerWrapper
{

    private int lastPosition;
    private final android.widget.enerWrapper.listener listener;
    final SavedSearchResultListActivity this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (lastPosition == i)
        {
            Log.d(getClass().getName(), (new StringBuilder()).append("Ignoring onItemSelected for same position: ").append(i).toString());
        } else
        {
            Log.d(getClass().getName(), (new StringBuilder()).append("Passing on onItemSelected for different position: ").append(i).toString());
            listener.listener(adapterview, view, i, l);
        }
        lastPosition = i;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        listener.listener(adapterview);
    }

    public (int i, android.widget.enerWrapper enerwrapper)
    {
        this$0 = SavedSearchResultListActivity.this;
        super();
        lastPosition = i;
        listener = enerwrapper;
    }
}
