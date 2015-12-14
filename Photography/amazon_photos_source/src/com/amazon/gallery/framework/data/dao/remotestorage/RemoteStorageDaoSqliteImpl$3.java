// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao.remotestorage:
//            RemoteStorageDaoSqliteImpl

class val.filePath extends DBWriteExecutor
{

    final RemoteStorageDaoSqliteImpl this$0;
    final String val$filePath;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        readwritesqlitedatabase.delete("multipart_upload", String.format("%s = ?", new Object[] {
            "file_path"
        }), new String[] {
            val$filePath
        });
        return null;
    }

    ()
    {
        this$0 = final_remotestoragedaosqliteimpl;
        val$filePath = String.this;
        super();
    }
}
