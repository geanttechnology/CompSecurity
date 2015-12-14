// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.shareview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class ShareItemView extends RelativeLayout
{

    protected final Context a;

    public ShareItemView(Context context)
    {
        super(context);
        a = context;
        a();
    }

    public ShareItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = context;
        a();
    }

    protected void a()
    {
        ((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f030203, this);
    }
}
