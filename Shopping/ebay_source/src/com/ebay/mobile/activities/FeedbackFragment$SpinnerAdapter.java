// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            FeedbackFragment

private class this._cls0 extends ArrayAdapter
{

    final FeedbackFragment this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = super.getView(i, null, viewgroup);
        }
        viewgroup = (String)getItem(i);
        TextView textview = (TextView)view.findViewById(0x1020014);
        if (textview != null)
        {
            textview.setText(viewgroup);
        }
        return view;
    }

    public (Context context, int i, List list)
    {
        this$0 = FeedbackFragment.this;
        super(context, i, list);
    }
}
