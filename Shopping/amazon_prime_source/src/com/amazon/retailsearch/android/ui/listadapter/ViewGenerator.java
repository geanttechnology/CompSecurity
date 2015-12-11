// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import android.view.View;
import android.view.ViewGroup;

public interface ViewGenerator
{

    public abstract int getCount();

    public abstract int getType(int i);

    public abstract View getView(int i, View view, ViewGroup viewgroup);

    public abstract boolean isEnabled(int i);
}
