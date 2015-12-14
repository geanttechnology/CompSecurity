// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NoticeGridItemChild extends RelativeLayout
{

    protected final Context a;
    protected TextView b;
    protected TextView c;

    public NoticeGridItemChild(Context context)
    {
        super(context);
        a = context;
        a();
    }

    public NoticeGridItemChild(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = context;
        a();
    }

    protected void a()
    {
        View view = ((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f030158, this);
        b = (TextView)view.findViewById(0x7f0c0629);
        c = (TextView)view.findViewById(0x7f0c0628);
    }

    public void a(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        b.setVisibility(i);
    }

    public void setActionName(String s)
    {
        s = new SpannableString(s);
        s.setSpan(new UnderlineSpan(), 0, s.length(), 0);
        b.setText(s);
    }

    public void setActionOnclickListener(android.view.View.OnClickListener onclicklistener)
    {
        b.setOnClickListener(new android.view.View.OnClickListener(onclicklistener) {

            final android.view.View.OnClickListener a;
            final NoticeGridItemChild b;

            public void onClick(View view)
            {
                a.onClick(b);
            }

            
            {
                b = NoticeGridItemChild.this;
                a = onclicklistener;
                super();
            }
        });
    }

    public void setFeatureDescription(String s)
    {
        c.setText(s);
    }
}
