// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.view.common.f;
import com.target.ui.view.common.i;

public abstract class BaseRegistryRefineChildView extends LinearLayout
    implements f, i
{

    public BaseRegistryRefineChildView(Context context)
    {
        super(context);
        c();
    }

    public BaseRegistryRefineChildView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public BaseRegistryRefineChildView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        c();
    }

    private void c()
    {
        setOrientation(1);
    }

    protected abstract boolean b();

    public View getView()
    {
        return this;
    }
}
