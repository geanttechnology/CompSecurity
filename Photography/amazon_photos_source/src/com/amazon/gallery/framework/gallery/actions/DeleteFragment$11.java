// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.os.AsyncTask;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class val.tags extends AsyncTask
{

    final DeleteFragment this$0;
    final Set val$tags;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new TagDaoChangeList();
        Iterator iterator = val$tags.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Tag tag = (Tag)iterator.next();
            List list = DeleteFragment.access$1200(DeleteFragment.this).getItemsByTag(tag).getMediaItems();
            if (!list.isEmpty())
            {
                DeleteFragment.access$1300(DeleteFragment.this).updateSortDateForTag(tag, list, false, true);
                avoid.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ype.MODIFIED);
            }
        } while (true);
        DeleteFragment.access$1300(DeleteFragment.this).notify(avoid);
        return null;
    }

    st()
    {
        this$0 = final_deletefragment;
        val$tags = Set.this;
        super();
    }
}
