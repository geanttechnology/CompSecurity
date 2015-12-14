// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import android.os.RemoteException;
import com.amazon.mixtape.metadata.processing.AccountChangedException;
import com.amazon.mixtape.metadata.processing.EventIdStore;
import com.amazon.mixtape.metadata.processing.MetadataProcessingException;
import com.amazon.mixtape.metadata.processing.NodeProcessor;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import com.amazon.mixtape.metrics.NoOpMixtapeMetricRecorder;
import com.amazon.mixtape.utils.MixtapeCursorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MetadataProcessor
{
    private static class BatchState
    {

        final List childrenToDelete = new LinkedList();
        final Map childrenToSave = new HashMap();
        int mNodesCursorWindowRows;
        int mNumNodesCursorRowsSeen;
        int mNumParentsCursorRowsSeen;
        int mParentsCursorWindowRows;
        final List parentsToDelete = new LinkedList();
        final Map parentsToSave = new HashMap();
        final Map unresolvedParents = new HashMap();

        void addChildToRemove(String s)
        {
            childrenToDelete.add(s);
        }

        void addChildToSave(String s, Object obj)
        {
            childrenToSave.put(s, obj);
        }

        void addParentToDelete(String s)
        {
            parentsToDelete.add(s);
        }

        void addParentToSave(String s, Object obj)
        {
            parentsToSave.put(s, obj);
        }

        void addUnresolvedParent(String s, Object obj)
        {
            unresolvedParents.put(s, obj);
        }

        Collection getChildrenToSave()
        {
            return childrenToSave.values();
        }

        int getNumRowsInNodesCursorWindow()
        {
            return mNodesCursorWindowRows;
        }

        int getNumRowsInParentsCursorWindow()
        {
            return mParentsCursorWindowRows;
        }

        int getNumRowsSeenInNodesCursor()
        {
            return mNumNodesCursorRowsSeen;
        }

        int getNumRowsSeenInParentsCursor()
        {
            return mNumParentsCursorRowsSeen;
        }

        Object getParent(String s)
        {
            if (parentsToSave.containsKey(s))
            {
                return parentsToSave.get(s);
            }
            if (unresolvedParents.containsKey(s))
            {
                return unresolvedParents.get(s);
            } else
            {
                return null;
            }
        }

        Collection getParentsToSave()
        {
            return parentsToSave.values();
        }

        int getSize()
        {
            return parentsToSave.size() + unresolvedParents.size() + parentsToDelete.size() + childrenToSave.size() + childrenToDelete.size();
        }

        Collection getUnresolvedParents()
        {
            return unresolvedParents.values();
        }

        void incrementNumRowsSeenInNodesCursor()
        {
            mNumNodesCursorRowsSeen = mNumNodesCursorRowsSeen + 1;
        }

        void incrementNumRowsSeenInParentsCursor()
        {
            mNumParentsCursorRowsSeen = mNumParentsCursorRowsSeen + 1;
        }

        boolean isEmpty()
        {
            return parentsToSave.isEmpty() && unresolvedParents.isEmpty() && parentsToDelete.isEmpty() && childrenToSave.isEmpty() && childrenToDelete.isEmpty();
        }

        boolean isNodesCursorWindowFinished()
        {
            return mNumNodesCursorRowsSeen == mNodesCursorWindowRows;
        }

        boolean isParentKnown(String s)
        {
            return parentsToSave.containsKey(s) || unresolvedParents.containsKey(s);
        }

        boolean isParentToBeSaved(String s)
        {
            return parentsToSave.containsKey(s);
        }

        boolean isParentUnresolved(String s)
        {
            return unresolvedParents.containsKey(s);
        }

        boolean isParentsCursorWindowFinished()
        {
            return mNumParentsCursorRowsSeen == mParentsCursorWindowRows;
        }

        Object removeUnresolvedParent(String s)
        {
            return unresolvedParents.remove(s);
        }

        void resolveParent(String s, Object obj)
        {
            unresolvedParents.remove(s);
            parentsToSave.put(s, obj);
        }

        BatchState(int i, int j, int k, int l)
        {
            mNodesCursorWindowRows = i;
            mParentsCursorWindowRows = j;
            mNumNodesCursorRowsSeen = k;
            mNumParentsCursorRowsSeen = l;
        }
    }


    private final String mAccountId;
    private final int mBatchSize;
    private final String mCloudNodesProviderAuthority;
    private final Context mContext;
    private final EventIdStore mEventIdStore;
    private final MixtapeMetricRecorder mMetricRecorder;
    private final NodeProcessor mNodeProcessor;

    public MetadataProcessor(Context context, MixtapeMetricRecorder mixtapemetricrecorder, String s, String s1, NodeProcessor nodeprocessor, EventIdStore eventidstore, int i)
    {
        mContext = context;
        mMetricRecorder = mixtapemetricrecorder;
        mCloudNodesProviderAuthority = s;
        mAccountId = s1;
        mNodeProcessor = nodeprocessor;
        mEventIdStore = eventidstore;
        mBatchSize = i;
    }

    public MetadataProcessor(Context context, String s, String s1, NodeProcessor nodeprocessor, EventIdStore eventidstore, int i)
    {
        this(context, ((MixtapeMetricRecorder) (new NoOpMixtapeMetricRecorder())), s, s1, nodeprocessor, eventidstore, i);
    }

    private void addParentRelationship(BatchState batchstate, Object obj, String s)
    {
        if (batchstate.isParentKnown(s))
        {
            batchstate = ((BatchState) (batchstate.getParent(s)));
        } else
        {
            Object obj1 = mNodeProcessor.createPlaceholderParent(s);
            batchstate.addUnresolvedParent(s, obj1);
            batchstate = ((BatchState) (obj1));
        }
        mNodeProcessor.addRelationship(batchstate, obj);
    }

    private void addParentRelationships(BatchState batchstate, Cursor cursor, long l, String s, Object obj)
    {
        if (!cursor.isAfterLast()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag = false;
_L10:
        if (!cursor.isAfterLast() && MixtapeCursorUtils.getLongFromCursor(cursor, "event_id") > l && (!flag || canTravserseParentCursorFurther(batchstate))) goto _L4; else goto _L3
_L3:
        flag = false;
_L9:
        if (cursor.isAfterLast() || MixtapeCursorUtils.getLongFromCursor(cursor, "event_id") != l) goto _L1; else goto _L5
_L5:
        String s1;
        String s2;
        s1 = MixtapeCursorUtils.getStringFromCursor(cursor, "node_id");
        s2 = MixtapeCursorUtils.getStringFromCursor(cursor, "parent_node_id");
        if (s.equals(s1)) goto _L7; else goto _L6
_L6:
        if (flag && !canTravserseParentCursorFurther(batchstate)) goto _L1; else goto _L8
_L8:
        cursor.moveToNext();
        flag = true;
          goto _L9
_L4:
        cursor.moveToNext();
        flag = true;
          goto _L10
_L7:
        addParentRelationship(batchstate, obj, s2);
        if (!flag || canTravserseParentCursorFurther(batchstate)) goto _L8; else goto _L11
_L11:
          goto _L10
    }

    private boolean canTravserseParentCursorFurther(BatchState batchstate)
    {
        batchstate.incrementNumRowsSeenInParentsCursor();
        return !batchstate.isParentsCursorWindowFinished();
    }

    private Cursor getCursor(ContentProviderClient contentproviderclient, Uri uri, String as[], com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange eventidrange)
        throws RemoteException
    {
        String as1[];
        if (eventidrange.lowerEventId != eventidrange.upperEventId)
        {
            String s = "event_id < ? AND event_id >= ?";
            as1 = new String[2];
            as1[0] = Long.toString(eventidrange.upperEventId);
            as1[1] = Long.toString(eventidrange.lowerEventId);
            eventidrange = s;
        } else
        if (eventidrange.lowerEventId == 0L && eventidrange.upperEventId == 0L)
        {
            eventidrange = null;
            as1 = null;
        } else
        {
            String s1 = "event_id > ?";
            as1 = new String[1];
            as1[0] = Long.toString(eventidrange.lowerEventId);
            eventidrange = s1;
        }
        return contentproviderclient.query(uri, as, eventidrange, as1, "event_id DESC");
    }

    private void persistChanges(ContentProviderClient contentproviderclient, BatchState batchstate)
        throws RemoteException, AccountChangedException
    {
        resolveParents(contentproviderclient, batchstate);
        mNodeProcessor.save(mAccountId, batchstate.getParentsToSave(), batchstate.getUnresolvedParents(), batchstate.getChildrenToSave());
        mNodeProcessor.delete(mAccountId, batchstate.parentsToDelete, batchstate.childrenToDelete);
    }

    private com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange processBatch(ContentProviderClient contentproviderclient, com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange eventidrange)
        throws RemoteException, AccountChangedException
    {
        BatchState batchstate;
        Object obj;
        Object obj1;
        long l;
        long l1;
        l = eventidrange.maximumEventId;
        l1 = 0L;
        obj1 = null;
        batchstate = null;
        obj = batchstate;
        Cursor cursor = getCursor(contentproviderclient, com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(mCloudNodesProviderAuthority, mAccountId), mNodeProcessor.getNeededColumns(), eventidrange);
        obj1 = cursor;
        obj = batchstate;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj1 = cursor;
        obj = batchstate;
        mNodeProcessor.notifyProcessingComplete(mAccountId);
        if (cursor != null)
        {
            cursor.close();
        }
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            return eventidrange;
        }
        obj1 = cursor;
        obj = batchstate;
        Cursor cursor1 = getCursor(contentproviderclient, com.amazon.mixtape.provider.CloudNodesContract.NodeParents.getContentUri(mCloudNodesProviderAuthority, mAccountId), null, eventidrange);
        obj1 = cursor;
        obj = cursor1;
        cursor1.moveToFirst();
        obj1 = cursor;
        obj = cursor1;
        batchstate = new BatchState(((SQLiteCursor)cursor).getWindow().getNumRows(), ((SQLiteCursor)cursor1).getWindow().getNumRows(), 0, 1);
        boolean flag;
        flag = false;
        obj = batchstate;
        cursor.moveToFirst();
_L12:
        obj = batchstate;
        if (cursor.isAfterLast()) goto _L2; else goto _L1
_L1:
        obj = batchstate;
        obj1 = MixtapeCursorUtils.getStringFromCursor(cursor, "node_id");
        obj = batchstate;
        l1 = MixtapeCursorUtils.getLongFromCursor(cursor, "event_id");
        obj = batchstate;
        l = Math.max(l, l1);
        obj = batchstate;
        if (!mNodeProcessor.isChild(cursor)) goto _L4; else goto _L3
_L3:
        obj = batchstate;
        translateChild(batchstate, cursor, cursor1, ((String) (obj1)));
_L11:
        obj = batchstate;
        if (batchstate.getSize() < mBatchSize)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        obj = batchstate;
        persistChanges(contentproviderclient, batchstate);
        obj = batchstate;
        int i = batchstate.getNumRowsSeenInNodesCursor();
        obj = batchstate;
        int j = batchstate.getNumRowsSeenInParentsCursor();
        obj = batchstate;
        batchstate = new BatchState(batchstate.getNumRowsInNodesCursorWindow(), batchstate.getNumRowsInParentsCursorWindow(), i, j);
        obj1 = cursor;
        obj = cursor1;
        Object obj2 = new com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange(eventidrange.lowerEventId, l1, l);
        obj1 = cursor;
        obj = cursor1;
        mEventIdStore.updateEventIdRange(mAccountId, ((com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange) (obj2)));
        obj1 = cursor;
        obj = cursor1;
        batchstate.incrementNumRowsSeenInNodesCursor();
        obj1 = cursor;
        obj = cursor1;
        if (batchstate.isNodesCursorWindowFinished())
        {
            break MISSING_BLOCK_LABEL_749;
        }
        obj2 = batchstate;
        obj1 = cursor;
        obj = cursor1;
        if (batchstate.isParentsCursorWindowFinished())
        {
            break MISSING_BLOCK_LABEL_749;
        }
          goto _L5
_L2:
        obj1 = cursor;
        obj = cursor1;
        if (batchstate.isEmpty())
        {
            break MISSING_BLOCK_LABEL_474;
        }
        obj1 = cursor;
        obj = cursor1;
        persistChanges(contentproviderclient, batchstate);
        if (!flag) goto _L7; else goto _L6
_L6:
        obj1 = cursor;
        obj = cursor1;
        if (batchstate.getNumRowsSeenInNodesCursor() == cursor.getCount()) goto _L7; else goto _L8
_L8:
        obj1 = cursor;
        obj = cursor1;
        contentproviderclient = new com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange(eventidrange.lowerEventId, l1, l);
        obj1 = cursor;
        obj = cursor1;
        mEventIdStore.updateEventIdRange(mAccountId, contentproviderclient);
_L13:
        if (cursor != null)
        {
            cursor.close();
        }
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return contentproviderclient;
_L4:
        obj = batchstate;
        if (!mNodeProcessor.isParent(cursor)) goto _L10; else goto _L9
_L9:
        obj = batchstate;
        translateParent(batchstate, cursor, ((String) (obj1)));
          goto _L11
        contentproviderclient;
        obj = cursor1;
        obj1 = cursor;
_L14:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw contentproviderclient;
_L10:
        obj = batchstate;
        batchstate.incrementNumRowsSeenInNodesCursor();
        obj = batchstate;
        boolean flag1 = batchstate.isNodesCursorWindowFinished();
label0:
        {
            if (!flag1)
            {
                break label0;
            }
            flag = true;
        }
          goto _L2
        obj2 = batchstate;
_L5:
        obj1 = cursor;
        obj = cursor1;
        cursor.moveToNext();
        batchstate = ((BatchState) (obj2));
          goto _L12
_L7:
        obj1 = cursor;
        obj = cursor1;
        contentproviderclient = new com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange(l, l, l);
        obj1 = cursor;
        obj = cursor1;
        mEventIdStore.updateEventIdRange(mAccountId, contentproviderclient);
          goto _L13
        contentproviderclient;
          goto _L14
        flag = true;
          goto _L2
    }

    private void resolveParents(ContentProviderClient contentproviderclient, BatchState batchstate)
        throws RemoteException, AccountChangedException
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        Iterator iterator;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        iterator = batchstate.unresolvedParents.entrySet().iterator();
_L2:
        Object obj;
        Object obj1;
        java.util.Map.Entry entry1;
        Object obj2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        entry1 = (java.util.Map.Entry)iterator.next();
        obj1 = (String)entry1.getKey();
        obj2 = entry1.getValue();
        obj = mNodeProcessor.getExistingParent(mAccountId, ((String) (obj1)));
        if (obj != null)
        {
            mNodeProcessor.updateExistingParent(obj2, obj);
            arraylist.add(obj1);
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        obj1 = contentproviderclient.query(com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(mCloudNodesProviderAuthority, mAccountId), null, "node_id = ?", new String[] {
            obj1
        }, null);
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj = obj1;
        if (!mNodeProcessor.isParent(((Cursor) (obj1))))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj = obj1;
        if (mNodeProcessor.shouldRemoveParent(((Cursor) (obj1))))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj = obj1;
        mNodeProcessor.updateExistingParent(obj2, ((Cursor) (obj1)));
        obj = obj1;
        arraylist1.add(entry1);
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (true) goto _L2; else goto _L1
        contentproviderclient;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw contentproviderclient;
_L1:
        java.util.Map.Entry entry;
        for (contentproviderclient = arraylist1.iterator(); contentproviderclient.hasNext(); batchstate.resolveParent((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)contentproviderclient.next();
        }

        for (contentproviderclient = arraylist.iterator(); contentproviderclient.hasNext(); batchstate.removeUnresolvedParent((String)contentproviderclient.next())) { }
        return;
    }

    private void translateChild(BatchState batchstate, Cursor cursor, Cursor cursor1, String s)
    {
        if (mNodeProcessor.shouldRemoveChild(cursor))
        {
            batchstate.addChildToRemove(s);
            return;
        } else
        {
            long l = MixtapeCursorUtils.getLongFromCursor(cursor, "event_id");
            cursor = ((Cursor) (mNodeProcessor.createChild(cursor)));
            addParentRelationships(batchstate, cursor1, l, s, cursor);
            batchstate.addChildToSave(s, cursor);
            return;
        }
    }

    private void translateParent(BatchState batchstate, Cursor cursor, String s)
        throws AccountChangedException
    {
        if (mNodeProcessor.shouldRemoveParent(cursor))
        {
            batchstate.addParentToDelete(s);
            return;
        }
        if (batchstate.isParentToBeSaved(s))
        {
            mNodeProcessor.updateExistingParent(batchstate.getParent(s), cursor);
            return;
        }
        if (batchstate.isParentUnresolved(s))
        {
            Object obj = batchstate.removeUnresolvedParent(s);
            mNodeProcessor.updateExistingParent(obj, cursor);
            batchstate.addParentToSave(s, obj);
            return;
        }
        Object obj1 = mNodeProcessor.getExistingParent(mAccountId, s);
        if (obj1 == null)
        {
            obj1 = mNodeProcessor.createPlaceholderParent(s);
        }
        mNodeProcessor.updateExistingParent(obj1, cursor);
        batchstate.addParentToSave(s, obj1);
    }

    public void processMetadata()
        throws MetadataProcessingException
    {
        com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange eventidrange;
        ContentProviderClient contentproviderclient;
        com.amazon.mixtape.metrics.MixtapeMetric.Timer timer;
        long l;
        timer = (new com.amazon.mixtape.metrics.MixtapeMetric.Timer("ProcessMetadata")).start();
        contentproviderclient = mContext.getContentResolver().acquireContentProviderClient(mCloudNodesProviderAuthority);
        eventidrange = mEventIdStore.getEventIdRange(mAccountId);
        l = -1L;
        while (eventidrange.upperEventId != l) 
        {
            l = eventidrange.upperEventId;
            eventidrange = processBatch(contentproviderclient, eventidrange);
        }
        mNodeProcessor.notifyProcessingComplete(mAccountId);
        mMetricRecorder.addMetric(timer.finished());
        contentproviderclient.release();
        return;
        Object obj;
        obj;
        mMetricRecorder.addMetric(timer.failed());
        throw new MetadataProcessingException("Failed to obtain nodes to process", ((Throwable) (obj)));
        obj;
        contentproviderclient.release();
        throw obj;
        obj;
        mMetricRecorder.addMetric(timer.finished());
        throw obj;
    }
}
