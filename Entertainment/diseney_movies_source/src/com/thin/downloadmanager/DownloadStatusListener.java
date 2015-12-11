// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;


public interface DownloadStatusListener
{

    public abstract void onDownloadComplete(int i);

    public abstract void onDownloadFailed(int i, int j, String s);

    public abstract void onProgress(int i, long l, long l1, int j);
}
