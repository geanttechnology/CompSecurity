// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagAllTagObserver;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl

class this._cls0
    implements TagAllTagObserver
{

    final AutoSaveManagerImpl this$0;

    public void onTagsChanged(ChangeList changelist)
    {
        changelist = new HashSet(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ADDED));
        if (changelist.isEmpty())
        {
            GLogger.d(AutoSaveManagerImpl.TAG, "Added change list is empty, no further action needed", new Object[0]);
        } else
        {
            GLogger.d(AutoSaveManagerImpl.TAG, "%d new tag(s) detected", new Object[] {
                Integer.valueOf(changelist.size())
            });
            AutoSaveManagerImpl.access$000(AutoSaveManagerImpl.this).filter(changelist, TagProperty.LOCAL, true);
            AutoSaveManagerImpl.access$000(AutoSaveManagerImpl.this).filter(changelist, TagProperty.FREETIME, false);
            AutoSaveManagerImpl.access$100(AutoSaveManagerImpl.this, changelist);
            HashSet hashset = new HashSet(changelist);
            AutoSaveManagerImpl.access$000(AutoSaveManagerImpl.this).filter(hashset, TagProperty.REMOVABLE, true);
            AutoSaveManagerImpl.access$000(AutoSaveManagerImpl.this).filter(changelist, TagProperty.REMOVABLE, false);
            if (!AutoSaveManagerImpl.isAutoSaveEnabled(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this), MediaType.PHOTO) && !AutoSaveManagerImpl.isAutoSaveEnabled(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this), MediaType.VIDEO))
            {
                AutoSaveManagerImpl.access$300(AutoSaveManagerImpl.this);
                GLogger.d(AutoSaveManagerImpl.TAG, "Auto save is disabled, ignoring new tags", new Object[0]);
                return;
            }
            if (!changelist.isEmpty())
            {
                if (toSaveTagSet.LOCAL_TAGS.getDisplayNewTagDialog(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this)))
                {
                    AutoSaveManagerImpl.access$400(AutoSaveManagerImpl.this, changelist, toSaveTagSet.LOCAL_TAGS);
                } else
                {
                    boolean flag = toSaveTagSet.LOCAL_TAGS.getAutoUploadFutureTags(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this));
                    GLogger.v(AutoSaveManagerImpl.TAG, "Future tags set to %b, applying to new tag(s)", new Object[] {
                        Boolean.valueOf(flag)
                    });
                    if (flag)
                    {
                        AutoSaveManagerImpl.access$500(AutoSaveManagerImpl.this, changelist);
                    }
                }
            }
            if (!hashset.isEmpty())
            {
                if (toSaveTagSet.REMOVABLE_TAGS.getDisplayNewTagDialog(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this)))
                {
                    AutoSaveManagerImpl.access$400(AutoSaveManagerImpl.this, hashset, toSaveTagSet.REMOVABLE_TAGS);
                    return;
                }
                boolean flag1 = toSaveTagSet.REMOVABLE_TAGS.getAutoUploadFutureTags(AutoSaveManagerImpl.access$200(AutoSaveManagerImpl.this));
                GLogger.v(AutoSaveManagerImpl.TAG, "Removable future tags set to %b, applying to new tag(s)", new Object[] {
                    Boolean.valueOf(flag1)
                });
                if (flag1)
                {
                    AutoSaveManagerImpl.access$500(AutoSaveManagerImpl.this, hashset);
                    return;
                }
            }
        }
    }

    toSaveTagSet()
    {
        this$0 = AutoSaveManagerImpl.this;
        super();
    }
}
