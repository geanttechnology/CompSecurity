// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.d;

import android.view.View;

public final class a
    implements android.view.View.OnClickListener
{

    private final android.view.View.OnClickListener a[];

    public transient a(android.view.View.OnClickListener aonclicklistener[])
    {
        a = aonclicklistener;
    }

    public final void onClick(View view)
    {
        android.view.View.OnClickListener aonclicklistener[] = a;
        int j = aonclicklistener.length;
        for (int i = 0; i < j; i++)
        {
            aonclicklistener[i].onClick(view);
        }

    }
}
