// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;


public interface MediaBuffer
{

    public abstract void clear();

    public abstract void get(byte abyte0[], int i, int j);

    public abstract void peek(byte abyte0[], int i, int j);

    public abstract void put(byte abyte0[], int i, int j);

    public abstract void putMediaData(int i, byte abyte0[], int j, byte abyte1[], int k);
}
