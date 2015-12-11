// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.rdio.android.core.util.Logging;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.core:
//            ItemBatchProcessor

class this._cls0
    implements Runnable
{

    final ItemBatchProcessor this$0;

    public void run()
    {
_L5:
        Object obj = ItemBatchProcessor.access$000(ItemBatchProcessor.this);
        obj;
        JVM INSTR monitorenter ;
_L1:
        boolean flag;
        if (ItemBatchProcessor.access$100(ItemBatchProcessor.this).isEmpty())
        {
            break MISSING_BLOCK_LABEL_39;
        }
        flag = ItemBatchProcessor.access$200(ItemBatchProcessor.this);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        ItemBatchProcessor.access$000(ItemBatchProcessor.this).wait();
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
        obj1 = ItemBatchProcessor.access$000(ItemBatchProcessor.this);
        obj1;
        JVM INSTR monitorenter ;
        int i = ItemBatchProcessor.access$100(ItemBatchProcessor.this).size() - 1;
_L3:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((List) (obj3)).size() >= getMaxBatchSize())
        {
            break; /* Loop/switch isn't completed */
        }
        ((List) (obj3)).add(ItemBatchProcessor.access$100(ItemBatchProcessor.this).get(i));
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
            synchronized (ItemBatchProcessor.access$000(ItemBatchProcessor.this))
            {
                ItemBatchProcessor.access$100(ItemBatchProcessor.this).removeAll(((java.util.Collection) (obj3)));
                if (ItemBatchProcessor.access$100(ItemBatchProcessor.this).isEmpty())
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

    ()
    {
        this$0 = ItemBatchProcessor.this;
        super();
    }
}
