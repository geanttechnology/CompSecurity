// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.widget.SpinnerAdapter;

public interface ThemedSpinnerAdapter
    extends SpinnerAdapter
{

    public abstract android.content.res.Resources.Theme getDropDownViewTheme();

    public abstract void setDropDownViewTheme(android.content.res.Resources.Theme theme);
}
