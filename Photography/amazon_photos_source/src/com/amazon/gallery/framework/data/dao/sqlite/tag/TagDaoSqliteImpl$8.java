// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import android.content.ContentResolver;
import android.content.Context;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagDaoSqliteImpl, TagDaoChangeList

class val.tags extends DBWriteExecutor
{

    final TagDaoSqliteImpl this$0;
    final Set val$tags;

    protected TagDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        Iterator iterator = val$tags.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Tag tag = (Tag)iterator.next();
            if (!tag.getType().equals(TagType.ALBUM))
            {
                String s = TagDaoSqliteImpl.access$300(new String[] {
                    "object_id_low", "object_id_hi"
                });
                long l = readwritesqlitedatabase.delete("tag", (new StringBuilder()).append(s).append(" AND NOT EXISTS (SELECT * FROM tag_membership WHERE tag_id=id)").toString(), new String[] {
                    (new StringBuilder()).append(tag.getObjectId().getLeastSignificantBits()).append("").toString(), (new StringBuilder()).append(tag.getObjectId().getMostSignificantBits()).append("").toString()
                });
                if (l > 0L)
                {
                    incrementSessionCounter();
                    tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.pe.REMOVED);
                    GLogger.v(TagDaoSqliteImpl.access$400(), "Deleted childless tag: %s, %d rows modified", new Object[] {
                        tag, Long.valueOf(l)
                    });
                }
            }
        } while (true);
        return tagdaochangelist;
    }

    protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
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
        val$tags = Set.this;
        super();
    }
}
