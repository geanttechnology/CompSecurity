// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncManager

class this._cls1
    implements Runnable
{

    final ByType this$1;

    public void run()
    {
        GLogger.logCustomerEvent("%s task is completed. Current cloud content in local database is %s", new Object[] {
            cess._mth1100(this._cls1.this), CDSSyncManager.access$1200(_fld0).getCloudCountByType()
        });
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
