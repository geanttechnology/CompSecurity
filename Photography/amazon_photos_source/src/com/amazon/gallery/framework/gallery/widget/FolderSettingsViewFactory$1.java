// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.widget.CompoundButton;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            FolderSettingsViewFactory

class val.tag
    implements android.widget.geListener
{

    final FolderSettingsViewFactory this$0;
    final Tag val$tag;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag != val$tag.hasProperty(TagProperty.AUTO_SAVE))
        {
            compoundbutton = new TagAutoSaveChangedEvent();
            if (flag)
            {
                val$tag.setProperty(TagProperty.AUTO_SAVE);
            } else
            {
                val$tag.setProperty(TagProperty.NO_AUTO_SAVE);
                compoundbutton.setPostRunnable(new Runnable() {

                    final FolderSettingsViewFactory._cls1 this$1;

                    public void run()
                    {
                        FolderSettingsViewFactory.access$000(this$0).removeTemporarySyncStates(tag, true, true, true);
                    }

            
            {
                this$1 = FolderSettingsViewFactory._cls1.this;
                super();
            }
                });
            }
            FolderSettingsViewFactory.access$000(FolderSettingsViewFactory.this).save(val$tag, true);
            GlobalMessagingBus.post(compoundbutton);
        }
    }

    _cls1.this._cls1()
    {
        this$0 = final_foldersettingsviewfactory;
        val$tag = Tag.this;
        super();
    }
}
