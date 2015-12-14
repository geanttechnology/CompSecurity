// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.camera;

import android.content.Intent;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.fragment.MediaLoaderTask;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class CameraMediaLoaderTask extends MediaLoaderTask
{

    private final Intent cameraIntent;
    private final String mediaUri;

    public CameraMediaLoaderTask(NativeGalleryActivity nativegalleryactivity, String s, Intent intent)
    {
        super(nativegalleryactivity, null);
        cameraIntent = intent;
        mediaUri = s;
    }

    public static boolean hasCameraLoaderExtras(Intent intent)
    {
        return IntentUtil.hasExtras(intent, new String[] {
            "media_loader_task_media_task", "media_loader_task_object_id"
        });
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        super.doInBackground(avoid);
        avoid = (CommonActivity)activityRef.get();
        if (avoid != null)
        {
            List list = ((MediaItemDao)avoid.getApplicationBean(Keys.MEDIA_ITEM_DAO)).getItemsByMetadata("media-store.uri", Arrays.asList(new String[] {
                mediaUri.toString()
            }));
            Object obj = null;
            Object obj1 = null;
            com.amazon.gallery.framework.model.media.MediaType mediatype = obj1;
            avoid = obj;
            if (list != null)
            {
                mediatype = obj1;
                avoid = obj;
                if (list.size() > 0)
                {
                    avoid = ((MediaItem)list.get(0)).getObjectId();
                    mediatype = ((MediaItem)list.get(0)).getType();
                }
            }
            cameraIntent.putExtra("media_loader_task_object_id", avoid);
            cameraIntent.putExtra("media_loader_task_media_task", mediatype);
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        void1 = (CommonActivity)activityRef.get();
        if (void1 != null)
        {
            void1.startActivity(cameraIntent);
        }
    }
}
