// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.view.Menu;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            BaseContextBar, MultiSelectTitleUpdater

public class TagContextBar extends BaseContextBar
    implements TagTagTypeObserver
{

    private TagType tagType;

    public TagContextBar(BeanAwareActivity beanawareactivity, int i)
    {
        super(beanawareactivity, i, new MultiSelectTitleUpdater(beanawareactivity), new CopyOnWriteArrayList());
    }

    private void resetMenu()
    {
        boolean flag3 = true;
        doSyncMenu();
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (TagType.LOCAL_FOLDER == tagType)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (TagType.ALBUM == tagType)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        setMenuItemSelectable(0x7f0c0246, flag2);
        setMenuItemSelectable(0x7f0c0247, flag1);
        if (flag1 && getSelectables().size() == 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        setMenuItemSelectable(0x7f0c0248, flag2);
        if (flag1 || flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setMenuItemSelectable(0x7f0c0245, flag1);
        setMenuItemSelectable(0x7f0c0243, FeatureManager.isFeatureEnabled(Features.CMS));
        if (FeatureManager.isFeatureEnabled(Features.SHARE_ALBUM) && flag)
        {
            flag1 = flag3;
        } else
        {
            flag1 = false;
        }
        setMenuItemSelectable(0x7f0c0249, flag1);
    }

    protected void executeAction(SelectionAction selectionaction)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(getSelectables());
        selectionaction.executeTags(arraylist);
    }

    public TagType getTagType()
    {
        return tagType;
    }

    public void onActionCompleteEvent(ActionCompleteEvent actioncompleteevent)
    {
        clearSelectables();
        hide();
    }

    public void onMultiSelectModeCommand(MultiSelectModeCommand multiselectmodecommand)
    {
        handleMultiSelectModeEvent(multiselectmodecommand);
    }

    protected void onPrepareActionMode(GalleryActionMode galleryactionmode, Menu menu)
    {
        resetMenu();
    }

    public void onTagsChanged(TagType tagtype, ChangeList changelist)
    {
        tagtype = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED).iterator();
        do
        {
            if (!tagtype.hasNext())
            {
                break;
            }
            changelist = (Tag)tagtype.next();
            if (isSelected(changelist))
            {
                removeSelectable(changelist);
            }
        } while (true);
    }

    protected void updateActionSelectable(int i, SelectionAction selectionaction)
    {
        setMenuItemSelectable(i, selectionaction.canExecuteTags(getSelectables()));
    }

    public void updateTagType(TagType tagtype)
    {
        tagType = tagtype;
        if (galleryActionMode.getMenu() == null)
        {
            return;
        } else
        {
            resetMenu();
            galleryActionMode.invalidate();
            return;
        }
    }
}
