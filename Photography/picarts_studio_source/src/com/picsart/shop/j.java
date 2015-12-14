// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

final class j extends LinearLayoutManager
{

    public j(Context context)
    {
        super(context, 0, false);
    }

    public final boolean canScrollHorizontally()
    {
        return true;
    }
}
