// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.remotestorage;

import android.content.ContentValues;
import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MultipartUpload;
import com.amazon.gallery.framework.model.media.UploadChunk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.remotestorage:
//            RemoteStorageDao

public class RemoteStorageDaoSqliteImpl
    implements RemoteStorageDao
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/remotestorage/RemoteStorageDaoSqliteImpl.getName();
    private GalleryDBConnectionManager connectionManager;

    public RemoteStorageDaoSqliteImpl(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        connectionManager = gallerydbconnectionmanager;
    }

    private MultipartUpload getMultipartUploadHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, String s)
    {
        Cursor cursor;
        cursor = readonlysqlitedatabase.query("multipart_upload", new String[] {
            "file_path", "object_id", "storage_key", "upload_id", "last_modified"
        }, "file_path=?", new String[] {
            s
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        int i = cursor.getCount();
        if (i == 0)
        {
            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
            return null;
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast()) goto _L2; else goto _L1
_L1:
        readonlysqlitedatabase = cursor.getString(cursor.getColumnIndex("file_path"));
        s = cursor.getString(cursor.getColumnIndex("object_id"));
        String s1 = cursor.getString(cursor.getColumnIndex("storage_key"));
        String s2 = cursor.getString(cursor.getColumnIndex("upload_id"));
        long l = cursor.getLong(cursor.getColumnIndex("last_modified"));
        readonlysqlitedatabase = new MultipartUpload(readonlysqlitedatabase, ObjectID.parseString(s), s1, s2, l);
_L3:
        s = readonlysqlitedatabase;
        if (cursor != null)
        {
            s = readonlysqlitedatabase;
            if (!cursor.isClosed())
            {
                cursor.close();
                s = readonlysqlitedatabase;
            }
        }
_L4:
        return s;
        readonlysqlitedatabase;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        throw readonlysqlitedatabase;
_L2:
        readonlysqlitedatabase = null;
          goto _L3
        s = null;
          goto _L4
    }

    private List getMultipartUploadPartsHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, String s)
    {
        ArrayList arraylist;
        Cursor cursor;
        arraylist = new ArrayList();
        cursor = readonlysqlitedatabase.query("multipart_upload_part", new String[] {
            "chunk_number", "chunk_start_position", "chunk_url", "headers", "parameters", "etag"
        }, "file_path=?", new String[] {
            s
        }, null, null, null);
        readonlysqlitedatabase = arraylist;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.getCount() != 0) goto _L4; else goto _L3
_L3:
        s = Collections.emptyList();
        readonlysqlitedatabase = s;
        if (cursor != null)
        {
            readonlysqlitedatabase = s;
            if (!cursor.isClosed())
            {
                cursor.close();
                readonlysqlitedatabase = s;
            }
        }
_L2:
        return readonlysqlitedatabase;
_L4:
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            arraylist.add(new UploadChunk(s, cursor.getInt(cursor.getColumnIndex("chunk_number")), cursor.getLong(cursor.getColumnIndex("chunk_start_position")), cursor.getString(cursor.getColumnIndex("chunk_url")), cursor.getString(cursor.getColumnIndex("headers")), cursor.getString(cursor.getColumnIndex("parameters")), cursor.getString(cursor.getColumnIndex("etag"))));
        }

        break MISSING_BLOCK_LABEL_280;
        readonlysqlitedatabase;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        throw readonlysqlitedatabase;
        readonlysqlitedatabase = arraylist;
        if (cursor != null)
        {
            readonlysqlitedatabase = arraylist;
            if (!cursor.isClosed())
            {
                cursor.close();
                return arraylist;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public MultipartUpload getMultipartUpload(final String localPath)
    {
        return (MultipartUpload)(new DBReadExecutor() {

            final RemoteStorageDaoSqliteImpl this$0;
            final String val$localPath;

            public MultipartUpload execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getMultipartUploadHelper(readonlysqlitedatabase, localPath);
            }

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = RemoteStorageDaoSqliteImpl.this;
                localPath = s;
                super();
            }
        }).execute(connectionManager);
    }

    public List getMultipartUploadParts(final String localPath)
    {
        return (List)(new DBReadExecutor() {

            final RemoteStorageDaoSqliteImpl this$0;
            final String val$localPath;

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            public List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getMultipartUploadPartsHelper(readonlysqlitedatabase, localPath);
            }

            
            {
                this$0 = RemoteStorageDaoSqliteImpl.this;
                localPath = s;
                super();
            }
        }).execute(connectionManager);
    }

    public void putMultipartUpload(final MultipartUpload mpUpload)
    {
        (new DBWriteExecutor() {

            final RemoteStorageDaoSqliteImpl this$0;
            final MultipartUpload val$mpUpload;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("object_id", mpUpload.getObjectId().toString());
                contentvalues.put("file_path", mpUpload.getFilePath());
                contentvalues.put("storage_key", mpUpload.getStorageKey());
                contentvalues.put("upload_id", mpUpload.getUploadId());
                contentvalues.put("last_modified", Long.valueOf(mpUpload.getLastModified()));
                readwritesqlitedatabase.replaceOrThrow("multipart_upload", null, contentvalues);
                return null;
            }

            
            {
                this$0 = RemoteStorageDaoSqliteImpl.this;
                mpUpload = multipartupload;
                super();
            }
        }).execute(connectionManager);
    }

    public void putMultipartUploadParts(final List uploadParts)
    {
        (new DBWriteExecutor() {

            final RemoteStorageDaoSqliteImpl this$0;
            final List val$uploadParts;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                ContentValues contentvalues;
                for (Iterator iterator = uploadParts.iterator(); iterator.hasNext(); readwritesqlitedatabase.replaceOrThrow("multipart_upload_part", null, contentvalues))
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

            
            {
                this$0 = RemoteStorageDaoSqliteImpl.this;
                uploadParts = list;
                super();
            }
        }).execute(connectionManager);
    }

    public void removeMultipartUpload(final String filePath)
    {
        (new DBWriteExecutor() {

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
                    filePath
                });
                return null;
            }

            
            {
                this$0 = RemoteStorageDaoSqliteImpl.this;
                filePath = s;
                super();
            }
        }).execute(connectionManager);
    }

    public void storeMultipartETag(final String localPath, final int partNumber, final String etag)
    {
        (new DBWriteExecutor() {

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
                contentvalues.put("etag", etag);
                readwritesqlitedatabase.update("multipart_upload_part", contentvalues, String.format("%s = ? AND %s = ?", new Object[] {
                    "file_path", "chunk_number"
                }), new String[] {
                    localPath, String.valueOf(partNumber)
                });
                return null;
            }

            
            {
                this$0 = RemoteStorageDaoSqliteImpl.this;
                etag = s;
                localPath = s1;
                partNumber = i;
                super();
            }
        }).execute(connectionManager);
    }



}
