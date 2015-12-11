// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results.listeners;

import android.view.ViewGroup;
import android.widget.ImageView;

public interface ResultItemBuildListener
{

    public abstract void onResultItemBuilt(ViewGroup viewgroup, ImageView imageview, String s);
}
