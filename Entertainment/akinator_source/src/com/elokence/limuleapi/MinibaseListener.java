// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;


public interface MinibaseListener
{

    public abstract void contentChanged();

    public abstract void errorLoading(int i);

    public abstract void isLoading();

    public abstract void loadingComplete();

    public abstract void resynchronized();
}
