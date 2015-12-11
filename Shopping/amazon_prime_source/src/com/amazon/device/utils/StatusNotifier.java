// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;


public interface StatusNotifier
{

    public abstract void broadcastUploadStatus(CharSequence charsequence);

    public abstract void broadcastUploadTag(CharSequence charsequence);

    public abstract void fireNotification(CharSequence charsequence, int i);

    public abstract void updateFilesCount(int i);

    public abstract void updateProgress(int i);
}
