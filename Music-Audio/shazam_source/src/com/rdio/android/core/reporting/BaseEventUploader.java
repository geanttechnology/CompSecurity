// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import com.google.a.d.e;
import com.rdio.android.core.ItemBatchProcessor;
import com.rdio.android.core.util.Logging;
import java.util.List;
import org.json.JSONArray;

public abstract class BaseEventUploader extends ItemBatchProcessor
{

    private static final int BATCH_SIZE = 5;
    private static final String TAG = "EventUploader";

    public BaseEventUploader(e e, Logging logging)
    {
        super(e, logging);
    }

    protected int getMaxBatchSize()
    {
        return 5;
    }

    protected String getProcessingThreadName()
    {
        return "EventUploader";
    }

    protected int getProcessingThreadPriority()
    {
        return 1;
    }

    protected void onBatchComplete(List list)
    {
        logging.log(4, "EventUploader", (new StringBuilder("Completed uploading ")).append(list.size()).append(" events.").toString());
    }

    protected void onItemsAdded(List list)
    {
        logging.log(4, "EventUploader", (new StringBuilder("Adding ")).append(list.size()).append(" item(s) to report").toString());
    }

    protected void onItemsRemoved(List list)
    {
    }

    protected void onProcessingCompleted()
    {
        logging.log(4, "EventUploader", "Completed event uploading");
    }

    protected List processItemBatch(List list)
    {
        if (!uploadEvents(new JSONArray(list)))
        {
            logging.log(6, "EventUploader", (new StringBuilder("Failed to upload ")).append(list.size()).append(" events").toString());
        }
        return list;
    }

    public abstract boolean uploadEvents(JSONArray jsonarray);
}
