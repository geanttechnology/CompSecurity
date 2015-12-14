// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import android.content.ContentValues;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao.remotestorage:
//            RemoteStorageDaoSqliteImpl

class val.partNumber extends DBWriteExecutor
{

    final RemoteStorageDaoSqliteImpl this$0;
    final String val$etag;
    final String val$localPath;
    final int val$partNumber;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("etag", val$etag);
        readwritesqlitedatabase.update("multipart_upload_part", contentvalues, String.format("%s = ? AND %s = ?", new Object[] {
            "file_path", "chunk_number"
        }), new String[] {
            val$localPath, String.valueOf(val$partNumber)
        });
        return null;
    }

    ()
    {
        this$0 = final_remotestoragedaosqliteimpl;
        val$etag = s;
        val$localPath = s1;
        val$partNumber = I.this;
        super();
    }
}
