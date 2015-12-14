// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.async.BlockingProgressDialog;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumMediaItemAction, AddToAlbumChooserActivity, AddToAlbumTask, AddToAlbumDialog, 
//            CreateAlbumHelper

public class AddToAlbumAction extends AlbumMediaItemAction
{

    private static final String TAG = com/amazon/gallery/thor/albums/AddToAlbumAction.getName();
    private final BeanAwareActivity activity;
    private final String dialogMessage;
    private final ArrayList mediaItemIds = new ArrayList();
    private final SharedPreferences sharedPrefs;
    private final TagDao tagDao;

    public AddToAlbumAction(BeanAwareActivity beanawareactivity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        super(beanawareactivity, networkconnectivity, photosdemomanager, 0x7f0e0012);
        activity = beanawareactivity;
        sharedPrefs = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        tagDao = (TagDao)beanawareactivity.getApplicationBean(Keys.TAG_DAO);
        dialogMessage = beanawareactivity.getString(0x7f0e0152);
    }

    private void enumerateAlbums()
    {
        BlockingProgressDialog blockingprogressdialog = new BlockingProgressDialog(context, 1, true) {

            final AddToAlbumAction this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient List doInBackground(Void avoid[])
            {
                return new ArrayList(tagDao.getTagsByType(TagType.ALBUM, new SortOrder("label", com.amazon.gallery.framework.data.dao.SortOrder.Order.NOCASE_ASC)));
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            protected void onPostExecute(List list)
            {
                super.onPostExecute(list);
                onAlbumsEnumerated(list);
            }

            
            {
                this$0 = AddToAlbumAction.this;
                super(context, i, flag);
            }
        };
        blockingprogressdialog.setDialogMessage(dialogMessage);
        blockingprogressdialog.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private boolean isInChooserMode()
    {
        return activity instanceof AddToAlbumChooserActivity;
    }

    private void startChooserActivity(Tag tag)
    {
        Intent intent = IntentUtil.getBaseAddToAlbumIntent(context);
        ObjectID objectid = tag.getObjectId();
        intent.putExtra("TAG_NODE_ID", IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits()));
        intent.putExtra("TAG_NAME", tag.getLabel());
        context.startActivity(intent);
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        if (sharedPrefs.getBoolean("coldBootStatus", false))
        {
            if (mediaitem == null)
            {
                if ((mediaitem = getTagFromViewDescriptor(viewdescriptor)) != null && mediaitem.getType() != TagType.LOCAL_FOLDER && !viewdescriptor.inLocalCollection())
                {
                    return true;
                }
            } else
            {
                return MediaItemUtil.isCloudMediaItem(mediaitem);
            }
        }
        return false;
    }

    public void execute(List list)
    {
        super.execute(list);
        if (!networkConnectivity.promptIfOffline(context))
        {
            Object obj;
            for (list = list.iterator(); list.hasNext(); mediaItemIds.add(obj))
            {
                obj = (MediaItem)list.next();
                obj = com.amazon.mixtape.utils.IdUtils.objectIdToNodeId(((MediaItem) (obj)).getObjectId().getMostSignificantBits(), ((MediaItem) (obj)).getObjectId().getLeastSignificantBits());
            }

            if (isInChooserMode())
            {
                list = ((AddToAlbumChooserActivity)activity).getAlbumId();
                if (list != null && !list.isEmpty() && !mediaItemIds.isEmpty())
                {
                    (new AddToAlbumTask(activity, new ArrayList(mediaItemIds), list, profiler)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                }
            } else
            {
                enumerateAlbums();
                return;
            }
        }
    }

    public void executeTags(List list)
    {
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        if (networkConnectivity.promptIfOffline(context))
        {
            return;
        }
        viewdescriptor = getTagFromViewDescriptor(viewdescriptor);
        if (viewdescriptor != null && mediaitem == null)
        {
            startChooserActivity(viewdescriptor);
            return;
        } else
        {
            viewdescriptor = new ArrayList();
            viewdescriptor.add(mediaitem);
            execute(viewdescriptor);
            return;
        }
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        boolean flag1 = false;
        boolean flag2 = sharedPrefs.getBoolean("coldBootStatus", false);
        boolean flag = flag1;
        if (super.isValid(mediaitem))
        {
            flag = flag1;
            if (MediaItemUtil.isCloudMediaItem(mediaitem))
            {
                flag = flag1;
                if (flag2)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void onAlbumsEnumerated(List list)
    {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("media_item_ids", new ArrayList(mediaItemIds));
        if (list != null && !list.isEmpty())
        {
            AddToAlbumDialog addtoalbumdialog = new AddToAlbumDialog();
            addtoalbumdialog.setArguments(bundle);
            addtoalbumdialog.setAlbumsList(list);
            addtoalbumdialog.setProfiler(profiler);
            addtoalbumdialog.show(activity.getSupportFragmentManager(), TAG);
        } else
        {
            (new CreateAlbumHelper((BeanAwareActivity)context, profiler, null, new ArrayList(mediaItemIds))).execute();
        }
        mediaItemIds.clear();
    }

    public void recordOnActionMetrics(List list)
    {
    }


}
