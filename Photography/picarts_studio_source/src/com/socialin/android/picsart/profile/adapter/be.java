// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.picsart.studio.utils.DynamicHeightImageView;

public final class be extends android.support.v7.widget.RecyclerView.ViewHolder
{

    DynamicHeightImageView a;
    View b;
    ImageView c;
    SeekBar d;
    ImageView e;
    View f;
    View g;

    public be(View view)
    {
        super(view);
        a = (DynamicHeightImageView)view.findViewById(0x7f1000ef);
        b = view.findViewById(0x7f1003e9);
        c = (ImageView)view.findViewById(0x7f1007a0);
        d = (SeekBar)view.findViewById(0x7f100ad7);
        e = (ImageView)view.findViewById(0x7f10054f);
        f = view.findViewById(0x7f100ad6);
        g = view.findViewById(0x7f100ad5);
    }
}
