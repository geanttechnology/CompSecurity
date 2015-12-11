// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

// Referenced classes of package com.smule.android.console:
//            j

public class ConsoleScrollView extends ScrollView
{

    private j a;

    public ConsoleScrollView(Context context)
    {
        super(context);
        a = null;
    }

    public ConsoleScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
    }

    public ConsoleScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
    }

    protected void onScrollChanged(int i, int k, int l, int i1)
    {
        super.onScrollChanged(i, k, l, i1);
        if (a != null)
        {
            a.a(i, k, l, i1);
        }
    }

    public void setScrollViewListener(j j1)
    {
        a = j1;
    }
}
