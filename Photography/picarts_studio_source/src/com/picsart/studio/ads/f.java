// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.picsart.studio.utils.DynamicHeightImageView;

final class f extends android.support.v7.widget.RecyclerView.ViewHolder
{

    public ImageView a;
    public TextView b;
    public TextView c;
    public DynamicHeightImageView d;
    public TextView e;
    public Button f;

    public f(View view)
    {
        super(view);
        a = (ImageView)view.findViewById(0x7f100718);
        b = (TextView)view.findViewById(0x7f100719);
        c = (TextView)view.findViewById(0x7f10071a);
        d = (DynamicHeightImageView)view.findViewById(0x7f10071c);
        e = (TextView)view.findViewById(0x7f10071d);
        f = (Button)view.findViewById(0x7f10071e);
        view.findViewById(0x7f100716);
    }
}
