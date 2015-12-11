// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.eb;

final class ep
    implements eb
{

    final Context a;
    final int b;
    final int c;
    final int d;

    ep(Context context, int i, int j, int k)
    {
        a = context;
        b = i;
        c = j;
        d = k;
        super();
    }

    public final int a()
    {
        return 2;
    }

    public final View a(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(a).inflate(0x7f03004b, viewgroup, false);
        TextView textview = (TextView)viewgroup.findViewById(0x7f0b0119);
        TextView textview1 = (TextView)viewgroup.findViewById(0x7f0b011a);
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Invalid tab index");

        case 0: // '\0'
            textview.setText(q.a(q.b()));
            textview1.setText(Integer.toString(b));
            return viewgroup;

        case 1: // '\001'
            textview.setText(0x7f0e0086);
            break;
        }
        textview1.setText(Integer.toString(c));
        return viewgroup;
    }

    public final String a(int i)
    {
        return null;
    }

    public final boolean b()
    {
        return false;
    }

    public final int c()
    {
        return d;
    }
}
