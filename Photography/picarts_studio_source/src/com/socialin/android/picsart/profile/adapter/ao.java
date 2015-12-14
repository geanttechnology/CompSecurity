// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class ao extends android.support.v7.widget.RecyclerView.ViewHolder
{

    TextView a;
    TextView b;
    FrameLayout c;
    CheckBox d;

    public ao(View view)
    {
        super(view);
        a = (TextView)view.findViewById(0x7f1007ca);
        b = (TextView)view.findViewById(0x7f1007cb);
        c = (FrameLayout)view.findViewById(0x7f1007c9);
        d = (CheckBox)view.findViewById(0x7f100177);
    }
}
