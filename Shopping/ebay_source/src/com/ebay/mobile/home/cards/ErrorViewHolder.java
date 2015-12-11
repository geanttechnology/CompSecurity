// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.view.View;
import com.ebay.mobile.common.view.ViewHolder;

public class ErrorViewHolder extends ViewHolder
{

    public ErrorViewHolder(View view)
    {
        super(view);
        view = view.findViewById(0x7f10022c);
        if (view != null)
        {
            view.setOnClickListener(this);
        }
    }
}
