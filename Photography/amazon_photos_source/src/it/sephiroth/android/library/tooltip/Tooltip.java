// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;


public interface Tooltip
{

    public abstract void hide(boolean flag);

    public abstract boolean isAttached();

    public abstract boolean isShown();

    public abstract void offsetTo(int i, int j);

    public abstract void setOffsetX(int i);

    public abstract void setOffsetY(int i);

    public abstract void show();
}
