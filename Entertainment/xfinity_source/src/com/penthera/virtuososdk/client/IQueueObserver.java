// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;


// Referenced classes of package com.penthera.virtuososdk.client:
//            IVirtuosoIdentifier

public interface IQueueObserver
{

    public abstract void downloadEngineDidFinishDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier);

    public abstract void downloadEngineDidStartDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier);

    public abstract void downloadEngineFileWithError(IVirtuosoIdentifier ivirtuosoidentifier);

    public abstract void downloadEngineProgressUpdatedForFile(IVirtuosoIdentifier ivirtuosoidentifier);

    public abstract void engineDownloadQueueChanged();

    public abstract void fragmentComplete(IVirtuosoIdentifier ivirtuosoidentifier);
}
