// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            GalleryDBConnectionManager, ReadWriteSQLiteDatabase

public abstract class DBWriteExecutor
{

    public DBWriteExecutor()
    {
    }

    public Object execute(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        ReadWriteSQLiteDatabase readwritesqlitedatabase;
        readwritesqlitedatabase = gallerydbconnectionmanager.getWritableConnection();
        preTransaction();
        Object obj;
        readwritesqlitedatabase.beginTransaction();
        obj = execute(readwritesqlitedatabase);
        readwritesqlitedatabase.setTransactionSuccessful();
        readwritesqlitedatabase.endTransaction();
        gallerydbconnectionmanager.release(readwritesqlitedatabase);
        postTransaction();
        return obj;
        Exception exception;
        exception;
        readwritesqlitedatabase.endTransaction();
        gallerydbconnectionmanager.release(readwritesqlitedatabase);
        throw exception;
    }

    protected abstract Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase);

    protected void postTransaction()
    {
    }

    protected void preTransaction()
    {
    }
}
