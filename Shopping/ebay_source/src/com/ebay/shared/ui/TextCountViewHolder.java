// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.view.View;
import android.widget.TextView;

public class TextCountViewHolder
{

    public TextView count;
    public TextView text;

    public TextCountViewHolder(View view)
    {
        text = (TextView)view.findViewById(0x7f100145);
        count = (TextView)view.findViewById(0x7f100146);
    }
}
