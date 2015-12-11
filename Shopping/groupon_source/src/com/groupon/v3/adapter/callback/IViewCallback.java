// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.callback;

import android.view.View;

public interface IViewCallback
{

    public abstract void onPendingViewBound();

    public abstract void onViewBound(int i, Object obj);

    public abstract void onViewClick(View view);
}
