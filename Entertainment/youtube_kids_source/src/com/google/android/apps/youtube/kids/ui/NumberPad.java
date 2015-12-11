// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import afn;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class NumberPad extends GridLayout
    implements android.view.View.OnClickListener
{

    public afn a;
    private View b[];

    public NumberPad(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        setColumnCount(3);
        setRowCount(4);
        b = new View[10];
        for (int i = 1; i < 10; i++)
        {
            attributeset = a(context, i);
            b[i] = attributeset;
            addView(attributeset);
        }

        context = a(context, 0);
        b[0] = context;
        attributeset = new android.widget.GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(1));
        attributeset.width = (int)getResources().getDimension(0x7f0a0135);
        attributeset.height = (int)getResources().getDimension(0x7f0a0136);
        attributeset.setMargins((int)getResources().getDimension(0x7f0a0133), (int)getResources().getDimension(0x7f0a0134), (int)getResources().getDimension(0x7f0a0133), (int)getResources().getDimension(0x7f0a0134));
        addView(context, attributeset);
    }

    NumberPad(Context context, View aview[])
    {
        super(context);
        a = null;
        b = aview;
        int j = aview.length;
        for (int i = 0; i < j; i++)
        {
            aview[i].setOnClickListener(this);
        }

    }

    private View a(Context context, int i)
    {
        context = (TextView)LayoutInflater.from(context).inflate(0x7f040049, this, false);
        context.setOnClickListener(this);
        context.setText(Integer.toString(i));
        context.setTag(0x7f100020, Integer.valueOf(i));
        return context;
    }

    public void onClick(View view)
    {
        a.a(((Integer)view.getTag(0x7f100020)).intValue());
    }
}
