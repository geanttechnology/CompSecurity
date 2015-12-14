// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.filter.MediaTypeFilter;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagAllTagObserver;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogAsyncTask;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.notifications.UploadNotificationHandler;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadActionEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.watchdog.AutoSaveManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import com.amazon.gallery.thor.removablestorage.RemovableStorageStateListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            NewFeatureNotification, Keys

public class AutoSaveManagerImpl
    implements AutoSaveManager
{
    private static class AutoSaveTagSet
    {

        public static final AutoSaveTagSet LOCAL_TAGS = new AutoSaveTagSet(false);
        public static final AutoSaveTagSet REMOVABLE_TAGS = new AutoSaveTagSet(true);
        private boolean isForRemovableStorage;

        public boolean getAutoUploadFutureTags(SharedPreferences sharedpreferences)
        {
            return sharedpreferences.getBoolean(getAutoUploadFutureTagsKey(), true);
        }

        public String getAutoUploadFutureTagsKey()
        {
            if (isForRemovableStorage)
            {
                return "auto_save_all_future_removable_tags";
            } else
            {
                return "auto_save_all_future_tags";
            }
        }

        public int getDialogTitleId()
        {
            return !isForRemovableStorage ? 0x7f0e0063 : 0x7f0e0064;
        }

        public boolean getDisplayNewTagDialog(SharedPreferences sharedpreferences)
        {
            return sharedpreferences.getBoolean(getDisplayNewTagDialogKey(), true);
        }

        public String getDisplayNewTagDialogKey()
        {
            if (isForRemovableStorage)
            {
                return "display_new_removable_tag_dialog";
            } else
            {
                return "display_new_tag_dialog";
            }
        }

        public void setAutoUploadFutureTags(SharedPreferences sharedpreferences, boolean flag)
        {
            sharedpreferences.edit().putBoolean(getAutoUploadFutureTagsKey(), flag).apply();
        }

        public void setDisplayNewTagDialog(SharedPreferences sharedpreferences, boolean flag)
        {
            sharedpreferences.edit().putBoolean(getDisplayNewTagDialogKey(), flag).apply();
        }


        public AutoSaveTagSet(boolean flag)
        {
            isForRemovableStorage = flag;
        }
    }


    private static final long AUTO_SAVE_DELAY;
    public static final String TAG = com/amazon/gallery/framework/kindle/AutoSaveManagerImpl.getName();
    private Activity activity;
    private AtomicBoolean applyToFutureTags;
    private final DialogManager dialogManager;
    private final Handler handler = new Handler();
    private final MediaItemDao mediaItemDao;
    private final NetworkConnectivity networkConnectivity;
    private Set newTagsForDialog;
    private Runnable restartRunnable;
    private final SharedPreferences sharedPreferences;
    private RemovableStorageStateListener storageStateListener;
    private final TagAllTagObserver tagAllTagObserver = new TagAllTagObserver() {

        final AutoSaveManagerImpl this$0;

        public void onTagsChanged(ChangeList changelist)
        {
            changelist = new HashSet(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED));
            if (changelist.isEmpty())
            {
                GLogger.d(AutoSaveManagerImpl.TAG, "Added change list is empty, no further action needed", new Object[0]);
            } else
            {
                GLogger.d(AutoSaveManagerImpl.TAG, "%d new tag(s) detected", new Object[] {
                    Integer.valueOf(changelist.size())
                });
                tagDao.filter(changelist, TagProperty.LOCAL, true);
                tagDao.filter(changelist, TagProperty.FREETIME, false);
                forceAutoSave(changelist);
                HashSet hashset = new HashSet(changelist);
                tagDao.filter(hashset, TagProperty.REMOVABLE, true);
                tagDao.filter(changelist, TagProperty.REMOVABLE, false);
                if (!AutoSaveManagerImpl.isAutoSaveEnabled(sharedPreferences, MediaType.PHOTO) && !AutoSaveManagerImpl.isAutoSaveEnabled(sharedPreferences, MediaType.VIDEO))
                {
                    showNewFeatureNotificationIfUpgraded();
                    GLogger.d(AutoSaveManagerImpl.TAG, "Auto save is disabled, ignoring new tags", new Object[0]);
                    return;
                }
                if (!changelist.isEmpty())
                {
                    if (AutoSaveTagSet.LOCAL_TAGS.getDisplayNewTagDialog(sharedPreferences))
                    {
                        queueNewDialog(changelist, AutoSaveTagSet.LOCAL_TAGS);
                    } else
                    {
                        boolean flag = AutoSaveTagSet.LOCAL_TAGS.getAutoUploadFutureTags(sharedPreferences);
                        GLogger.v(AutoSaveManagerImpl.TAG, "Future tags set to %b, applying to new tag(s)", new Object[] {
                            Boolean.valueOf(flag)
                        });
                        if (flag)
                        {
                            enableAutoSave(changelist);
                        }
                    }
                }
                if (!hashset.isEmpty())
                {
                    if (AutoSaveTagSet.REMOVABLE_TAGS.getDisplayNewTagDialog(sharedPreferences))
                    {
                        queueNewDialog(hashset, AutoSaveTagSet.REMOVABLE_TAGS);
                        return;
                    }
                    boolean flag1 = AutoSaveTagSet.REMOVABLE_TAGS.getAutoUploadFutureTags(sharedPreferences);
                    GLogger.v(AutoSaveManagerImpl.TAG, "Removable future tags set to %b, applying to new tag(s)", new Object[] {
                        Boolean.valueOf(flag1)
                    });
                    if (flag1)
                    {
                        enableAutoSave(hashset);
                        return;
                    }
                }
            }
        }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                super();
            }
    };
    private final TagDao tagDao;
    private boolean upgradedFromTruth;
    private final UploadNotificationHandler uploadNotificationHandler;

    public AutoSaveManagerImpl(TagDao tagdao, MediaItemDao mediaitemdao, DialogManager dialogmanager, SharedPreferences sharedpreferences, NetworkConnectivity networkconnectivity, RemovableStorageManager removablestoragemanager, UploadNotificationHandler uploadnotificationhandler)
    {
        newTagsForDialog = null;
        restartRunnable = new Runnable() {

            final AutoSaveManagerImpl this$0;

            public void run()
            {
                GlobalMessagingBus.post(new UploadActionEvent(QueueType.AUTO_SAVE, UploadControlAction.START, AutoSaveManagerImpl.TAG));
            }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                super();
            }
        };
        applyToFutureTags = new AtomicBoolean(false);
        storageStateListener = new RemovableStorageStateListener() {

            final AutoSaveManagerImpl this$0;

            public void onMediaBadRemoval()
            {
            }

            public void onMediaMounted()
            {
            }

            public void onMediaUnmounted()
            {
                AutoSaveTagSet.REMOVABLE_TAGS.setAutoUploadFutureTags(sharedPreferences, false);
                AutoSaveTagSet.REMOVABLE_TAGS.setDisplayNewTagDialog(sharedPreferences, true);
            }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                super();
            }
        };
        tagDao = tagdao;
        dialogManager = dialogmanager;
        mediaItemDao = mediaitemdao;
        sharedPreferences = sharedpreferences;
        networkConnectivity = networkconnectivity;
        uploadNotificationHandler = uploadnotificationhandler;
        tagdao.registerObserver(tagAllTagObserver);
        removablestoragemanager.addListener(storageStateListener);
    }

    private Dialog createNewTagDialog(final Activity activity, final Set tags, final AutoSaveTagSet tagSet)
    {
        applyToFutureTags.set(true);
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final AutoSaveManagerImpl this$0;
            final Activity val$activity;
            final AutoSaveTagSet val$tagSet;
            final Set val$tags;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                if (j == -1)
                {
                    enableAutoSave(tags);
                    onNewTagPreferencesSet(true, tagSet);
                } else
                {
                    onNewTagPreferencesSet(false, tagSet);
                }
                NewFeatureNotification.launchNewFeatureNotificationIfNeverSeen((FragmentActivity)activity);
                ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
            }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                tags = set;
                tagSet = autosavetagset;
                activity = activity1;
                super();
            }
        };
        android.widget.CompoundButton.OnCheckedChangeListener oncheckedchangelistener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final AutoSaveManagerImpl this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                GLogger.v(AutoSaveManagerImpl.TAG, "Apply to future tags explicitly modified, set to %b", new Object[] {
                    Boolean.valueOf(flag)
                });
                applyToFutureTags.set(flag);
            }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                super();
            }
        };
        int i;
        if (tags.size() > 1)
        {
            tagSet = activity.getString(tagSet.getDialogTitleId());
        } else
        {
            tagSet = activity.getString(0x7f0e0061, new Object[] {
                ((Tag)tags.iterator().next()).getLabel()
            });
        }
        if (tags.size() > 1)
        {
            i = 0x7f0e0062;
        } else
        {
            i = 0x7f0e005d;
        }
        return dialogManager.createAutoSaveDialog(activity, tagSet, activity.getString(i), onclicklistener, oncheckedchangelistener);
    }

    private void enableAutoSave(Tag tag)
    {
        enableAutoSave(Collections.singleton(tag));
    }

    private void enableAutoSave(Set set)
    {
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ((Tag)iterator.next()).setProperty(TagProperty.AUTO_SAVE)) { }
        tagDao.save(set, true);
        GlobalMessagingBus.post(new TagAutoSaveChangedEvent());
    }

    private void forceAutoSave(Set set)
    {
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Tag tag = (Tag)set.next();
            if (tag.hasProperty(TagProperty.CAMERA))
            {
                GLogger.d(TAG, "Camera roll created, forcing auto save property", new Object[0]);
                enableAutoSave(tag);
                set.remove();
            }
        } while (true);
    }

    private MediaItemCollection getMediaCollectionForTag(Tag tag, MediaFilter mediafilter)
    {
        if (mediafilter == null)
        {
            return mediaItemDao.getUnuploadedItemsByTag(tag);
        } else
        {
            return mediaItemDao.getUnuploadedItemsByTag(tag, mediafilter);
        }
    }

    private MediaFilter getMediaFilter()
    {
        boolean flag = isAutoSaveEnabled(sharedPreferences, MediaType.PHOTO);
        boolean flag1 = isAutoSaveEnabled(sharedPreferences, MediaType.VIDEO);
        if (flag && !flag1 || networkConnectivity.getConnectionStatus() == com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.ConnectionStatus.WAN)
        {
            MediaFilter mediafilter = new MediaFilter();
            mediafilter.setMediaTypeFilter(new MediaTypeFilter(MediaType.PHOTO));
            GLogger.d(TAG, "Applying PHOTOS only filter", new Object[0]);
            return mediafilter;
        }
        if (!flag && flag1)
        {
            MediaFilter mediafilter1 = new MediaFilter();
            mediafilter1.setMediaTypeFilter(new MediaTypeFilter(MediaType.VIDEO));
            GLogger.d(TAG, "Applying VIDEOS only filter", new Object[0]);
            return mediafilter1;
        } else
        {
            GLogger.d(TAG, "No media filter applied", new Object[0]);
            return null;
        }
    }

    public static boolean isAutoSaveEnabled(SharedPreferences sharedpreferences, MediaType mediatype)
    {
        static class _cls9
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls9..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediatype.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return sharedpreferences.getBoolean("auto_upload_photos_key", false);

        case 2: // '\002'
            return sharedpreferences.getBoolean("auto_upload_videos_key", false);
        }
    }

    private void loadNewTagsForDialog()
    {
        Object obj = sharedPreferences.getStringSet("new_tags_for_dialog", Collections.emptySet());
        if (((Set) (obj)).size() > 0)
        {
            HashSet hashset = new HashSet(((Set) (obj)).size());
            obj = ((Set) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = (String)((Iterator) (obj)).next();
                obj1 = tagDao.getTagById(ObjectID.parseString(((String) (obj1))));
                if (obj1 != null)
                {
                    hashset.add(obj1);
                }
            } while (true);
            newTagsForDialog = hashset;
            return;
        } else
        {
            newTagsForDialog = new HashSet();
            return;
        }
    }

    private void onNewTagPreferencesSet(boolean flag, AutoSaveTagSet autosavetagset)
    {
        newTagsForDialog = null;
        sharedPreferences.edit().remove("new_tags_for_dialog").commit();
        SharedPreferences sharedpreferences = sharedPreferences;
        boolean flag1;
        if (!applyToFutureTags.get())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        autosavetagset.setDisplayNewTagDialog(sharedpreferences, flag1);
        autosavetagset.setAutoUploadFutureTags(sharedPreferences, flag);
    }

    private void queueNewDialog(Set set, AutoSaveTagSet autosavetagset)
    {
        if (activity == null)
        {
            return;
        }
        if (newTagsForDialog == null)
        {
            newTagsForDialog = set;
        } else
        {
            newTagsForDialog.addAll(set);
        }
        set = new HashSet(newTagsForDialog.size());
        for (Iterator iterator = newTagsForDialog.iterator(); iterator.hasNext(); set.add(((Tag)iterator.next()).getObjectId().toString())) { }
        sharedPreferences.edit().putStringSet("new_tags_for_dialog", set).commit();
        if (newTagsForDialog == null || newTagsForDialog.size() <= 0)
        {
            GLogger.v(TAG, "No tags to display for", new Object[0]);
            return;
        } else
        {
            GLogger.v(TAG, "Displaying new tag dialog", new Object[0]);
            set = new HashSet(newTagsForDialog);
            (new ShowDialogSyncTask(autosavetagset) {

                final AutoSaveManagerImpl this$0;
                final AutoSaveTagSet val$tagSet;
                final Set val$tagsToShow;

                protected Dialog createDialog()
                {
                    return createNewTagDialog(mActivity, tagsToShow, tagSet);
                }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                tagsToShow = set;
                tagSet = autosavetagset;
                super(final_activity1);
            }
            }).queue();
            return;
        }
    }

    private void restartAutoSave(Runnable runnable)
    {
        uploadNotificationHandler.clearNotification(QueueType.AUTO_SAVE);
        GLogger.i(TAG, "Removing restartRunnable callback from handler", new Object[0]);
        handler.removeCallbacks(restartRunnable);
        GlobalMessagingBus.post(new UploadActionEvent(QueueType.AUTO_SAVE, UploadControlAction.CANCEL, TAG));
        if (runnable != null)
        {
            handler.postDelayed(runnable, AUTO_SAVE_DELAY - 1L);
        }
        handler.postDelayed(restartRunnable, AUTO_SAVE_DELAY);
    }

    private void showNewFeatureNotificationIfUpgraded()
    {
        if (upgradedFromTruth && activity != null)
        {
            handler.post(new Runnable() {

                final AutoSaveManagerImpl this$0;

                public void run()
                {
                    NewFeatureNotification.launchNewFeatureNotificationIfNeverSeen((FragmentActivity)activity);
                }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                super();
            }
            });
        }
    }

    public Map getMediaItems()
    {
        HashMap hashmap = new HashMap();
        MediaFilter mediafilter = getMediaFilter();
        Object obj = tagDao.getTagsByProperty(TagType.LOCAL_FOLDER, TagProperty.AUTO_SAVE);
        GLogger.i(TAG, "Queried for auto save tags, return %d tags", new Object[] {
            Integer.valueOf(((List) (obj)).size())
        });
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Tag tag = (Tag)((Iterator) (obj)).next();
            MediaItemCollection mediaitemcollection = getMediaCollectionForTag(tag, mediafilter);
            if (!mediaitemcollection.getMediaItems().isEmpty())
            {
                hashmap.put(tag, mediaitemcollection);
            }
        } while (true);
        return hashmap;
    }

    public void onTagAutoSaveChangedEvent(TagAutoSaveChangedEvent tagautosavechangedevent)
    {
        restartAutoSave(tagautosavechangedevent.getPostRunnable());
    }

    public void registerObserver()
    {
        GlobalMessagingBus.register(this);
    }

    public void setContext(Activity activity1)
    {
        activity = activity1;
        if (activity1 == null)
        {
            return;
        } else
        {
            uploadNotificationHandler.clearCompleteNotification();
            upgradedFromTruth = (new AospPreferences(activity1)).getUpgradedFromTruth();
            (new ShowDialogAsyncTask(activity1) {

                private Set tagsToShow;
                final AutoSaveManagerImpl this$0;

                protected Dialog createDialog()
                {
                    return createNewTagDialog(mActivity, tagsToShow, AutoSaveTagSet.LOCAL_TAGS);
                }

                protected boolean shouldShowDialog()
                {
                    loadNewTagsForDialog();
                    tagsToShow = new HashSet(newTagsForDialog);
                    if (tagsToShow == null || tagsToShow.size() <= 0)
                    {
                        GLogger.v(AutoSaveManagerImpl.TAG, "No tags to display for", new Object[0]);
                        return false;
                    } else
                    {
                        GLogger.v(AutoSaveManagerImpl.TAG, "Displaying new tag dialog", new Object[0]);
                        return true;
                    }
                }

            
            {
                this$0 = AutoSaveManagerImpl.this;
                super(activity1);
                tagsToShow = null;
            }
            }).queue();
            return;
        }
    }

    public void showNewDialogForCurrentTags()
    {
        HashSet hashset = new HashSet(tagDao.getTagsByType(TagType.LOCAL_FOLDER));
        tagDao.filter(hashset, TagProperty.CAMERA, false);
        tagDao.filter(hashset, TagProperty.FREETIME, false);
        HashSet hashset1 = new HashSet(hashset);
        tagDao.filter(hashset, TagProperty.REMOVABLE, false);
        tagDao.filter(hashset1, TagProperty.REMOVABLE, true);
        if (hashset.size() > 0)
        {
            queueNewDialog(hashset, AutoSaveTagSet.LOCAL_TAGS);
        }
        if (hashset1.size() > 0)
        {
            queueNewDialog(hashset1, AutoSaveTagSet.REMOVABLE_TAGS);
        }
    }

    static 
    {
        AUTO_SAVE_DELAY = TimeUnit.SECONDS.toMillis(5L);
    }












}
