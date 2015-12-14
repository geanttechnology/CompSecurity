// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            GalleryDBConnectionManager, ReadOnlySQLiteDatabase

public abstract class DBReadExecutor
{

    public DBReadExecutor()
    {
    }

    public Object execute(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        ReadOnlySQLiteDatabase readonlysqlitedatabase = gallerydbconnectionmanager.getReadableConnection();
        Object obj = execute(readonlysqlitedatabase);
        gallerydbconnectionmanager.release(readonlysqlitedatabase);
        return obj;
        Exception exception;
        exception;
        gallerydbconnectionmanager.release(readonlysqlitedatabase);
        throw exception;
    }

    protected abstract Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase);
}
