// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;


public interface IObjectDelegate
{

    public abstract boolean equals(Object obj);

    public abstract Object getWrapper();

    public abstract int hashCode();

    public abstract void setWrapper(Object obj);

    public abstract String toString();
}
