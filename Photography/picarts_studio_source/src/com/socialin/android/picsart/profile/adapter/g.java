// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class g extends android.support.v7.widget.RecyclerView.ViewHolder
{

    View a;
    ImageView b;
    TextView c;
    TextView d;
    LinearLayout e;
    View f;
    TextView g;
    View h;

    public g(View view, boolean flag)
    {
        super(view);
        if (!flag)
        {
            return;
        } else
        {
            a = view.findViewById(0x7f100261);
            b = (ImageView)a.findViewById(0x7f1000f2);
            c = (TextView)a.findViewById(0x7f1000f3);
            d = (TextView)a.findViewById(0x7f100262);
            e = (LinearLayout)view.findViewById(0x7f100263);
            f = view.findViewById(0x7f100264);
            g = (TextView)f.findViewById(0x7f100266);
            h = f.findViewById(0x7f100265);
            return;
        }
    }
}
