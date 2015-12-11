// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


public interface TJViewListener
{

    public abstract void onViewDidClose(int i);

    public abstract void onViewDidOpen(int i);

    public abstract void onViewWillClose(int i);

    public abstract void onViewWillOpen(int i);
}
