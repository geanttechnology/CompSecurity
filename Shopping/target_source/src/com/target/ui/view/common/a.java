// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.widget.Checkable;

public interface a
    extends Checkable
{

    public abstract View getView();

    public abstract boolean isChecked();

    public abstract void setChecked(boolean flag);

    public abstract void setText(String s);
}
