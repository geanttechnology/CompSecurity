// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.picsart.studio.utils.DynamicHeightImageView;

public final class ak extends android.support.v7.widget.RecyclerView.ViewHolder
{

    DynamicHeightImageView a;
    TextView b;
    Button c;
    TextView d;
    View e;

    public ak(View view)
    {
        super(view);
        a = (DynamicHeightImageView)view.findViewById(0x7f1000ef);
        b = (TextView)view.findViewById(0x7f10051c);
        c = (Button)view.findViewById(0x7f1007ad);
        d = (TextView)view.findViewById(0x7f10051b);
        e = view.findViewById(0x7f1003e9);
    }
}
