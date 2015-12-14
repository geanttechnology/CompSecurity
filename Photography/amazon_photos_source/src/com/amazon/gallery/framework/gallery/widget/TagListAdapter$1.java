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

class this._cls0
    implements TagTagTypeObserver
{

    final TagListAdapter this$0;

    public void onTagsChanged(final TagType newTags, ChangeList changelist)
    {
        boolean flag1 = false;
        newTags = changelist.getAllChangeLists().iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!newTags.hasNext())
            {
                break;
            }
            if (!((Tag)newTags.next()).hasProperty(TagListAdapter.access$000(TagListAdapter.this)))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        if (flag)
        {
            newTags = loadTags(TagListAdapter.access$000(TagListAdapter.this));
            if (isTagsChanged(newTags))
            {
                TagListAdapter.access$100(TagListAdapter.this).post(new Runnable() {

                    final TagListAdapter._cls1 this$1;
                    final List val$newTags;

                    public void run()
                    {
                        setTags(newTags);
                    }

            
            {
                this$1 = TagListAdapter._cls1.this;
                newTags = list;
                super();
            }
                });
            }
        }
    }

    _cls1.val.newTags()
    {
        this$0 = TagListAdapter.this;
        super();
    }
}
