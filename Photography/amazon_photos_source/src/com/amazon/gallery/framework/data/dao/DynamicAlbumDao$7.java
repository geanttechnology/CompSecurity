// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            DynamicAlbumDao

class utor extends DBWriteExecutor
{

    final DynamicAlbumDao this$0;
    final List val$mediaItemIds;
    final long val$tagId;

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        Object obj = new ArrayList(val$mediaItemIds.size());
        for (int i = 0; i < val$mediaItemIds.size(); i++)
        {
            ((List) (obj)).add(String.valueOf(val$mediaItemIds.get(i)));
        }

        Object obj1;
        for (obj = DynamicAlbumDao.access$500(DynamicAlbumDao.this, ((List) (obj))).iterator(); ((Iterator) (obj)).hasNext(); ((com.amazon.gallery.framework.data.dao.sqlite.abase.ReadWriteSQLiteStatement) (obj1)).executeUpdateDelete())
        {
            obj1 = Arrays.toString(((List)((Iterator) (obj)).next()).toArray()).replace('[', '(').replace(']', ')');
            obj1 = readwritesqlitedatabase.compileStatement(SQLiteDaoUtil.deleteClause("dynamic_album_membership", (new StringBuilder()).append("tag_id=? AND media_item_id IN ").append(((String) (obj1))).toString()));
            ((com.amazon.gallery.framework.data.dao.sqlite.abase.ReadWriteSQLiteStatement) (obj1)).bindLong(1, val$tagId);
        }

        return null;
    }

    protected void postTransaction()
    {
        DynamicAlbumDao.access$300(DynamicAlbumDao.this, val$tagId);
    }

    LiteDatabase()
    {
        this$0 = final_dynamicalbumdao;
        val$mediaItemIds = list;
        val$tagId = J.this;
        super();
    }
}
