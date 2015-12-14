// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            TruthDBMigrationHelper

class this._cls0
    implements ThreadFactory
{

    final TruthDBMigrationHelper this$0;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, "TruthDBMigrationThread");
        runnable.setPriority(3);
        return runnable;
    }

    ()
    {
        this$0 = TruthDBMigrationHelper.this;
        super();
    }
}
