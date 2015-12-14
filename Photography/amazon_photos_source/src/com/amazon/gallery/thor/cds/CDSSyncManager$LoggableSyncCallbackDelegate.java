// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncManager

private class <init>
    implements SennaSyncListener
{

    private final SennaSyncListener _flddelegate;
    private final String name;
    final CDSSyncManager this$0;

    public void onFirstSyncCompleted()
    {
        _flddelegate.onFirstSyncCompleted();
        CDSSyncManager.access$1300(CDSSyncManager.this).execute(new Runnable() {

            final CDSSyncManager.LoggableSyncCallbackDelegate this$1;

            public void run()
            {
                GLogger.logCustomerEvent("%s task is completed. Current cloud content in local database is %s", new Object[] {
                    name, CDSSyncManager.access$1200(this$0).getCloudCountByType()
                });
            }

            
            {
                this$1 = CDSSyncManager.LoggableSyncCallbackDelegate.this;
                super();
            }
        });
    }


    private _cls1.this._cls1(SennaSyncListener sennasynclistener, String s)
    {
        this$0 = CDSSyncManager.this;
        super();
        _flddelegate = sennasynclistener;
        name = s;
    }

    name(SennaSyncListener sennasynclistener, String s, name name1)
    {
        this(sennasynclistener, s);
    }
}
