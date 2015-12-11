// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            SearchEntryBarListener

public class RetailSearchEntryBar extends LinearLayout
{

    private SearchEntryBarListener listener;

    public RetailSearchEntryBar(Context context)
    {
        super(context);
    }

    public RetailSearchEntryBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyevent)
    {
        if (listener != null && listener.onDispatchKeyEventPreIme(keyevent, getContext()))
        {
            return true;
        } else
        {
            return super.dispatchKeyEventPreIme(keyevent);
        }
    }

    public void setListener(SearchEntryBarListener searchentrybarlistener)
    {
        listener = searchentrybarlistener;
    }

    public void updateBackgroundColor(int i)
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_search_plate);
        if (linearlayout != null)
        {
            linearlayout.setBackgroundColor(i);
        }
    }
}
