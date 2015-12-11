// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackView

public class VerticalStackView extends ListView
    implements StackView
{

    public VerticalStackView(Context context)
    {
        super(context);
        init();
    }

    public VerticalStackView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public VerticalStackView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
    }

    public View getView()
    {
        return this;
    }
}
