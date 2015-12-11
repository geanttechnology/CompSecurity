// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.text.StaticLayout;
import android.util.AttributeSet;

// Referenced classes of package com.groupon.view:
//            AutoResizeTextView

public class AutoResizeTextViewWidth extends AutoResizeTextView
{

    public AutoResizeTextViewWidth(Context context)
    {
        this(context, null);
    }

    public AutoResizeTextViewWidth(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AutoResizeTextViewWidth(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected int getLayoutSize(StaticLayout staticlayout)
    {
        return staticlayout.getWidth();
    }

    protected int getSize(int i, int j)
    {
        return j;
    }
}
