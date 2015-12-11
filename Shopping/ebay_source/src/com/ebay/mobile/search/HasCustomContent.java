// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.View;
import android.view.ViewGroup;

public interface HasCustomContent
{

    public abstract View getCustomView();

    public abstract void setCustomViewHost(ViewGroup viewgroup);
}
