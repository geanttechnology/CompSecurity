// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class c extends RelativeLayout
{

    private TextView a;
    private ImageView b;
    private int c;
    private boolean d;

    public c(Context context)
    {
        super(context);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f04006b, this);
        a = (TextView)findViewById(0x7f10015b);
        b = (ImageView)findViewById(0x7f10015c);
    }

    public int getId()
    {
        return c;
    }

    public boolean isSelected()
    {
        return d;
    }

    public void setId(int i)
    {
        c = i;
    }

    public void setSelected(boolean flag)
    {
        d = flag;
        ImageView imageview = b;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        imageview.setVisibility(i);
    }

    public void setTitle(int i)
    {
        a.setText(i);
    }

    public void setTitle(String s)
    {
        a.setText(s);
    }
}
