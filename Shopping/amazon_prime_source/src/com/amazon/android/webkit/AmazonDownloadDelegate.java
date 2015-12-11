// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public interface AmazonDownloadDelegate
{

    public abstract void onHttpPostDownloadCompleted(String s, String s1, String s2, long l, boolean flag);

    public abstract void onHttpPostDownloadStarted();

    public abstract void requestHttpGetDownload(String s, String s1, String s2, String s3, String s4, String s5, long l);
}
