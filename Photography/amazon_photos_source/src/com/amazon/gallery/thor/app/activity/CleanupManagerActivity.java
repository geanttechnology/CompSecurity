// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.CabVisibilityNotification;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.widget.ItemMetadataViewFactory;
import com.amazon.gallery.framework.gallery.widget.ItemMetadataViewHolder;
import com.amazon.gallery.framework.gallery.widget.MediaItemListAdapter;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.activity.WhisperPlayActivity;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.fragment.DataFragment;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.CleanupPreferenceManager;
import com.amazon.gallery.thor.app.ui.MenuItemTinter;
import com.amazon.gallery.thor.app.ui.cab.CleanupManagerActivityContextBar;
import com.amazon.gallery.thor.app.ui.cab.CleanupTitleUpdater;
import com.amazon.gallery.thor.cleanupmanager.CleanupManagerDialogHelper;
import com.amazon.gallery.thor.cleanupmanager.CleanupManagerUiThreadHandler;
import com.amazon.gallery.thor.cleanupmanager.DeduplicationHelper;
import com.amazon.gallery.thor.di.GalleryActivityBeans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidToolbar, GalleryNavigationSetting

public class CleanupManagerActivity extends BeanAwareActivity
    implements WhisperPlayActivity
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent CleanupActivityAmountFound;
        public static final MetricsEvent CleanupActivityDeleteExecuted;
        public static final MetricsEvent CleanupActivityEntered;
        public static final MetricsEvent CleanupActivityExited;
        public static final MetricsEvent CleanupActivityInfoExecuted;
        public static final MetricsEvent CleanupActivityNoneFound;
        public static final MetricsEvent CleanupActivitySelect1Gb;
        public static final MetricsEvent CleanupActivitySelect2Gb;
        public static final MetricsEvent CleanupActivitySelect500Mb;
        public static final MetricsEvent CleanupActivitySelectAll;
        public static final MetricsEvent CleanupActivitySortChangedToLargest;
        public static final MetricsEvent CleanupActivitySortChangedToOldest;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/app/activity/CleanupManagerActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            CleanupActivityEntered = new MetricsEvent("CleanupActivityEntered", 0);
            CleanupActivityExited = new MetricsEvent("CleanupActivityExited", 1);
            CleanupActivityDeleteExecuted = new MetricsEvent("CleanupActivityDeleteExecuted", 2);
            CleanupActivitySortChangedToOldest = new MetricsEvent("CleanupActivitySortChangedToOldest", 3);
            CleanupActivitySortChangedToLargest = new MetricsEvent("CleanupActivitySortChangedToLargest", 4);
            CleanupActivitySelect500Mb = new MetricsEvent("CleanupActivitySelect500Mb", 5);
            CleanupActivitySelect1Gb = new MetricsEvent("CleanupActivitySelect1Gb", 6);
            CleanupActivitySelect2Gb = new MetricsEvent("CleanupActivitySelect2Gb", 7);
            CleanupActivitySelectAll = new MetricsEvent("CleanupActivitySelectAll", 8);
            CleanupActivityInfoExecuted = new MetricsEvent("CleanupActivityInfoExecuted", 9);
            CleanupActivityNoneFound = new MetricsEvent("CleanupActivityNoneFound", 10);
            CleanupActivityAmountFound = new MetricsEvent("CleanupActivityAmountFound", 11);
            $VALUES = (new MetricsEvent[] {
                CleanupActivityEntered, CleanupActivityExited, CleanupActivityDeleteExecuted, CleanupActivitySortChangedToOldest, CleanupActivitySortChangedToLargest, CleanupActivitySelect500Mb, CleanupActivitySelect1Gb, CleanupActivitySelect2Gb, CleanupActivitySelectAll, CleanupActivityInfoExecuted, 
                CleanupActivityNoneFound, CleanupActivityAmountFound
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private static class SavedState
    {

        private final DeduplicationHelper deduplicationHelper;
        private final List selectedItems;

        public DeduplicationHelper getDeduplicationHelper()
        {
            return deduplicationHelper;
        }

        public List getSelectedItems()
        {
            return selectedItems;
        }

        public SavedState(List list, DeduplicationHelper deduplicationhelper)
        {
            selectedItems = list;
            deduplicationHelper = deduplicationhelper;
        }
    }


    private static final String TAG = com/amazon/gallery/thor/app/activity/CleanupManagerActivity.getName();
    private AndroidToolbar actionBar;
    private CleanupManagerActivityContextBar cleanupManagerActivityContextBar;
    private CleanupPreferenceManager cleanupPreferenceManager;
    private DeduplicationHelper deduplicationHelper;
    private CleanupManagerDialogHelper dialogHelper;
    private DialogManager dialogManager;
    private boolean dismissActiveDialog;
    private MediaItemListAdapter mediaItemListAdapter;
    private ComponentProfiler profiler;
    private RecyclerAdapter recyclerAdapter;
    private DataFragment saveStateFragment;
    private CleanupManagerUiThreadHandler uiThreadHandler;

    public CleanupManagerActivity()
    {
        super(new GalleryActivityBeans());
        dismissActiveDialog = true;
    }

    private void executeSelectX(long l)
    {
        Iterator iterator = mediaItemListAdapter.getItems().iterator();
        do
        {
            MediaItem mediaitem;
label0:
            {
                if (iterator.hasNext())
                {
                    mediaitem = (MediaItem)iterator.next();
                    if (mediaitem.getSize() <= l)
                    {
                        break label0;
                    }
                }
                ((RecyclerView)findViewById(0x7f0c0114)).scrollToPosition(0);
                GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.TAP));
                recyclerAdapter.notifyDataSetChanged();
                return;
            }
            cleanupManagerActivityContextBar.addSelectable(mediaitem);
            l -= mediaitem.getSize();
        } while (true);
    }

    private void executeSortAction(int i)
    {
        if (i != 0x7f0c0242) goto _L2; else goto _L1
_L1:
        mediaItemListAdapter.addAll(deduplicationHelper.getDateSortedDuplicates());
        profiler.trackEvent(MetricsEvent.CleanupActivitySortChangedToOldest);
_L4:
        ((RecyclerView)findViewById(0x7f0c0114)).scrollToPosition(0);
        return;
_L2:
        if (i == 0x7f0c0241)
        {
            mediaItemListAdapter.addAll(deduplicationHelper.getSizeSortedDuplicates());
            profiler.trackEvent(MetricsEvent.CleanupActivitySortChangedToLargest);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void refreshSelectActionOptions()
    {
        Pair apair[] = new Pair[3];
        apair[0] = new Pair(actionBar.getToolbar().getMenu().findItem(0x7f0c023c), Long.valueOf(0x1f400000L));
        apair[1] = new Pair(actionBar.getToolbar().getMenu().findItem(0x7f0c023d), Long.valueOf(0x40000000L));
        apair[2] = new Pair(actionBar.getToolbar().getMenu().findItem(0x7f0c023e), Long.valueOf(0x80000000L));
        int j = apair.length;
        int i = 0;
        while (i < j) 
        {
            Pair pair = apair[i];
            MenuItem menuitem = (MenuItem)pair.first;
            boolean flag;
            if (deduplicationHelper.getTotalDupesFileSize() >= ((Long)pair.second).longValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            menuitem.setVisible(flag);
            i++;
        }
    }

    private void setScreenMode()
    {
        ((ScreenModeManager)getApplicationBean(Keys.SCREEN_MODE_MANAGER)).setScreenMode(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI, this);
    }

    private void setupActionBar()
    {
        actionBar = new AndroidToolbar(this, (Toolbar)findViewById(0x7f0c0086), null);
        actionBar.setTitle(getResources().getString(0x7f0e0144));
        actionBar.setNavigationSetting(GalleryNavigationSetting.BACK);
        actionBar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final CleanupManagerActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = CleanupManagerActivity.this;
                super();
            }
        });
        actionBar.inflateMenu(0x7f100000);
        int j = getResources().getColor(0x7f090091);
        Menu menu = actionBar.getMenu();
        if (menu != null)
        {
            for (int i = 0; i < menu.size(); i++)
            {
                MenuItemTinter.applyTint(menu.getItem(i).getIcon(), j);
            }

        }
        actionBar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {

            final CleanupManagerActivity this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                switch (menuitem.getItemId())
                {
                case 2131493434: 
                default:
                    return false;

                case 2131493435: 
                    actionBar.getToolbar().getMenu().findItem(0x7f0c023f).setTitle((new StringBuilder()).append(getString(0x7f0e007c)).append(" ( ").append(FileUtils.byteCountToDisplaySize(deduplicationHelper.getTotalDupesFileSize())).append(" )").toString());
                    return true;

                case 2131493436: 
                    executeSelectX(0x1f400000L);
                    profiler.trackEvent(MetricsEvent.CleanupActivitySelect500Mb);
                    return true;

                case 2131493437: 
                    executeSelectX(0x40000000L);
                    profiler.trackEvent(MetricsEvent.CleanupActivitySelect1Gb);
                    return true;

                case 2131493438: 
                    executeSelectX(0x80000000L);
                    profiler.trackEvent(MetricsEvent.CleanupActivitySelect2Gb);
                    return true;

                case 2131493439: 
                    cleanupManagerActivityContextBar.addAll(mediaItemListAdapter.getItems());
                    GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.TAP));
                    recyclerAdapter.notifyDataSetChanged();
                    profiler.trackEvent(MetricsEvent.CleanupActivitySelectAll);
                    return true;

                case 2131493433: 
                    dialogHelper.showInstructionDialog(deduplicationHelper.isNoDupesFound());
                    profiler.trackEvent(MetricsEvent.CleanupActivityInfoExecuted);
                    return true;
                }
            }

            
            {
                this$0 = CleanupManagerActivity.this;
                super();
            }
        });
        actionBar.setOnSortChangedListener(new OnSortingChangedListener() {

            final CleanupManagerActivity this$0;

            public void onSortingChanged(int k)
            {
                mediaItemListAdapter.clear();
                executeSortAction(k);
            }

            
            {
                this$0 = CleanupManagerActivity.this;
                super();
            }
        });
    }

    private void setupContextBar()
    {
        cleanupManagerActivityContextBar = new CleanupManagerActivityContextBar(this, 0x7f100001, new CleanupTitleUpdater(this));
    }

    private boolean setupFragment()
    {
        saveStateFragment = (DataFragment)getFragmentManager().findFragmentByTag("Cleanup_Fragment");
        if (saveStateFragment == null)
        {
            saveStateFragment = new DataFragment();
            getFragmentManager().beginTransaction().add(saveStateFragment, "Cleanup_Fragment").commit();
            return true;
        } else
        {
            return false;
        }
    }

    private void setupRecyclerView()
    {
        ((RecyclerView)findViewById(0x7f0c0114)).setLayoutManager(new LinearLayoutManager(this, 1, false));
        ItemMetadataViewFactory itemmetadataviewfactory = new ItemMetadataViewFactory(this, cleanupManagerActivityContextBar);
        mediaItemListAdapter = new MediaItemListAdapter(this, new ArrayList(), itemmetadataviewfactory);
        mediaItemListAdapter.registerDataSetObserver(new DataSetObserver() {

            final CleanupManagerActivity this$0;

            public void onChanged()
            {
                uiThreadHandler.sendRefreshViewMessage();
            }

            
            {
                this$0 = CleanupManagerActivity.this;
                super();
            }
        });
        recyclerAdapter = new RecyclerAdapter(mediaItemListAdapter, itemmetadataviewfactory);
        recyclerAdapter.setHasStableIds(true);
        recyclerAdapter.setOnClickListener(new android.view.View.OnClickListener() {

            final CleanupManagerActivity this$0;

            public void onClick(View view)
            {
                int i = ((android.support.v7.widget.RecyclerView.ViewHolder)view.getTag()).getPosition();
                MediaItem mediaitem = (MediaItem)mediaItemListAdapter.getItem(i);
                if (!cleanupManagerActivityContextBar.isContextBarActive())
                {
                    GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.TAP));
                }
                ItemMetadataViewHolder itemmetadataviewholder = (ItemMetadataViewHolder)(ItemMetadataViewHolder)view.getTag();
                if (itemmetadataviewholder == null)
                {
                    view = (CheckBox)view.findViewById(0x7f0c017c);
                } else
                {
                    view = itemmetadataviewholder.checkBox;
                }
                view.performClick();
                if (view.isChecked())
                {
                    cleanupManagerActivityContextBar.addSelectable(mediaitem);
                    return;
                } else
                {
                    cleanupManagerActivityContextBar.removeSelectable(mediaitem);
                    return;
                }
            }

            
            {
                this$0 = CleanupManagerActivity.this;
                super();
            }
        });
        ((RecyclerView)findViewById(0x7f0c0114)).setAdapter(recyclerAdapter);
    }

    public void finish()
    {
        deduplicationHelper.updateContext(null);
        dialogManager.dismissActiveDialog();
        profiler.trackEvent(MetricsEvent.CleanupActivityExited);
        super.finish();
    }

    public boolean getCleanupPreference()
    {
        return cleanupPreferenceManager.getCleanupPreference();
    }

    public CleanupManagerDialogHelper getDialogHelper()
    {
        return dialogHelper;
    }

    public MediaItemListAdapter getMediaItemListAdapter()
    {
        return mediaItemListAdapter;
    }

    public ComponentProfiler getProfiler()
    {
        return profiler;
    }

    public RecyclerAdapter getRecyclerAdapter()
    {
        return recyclerAdapter;
    }

    public CleanupManagerUiThreadHandler getUiThreadHandler()
    {
        return uiThreadHandler;
    }

    public boolean isWhisperPlayModeEnabled()
    {
        return false;
    }

    public void onActionCompleteEvent(ActionCompleteEvent actioncompleteevent)
    {
        if (actioncompleteevent.actionSource != null && actioncompleteevent.actionSource == com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent.ActionSource.DELETE)
        {
            actioncompleteevent = FileUtils.byteCountToDisplaySize(cleanupManagerActivityContextBar.getSelectablesFileSize());
            int i = cleanupManagerActivityContextBar.getSelectables().size();
            HashMap hashmap = new HashMap(2);
            hashmap.put("fileSize", actioncompleteevent);
            hashmap.put("numFiles", String.valueOf(i));
            profiler.trackEvent(MetricsEvent.CleanupActivityDeleteExecuted, hashmap);
            MediaItem mediaitem;
            for (actioncompleteevent = cleanupManagerActivityContextBar.getSelectables().iterator(); actioncompleteevent.hasNext(); deduplicationHelper.getDateSortedDuplicates().remove(mediaitem))
            {
                mediaitem = (MediaItem)actioncompleteevent.next();
                mediaItemListAdapter.remove(mediaitem);
                deduplicationHelper.getSizeSortedDuplicates().remove(mediaitem);
            }

            recyclerAdapter.notifyDataSetChanged();
            dialogHelper.showDeleteDialog(mediaItemListAdapter.isEmpty(), cleanupManagerActivityContextBar.getSelectablesFileSize());
            long l = deduplicationHelper.getTotalDupesFileSize();
            long l1 = cleanupManagerActivityContextBar.getSelectablesFileSize();
            deduplicationHelper.setTotalDupesFileSize(l - l1);
        }
        cleanupManagerActivityContextBar.clearSelectables();
        cleanupManagerActivityContextBar.hide();
        refreshSelectActionOptions();
    }

    public void onBackPressed()
    {
        if (!cleanupManagerActivityContextBar.getSelectables().isEmpty())
        {
            cleanupManagerActivityContextBar.clearSelectables();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCabVisibilityNotification(CabVisibilityNotification cabvisibilitynotification)
    {
        if (!cabvisibilitynotification.show)
        {
            recyclerAdapter.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030076);
        dialogManager = (DialogManager)getApplicationBean(Keys.DIALOG_MANAGER);
        profiler = new ComponentProfiler((Profiler)getApplicationBean(Keys.PROFILER), getClass());
        cleanupPreferenceManager = new CleanupPreferenceManager(this);
        uiThreadHandler = new CleanupManagerUiThreadHandler(this);
        dialogHelper = new CleanupManagerDialogHelper(this);
        if (bundle != null && bundle.containsKey("TIME"))
        {
            long l = bundle.getLong("TIME");
            if (SystemClock.uptimeMillis() - l < 5000L)
            {
                dismissActiveDialog = false;
            }
        }
        setupActionBar();
        setupContextBar();
        setScreenMode();
        if (setupFragment())
        {
            deduplicationHelper = new DeduplicationHelper(this);
            profiler.trackEvent(MetricsEvent.CleanupActivityEntered);
            deduplicationHelper.startDeduplication();
            findViewById(0x7f0c0115).setVisibility(0);
        }
        setupRecyclerView();
    }

    public void onPause()
    {
        cleanupManagerActivityContextBar.onPause();
        GlobalMessagingBus.unregister(this);
        super.onPause();
    }

    public void onProgressUpdate(long l)
    {
        uiThreadHandler.sendUpdateProgressBarMessage(l);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        deduplicationHelper = ((SavedState)saveStateFragment.getSavedState()).getDeduplicationHelper();
        deduplicationHelper.updateContext(this);
        if (!((SavedState)saveStateFragment.getSavedState()).getSelectedItems().isEmpty())
        {
            cleanupManagerActivityContextBar.restoreState(((SavedState)saveStateFragment.getSavedState()).getSelectedItems());
        }
        boolean flag;
        if (bundle.getBoolean("isSizeSorted"))
        {
            mediaItemListAdapter.addAll(deduplicationHelper.getSizeSortedDuplicates());
        } else
        {
            mediaItemListAdapter.addAll(deduplicationHelper.getDateSortedDuplicates());
        }
        bundle = (ProgressBar)findViewById(0x7f0c0116);
        bundle.setProgress(deduplicationHelper.getProgress());
        if (bundle.getProgress() >= bundle.getMax())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && !deduplicationHelper.isNoDupesFound())
        {
            findViewById(0x7f0c0115).setVisibility(0);
        } else
        {
            findViewById(0x7f0c0115).setVisibility(8);
            if (!deduplicationHelper.isNoDupesFound())
            {
                updateActionBar();
                return;
            }
        }
    }

    public void onResume()
    {
        super.onResume();
        if (dismissActiveDialog)
        {
            dialogManager.dismissActiveDialog();
        }
        if (!cleanupPreferenceManager.getCleanupPreference())
        {
            dialogHelper.showInstructionDialog(deduplicationHelper.isNoDupesFound());
        }
        cleanupManagerActivityContextBar.onResume();
        GlobalMessagingBus.register(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isSizeSorted", mediaItemListAdapter.getItems().equals(deduplicationHelper.getSizeSortedDuplicates()));
        bundle = new SavedState(cleanupManagerActivityContextBar.getSelectables(), deduplicationHelper);
        saveStateFragment.setSavedState(bundle);
    }

    public void setCleanupPreference(boolean flag)
    {
        cleanupPreferenceManager.setCleanupPreference(flag);
    }

    public void updateActionBar()
    {
        if (mediaItemListAdapter.getItems().equals(deduplicationHelper.getSizeSortedDuplicates()))
        {
            actionBar.setupSort(0x7f100002, 0x7f0c0241);
        } else
        {
            actionBar.setupSort(0x7f100002, 0x7f0c0242);
        }
        refreshSelectActionOptions();
        actionBar.getToolbar().getMenu().findItem(0x7f0c023a).setVisible(true);
        actionBar.getToolbar().getMenu().findItem(0x7f0c023b).setVisible(true);
    }











}
