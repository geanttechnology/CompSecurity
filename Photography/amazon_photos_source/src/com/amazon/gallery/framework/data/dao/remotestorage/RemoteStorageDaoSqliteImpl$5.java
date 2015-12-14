// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import android.content.ContentValues;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.model.media.UploadChunk;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.remotestorage:
//            RemoteStorageDaoSqliteImpl

class val.uploadParts extends DBWriteExecutor
{

    final RemoteStorageDaoSqliteImpl this$0;
    final List val$uploadParts;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        ContentValues contentvalues;
        for (Iterator iterator = val$uploadParts.iterator(); iterator.hasNext(); readwritesqlitedatabase.replaceOrThrow("multipart_upload_part", null, contentvalues))
        {
            UploadChunk uploadchunk = (UploadChunk)iterator.next();
            contentvalues = new ContentValues();
            contentvalues.put("file_path", uploadchunk.getFilePath());
            contentvalues.put("chunk_number", Integer.valueOf(uploadchunk.getChunkNumber()));
            contentvalues.put("chunk_start_position", Long.valueOf(uploadchunk.getStartPosition()));
            contentvalues.put("chunk_url", uploadchunk.getUploadUrl());
            contentvalues.put("headers", uploadchunk.getHeaders());
            contentvalues.put("parameters", uploadchunk.getParameters());
        }

        return null;
    }

    ()
    {
        this$0 = final_remotestoragedaosqliteimpl;
        val$uploadParts = List.this;
        super();
    }
}
