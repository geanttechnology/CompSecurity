// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;


public interface Preferences
{

    public abstract long getLong(String s, long l);

    public abstract String getString(String s, String s1);

    public abstract void putLong(String s, long l);

    public abstract void putString(String s, String s1);
}
