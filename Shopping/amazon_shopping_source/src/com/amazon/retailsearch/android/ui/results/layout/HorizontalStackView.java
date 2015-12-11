// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.amazon.retailsearch.android.ui.HorizontalListView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackView

public class HorizontalStackView extends HorizontalListView
    implements StackView
{

    private int itemWidth;

    public HorizontalStackView(Context context)
    {
        super(context);
        init();
    }

    public HorizontalStackView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public HorizontalStackView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        itemWidth = getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_split_view_port_item_width);
    }

    protected int getItemWidth()
    {
        return itemWidth;
    }

    public View getView()
    {
        return this;
    }
}
