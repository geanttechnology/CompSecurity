// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import android.content.ContentValues;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MultipartUpload;

// Referenced classes of package com.amazon.gallery.framework.data.dao.remotestorage:
//            RemoteStorageDaoSqliteImpl

class val.mpUpload extends DBWriteExecutor
{

    final RemoteStorageDaoSqliteImpl this$0;
    final MultipartUpload val$mpUpload;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("object_id", val$mpUpload.getObjectId().toString());
        contentvalues.put("file_path", val$mpUpload.getFilePath());
        contentvalues.put("storage_key", val$mpUpload.getStorageKey());
        contentvalues.put("upload_id", val$mpUpload.getUploadId());
        contentvalues.put("last_modified", Long.valueOf(val$mpUpload.getLastModified()));
        readwritesqlitedatabase.replaceOrThrow("multipart_upload", null, contentvalues);
        return null;
    }

    ()
    {
        this$0 = final_remotestoragedaosqliteimpl;
        val$mpUpload = MultipartUpload.this;
        super();
    }
}
