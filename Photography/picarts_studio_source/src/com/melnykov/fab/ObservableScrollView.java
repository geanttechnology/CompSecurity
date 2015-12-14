// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

// Referenced classes of package com.melnykov.fab:
//            a

public class ObservableScrollView extends ScrollView
{

    public ObservableScrollView(Context context)
    {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ObservableScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
    }

    public void setOnScrollChangedListener(a a)
    {
    }
}
