// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import com.mixerbox.mixerbox3b.classes.VectorOnClickListener;

class mListener extends ClickableSpan
{

    private VectorOnClickListener mListener;

    public void onClick(View view)
    {
        mListener.onClick(view);
    }

    public A(VectorOnClickListener vectoronclicklistener)
    {
        mListener = vectoronclicklistener;
    }
}
