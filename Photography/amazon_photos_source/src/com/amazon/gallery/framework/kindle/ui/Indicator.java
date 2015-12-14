// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.view.View;

public abstract class Indicator
{

    private boolean enabled;

    public Indicator()
    {
        enabled = true;
    }

    public abstract View getView();

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean flag)
    {
        enabled = flag;
        View view = getView();
        if (!flag && view.getVisibility() != 8)
        {
            view.setVisibility(8);
        }
    }
}
