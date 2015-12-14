// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class b extends FrameLayout
    implements Checkable
{

    protected View a;

    public b(Context context)
    {
        super(context);
        a(context);
    }

    protected void a(Context context)
    {
        a = (ViewGroup)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030204, this);
        if (!isInEditMode());
    }

    public boolean isChecked()
    {
        return isSelected();
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void toggle()
    {
        boolean flag;
        if (!isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setSelected(flag);
    }
}
