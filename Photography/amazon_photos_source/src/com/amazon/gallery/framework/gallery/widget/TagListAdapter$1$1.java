// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.os.Handler;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            TagListAdapter

class val.newTags
    implements Runnable
{

    final val.newTags this$1;
    final List val$newTags;

    public void run()
    {
        setTags(val$newTags);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$newTags = List.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/gallery/widget/TagListAdapter$1

/* anonymous class */
    class TagListAdapter._cls1
        implements TagTagTypeObserver
    {

        final TagListAdapter this$0;

        public void onTagsChanged(TagType tagtype, ChangeList changelist)
        {
            boolean flag1 = false;
            tagtype = changelist.getAllChangeLists().iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!tagtype.hasNext())
                {
                    break;
                }
                if (!((Tag)tagtype.next()).hasProperty(TagListAdapter.access$000(TagListAdapter.this)))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (flag)
            {
                tagtype = loadTags(TagListAdapter.access$000(TagListAdapter.this));
                if (isTagsChanged(tagtype))
                {
                    TagListAdapter.access$100(TagListAdapter.this).post(tagtype. new TagListAdapter._cls1._cls1());
                }
            }
        }

            
            {
                this$0 = TagListAdapter.this;
                super();
            }
    }

}
