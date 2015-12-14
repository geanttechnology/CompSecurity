// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.tag.PrependedFilteredList;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.gallery.widget.FolderSettingsViewFactory;
import com.amazon.gallery.framework.gallery.widget.FolderSettingsViewHolder;
import com.amazon.gallery.framework.gallery.widget.TagListAdapter;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.GridActivityParams;
import com.amazon.gallery.framework.kindle.activity.LeftPanelListActivity;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.fragment.SettingsFragment;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.camera.SystemPathProvider;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.di.NativeActivityBeans;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FolderSelectionActivity extends LeftPanelListActivity
    implements TagTagTypeObserver
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent InFolderSettings;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/app/activity/FolderSelectionActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            InFolderSettings = new MetricsEvent("InFolderSettings", 0);
            $VALUES = (new MetricsEvent[] {
                InFolderSettings
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    protected TagListAdapter listAdapter;
    private String locked_directories[];

    public FolderSelectionActivity()
    {
        super(new GridActivityParams(0x7f0c0121, com/amazon/gallery/framework/kindle/fragment/SettingsFragment, new ThorLaunchCamera(), new NativeActivityBeans()));
    }

    protected SyncHandler createSyncHandler()
    {
        return null;
    }

    protected Class getLauncherActivityClass()
    {
        return null;
    }

    protected BaseAdapter getListAdapter()
    {
        return listAdapter;
    }

    protected Enum getOpenEvent()
    {
        return MetricsEvent.InFolderSettings;
    }

    protected void initGridItemViewFactory()
    {
        int i = getResources().getDimensionPixelSize(0x7f0a0152);
        FolderSettingsViewFactory foldersettingsviewfactory = new FolderSettingsViewFactory(getApplicationContext(), tagDao, mediaItemDao);
        foldersettingsviewfactory.setLockedStyle(0x7f0f0205);
        foldersettingsviewfactory.setRegularStyle(0x7f0f0204);
        foldersettingsviewfactory.setLoadingStatusTracker(statusTracker);
        foldersettingsviewfactory.setContext(this);
        foldersettingsviewfactory.setBoundingSize(i);
        itemViewFactory = foldersettingsviewfactory;
    }

    protected void initListAdapter()
    {
        SystemPathProvider systempathprovider = new SystemPathProvider((FreeTime)ThorGalleryApplication.getBean(AppKeys.THOR_FREE_TIME), (RemovableStorageManager)ThorGalleryApplication.getBean(Keys.REMOVABLE_STORAGE_MANAGER));
        locked_directories = (new String[] {
            systempathprovider.getCameraDirPath(), systempathprovider.getRemovableCameraDirPath(), systempathprovider.getAttachmentsPath(), systempathprovider.getScreenshotsPath()
        });
        listAdapter = new TagListAdapter();
        listAdapter.setSortType(com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.NAME_DESC);
        listAdapter.setTagDao(tagDao);
        listAdapter.setViewFactory(itemViewFactory);
        refreshTags();
    }

    protected void initPipelineFactory()
    {
    }

    public void onAccountDeregistered()
    {
    }

    public void onAccountRegistered()
    {
    }

    protected void onClick(View view, int i)
    {
        FolderSettingsViewHolder foldersettingsviewholder = (FolderSettingsViewHolder)view.getTag();
        if (foldersettingsviewholder != null)
        {
            view = foldersettingsviewholder.checkbox;
        } else
        {
            view = (CheckBox)view.findViewById(0x7f0c014a);
        }
        view.performClick();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((TextView)findViewById(0x7f0c014d)).setText(getString(0x7f0e00a3));
        refreshTags();
        tagDao.registerObserver(this, TagType.LOCAL_FOLDER);
    }

    public void onDestroy()
    {
        super.onDestroy();
        listAdapter.onDestroy();
        tagDao.unregisterObserver(this, TagType.LOCAL_FOLDER);
    }

    public void onTagsChanged(TagType tagtype, ChangeList changelist)
    {
        runOnUiThread(new Runnable() {

            final FolderSelectionActivity this$0;

            public void run()
            {
                refreshTags();
            }

            
            {
                this$0 = FolderSelectionActivity.this;
                super();
            }
        });
    }

    protected void refreshTags()
    {
        List list = tagDao.getTagsByProperty(TagType.LOCAL_FOLDER, TagProperty.LOCAL, com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.NAME_ASC.getSortOrder());
        ArrayList arraylist = new ArrayList();
        String as[] = locked_directories;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = as[i];
            if (obj == null)
            {
                continue;
            }
            obj = tagDao.getTagsByPathPrefix(TagType.LOCAL_FOLDER, ((String) (obj)));
            if (((List) (obj)).size() == 1)
            {
                arraylist.add(((List) (obj)).get(0));
                ((Tag)((List) (obj)).get(0)).setLocalMetaField("locked", "true");
            }
        }

        HashSet hashset = new HashSet();
        hashset.addAll(tagDao.getTagsByProperty(TagType.LOCAL_FOLDER, TagProperty.FREETIME));
        listAdapter.setTags(new PrependedFilteredList(list, arraylist, hashset));
    }

    public void setActivityContentView()
    {
        setContentView(0x7f03008f);
    }

    protected void setupActionBar()
    {
        super.setupActionBar();
        setTitle(getResources().getString(0x7f0e0146));
    }
}
