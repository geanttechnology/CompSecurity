// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.util;

import android.view.ViewGroup;

public interface ListViewWrapper
{

    public abstract int getFirstVisiblePosition();

    public abstract int getLastVisiblePosition();

    public abstract ViewGroup getListView();
}
