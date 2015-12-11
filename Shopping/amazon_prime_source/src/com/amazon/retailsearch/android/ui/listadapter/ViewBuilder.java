// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;

public interface ViewBuilder
{

    public abstract void buildView(View view);

    public abstract View createView(ViewGroup viewgroup);
}
