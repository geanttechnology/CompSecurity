// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            DBWriteExecutor, SortTypeSqliteImpl, ReadWriteSQLiteDatabase

class > extends DBWriteExecutor
{

    final SortTypeSqliteImpl this$0;
    final Collection val$tags;

    protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    protected Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        for (Iterator iterator = val$tags.iterator(); iterator.hasNext(); readwritesqlitedatabase.delete("sort_preference", "tag_id=?", new String[] {
    ((Tag)iterator.next()).getObjectId().toString()
})) { }
        return null;
    }

    se()
    {
        this$0 = final_sorttypesqliteimpl;
        val$tags = Collection.this;
        super();
    }
}
