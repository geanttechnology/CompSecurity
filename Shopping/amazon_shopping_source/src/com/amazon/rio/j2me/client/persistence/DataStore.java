// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.persistence;


public interface DataStore
{

    public abstract boolean getBoolean(String s);

    public abstract boolean getBoolean(String s, String s1);

    public abstract boolean getBoolean(String s, boolean flag);

    public abstract byte[] getByteArray(String s);

    public abstract int getInt(String s);

    public abstract long getLong(String s);

    public abstract long getLong(String s, String s1);

    public abstract String getString(String s);

    public abstract String getString(String s, String s1);

    public abstract void putBoolean(String s, boolean flag);

    public abstract void putBoolean(String s, boolean flag, String s1);

    public abstract void putByteArray(String s, byte abyte0[]);

    public abstract void putInt(String s, int i);

    public abstract void putLong(String s, long l);

    public abstract void putLong(String s, long l, String s1);

    public abstract void putString(String s, String s1);

    public abstract void putString(String s, String s1, String s2);

    public abstract void putString(String s, String s1, boolean flag);

    public abstract void remove(String s);

    public abstract void remove(String s, String s1);

    public abstract void removeSessionData(String s);
}
