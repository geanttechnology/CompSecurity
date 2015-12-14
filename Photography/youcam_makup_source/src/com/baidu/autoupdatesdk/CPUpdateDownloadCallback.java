// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;


public interface CPUpdateDownloadCallback
{

    public abstract void onDownloadComplete(String s);

    public abstract void onFail(Throwable throwable, String s);

    public abstract void onPercent(int i, long l, long l1);

    public abstract void onStart();

    public abstract void onStop();
}
