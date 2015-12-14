// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.database.sqlite.SQLiteDatabase;
import com.amazon.clouddrive.exceptions.CloudDriveException;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataCleanup, MetadataSyncException

private class <init>
    implements com.amazon.mixtape.account.Task
{

    final MetadataCleanup this$0;

    public void run(SQLiteDatabase sqlitedatabase)
        throws CloudDriveException, MetadataSyncException, InterruptedException
    {
    }

    private Task()
    {
        this$0 = MetadataCleanup.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
