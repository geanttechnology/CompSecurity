// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.emilsjolander.components.StickyListHeaders;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface StickyListHeadersAdapter
{

    public abstract long getHeaderId(int i);

    public abstract View getHeaderView(int i, View view);

    public abstract void setDivider(Drawable drawable);

    public abstract void setDividerHeight(int i);
}
