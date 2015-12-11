// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common.view;

import android.view.View;

public abstract class ViewModel
{
    public static interface OnClickListener
    {

        public abstract void onClick(View view, ViewModel viewmodel);
    }


    public final OnClickListener listener;
    public final int viewType;

    public ViewModel(int i, OnClickListener onclicklistener)
    {
        viewType = i;
        listener = onclicklistener;
    }
}
