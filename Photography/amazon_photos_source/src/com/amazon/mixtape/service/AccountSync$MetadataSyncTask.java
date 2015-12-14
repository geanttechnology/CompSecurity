// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtended;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.service:
//            AccountSync, MetadataSyncException, DatabaseSizeMetrics, MetadataFetcher, 
//            MetadataFetcherProgressObserver

private static class mProgressObserver
    implements com.amazon.mixtape.account.aTask
{

    private final String mAccountId;
    private final String mAuthority;
    private final AmazonCloudDriveExtended mClient;
    private final Context mContext;
    private final MixtapeMetricRecorder mMixtapeMetricRecorder;
    private final List mPartialSyncRequests;
    private final MetadataFetcherProgressObserver mProgressObserver;

    public void run(SQLiteDatabase sqlitedatabase)
        throws InterruptedException, CloudDriveException, MetadataSyncException
    {
        Object obj;
        sqlitedatabase = AccountContextFactory.getContextForAccountId(mContext, mAccountId).createMetadataStore(mAuthority);
        obj = new DatabaseSizeMetrics(mContext, sqlitedatabase, mMixtapeMetricRecorder);
        obj = new MetadataFetcher(mClient, sqlitedatabase, mPartialSyncRequests, mProgressObserver, mMixtapeMetricRecorder, ((DatabaseSizeMetrics) (obj)));
        ((MetadataFetcher) (obj)).fetch();
        Exception exception;
        try
        {
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            return;
        }
        exception;
        try
        {
            sqlitedatabase.close();
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase) { }
        throw exception;
    }

    public er(Context context, AmazonCloudDriveExtended amazonclouddriveextended, String s, String s1, List list, MixtapeMetricRecorder mixtapemetricrecorder, MetadataFetcherProgressObserver metadatafetcherprogressobserver)
    {
        mContext = context;
        mClient = amazonclouddriveextended;
        mAccountId = s;
        mAuthority = s1;
        mPartialSyncRequests = list;
        mMixtapeMetricRecorder = mixtapemetricrecorder;
        mProgressObserver = metadatafetcherprogressobserver;
    }
}
