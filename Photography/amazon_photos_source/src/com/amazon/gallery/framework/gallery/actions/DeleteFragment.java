// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.CompoundButton;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.metrics.EngagementMetrics;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.albums.DeleteAlbumTask;
import com.amazon.gallery.thor.albums.DeleteFromAlbumTask;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            PersistentDialogFragment, DeleteAction

public class DeleteFragment extends PersistentDialogFragment
{

    private static final String TAG = com/amazon/gallery/framework/gallery/actions/DeleteFragment.getName();
    private MediaItemAction.ActionSource actionSource;
    private ComponentProfiler albumsProfiler;
    private ComponentProfiler componentProfiler;
    private boolean deleteCloudAndLocal;
    private DialogManager dialogManager;
    private EngagementMetrics engagementProfiler;
    private DeleteAction.Selection itemSelection;
    private MediaItemDao mediaItemDao;
    private List mediaItemList;
    private MediaStoreHelper mediaStoreHelper;
    private NetworkConnectivity networkConnectivity;
    private NetworkExecutor networkExecutor;
    private String parentObjectId;
    private RestClient restClient;
    private SortTypeDao sortTypeDao;
    private DeleteAction.SourceType sourceType;
    private volatile boolean success;
    private TagDao tagDao;
    private List tagList;
    private Timer timer;

    public DeleteFragment()
    {
        success = false;
    }

    private boolean areAllAlbums(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (!((Tag)list.next()).hasProperty(TagProperty.CLOUD))
            {
                return false;
            }
        }

        return true;
    }

    private boolean areAllLocalFolders(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (!((Tag)list.next()).hasProperty(TagProperty.LOCAL))
            {
                return false;
            }
        }

        return true;
    }

    private void changeCovers(Set set)
    {
        HashSet hashset = new HashSet();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Tag tag = (Tag)set.next();
            MediaItem mediaitem = mediaItemDao.getItemsByTag(tag).getCoverMediaItem();
            if (mediaitem != null && !mediaitem.getObjectId().equals(tag.getCoverId()))
            {
                tag.setCoverId(mediaitem.getObjectId());
                hashset.add(tag);
            }
        } while (true);
        tagDao.save(hashset, true);
    }

    private void executeAndShowSpinner(Runnable runnable, Runnable runnable1)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        runnable = new BlockingSpinnerDialog(fragmentactivity, runnable, fragmentactivity.getString(0x7f0e008e));
        runnable.setPostExecuteTask(runnable1);
        runnable.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private Runnable getDeleteFromAlbumRunnable(final Activity activity, final List mediaItemList, final String parentObjectId, final boolean deleteCloud)
    {
        return new Runnable() {

            final DeleteFragment this$0;
            final Activity val$activity;
            final boolean val$deleteCloud;
            final List val$mediaItemList;
            final String val$parentObjectId;

            public void run()
            {
                deleteMediaItemsFromAlbum(activity, mediaItemList, parentObjectId, deleteCloud);
            }

            
            {
                this$0 = DeleteFragment.this;
                activity = activity1;
                mediaItemList = list;
                parentObjectId = s;
                deleteCloud = flag;
                super();
            }
        };
    }

    private Runnable getDeleteRunnable(final List mediaItemList)
    {
        return new Runnable() {

            final DeleteFragment this$0;
            final List val$mediaItemList;

            public void run()
            {
                deleteMediaItems(mediaItemList);
            }

            
            {
                this$0 = DeleteFragment.this;
                mediaItemList = list;
                super();
            }
        };
    }

    public static DeleteFragment getInstance(DeleteAction.Selection selection, List list)
    {
        Bundle bundle = new Bundle();
        bundle.putInt(com/amazon/gallery/framework/gallery/actions/DeleteAction$Selection.getSimpleName(), selection.ordinal());
        selection = new DeleteFragment();
        selection.setArguments(bundle);
        selection.setTagList(list);
        return selection;
    }

    public static DeleteFragment getInstance(MediaItemAction.ActionSource actionsource, DeleteAction.SourceType sourcetype, DeleteAction.Selection selection, List list, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt(com/amazon/gallery/framework/gallery/actions/MediaItemAction$ActionSource.getSimpleName(), actionsource.ordinal());
        bundle.putInt(com/amazon/gallery/framework/gallery/actions/DeleteAction$SourceType.getSimpleName(), sourcetype.ordinal());
        bundle.putInt(com/amazon/gallery/framework/gallery/actions/DeleteAction$Selection.getSimpleName(), selection.ordinal());
        if (s != null)
        {
            bundle.putString(DeleteAction.KEY_EXTRA_PARENT_OBJECT_ID, s);
        }
        actionsource = new DeleteFragment();
        actionsource.setArguments(bundle);
        actionsource.setMediaItemList(list);
        return actionsource;
    }

    public static DeleteFragment getInstanceWithoutDialog(List list)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("NO_DIALOG", true);
        DeleteFragment deletefragment = new DeleteFragment();
        deletefragment.setArguments(bundle);
        deletefragment.setMediaItemList(list);
        return deletefragment;
    }

    private Dialog initAlbumDeletion()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        String s2 = "";
        String s;
        String s1;
        if (tagList.size() == 1)
        {
            s = fragmentactivity.getString(0x7f0e001e, new Object[] {
                ViewNameFactory.getTitle((Tag)tagList.get(0), fragmentactivity)
            });
        } else
        {
            s = fragmentactivity.getString(0x7f0e001f, new Object[] {
                String.valueOf(tagList.size())
            });
        }
        s1 = s;
        if (BuildFlavors.isAosp())
        {
            s1 = "";
            s2 = s;
        }
        return setupDeleteAlbumsDialog(fragmentactivity, s1, s2, new DeleteAlbumTask(fragmentactivity, tagList, albumsProfiler));
    }

    private Dialog initLocalFoldersDeletion()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        success = false;
        Runnable runnable = new Runnable() {

            final DeleteFragment this$0;

            public void run()
            {
                deleteTags(tagList);
            }

            
            {
                this$0 = DeleteFragment.this;
                super();
            }
        };
        Runnable runnable1 = new Runnable() {

            final DeleteFragment this$0;

            public void run()
            {
                if (success)
                {
                    GLogger.d(DeleteFragment.TAG, "Delete Tag(s) Successful", new Object[0]);
                    GlobalMessagingBus.post(new ActionCompleteEvent(com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent.ActionSource.DELETE));
                    return;
                } else
                {
                    GLogger.d(DeleteFragment.TAG, "Delete Tag(s) Failed", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = DeleteFragment.this;
                super();
            }
        };
        String s = ViewNameFactory.getTitle((Tag)tagList.get(0), fragmentactivity);
        String s2 = "";
        String s1;
        if (tagList.size() > 1)
        {
            s = fragmentactivity.getString(0x7f0e0087);
        } else
        {
            s = fragmentactivity.getString(0x7f0e0086, new Object[] {
                s
            });
        }
        s1 = s;
        if (BuildFlavors.isAosp())
        {
            s1 = "";
            s2 = s;
        }
        return setupThisDialog(fragmentactivity, s1, s2, runnable, runnable1);
    }

    private Dialog initMediaItemDeletion()
    {
        String s;
        android.support.v4.app.FragmentActivity fragmentactivity;
        final DeleteAction.MetricsEvent completeEvent;
        DeleteAction.MetricsEvent metricsevent;
        fragmentactivity = getActivity();
        success = false;
        s = "";
        metricsevent = DeleteAction.MetricsEvent.getEvent(itemSelection, actionSource, DeleteAction.ActionState.ACTIVATED);
        completeEvent = DeleteAction.MetricsEvent.getEvent(itemSelection, actionSource, DeleteAction.ActionState.COMPLETED);
        static class _cls12
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection = new int[DeleteAction.Selection.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[DeleteAction.Selection.REMOVE_FROM_ALBUM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[DeleteAction.Selection.CLOUD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[DeleteAction.Selection.DELETE_FROM_ALBUM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[DeleteAction.Selection.LOCAL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[DeleteAction.Selection.CLOUD_AND_LOCAL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$DeleteAction$Selection[DeleteAction.Selection.UNIFIED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls12..SwitchMap.com.amazon.gallery.framework.gallery.actions.DeleteAction.Selection[itemSelection.ordinal()];
        JVM INSTR tableswitch 1 6: default 96
    //                   1 107
    //                   2 257
    //                   3 257
    //                   4 283
    //                   5 309
    //                   6 344;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalStateException("Photos selected are neither cloud or local!");
_L2:
        Object obj;
        timer = engagementProfiler.newTimer(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteFromAlbumDialogDisplayed);
        obj = fragmentactivity.getString(0x7f0e002c);
_L8:
        String s1;
        String s2;
label0:
        {
            s2 = ((String) (obj));
            s1 = s;
            if (!BuildFlavors.isAosp())
            {
                break label0;
            }
            if (itemSelection != DeleteAction.Selection.CLOUD)
            {
                s2 = ((String) (obj));
                s1 = s;
                if (itemSelection != DeleteAction.Selection.LOCAL)
                {
                    break label0;
                }
            }
            s2 = "";
            s1 = ((String) (obj));
        }
        if (metricsevent != null && componentProfiler != null)
        {
            componentProfiler.trackEvent(metricsevent);
        }
        if (timer != null)
        {
            timer.start();
        }
        if (itemSelection == DeleteAction.Selection.REMOVE_FROM_ALBUM)
        {
            obj = getDeleteFromAlbumRunnable(fragmentactivity, mediaItemList, parentObjectId, false);
        } else
        if (itemSelection == DeleteAction.Selection.DELETE_FROM_ALBUM)
        {
            obj = getDeleteFromAlbumRunnable(fragmentactivity, mediaItemList, parentObjectId, true);
        } else
        {
            obj = getDeleteRunnable(mediaItemList);
        }
        return setupThisDialog(fragmentactivity, s2, s1, ((Runnable) (obj)), new Runnable() {

            final DeleteFragment this$0;
            final DeleteAction.MetricsEvent val$completeEvent;

            public void run()
            {
                if (success)
                {
                    GLogger.d(DeleteFragment.TAG, " Delete MediaItem(s) Successful", new Object[0]);
                    if (completeEvent != null && componentProfiler != null)
                    {
                        componentProfiler.trackEvent(completeEvent);
                    }
                    GlobalMessagingBus.post(new ActionCompleteEvent(com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent.ActionSource.DELETE));
                    return;
                } else
                {
                    GLogger.d(DeleteFragment.TAG, " Delete MediaItem(s) Failed", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = DeleteFragment.this;
                completeEvent = metricsevent;
                super();
            }
        });
_L3:
        timer = engagementProfiler.newTimer(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteFromCloudDriveDialogDisplayed);
        obj = fragmentactivity.getString(0x7f0e008a);
        continue; /* Loop/switch isn't completed */
_L4:
        timer = engagementProfiler.newTimer(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteFromYourDeviceDialogDisplayed);
        obj = fragmentactivity.getString(0x7f0e0087);
        continue; /* Loop/switch isn't completed */
_L5:
        timer = engagementProfiler.newTimer(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeviceAndCloudDeleteDialogDisplayed);
        s = fragmentactivity.getString(0x7f0e008c);
        obj = fragmentactivity.getString(0x7f0e008d);
        continue; /* Loop/switch isn't completed */
_L6:
        if (sourceType == DeleteAction.SourceType.CLOUD)
        {
            timer = engagementProfiler.newTimer(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteCloudUnifiedDialogDisplayed);
            s = fragmentactivity.getString(0x7f0e0089);
            obj = fragmentactivity.getString(0x7f0e008a);
        } else
        {
            timer = engagementProfiler.newTimer(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteUnifiedDialogDisplayed);
            s = fragmentactivity.getString(0x7f0e0088);
            obj = fragmentactivity.getString(0x7f0e0087);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void initMediaItemDeletionWithoutDialog()
    {
        setShowsDialog(false);
        executeAndShowSpinner(getDeleteRunnable(mediaItemList), new Runnable() {

            final DeleteFragment this$0;

            public void run()
            {
                if (success)
                {
                    GLogger.d(DeleteFragment.TAG, " Delete MediaItem(s) Successful", new Object[0]);
                    return;
                } else
                {
                    GLogger.d(DeleteFragment.TAG, " Delete MediaItem(s) Failed", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = DeleteFragment.this;
                super();
            }
        });
    }

    private MediaItem refreshMediaItem(MediaItem mediaitem)
    {
        Object obj;
label0:
        {
            if (MediaItemUtil.isLocalMediaItem(mediaitem))
            {
                obj = mediaItemDao.getItemsByLocalPath(mediaitem.getLocalPath()).getMediaItems();
                if (!((List) (obj)).isEmpty())
                {
                    break label0;
                }
                GLogger.e(TAG, "No media item returned when query by local path, this shouldn't happen", new Object[0]);
            }
            return mediaitem;
        }
        if (((List) (obj)).size() == 1)
        {
            obj = (MediaItem)((List) (obj)).get(0);
            GLogger.i(TAG, "Item refreshed from %s to %s", new Object[] {
                mediaitem.getObjectId(), ((MediaItem) (obj)).getObjectId()
            });
            return ((MediaItem) (obj));
        } else
        {
            GLogger.e(TAG, "More than one media item returned when query by local path, in order not to delete the wrong picture, we don't refresh the item", new Object[0]);
            return mediaitem;
        }
    }

    private void setMediaItemList(List list)
    {
        mediaItemList = list;
    }

    private void setTagList(List list)
    {
        tagList = list;
    }

    private Dialog setupDeleteAlbumsDialog(Activity activity, String s, String s1, final AsyncTask deleteOperation)
    {
        deleteOperation = new android.content.DialogInterface.OnClickListener() {

            final DeleteFragment this$0;
            final AsyncTask val$deleteOperation;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromAlbumsListDialog);
                deleteOperation.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }

            
            {
                this$0 = DeleteFragment.this;
                deleteOperation = asynctask;
                super();
            }
        };
        String s2 = activity.getString(0x7f0e0047);
        String s3 = activity.getString(0x7f0e0092);
        if (dialogManager.isDialogActive())
        {
            GLogger.w(TAG, "dialog is active while you're trying to delete, this shouldn't happen", new Object[0]);
            return null;
        }
        activity = dialogManager.createDialog(activity, s2, s3, null, deleteOperation);
        activity.setMessage(s1);
        if (!s.isEmpty())
        {
            activity.setTitle(s);
        }
        return activity;
    }

    private Dialog setupThisDialog(Activity activity, String s, String s1, final Runnable deleteOperation, final Runnable postExecutionTask)
    {
        String s2;
        postExecutionTask = new android.content.DialogInterface.OnClickListener() {

            final DeleteFragment this$0;
            final Runnable val$deleteOperation;
            final Runnable val$postExecutionTask;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                _cls12..SwitchMap.com.amazon.gallery.framework.gallery.actions.DeleteAction.Selection[itemSelection.ordinal()];
                JVM INSTR tableswitch 2 6: default 48
            //                           2 71
            //                           3 48
            //                           4 113
            //                           5 129
            //                           6 145;
                   goto _L1 _L2 _L1 _L3 _L4 _L5
_L1:
                dismiss();
                executeAndShowSpinner(deleteOperation, postExecutionTask);
                return;
_L2:
                if (parentObjectId != null)
                {
                    engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromAlbumDialog);
                } else
                {
                    engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromCloudDriveDialog);
                }
                continue; /* Loop/switch isn't completed */
_L3:
                engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromYourDeviceDialog);
                continue; /* Loop/switch isn't completed */
_L4:
                engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromDeviceAndCloudDialog);
                continue; /* Loop/switch isn't completed */
_L5:
                if (sourceType == DeleteAction.SourceType.CLOUD)
                {
                    engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromCloudUnifiedDialog);
                } else
                {
                    engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.DeleteClickedFromUnifiedDialog);
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                this$0 = DeleteFragment.this;
                deleteOperation = runnable;
                postExecutionTask = runnable1;
                super();
            }
        };
        if (parentObjectId != null)
        {
            deleteOperation = activity.getString(0x7f0e002b);
        } else
        {
            deleteOperation = activity.getString(0x7f0e0047);
        }
        s2 = activity.getString(0x7f0e0092);
        if (dialogManager.isDialogActive())
        {
            GLogger.w(TAG, "dialog is active while you're trying to delete, this shouldn't happen", new Object[0]);
            return null;
        }
        _cls12..SwitchMap.com.amazon.gallery.framework.gallery.actions.DeleteAction.Selection[itemSelection.ordinal()];
        JVM INSTR tableswitch 6 6: default 104
    //                   6 139;
           goto _L1 _L2
_L1:
        activity = dialogManager.createDialog(activity, deleteOperation, s2, null, postExecutionTask);
        activity.setMessage(s1);
_L4:
        if (!s.isEmpty())
        {
            activity.setTitle(s);
        }
        return activity;
_L2:
        activity = dialogManager.createDialog(activity, deleteOperation, s2, s1, postExecutionTask, new android.widget.CompoundButton.OnCheckedChangeListener() {

            final DeleteFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    if (networkConnectivity.promptIfOffline(getActivity()))
                    {
                        compoundbutton.setChecked(false);
                        return;
                    }
                    engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.CloudAlsoCheckboxSelected);
                }
                deleteCloudAndLocal = flag;
            }

            
            {
                this$0 = DeleteFragment.this;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void updateSortDateAsync(final Set tags)
    {
        if (tags.size() != 0)
        {
            (new AsyncTask() {

                final DeleteFragment this$0;
                final Set val$tags;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    avoid = new TagDaoChangeList();
                    Iterator iterator = tags.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        Tag tag = (Tag)iterator.next();
                        List list = mediaItemDao.getItemsByTag(tag).getMediaItems();
                        if (!list.isEmpty())
                        {
                            tagDao.updateSortDateForTag(tag, list, false, true);
                            avoid.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
                        }
                    } while (true);
                    tagDao.notify(avoid);
                    return null;
                }

            
            {
                this$0 = DeleteFragment.this;
                tags = set;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    boolean deleteMediaItems(List list)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        HashSet hashset;
        int i;
        int j;
        int k;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        hashset = new HashSet();
        j = 0;
        i = 0;
        k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            MediaItem mediaitem = refreshMediaItem((MediaItem)iterator.next());
            hashset.addAll(mediaitem.getTags());
            boolean flag;
            if (MediaItemUtil.isCloudMediaItem(mediaitem) && MediaItemUtil.isLocalMediaItem(mediaitem))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (deleteCloudAndLocal)
                {
                    arraylist.add(mediaitem);
                    arraylist1.add(mediaitem);
                    k++;
                } else
                if (sourceType == DeleteAction.SourceType.CLOUD)
                {
                    arraylist.add(mediaitem);
                    j++;
                    arraylist2.add(mediaitem);
                } else
                {
                    arraylist1.add(mediaitem);
                    i++;
                    arraylist2.add(mediaitem);
                }
            } else
            if (!mediaitem.hasProperty(CommonMediaProperty.LOCAL))
            {
                arraylist.add(mediaitem);
                j++;
            } else
            {
                arraylist1.add(mediaitem);
                i++;
            }
        }

        GlobalMessagingBus.post(new ToggleContentObserverEvent(false));
        int l = arraylist.size();
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        networkExecutor.execute(restClient.getDeleteMediaItemsOperation(arraylist));
        if (!arraylist1.isEmpty())
        {
            mediaStoreHelper.deleteFromMediaStoreAndFileSystem(arraylist1);
        }
        logMetric(DeleteAction.MetricsEvent.DeleteFile, j, i, k);
        if (arraylist2.isEmpty() || sourceType != DeleteAction.SourceType.LOCAL && sourceType != DeleteAction.SourceType.DEFAULT) goto _L2; else goto _L1
_L1:
        mediaItemDao.deleteLocalFields(arraylist2, true, false);
        list.removeAll(arraylist2);
_L4:
        mediaItemDao.deleteItem(list, true);
        updateSortDateAsync(hashset);
        changeCovers(hashset);
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        success = true;
        GLogger.v(TAG, "Delete Files: %d complete", new Object[] {
            Integer.valueOf(list.size())
        });
        return true;
        list;
        GLogger.e(TAG, "InvalidParameterException in deleting list of media items", new Object[] {
            list
        });
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        return false;
        list;
        GLogger.e(TAG, "TerminalException in deleting list of media items", new Object[] {
            list
        });
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        return false;
_L2:
        if (arraylist2.isEmpty() || sourceType != DeleteAction.SourceType.CLOUD) goto _L4; else goto _L3
_L3:
        mediaItemDao.deleteCloudFields(arraylist2, true);
        list.removeAll(arraylist2);
          goto _L4
        list;
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        throw list;
    }

    boolean deleteMediaItemsFromAlbum(final Activity activity, final List mediaItemList, final String parentObjectId, final boolean deleteCloud)
    {
        GlobalMessagingBus.post(new ToggleContentObserverEvent(false));
        activity.runOnUiThread(new Runnable() {

            final DeleteFragment this$0;
            final Activity val$activity;
            final boolean val$deleteCloud;
            final List val$mediaItemList;
            final String val$parentObjectId;

            public void run()
            {
                DeleteFromAlbumTask deletefromalbumtask = new DeleteFromAlbumTask(activity, mediaItemList, parentObjectId, deleteCloud, albumsProfiler);
                deletefromalbumtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
_L2:
                GlobalMessagingBus.post(new ActionCompleteEvent());
                return;
                Object obj;
                obj;
                GLogger.ex(DeleteFragment.TAG, "Error occurred trying to delete item(s) from album", ((Throwable) (obj)));
                GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
                if (true) goto _L2; else goto _L1
_L1:
                obj;
                GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
                throw obj;
            }

            
            {
                this$0 = DeleteFragment.this;
                activity = activity1;
                mediaItemList = list;
                parentObjectId = s;
                deleteCloud = flag;
                super();
            }
        });
        return true;
    }

    boolean deleteTags(List list)
    {
        Object obj = new ArrayList();
        Object obj1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            Tag tag = (Tag)iterator.next();
            List list1 = mediaItemDao.getItemsByTag(tag).getMediaItems();
            if (tag.hasProperty(TagProperty.CLOUD))
            {
                ((List) (obj)).add(tag);
            } else
            if (tag.hasProperty(TagProperty.LOCAL))
            {
                ((List) (obj1)).add(tag);
            }
            arraylist.addAll(list1);
        }
        if (!((List) (obj)).isEmpty())
        {
            try
            {
                networkExecutor.execute(restClient.getDeleteTagsOperation(((List) (obj))));
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                GLogger.e(TAG, "InvalidParameterException in deleting list of media items", new Object[] {
                    list
                });
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                GLogger.e(TAG, "TerminalException in deleting list of media items", new Object[] {
                    list
                });
                return false;
            }
        }
        for (obj = ((List) (obj1)).iterator(); ((Iterator) (obj)).hasNext(); mediaStoreHelper.deleteFromMediaStoreAndFileSystem(((Tag) (obj1))))
        {
            obj1 = (Tag)((Iterator) (obj)).next();
        }

        mediaItemDao.deleteLocalFields(arraylist, true, false);
        tagDao.delete(list, true);
        sortTypeDao.deleteSortTags(list);
        success = true;
        return true;
    }

    public void dismiss()
    {
        super.dismiss();
        if (timer != null)
        {
            timer.stop();
        }
    }

    void init(BeanAwareActivity beanawareactivity)
    {
        dialogManager = (DialogManager)getApplicationBean(beanawareactivity, Keys.DIALOG_MANAGER);
        networkConnectivity = (NetworkConnectivity)getApplicationBean(beanawareactivity, Keys.NETWORK_CONNECTIVITY);
        engagementProfiler = (EngagementMetrics)getApplicationBean(beanawareactivity, Keys.ENGAGEMENT_METRICS);
        mediaItemDao = (MediaItemDao)getApplicationBean(beanawareactivity, Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)getApplicationBean(beanawareactivity, Keys.TAG_DAO);
        restClient = (RestClient)getApplicationBean(beanawareactivity, Keys.REST_CLIENT);
        mediaStoreHelper = (MediaStoreHelper)getApplicationBean(beanawareactivity, Keys.MEDIA_STORE_HELPER);
        sortTypeDao = (SortTypeDao)getApplicationBean(beanawareactivity, Keys.SORT_PREFERENCE_DAO);
        networkExecutor = NetworkExecutor.getInstance();
        beanawareactivity = (Profiler)beanawareactivity.getApplicationBean(Keys.PROFILER);
        albumsProfiler = new ComponentProfiler(beanawareactivity, "AlbumsMetrics");
        componentProfiler = new ComponentProfiler(beanawareactivity, getClass());
    }

    void logMetric(DeleteAction.MetricsEvent metricsevent, int i, int j, int k)
    {
        componentProfiler.trackEvent(metricsevent, CustomerMetricsHelper.getExtraEventTag((new StringBuilder()).append("Cloud:").append(i).append(";Device:").append(j).append(";Unified:").append(k).toString()));
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        init((BeanAwareActivity)activity);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getArguments();
        if (bundle.getBoolean("NO_DIALOG", false))
        {
            if (mediaItemList == null || mediaItemList.isEmpty())
            {
                GLogger.e(TAG, "no media items to delete", new Object[0]);
                dismiss();
                return null;
            } else
            {
                initMediaItemDeletionWithoutDialog();
                return null;
            }
        }
        itemSelection = DeleteAction.Selection.values()[bundle.getInt(com/amazon/gallery/framework/gallery/actions/DeleteAction$Selection.getSimpleName())];
        if (itemSelection == DeleteAction.Selection.TAG)
        {
            if (tagList == null || tagList.isEmpty())
            {
                GLogger.e(TAG, "no tags to delete", new Object[0]);
                dismiss();
                return null;
            }
            if (areAllAlbums(tagList))
            {
                return initAlbumDeletion();
            }
            if (areAllLocalFolders(tagList))
            {
                return initLocalFoldersDeletion();
            } else
            {
                throw new RuntimeException("Trying to delete a mix of cloud and local folders... this shouldn't happen!");
            }
        }
        if (mediaItemList == null || mediaItemList.isEmpty())
        {
            GLogger.e(TAG, "no media items to delete", new Object[0]);
            dismiss();
            return null;
        } else
        {
            parentObjectId = bundle.getString(DeleteAction.KEY_EXTRA_PARENT_OBJECT_ID);
            actionSource = MediaItemAction.ActionSource.values()[bundle.getInt(com/amazon/gallery/framework/gallery/actions/MediaItemAction$ActionSource.getSimpleName())];
            sourceType = DeleteAction.SourceType.values()[bundle.getInt(com/amazon/gallery/framework/gallery/actions/DeleteAction$SourceType.getSimpleName())];
            return initMediaItemDeletion();
        }
    }





/*
    static boolean access$1002(DeleteFragment deletefragment, boolean flag)
    {
        deletefragment.deleteCloudAndLocal = flag;
        return flag;
    }

*/











}
