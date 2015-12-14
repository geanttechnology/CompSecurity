// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.database.sqlite.SQLiteConstraintException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            DynamicAlbumDao

class utor extends DBWriteExecutor
{

    final DynamicAlbumDao this$0;
    final List val$mediaItems;
    final boolean val$notifyChange;
    final long val$tagId;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        try
        {
            readwritesqlitedatabase = (com.amazon.gallery.framework.data.dao.sqlite.abase.ReadWriteSQLiteStatement)DynamicAlbumDao.access$100().get();
            long l = System.currentTimeMillis();
            for (Iterator iterator = val$mediaItems.iterator(); iterator.hasNext(); readwritesqlitedatabase.executeInsert())
            {
                readwritesqlitedatabase.bindLong(1, ((Long)iterator.next()).longValue());
                readwritesqlitedatabase.bindLong(2, val$tagId);
                readwritesqlitedatabase.bindLong(3, l);
            }

        }
        // Misplaced declaration of an exception variable
        catch (ReadWriteSQLiteDatabase readwritesqlitedatabase)
        {
            GLogger.e(DynamicAlbumDao.access$200(), "Error inserting dynamic album", new Object[] {
                readwritesqlitedatabase
            });
        }
        return null;
    }

    protected void postTransaction()
    {
        if (val$notifyChange)
        {
            DynamicAlbumDao.access$300(DynamicAlbumDao.this, val$tagId);
        }
    }

    LiteDatabase()
    {
        this$0 = final_dynamicalbumdao;
        val$mediaItems = list;
        val$tagId = l;
        val$notifyChange = Z.this;
        super();
    }
}
