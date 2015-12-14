// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.clouddrive.AmazonCloudDrive;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtended;
import com.amazon.clouddrive.extended.model.GetChangesExtendedResponse;
import com.amazon.clouddrive.extended.model.ListNodesExtendedResponse;
import com.amazon.clouddrive.model.GetChangesRequest;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.ListNodesResponse;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataSyncException, MetadataFetcherProgressObserver, DatabaseSizeMetrics

class MetadataFetcher
{
    private static final class FetchKind extends Enum
    {

        private static final FetchKind $VALUES[];
        public static final FetchKind COLD_BOOT;
        public static final FetchKind INCREMENTAL;
        public static final FetchKind UPGRADE;
        final String sizeMetricName;
        final String timingMetricName;

        public static FetchKind getKindFromState(State state)
        {
            if ("READY".equals(state.currentState))
            {
                if (state.needsUpgrade)
                {
                    return UPGRADE;
                } else
                {
                    return INCREMENTAL;
                }
            } else
            {
                return COLD_BOOT;
            }
        }

        public static FetchKind valueOf(String s)
        {
            return (FetchKind)Enum.valueOf(com/amazon/mixtape/service/MetadataFetcher$FetchKind, s);
        }

        public static FetchKind[] values()
        {
            return (FetchKind[])$VALUES.clone();
        }

        static 
        {
            COLD_BOOT = new FetchKind("COLD_BOOT", 0, "ColdBoot", "DBSizeColdBoot");
            UPGRADE = new FetchKind("UPGRADE", 1, "Upgrade", "DBSizeUpgrade");
            INCREMENTAL = new FetchKind("INCREMENTAL", 2, "Incremental", "DBSize");
            $VALUES = (new FetchKind[] {
                COLD_BOOT, UPGRADE, INCREMENTAL
            });
        }

        private FetchKind(String s, int i, String s1, String s2)
        {
            super(s, i);
            timingMetricName = s1;
            sizeMetricName = s2;
        }
    }

    private class State
    {

        int currentMetadataVersion;
        String currentState;
        final boolean needsUpgrade;
        final MetadataFetcher this$0;

        public void addAccountMetadataState(String s)
            throws MetadataSyncException
        {
            if (!s.equals(currentState) || 5 != currentMetadataVersion)
            {
                mCloudMetadataStore.addAccountMetadataState(s);
                currentState = s;
                currentMetadataVersion = 5;
            }
        }

        public void resetMetadata()
            throws MetadataSyncException
        {
            mCloudMetadataStore.resetStore();
            addAccountMetadataState("RESET");
        }

        public State(com.amazon.mixtape.account.MetadataStore.MetadataState metadatastate)
        {
            this$0 = MetadataFetcher.this;
            super();
            currentState = metadatastate.getState();
            currentMetadataVersion = metadatastate.getMetadataVersion();
            boolean flag;
            if (5 > currentMetadataVersion && currentState != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            needsUpgrade = flag;
        }
    }


    private final AmazonCloudDriveExtended mClient;
    private final MetadataStore mCloudMetadataStore;
    private final DatabaseSizeMetrics mDatabaseSizeMetrics;
    private final MetadataFetcherProgressObserver mMetadataFetcherProgressObserver;
    private final MixtapeMetricRecorder mMetricRecorder;
    private final List mPartialSyncListNodeRequests;

    MetadataFetcher(AmazonCloudDriveExtended amazonclouddriveextended, MetadataStore metadatastore, List list, MetadataFetcherProgressObserver metadatafetcherprogressobserver, MixtapeMetricRecorder mixtapemetricrecorder, DatabaseSizeMetrics databasesizemetrics)
    {
        mClient = amazonclouddriveextended;
        mCloudMetadataStore = metadatastore;
        mPartialSyncListNodeRequests = list;
        mMetadataFetcherProgressObserver = metadatafetcherprogressobserver;
        mMetricRecorder = mixtapemetricrecorder;
        mDatabaseSizeMetrics = databasesizemetrics;
    }

    private void checkInterrupted()
        throws InterruptedException
    {
        if (Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException("Interrupted while attempting to fetch account metadata");
        } else
        {
            return;
        }
    }

    private long getTotalNodeCount(AmazonCloudDrive amazonclouddrive)
        throws CloudDriveException, InterruptedException
    {
        ListNodesRequest listnodesrequest = new ListNodesRequest();
        listnodesrequest.setLimit(Integer.valueOf(1));
        long l = amazonclouddrive.listNodes(listnodesrequest).getCount();
        listnodesrequest = new ListNodesRequest();
        listnodesrequest.setLimit(Integer.valueOf(1));
        listnodesrequest.setFilters("status:PURGED");
        long l1 = amazonclouddrive.listNodes(listnodesrequest).getCount();
        listnodesrequest = new ListNodesRequest();
        listnodesrequest.setLimit(Integer.valueOf(1));
        listnodesrequest.setFilters("status:TRASH");
        return 0L + l + l1 + amazonclouddrive.listNodes(listnodesrequest).getCount();
    }

    private void syncChanges(State state, boolean flag)
        throws InterruptedException, MetadataSyncException, CloudDriveException
    {
        com.amazon.mixtape.metrics.MixtapeMetric.Counter counter = new com.amazon.mixtape.metrics.MixtapeMetric.Counter("NodesSynced");
_L7:
        String s;
        Object obj;
        checkInterrupted();
        s = mCloudMetadataStore.getLastCheckpoint();
        obj = new GetChangesRequest();
        ((GetChangesRequest) (obj)).setIncludePurged("true");
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.equals("")) goto _L2; else goto _L3
_L3:
        int i = 1;
_L5:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        ((GetChangesRequest) (obj)).setCheckpoint(s);
        com.amazon.mixtape.metrics.MixtapeMetric.Timer timer = (new com.amazon.mixtape.metrics.MixtapeMetric.Timer("ChangesRequest")).start();
        obj = mClient.getChangesExtended(((GetChangesRequest) (obj)));
        mMetricRecorder.addMetric(timer.finished());
        checkInterrupted();
        if (!((GetChangesExtendedResponse) (obj)).isReset() || i == 0)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        state.resetMetadata();
        List list;
        list = ((GetChangesExtendedResponse) (obj)).getNodes();
        i = list.size();
        com.amazon.mixtape.metrics.MixtapeMetric.Timer timer1 = (new com.amazon.mixtape.metrics.MixtapeMetric.Timer("SaveNodes")).start();
        mCloudMetadataStore.saveNodes(list, ((GetChangesExtendedResponse) (obj)).getCheckpoint(), s);
        mMetricRecorder.addMetric(timer1.finished());
        counter.increment(i);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        mMetadataFetcherProgressObserver.updateCurrentCount(i);
        boolean flag1 = list.isEmpty();
        if (flag1)
        {
            mMetricRecorder.addMetric(counter);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L5; else goto _L4
_L4:
        state;
        mMetricRecorder.addMetric(counter);
        throw state;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void fetch()
        throws CloudDriveException, MetadataSyncException, InterruptedException
    {
        State state = new State(mCloudMetadataStore.getMostRecentAccountMetadataState());
        FetchKind fetchkind = FetchKind.getKindFromState(state);
        com.amazon.mixtape.metrics.MixtapeMetric.Timer timer = (new com.amazon.mixtape.metrics.MixtapeMetric.Timer(fetchkind.timingMetricName)).start();
        checkInterrupted();
        boolean flag;
        if (mMetadataFetcherProgressObserver != null && !"READY".equals(state.currentState))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            com.amazon.mixtape.metrics.MixtapeMetric.Timer timer1 = (new com.amazon.mixtape.metrics.MixtapeMetric.Timer("InitializeSyncProgress")).start();
            mMetadataFetcherProgressObserver.setTotalCount(getTotalNodeCount(mClient));
            mMetadataFetcherProgressObserver.setCurrentCount(mCloudMetadataStore.getCurrentNodesCount());
            mMetricRecorder.addMetric(timer1.finished());
        }
        checkInterrupted();
        if (state.currentState == null || state.currentState.equals("PARTIAL_SYNC"))
        {
            if (mPartialSyncListNodeRequests != null && !mPartialSyncListNodeRequests.isEmpty())
            {
                com.amazon.mixtape.metrics.MixtapeMetric.Timer timer2 = (new com.amazon.mixtape.metrics.MixtapeMetric.Timer("PartialSync")).start();
                state.addAccountMetadataState("PARTIAL_SYNC");
                Iterator iterator = mPartialSyncListNodeRequests.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (ListNodesRequest)iterator.next();
                    checkInterrupted();
                    obj = mClient.listNodesExtended(((ListNodesRequest) (obj))).getData();
                    checkInterrupted();
                    mCloudMetadataStore.saveNodes(((List) (obj)));
                    if (flag)
                    {
                        mMetadataFetcherProgressObserver.updateCurrentCount(((List) (obj)).size());
                    }
                } while (true);
                mMetricRecorder.addMetric(timer2.finished());
            }
            state.addAccountMetadataState("COLDBOOT");
        }
        checkInterrupted();
        if (state.needsUpgrade)
        {
            if ("COLDBOOT".equals(state.currentState))
            {
                state.addAccountMetadataState("COLDBOOT");
            } else
            {
                state.addAccountMetadataState("UPGRADE");
            }
            mCloudMetadataStore.resetCheckpoint();
        }
        syncChanges(state, flag);
        state.addAccountMetadataState("READY");
        if (flag)
        {
            mMetadataFetcherProgressObserver.notifyComplete();
        }
        mDatabaseSizeMetrics.collect(fetchkind.sizeMetricName);
        mMetricRecorder.addMetric(timer.finished());
    }

}
