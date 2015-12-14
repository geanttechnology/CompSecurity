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

class this._cls1
    implements Runnable
{

    final l.tag this$1;

    public void run()
    {
        FolderSettingsViewFactory.access$000(_fld0).removeTemporarySyncStates(tag, true, true, true);
    }

    l.tag()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/gallery/widget/FolderSettingsViewFactory$1

/* anonymous class */
    class FolderSettingsViewFactory._cls1
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final FolderSettingsViewFactory this$0;
        final Tag val$tag;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (flag != tag.hasProperty(TagProperty.AUTO_SAVE))
            {
                compoundbutton = new TagAutoSaveChangedEvent();
                if (flag)
                {
                    tag.setProperty(TagProperty.AUTO_SAVE);
                } else
                {
                    tag.setProperty(TagProperty.NO_AUTO_SAVE);
                    compoundbutton.setPostRunnable(new FolderSettingsViewFactory._cls1._cls1());
                }
                FolderSettingsViewFactory.access$000(FolderSettingsViewFactory.this).save(tag, true);
                GlobalMessagingBus.post(compoundbutton);
            }
        }

            
            {
                this$0 = final_foldersettingsviewfactory;
                tag = Tag.this;
                super();
            }
    }

}
