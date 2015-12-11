// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;


public interface IFileFragment
{

    public abstract double currentSize();

    public abstract com.penthera.virtuososdk.Common.EFileDownloadStatus downloadStatus();

    public abstract double expectedSize();

    public abstract String filePath();

    public abstract int id();

    public abstract String remotePath();
}
