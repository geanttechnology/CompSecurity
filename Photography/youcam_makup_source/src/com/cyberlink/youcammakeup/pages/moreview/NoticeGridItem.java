// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NoticeGridItem extends RelativeLayout
{

    protected final Context a;
    private ImageView b;
    private ImageView c;
    private View d;
    private TextView e;
    private TextView f;
    private TextView g;

    public NoticeGridItem(Context context)
    {
        super(context);
        a = context;
        a();
    }

    public NoticeGridItem(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = context;
        a();
    }

    protected void a()
    {
        View view = ((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f030157, this);
        d = view.findViewById(0x7f0c0621);
        b = (ImageView)view.findViewById(0x7f0c0624);
        c = (ImageView)view.findViewById(0x7f0c0623);
        e = (TextView)view.findViewById(0x7f0c0625);
        f = (TextView)view.findViewById(0x7f0c0626);
        g = (TextView)view.findViewById(0x7f0c0627);
    }

    public void b()
    {
        b.setVisibility(0);
        c.setVisibility(8);
    }

    public void c()
    {
        b.setVisibility(8);
        c.setVisibility(0);
    }

    public void setDate(String s)
    {
        e.setText(s);
    }

    public void setFeature(String s)
    {
        g.setText(s);
    }

    public void setNewIconVisibility(int i)
    {
        d.setVisibility(i);
    }

    public void setVersion(String s)
    {
        f.setText(s);
    }
}
