// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.mixtape.service.SyncProgressObserver;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncHandler

class this._cls0
    implements SyncProgressObserver
{

    final CDSSyncHandler this$0;

    public void onProgressUpdate(double d, double d1)
    {
        GLogger.i(CDSSyncHandler.access$000(), "onProgressChanged for metadata sync, progress: %f", new Object[] {
            Double.valueOf(d)
        });
        if (d == d1)
        {
            GLogger.i(CDSSyncHandler.access$000(), "First stage metadata sync has completed", new Object[0]);
            CDSSyncHandler.access$700(CDSSyncHandler.this);
        }
        CDSSyncHandler.access$500(CDSSyncHandler.this, d, ogress.Part.ONE);
    }

    ogress.Part()
    {
        this$0 = CDSSyncHandler.this;
        super();
    }
}
