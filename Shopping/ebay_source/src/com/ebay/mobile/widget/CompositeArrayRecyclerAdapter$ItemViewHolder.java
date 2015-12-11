// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.widget:
//            CompositeArrayRecyclerAdapter

public static class textView extends textView
{

    public final TextView textView;

    final void bindView(int i, Object obj)
    {
        onBindView(i, obj);
    }

    protected void onBindView(int i, Object obj)
    {
        if (obj instanceof CharSequence)
        {
            textView.setText((CharSequence)obj);
            return;
        } else
        {
            textView.setText(obj.toString());
            return;
        }
    }

    public I(View view, TextView textview)
    {
        super(view);
        textView = textview;
    }
}
