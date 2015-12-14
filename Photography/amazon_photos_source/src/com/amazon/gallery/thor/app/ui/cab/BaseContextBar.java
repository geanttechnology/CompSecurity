// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.app.Activity;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.CabVisibilityNotification;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.gallery.cab.ContextBar;
import com.amazon.gallery.thor.app.activity.AndroidActionMode;
import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import com.amazon.gallery.thor.app.activity.GalleryActionModeCallback;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            TitleUpdater

public abstract class BaseContextBar
    implements ContextBar
{

    public static final String TAG = com/amazon/gallery/thor/app/ui/cab/BaseContextBar.getName();
    private final GalleryActionModeCallback actionModeCallback = new GalleryActionModeCallback() {

        final BaseContextBar this$0;

        public boolean onActionItemClicked(GalleryActionMode galleryactionmode, MenuItem menuitem)
        {
            galleryactionmode = (SelectionAction)actions.get(menuitem.getItemId());
            executeAction(galleryactionmode);
            return true;
        }

        public boolean onCreateActionMode(GalleryActionMode galleryactionmode, Menu menu)
        {
            return true;
        }

        public void onDestroyActionMode(GalleryActionMode galleryactionmode)
        {
            GlobalMessagingBus.post(new ActionCompleteEvent());
        }

        public boolean onPrepareActionMode(GalleryActionMode galleryactionmode, Menu menu)
        {
            BaseContextBar.this.onPrepareActionMode(galleryactionmode, menu);
            doSyncMenu();
            return true;
        }

            
            {
                this$0 = BaseContextBar.this;
                super();
            }
    };
    private final SparseArray actions = new SparseArray();
    protected Activity activity;
    protected final GalleryActionMode galleryActionMode;
    protected final List selectables;
    protected final TitleUpdater titleUpdater;

    public BaseContextBar(Activity activity1, int i, TitleUpdater titleupdater, List list)
    {
        activity = activity1;
        titleUpdater = titleupdater;
        selectables = list;
        galleryActionMode = new AndroidActionMode(activity1, i, titleupdater.getTitle());
    }

    private void removeSelectable(Object obj, boolean flag)
    {
        if (selectables.contains(obj))
        {
            selectables.remove(obj);
            syncSelectablesWithActionModeMenu();
            if (flag)
            {
                GlobalMessagingBus.post(new ItemChangeEvent());
            }
        }
    }

    public void addAction(int i, SelectionAction selectionaction)
    {
        actions.put(i, selectionaction);
        updateActionSelectable(i, selectionaction);
    }

    public void addAll(List list)
    {
        selectables.addAll(list);
        syncSelectablesWithActionModeMenu();
    }

    public void addSelectable(Object obj)
    {
        if (!selectables.contains(obj))
        {
            selectables.add(obj);
            syncSelectablesWithActionModeMenu();
        }
    }

    public void clearSelectables()
    {
        selectables.clear();
        syncSelectablesWithActionModeMenu();
        GlobalMessagingBus.post(new ItemChangeEvent());
    }

    protected void doSyncMenu()
    {
        Menu menu = galleryActionMode.getMenu();
        if (menu == null)
        {
            return;
        }
        for (int i = 0; i < actions.size(); i++)
        {
            int j = actions.keyAt(i);
            SelectionAction selectionaction = (SelectionAction)actions.get(j);
            if (menu.findItem(j) != null)
            {
                updateActionSelectable(j, selectionaction);
            }
        }

        setSubtitle();
    }

    protected abstract void executeAction(SelectionAction selectionaction);

    public List getSelectables()
    {
        return selectables;
    }

    protected void handleMultiSelectModeEvent(MultiSelectModeCommand multiselectmodecommand)
    {
        if (multiselectmodecommand.enabled)
        {
            if (multiselectmodecommand.entrance == com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.BUTTON)
            {
                updateEnabledActions();
            }
            show();
            return;
        } else
        {
            hide();
            return;
        }
    }

    public void hide()
    {
        if (isContextBarActive())
        {
            activity.runOnUiThread(new Runnable() {

                final BaseContextBar this$0;

                public void run()
                {
                    galleryActionMode.stopActionMode();
                }

            
            {
                this$0 = BaseContextBar.this;
                super();
            }
            });
        }
        GlobalMessagingBus.post(new CabVisibilityNotification(false));
    }

    public boolean isContextBarActive()
    {
        return galleryActionMode.isModeRunning();
    }

    public boolean isSelected(Object obj)
    {
        return selectables.contains(obj);
    }

    public void onPause()
    {
        GlobalMessagingBus.unregister(this);
    }

    protected void onPrepareActionMode(GalleryActionMode galleryactionmode, Menu menu)
    {
    }

    public void onResume()
    {
        GlobalMessagingBus.register(this);
    }

    public void removeSelectable(Object obj)
    {
        removeSelectable(obj, false);
    }

    public void restoreState(List list)
    {
        for (list = list.iterator(); list.hasNext(); addSelectable(list.next())) { }
        show();
    }

    protected void setMenuItemSelectable(int i, boolean flag)
    {
        if (galleryActionMode.getMenu() != null)
        {
            MenuItem menuitem = galleryActionMode.getMenu().findItem(i);
            if (menuitem != null)
            {
                menuitem.setVisible(flag);
            }
        }
    }

    public void setSubtitle()
    {
        activity.runOnUiThread(new Runnable() {

            final BaseContextBar this$0;

            public void run()
            {
                galleryActionMode.setSubtitle(titleUpdater.getSubTitle(selectables.size()));
            }

            
            {
                this$0 = BaseContextBar.this;
                super();
            }
        });
    }

    public void show()
    {
        if (!isContextBarActive())
        {
            galleryActionMode.startActionMode(actionModeCallback);
        }
        GlobalMessagingBus.post(new CabVisibilityNotification(true));
    }

    protected void syncSelectablesWithActionModeMenu()
    {
        if (selectables.size() == 0)
        {
            hide();
            return;
        } else
        {
            updateEnabledActions();
            return;
        }
    }

    protected void updateActionSelectable(int i, SelectionAction selectionaction)
    {
    }

    protected void updateEnabledActions()
    {
        activity.runOnUiThread(new Runnable() {

            final BaseContextBar this$0;

            public void run()
            {
                doSyncMenu();
                galleryActionMode.invalidate();
            }

            
            {
                this$0 = BaseContextBar.this;
                super();
            }
        });
    }


}
