// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmThemedSearchActivity

private class this._cls0 extends ArrayAdapter
{

    final RtmThemedSearchActivity this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        viewgroup = (TextView)view.findViewById(0x1020014);
        viewgroup.setTypeface(Typeface.DEFAULT_BOLD);
        viewgroup.setText((CharSequence)RtmThemedSearchActivity.access$100(RtmThemedSearchActivity.this).get(i));
        return view;
    }

    public I(Context context, int i, int j, List list)
    {
        this$0 = RtmThemedSearchActivity.this;
        super(context, i, j, list);
    }
}
