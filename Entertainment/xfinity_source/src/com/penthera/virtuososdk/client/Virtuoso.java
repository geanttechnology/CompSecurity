// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.penthera.virtuososdk.interfaces.toolkit.VirtuosoContentBox;
import com.penthera.virtuososdk.service.VirtuosoService;
import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.client:
//            ServiceException, IServiceConnectedCallback, IDownloadedObserver, IEngineObserver, 
//            IQueueObserver, IVirtuosoIdentifier, IVirtuosoDownloadEngineStatus, IVirtuosoHLSFile

public class Virtuoso
{

    private VirtuosoContentBox iContentBox;

    public Virtuoso(Context context, IServiceConnectedCallback iserviceconnectedcallback)
    {
        this(context, iserviceconnectedcallback, null);
    }

    protected Virtuoso(Context context, IServiceConnectedCallback iserviceconnectedcallback, ComponentName componentname)
    {
        iContentBox = null;
        if (context == null)
        {
            throw new IllegalArgumentException("Context is invalid");
        }
        ComponentName componentname1 = componentname;
        if (componentname == null)
        {
            componentname1 = new ComponentName(context, com/penthera/virtuososdk/service/VirtuosoService);
        }
        iContentBox = new VirtuosoContentBox(context, iserviceconnectedcallback, componentname1);
    }

    public void addDownloadedObserver(IDownloadedObserver idownloadedobserver)
    {
        iContentBox.addDownloadedObserver(idownloadedobserver);
    }

    public void addEngineObserver(IEngineObserver iengineobserver)
    {
        iContentBox.addEngineObserver(iengineobserver);
    }

    public void addQueueObserver(IQueueObserver iqueueobserver)
    {
        iContentBox.addQueueObserver(iqueueobserver);
    }

    public void addToQueue(IVirtuosoIdentifier ivirtuosoidentifier)
        throws ServiceException
    {
        iContentBox.addToQueue(ivirtuosoidentifier);
    }

    public void configure(Bundle bundle, int i, int j)
        throws ServiceException
    {
        iContentBox.configure(bundle, i, j);
    }

    public void delete(IVirtuosoIdentifier ivirtuosoidentifier)
        throws ServiceException
    {
        iContentBox.delete(ivirtuosoidentifier);
    }

    public void deleteAllFiles()
        throws ServiceException
    {
        iContentBox.deleteAllFiles();
    }

    public List downloadedRootList()
    {
        return iContentBox.downloadedRootList();
    }

    public void expire(IVirtuosoIdentifier ivirtuosoidentifier)
        throws ServiceException
    {
        iContentBox.expire(ivirtuosoidentifier);
    }

    public void move(IVirtuosoIdentifier ivirtuosoidentifier, int i)
        throws ServiceException
    {
        iContentBox.move(ivirtuosoidentifier, i);
    }

    public void onResume()
    {
        iContentBox.onResume();
    }

    public void overrideBatteryThreshold(double d)
        throws ServiceException
    {
        iContentBox.overrideBatteryThreshold(d);
    }

    public void overrideCellularDataQuota(double d)
        throws ServiceException
    {
        iContentBox.overrideCellularDataQuota(d);
    }

    public void overrideHeadroom(double d)
        throws ServiceException
    {
        iContentBox.overrideHeadroom(d);
    }

    public void overrideMaxStorageAllowed(double d)
        throws ServiceException
    {
        iContentBox.overrideMaxStorageAllowed(d);
    }

    public void pauseDownloads()
        throws ServiceException
    {
        iContentBox.pauseDownloads();
    }

    public List queuedRootList()
    {
        return iContentBox.queuedRootList();
    }

    public void resumeDownloads()
        throws ServiceException
    {
        iContentBox.resumeDownloads();
    }

    public IVirtuosoDownloadEngineStatus status()
        throws ServiceException
    {
        return iContentBox.status();
    }

    public boolean update(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        return iContentBox.update(ivirtuosoidentifier);
    }

    public IVirtuosoHLSFile virtuosoHLSFile(String s, String s1)
        throws ServiceException
    {
        return iContentBox.virtuosoHLSFile(s, s1);
    }
}
