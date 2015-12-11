// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.widget.LinearLayout;

// Referenced classes of package com.groupon.util:
//            MultiColumnListAdapter

public class owItemWrapper extends LinearLayout
{

    private final int numUsedCols;
    final MultiColumnListAdapter this$0;

    public int getNumUsedCols()
    {
        return numUsedCols;
    }

    public temWrapper wrapperAt(int i)
    {
        return (temWrapper)getChildAt(i);
    }

    public temWrapper(Context context, int i)
    {
        this$0 = MultiColumnListAdapter.this;
        super(context);
        numUsedCols = i;
        setOrientation(0);
        for (i = 0; i < MultiColumnListAdapter.access$000(MultiColumnListAdapter.this); i++)
        {
            addView(getRowItemWrapper(context));
        }

    }
}
