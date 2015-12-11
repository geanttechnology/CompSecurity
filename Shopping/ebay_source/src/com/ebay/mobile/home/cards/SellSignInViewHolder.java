// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.view.View;
import com.ebay.mobile.common.view.ViewHolder;

public class SellSignInViewHolder extends ViewHolder
{

    public View register;
    public View signIn;

    public SellSignInViewHolder(View view)
    {
        super(view);
        register = view.findViewById(0x7f10029d);
        signIn = view.findViewById(0x7f10029e);
        register.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }
}
