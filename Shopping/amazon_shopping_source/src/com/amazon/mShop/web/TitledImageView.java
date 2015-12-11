// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Context;
import android.widget.ImageView;
import com.amazon.mShop.TitleProvider;

public class TitledImageView extends ImageView
    implements TitleProvider
{

    CharSequence mTitle;

    public TitledImageView(Context context)
    {
        super(context);
        mTitle = null;
    }

    public CharSequence getTitle()
    {
        return mTitle;
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
    }
}
