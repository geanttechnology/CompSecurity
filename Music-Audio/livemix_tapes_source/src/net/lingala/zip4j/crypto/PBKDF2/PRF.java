// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.PBKDF2;


interface PRF
{

    public abstract byte[] doFinal(byte abyte0[]);

    public abstract int getHLen();

    public abstract void init(byte abyte0[]);
}
