// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.a.d.e;
import com.rdio.android.core.util.Logging;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ItemBatchProcessor
{

    private static final String TAG = "ItemBatchProcessor";
    protected e eventBus;
    private volatile boolean isPaused;
    private Thread itemProcessingThread;
    private List itemsToProcess;
    public Logging logging;
    private final Object monitor = new Object();

    public ItemBatchProcessor(e e, Logging logging1)
    {
        itemsToProcess = new ArrayList();
        isPaused = false;
        eventBus = e;
        logging = logging1;
    }

    private void startItemProcessing()
    {
        if (itemProcessingThread == null)
        {
            itemProcessingThread = new Thread(new Runnable() {

                final ItemBatchProcessor this$0;

                public void run()
                {
_L5:
                    Object obj = monitor;
                    obj;
                    JVM INSTR monitorenter ;
_L1:
                    boolean flag;
                    if (itemsToProcess.isEmpty())
                    {
                        break MISSING_BLOCK_LABEL_39;
                    }
                    flag = isPaused;
                    if (!flag)
                    {
                        break MISSING_BLOCK_LABEL_78;
                    }
                    monitor.wait();
                      goto _L1
                    Object obj2;
                    obj2;
                    logging.log(4, "ItemBatchProcessor", "Interrupted while waiting for keys");
                      goto _L1
                    obj2;
                    obj;
                    JVM INSTR monitorexit ;
                    throw obj2;
                    obj;
                    JVM INSTR monitorexit ;
                    Object obj3 = new ArrayList();
                    obj1 = monitor;
                    obj1;
                    JVM INSTR monitorenter ;
                    int i = itemsToProcess.size() - 1;
_L3:
                    if (i < 0)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    if (((List) (obj3)).size() >= getMaxBatchSize())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    ((List) (obj3)).add(itemsToProcess.get(i));
                    i--;
                    if (true) goto _L3; else goto _L2
_L2:
                    obj1;
                    JVM INSTR monitorexit ;
                    obj3 = processItemBatch(((List) (obj3)));
                    onBatchComplete(((List) (obj3)));
                    Exception exception1;
                    if (obj3 != null)
                    {
                        logging.log(3, "ItemBatchProcessor", (new StringBuilder("Removing ")).append(((List) (obj3)).size()).append(" from pending items").toString());
                        synchronized (monitor)
                        {
                            itemsToProcess.removeAll(((java.util.Collection) (obj3)));
                            if (itemsToProcess.isEmpty())
                            {
                                onProcessingCompleted();
                                logging.log(4, "ItemBatchProcessor", "Completed item processing");
                            }
                        }
                    } else
                    {
                        logging.log(3, "ItemBatchProcessor", "No items processed");
                    }
                    if (true) goto _L5; else goto _L4
_L4:
                    exception;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception;
                    exception1;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception1;
                }

            
            {
                this$0 = ItemBatchProcessor.this;
                super();
            }
            }, getProcessingThreadName());
            itemProcessingThread.setPriority(getProcessingThreadPriority());
            itemProcessingThread.start();
        }
    }

    public void addItemToProcess(Object obj)
    {
        startItemProcessing();
        synchronized (monitor)
        {
            itemsToProcess.add(obj);
            monitor.notifyAll();
        }
        onItemsAdded(Arrays.asList(new Object[] {
            obj
        }));
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void addItemsToProcess(List list)
    {
        startItemProcessing();
        synchronized (monitor)
        {
            itemsToProcess.addAll(list);
            monitor.notifyAll();
        }
        onItemsAdded(list);
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public List getItemsToProcess()
    {
        return itemsToProcess;
    }

    public abstract int getMaxBatchSize();

    public abstract String getProcessingThreadName();

    public abstract int getProcessingThreadPriority();

    protected boolean isItemStillValid(Object obj)
    {
        Object obj1 = monitor;
        obj1;
        JVM INSTR monitorenter ;
        if (itemsToProcess.contains(obj))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        logging.log(4, "ItemBatchProcessor", (new StringBuilder("Key: ")).append(obj).append(" no longer in download list, skipping.").toString());
        return false;
        obj1;
        JVM INSTR monitorexit ;
        return true;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public boolean isPaused()
    {
        return isPaused;
    }

    public abstract void onBatchComplete(List list);

    public abstract void onItemsAdded(List list);

    public abstract void onItemsRemoved(List list);

    public abstract void onProcessingCompleted();

    public void pause()
    {
        isPaused = true;
    }

    public abstract List processItemBatch(List list);

    protected void removeItemFromPending(Object obj)
    {
        synchronized (monitor)
        {
            if (itemsToProcess.contains(obj))
            {
                itemsToProcess.remove(obj);
            }
        }
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void removeItemsToProcess(List list)
    {
        synchronized (monitor)
        {
            itemsToProcess.removeAll(list);
        }
        onItemsRemoved(list);
        return;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public void resume()
    {
        isPaused = false;
    }



}
