// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


public interface TJVideoListener
{

    public abstract void onVideoComplete();

    public abstract void onVideoError(int i);

    public abstract void onVideoStart();
}
