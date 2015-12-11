// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.util;


public interface Logging
{

    public abstract void log(int i, String s, String s1);

    public abstract void logException(Throwable throwable, boolean flag);
}
