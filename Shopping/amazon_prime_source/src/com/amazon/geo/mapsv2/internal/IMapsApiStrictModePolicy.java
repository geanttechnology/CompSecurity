// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;


public interface IMapsApiStrictModePolicy
{

    public abstract boolean detectAll();

    public abstract boolean detectUnimplemented();

    public abstract boolean penaltyLog();

    public abstract boolean penaltyThrow();

    public abstract void throwException(String s, Throwable throwable);
}
