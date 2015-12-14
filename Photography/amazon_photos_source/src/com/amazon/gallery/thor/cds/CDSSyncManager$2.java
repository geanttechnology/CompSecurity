// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.syncframework.MetadataSyncScheduler;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncManager

class this._cls0 extends AsyncTask
{

    final CDSSyncManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        while (!CDSSyncManager.access$100(CDSSyncManager.this) || CDSSyncManager.access$200(CDSSyncManager.this).getAndSet(1) == 1 || CDSSyncManager.access$300(CDSSyncManager.this) == null) 
        {
            return null;
        }
        GLogger.i(CDSSyncManager.access$400(), "Scheduling background mixtape sync. (%s %s)", new Object[] {
            Long.valueOf(1L), CDSSyncManager.access$800()
        });
        CDSSyncManager.access$700(CDSSyncManager.this).scheduleBackgroundSync(CDSSyncManager.access$600(CDSSyncManager.this), 1L, CDSSyncManager.access$800());
        return null;
    }

    aSyncScheduler()
    {
        this$0 = CDSSyncManager.this;
        super();
    }
}
