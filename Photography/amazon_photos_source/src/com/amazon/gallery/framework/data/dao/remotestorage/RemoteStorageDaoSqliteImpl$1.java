// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.media.MultipartUpload;

// Referenced classes of package com.amazon.gallery.framework.data.dao.remotestorage:
//            RemoteStorageDaoSqliteImpl

class val.localPath extends DBReadExecutor
{

    final RemoteStorageDaoSqliteImpl this$0;
    final String val$localPath;

    public MultipartUpload execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return RemoteStorageDaoSqliteImpl.access$000(RemoteStorageDaoSqliteImpl.this, readonlysqlitedatabase, val$localPath);
    }

    public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    ()
    {
        this$0 = final_remotestoragedaosqliteimpl;
        val$localPath = String.this;
        super();
    }
}
