// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class TZOrderView extends View
{

    private int zorder;

    public TZOrderView(Context context)
    {
        super(context);
    }

    public TZOrderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getZorder()
    {
        return zorder;
    }

    public void setZorder(int i)
    {
        zorder = i;
    }
}
