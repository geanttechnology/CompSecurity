// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import android.content.ContentResolver;
import android.content.Context;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import java.util.Collection;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagDaoSqliteImpl, TagDaoChangeList

class val.tags extends DBWriteExecutor
{

    final TagDaoSqliteImpl this$0;
    final Collection val$tags;

    public TagDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        TagDaoSqliteImpl.access$500(TagDaoSqliteImpl.this, val$tags, readwritesqlitedatabase, tagdaochangelist);
        if (!tagdaochangelist.getAllChangeList().isEmpty())
        {
            incrementSessionCounter();
        }
        return tagdaochangelist;
    }

    public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    protected void postTransaction()
    {
        TagDaoSqliteImpl.access$200(TagDaoSqliteImpl.this).getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.entProvider.Tag.CONTENT_URI, null);
    }

    ()
    {
        this$0 = final_tagdaosqliteimpl;
        val$tags = Collection.this;
        super();
    }
}
