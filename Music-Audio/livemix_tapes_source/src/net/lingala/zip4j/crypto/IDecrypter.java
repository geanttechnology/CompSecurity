// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto;

import net.lingala.zip4j.exception.ZipException;

public interface IDecrypter
{

    public abstract int decryptData(byte abyte0[])
        throws ZipException;

    public abstract int decryptData(byte abyte0[], int i, int j)
        throws ZipException;
}
