// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaTagTypeObserver;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.dao.tag.TagTagTypeObserver;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.IntentPage;
import com.amazon.gallery.framework.kindle.activity.Page;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.kindle.widget.DebugPopup;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.CollectionListPickActivity;
import com.amazon.gallery.thor.app.activity.ThorChooserActivity;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import com.amazon.gallery.thor.widget.AndroidNavigationPane;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class NavigationPaneController
    implements android.support.design.widget.NavigationView.OnNavigationItemSelectedListener
{
    private class TagTypeDaoObserver
        implements MediaTagTypeObserver, TagTagTypeObserver
    {

        final NavigationPaneController this$0;

        private void notify(TagType tagtype)
        {
            if (NavigationPaneController.TAG_TYPES.contains(tagtype))
            {
                GLogger.d(NavigationPaneController.TAG, "Changes for tag type %s are found", new Object[] {
                    tagtype
                });
                updateItems();
            }
        }

        public void onMediaItemCollectionChanged(TagType tagtype)
        {
            notify(tagtype);
        }

        public void onTagsChanged(TagType tagtype, ChangeList changelist)
        {
            notify(tagtype);
        }

        private TagTypeDaoObserver()
        {
            this$0 = NavigationPaneController.this;
            super();
        }

    }

    private class UpdateItemsRunnable
        implements Runnable
    {

        private final WeakReference activityReference;
        final NavigationPaneController this$0;

        public void run()
        {
            updateCloudOnlyPages();
            ArrayList arraylist = new ArrayList();
            final ArrayList showItems = new ArrayList();
            Activity activity1 = (Activity)activityReference.get();
            if (activity1 != null)
            {
                for (Iterator iterator = NavigationPaneController.idToPage.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if (((Page)entry.getValue()).isValid(activity1))
                    {
                        showItems.add(entry.getKey());
                    } else
                    {
                        arraylist.add(entry.getKey());
                    }
                }

                activity1 = (Activity)activityReference.get();
                if (activity1 != null)
                {
                    activity1.runOnUiThread(arraylist. new Runnable() {

                        final UpdateItemsRunnable this$1;
                        final List val$hideItems;
                        final List val$showItems;

                        public void run()
                        {
                            if (navigationPane != null)
                            {
                                Integer integer;
                                for (Iterator iterator = showItems.iterator(); iterator.hasNext(); navigationPane.setItemVisible(integer.intValue()))
                                {
                                    integer = (Integer)iterator.next();
                                }

                                Integer integer1;
                                for (Iterator iterator1 = hideItems.iterator(); iterator1.hasNext(); navigationPane.setItemInvisible(integer1.intValue()))
                                {
                                    integer1 = (Integer)iterator1.next();
                                }

                            }
                        }

            
            {
                this$1 = final_updateitemsrunnable;
                showItems = list;
                hideItems = List.this;
                super();
            }
                    });
                    return;
                }
            }
        }

        public UpdateItemsRunnable(Activity activity1)
        {
            this$0 = NavigationPaneController.this;
            super();
            activityReference = new WeakReference(activity1);
        }
    }


    public static final Page ADD_PHOTOS;
    public static final IntentPage ALBUMS;
    public static final Page ALL;
    public static final Page CAMERA_ROLL;
    public static final Page DEBUG;
    public static final Page DEVICE;
    public static final Page HELP;
    public static final IntentPage MANAGE_STORAGE;
    public static final Page SETTINGS;
    private static final String TAG = com/amazon/gallery/thor/controller/NavigationPaneController.getName();
    private static final Set TAG_TYPES;
    public static final IntentPage THIS_DAY;
    public static final Page VIDEO;
    private static Map idToPage = null;
    private Activity activity;
    private final List cloudOnlyPages = new ArrayList();
    private final MediaItemDao mediaItemDao;
    private PhotosNavigationPane navigationPane;
    private SharedPreferences sharedPreferences;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferencesListener;
    private final TagDao tagDao;
    private final TagTypeDaoObserver tagObserver = new TagTypeDaoObserver();
    private final Executor uiReadyExecutor;

    public NavigationPaneController(Activity activity1, PhotosNavigationPane photosnavigationpane, TagDao tagdao, MediaItemDao mediaitemdao, Executor executor)
    {
        sharedPreferencesListener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

            final NavigationPaneController this$0;

            public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
            {
                while (sharedpreferences == null || !"coldBootStatus".equals(s)) 
                {
                    return;
                }
                updateItems();
            }

            
            {
                this$0 = NavigationPaneController.this;
                super();
            }
        };
        if (idToPage == null)
        {
            constructIdToPageMap();
        }
        activity = activity1;
        navigationPane = photosnavigationpane;
        tagDao = tagdao;
        mediaItemDao = mediaitemdao;
        uiReadyExecutor = executor;
        sharedPreferences = activity1.getSharedPreferences("galleryKindleSharedPrefs", 0);
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener);
        cloudOnlyPages.add(ALBUMS);
        cloudOnlyPages.add(THIS_DAY);
        cloudOnlyPages.add(MANAGE_STORAGE);
    }

    private static void constructIdToPageMap()
    {
        com/amazon/gallery/thor/controller/NavigationPaneController;
        JVM INSTR monitorenter ;
        idToPage = new HashMap();
        idToPage.put(Integer.valueOf(0x7f0c0268), ALL);
        idToPage.put(Integer.valueOf(0x7f0c026b), VIDEO);
        idToPage.put(Integer.valueOf(0x7f0c026c), CAMERA_ROLL);
        idToPage.put(Integer.valueOf(0x7f0c026a), ALBUMS);
        idToPage.put(Integer.valueOf(0x7f0c026d), DEVICE);
        idToPage.put(Integer.valueOf(0x7f0c0269), THIS_DAY);
        idToPage.put(Integer.valueOf(0x7f0c026f), ADD_PHOTOS);
        idToPage.put(Integer.valueOf(0x7f0c0270), SETTINGS);
        idToPage.put(Integer.valueOf(0x7f0c0271), HELP);
        idToPage.put(Integer.valueOf(0x7f0c0272), MANAGE_STORAGE);
        idToPage.put(Integer.valueOf(0x7f0c0273), DEBUG);
        com/amazon/gallery/thor/controller/NavigationPaneController;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void updateCloudOnlyPages()
    {
        boolean flag = sharedPreferences.getBoolean("coldBootStatus", false);
        for (Iterator iterator = cloudOnlyPages.iterator(); iterator.hasNext(); ((IntentPage)iterator.next()).setCloudContentExists(flag)) { }
    }

    public void onDestroy()
    {
        activity = null;
        navigationPane = null;
        if (sharedPreferences != null && sharedPreferencesListener != null)
        {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(sharedPreferencesListener);
        }
    }

    public boolean onNavigationItemSelected(MenuItem menuitem)
    {
        menuitem = (Page)idToPage.get(Integer.valueOf(menuitem.getItemId()));
        if (menuitem != null)
        {
            return menuitem.onClick(activity);
        } else
        {
            return false;
        }
    }

    public void onPause()
    {
        ((AndroidNavigationPane)navigationPane).setOnNavigationItemSelectedListener(null);
        TagType tagtype;
        for (Iterator iterator = TAG_TYPES.iterator(); iterator.hasNext(); mediaItemDao.unregisterObserver(tagObserver, tagtype))
        {
            tagtype = (TagType)iterator.next();
            tagDao.unregisterObserver(tagObserver, tagtype);
        }

    }

    public void onResume()
    {
        TagType tagtype;
        for (Iterator iterator = TAG_TYPES.iterator(); iterator.hasNext(); mediaItemDao.registerObserverByTagType(tagObserver, tagtype))
        {
            tagtype = (TagType)iterator.next();
            tagDao.registerObserver(tagObserver, tagtype);
        }

        ((AndroidNavigationPane)navigationPane).setOnNavigationItemSelectedListener(this);
        updateItems();
    }

    public void updateItems()
    {
        uiReadyExecutor.execute(new UpdateItemsRunnable(activity));
    }

    static 
    {
        ALL = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelAllPhotos, IntentUtil.getAllViewIntent(), com/amazon/gallery/thor/app/activity/ThorChooserActivity);
        VIDEO = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelAllVideos, IntentUtil.getVideoViewIntent(), EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE));
        CAMERA_ROLL = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelCameraRoll, IntentUtil.getCameraRollIntent(), com/amazon/gallery/thor/app/activity/ThorChooserActivity, EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_AOSP, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_WHEN_CAMERA_UNAVAILABLE));
        ALBUMS = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelFolders, IntentUtil.getCollectionListIntent(TagType.ALBUM), com/amazon/gallery/thor/app/activity/CollectionListPickActivity, EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_BEFORE_CLOUD_SYNC)) {

            public boolean onClick(Activity activity1)
            {
                PhotosDemoManager photosdemomanager = (PhotosDemoManager)ThorGalleryApplication.getBean(Keys.DEMO_MANAGER);
                if (photosdemomanager != null && photosdemomanager.isInDemoMode())
                {
                    photosdemomanager.showWarningForUnavailableAction(activity1);
                    return false;
                } else
                {
                    return super.onClick(activity1);
                }
            }

        };
        DEVICE = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelLocal, IntentUtil.getCollectionListIntent(TagType.LOCAL_FOLDER), com/amazon/gallery/thor/app/activity/CollectionListPickActivity);
        THIS_DAY = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelThisDay, IntentUtil.getThisDayCollectionViewIntent(), EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_BEFORE_CLOUD_SYNC, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_FREETIME_MODE)) {

            public boolean onClick(Activity activity1)
            {
                PhotosDemoManager photosdemomanager = (PhotosDemoManager)ThorGalleryApplication.getBean(Keys.DEMO_MANAGER);
                if (photosdemomanager != null && photosdemomanager.isInDemoMode())
                {
                    photosdemomanager.showWarningForUnavailableAction(activity1);
                    return false;
                } else
                {
                    return super.onClick(activity1);
                }
            }

        };
        ADD_PHOTOS = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelAddPhotos, IntentUtil.getAddPhotosIntent(), EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_FREETIME_MODE, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE));
        SETTINGS = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelSettings, IntentPage.getSettingsIntent(), EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_FREETIME_MODE, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE)) {

            public boolean onClick(Activity activity1)
            {
                PhotosDemoManager photosdemomanager = (PhotosDemoManager)ThorGalleryApplication.getBean(Keys.DEMO_MANAGER);
                if (photosdemomanager != null && photosdemomanager.isInDemoMode())
                {
                    photosdemomanager.showWarningForUnavailableAction(activity1);
                    return false;
                } else
                {
                    return super.onClick(activity1);
                }
            }

        };
        HELP = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelHelp, IntentPage.getHelpIntent(), EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_AOSP, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE));
        MANAGE_STORAGE = new IntentPage(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelManageStorage, null, EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_BEFORE_CLOUD_SYNC, com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_CHOOSER_MODE)) {

            public boolean onClick(Activity activity1)
            {
                GalleryWebViewHelper.startManageStorage(activity1);
                return true;
            }

        };
        DEBUG = new Page(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.LeftPanelDebug, EnumSet.of(com.amazon.gallery.framework.kindle.activity.Page.VisibilityFlag.INVISIBLE_IN_PRODUCTION)) {

            public boolean onClick(Activity activity1)
            {
                (new DebugPopup(activity1)).show();
                return true;
            }

        };
        TAG_TYPES = EnumSet.of(TagType.ALBUM, TagType.FOLDER, TagType.SOURCE);
    }





}
