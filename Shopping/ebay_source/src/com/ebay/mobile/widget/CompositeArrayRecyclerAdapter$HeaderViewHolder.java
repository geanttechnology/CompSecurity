// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.widget:
//            CompositeArrayRecyclerAdapter

public static class textView extends textView
{

    public final TextView textView;

    final void bindView(int i, Object obj)
    {
        onBindView(i, (CharSequence)obj);
    }

    protected void onBindView(int i, CharSequence charsequence)
    {
        textView.setText(charsequence);
    }

    public (View view)
    {
        super(view);
        if (view instanceof TextView)
        {
            textView = (TextView)view;
            return;
        }
        try
        {
            textView = (TextView)view.findViewById(0x1020014);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e("CompositeArrayRVAdapter", "You must supply a resource with ID android.R.id.text1 for a TextView");
        }
        throw new IllegalStateException("CompositeArrayRecyclerAdapter requires the resource ID android.R.id.text1 to be a TextView", view);
    }
}
