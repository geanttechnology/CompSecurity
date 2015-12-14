// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreImageHelper;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PrepareMediaItemsHelper
{
    public static interface ProgressNotifier
    {

        public abstract void update(int i, int j);
    }

    public static final class UriPreference extends Enum
    {

        private static final UriPreference $VALUES[];
        public static final UriPreference CLOUD;
        public static final UriPreference CONTENT;
        public static final UriPreference DIRECT_LINK;
        public static final UriPreference FILE;
        public static final UriPreference THUMBNAIL;

        public static UriPreference valueOf(String s)
        {
            return (UriPreference)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/PrepareMediaItemsHelper$UriPreference, s);
        }

        public static UriPreference[] values()
        {
            return (UriPreference[])$VALUES.clone();
        }

        static 
        {
            CONTENT = new UriPreference("CONTENT", 0);
            FILE = new UriPreference("FILE", 1);
            THUMBNAIL = new UriPreference("THUMBNAIL", 2);
            CLOUD = new UriPreference("CLOUD", 3);
            DIRECT_LINK = new UriPreference("DIRECT_LINK", 4);
            $VALUES = (new UriPreference[] {
                CONTENT, FILE, THUMBNAIL, CLOUD, DIRECT_LINK
            });
        }

        private UriPreference(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/actions/PrepareMediaItemsHelper.getName();
    private final Context context;
    private int cutSize[] = {
        2048, 2048
    };
    private final MediaStoreImageHelper mediaStoreHelper = new MediaStoreImageHelper();
    private final NetworkExecutor networkExecutor;
    private ProgressNotifier progressListener;
    private final RestClient restClient;
    private final ShareStore shareStore;
    private UriPreference uriPreference;

    public PrepareMediaItemsHelper(Context context1, NetworkExecutor networkexecutor, RestClient restclient, ShareStore sharestore)
    {
        uriPreference = UriPreference.FILE;
        context = context1;
        networkExecutor = networkexecutor;
        restClient = restclient;
        shareStore = sharestore;
        mediaStoreHelper.setContext(context1);
    }

    private List getLenticularItems(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)list.next();
            if (GroupType.LENTICULAR.equals(mediaitem.getGroupType()))
            {
                arraylist.add(mediaitem);
            }
        } while (true);
        return arraylist;
    }

    private ArrayList prepareCloudLinkInBackground(List list)
    {
        final ArrayList links = new ArrayList();
        final CountDownLatch latch = new CountDownLatch(1);
        if (progressListener != null)
        {
            progressListener.update(0, 1);
        }
        com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler resulthandler = new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final PrepareMediaItemsHelper this$0;
            final CountDownLatch val$latch;
            final ArrayList val$links;

            public void onFailure(TerminalException terminalexception)
            {
                GLogger.ex(PrepareMediaItemsHelper.TAG, "Execute ShareOperation failed", terminalexception);
                latch.countDown();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                jsonobject = jsonobject.getJSONArray("contacts");
                if (jsonobject == null) goto _L2; else goto _L1
_L1:
                if (jsonobject.getJSONObject(0) != null) goto _L3; else goto _L2
_L2:
                GLogger.e(PrepareMediaItemsHelper.TAG, "No contacts found while getting the share url", new Object[0]);
_L7:
                latch.countDown();
                return;
_L3:
                int i = 0;
_L5:
                if (i >= jsonobject.length())
                {
                    continue; /* Loop/switch isn't completed */
                }
                links.add(Uri.parse(jsonobject.getJSONObject(i).getString("extension")));
                i++;
                if (true) goto _L5; else goto _L4
_L4:
                jsonobject;
                GLogger.e(PrepareMediaItemsHelper.TAG, "Can't parse result page to get share url", new Object[0]);
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                this$0 = PrepareMediaItemsHelper.this;
                links = arraylist;
                latch = countdownlatch;
                super();
            }
        };
        try
        {
            list = restClient.getShareOperation(list, null);
            networkExecutor.executeForeground(list, resulthandler);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            GLogger.ex(TAG, "Try to execute ShareOperation failed", list);
        }
        try
        {
            latch.await();
            if (progressListener != null)
            {
                progressListener.update(1, 1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            GLogger.ex(TAG, "Count down interrupted", list);
            return links;
        }
        return links;
    }

    private ArrayList prepareDirectLinkInBackground(List list)
    {
        ArrayList arraylist = new ArrayList();
        CountDownLatch countdownlatch = new CountDownLatch(1);
        if (progressListener != null)
        {
            progressListener.update(0, 1);
        }
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (MediaItem)list.next();
            try
            {
                obj = restClient.getMediaItemURLOperation(((MediaItem) (obj)).getObjectId(), SennaMediaType.valueOf(MediaType.PHOTO), cutSize[0], cutSize[1], ScaleMode.SCALE_TO_FIT);
                arraylist.add(Uri.parse((String)NetworkExecutor.getInstance().execute(((com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation) (obj)))));
            }
            catch (InvalidParameterException invalidparameterexception)
            {
                GLogger.ex(TAG, "Try to execute ShareOperation failed", invalidparameterexception);
            }
            catch (TerminalException terminalexception)
            {
                terminalexception.printStackTrace();
            }
        }

        try
        {
            countdownlatch.await();
            if (progressListener != null)
            {
                progressListener.update(1, 1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            GLogger.ex(TAG, "Count down interrupted", list);
            return arraylist;
        }
        return arraylist;
    }

    private ArrayList prepareLocalFilesInBackground(List list)
    {
        ArrayList arraylist = new ArrayList();
        int j1 = list.size();
        int j = 0;
        int i = 0;
        if (progressListener != null)
        {
            progressListener.update(0, j1);
        }
        List list1 = getLenticularItems(list);
        if (!list1.isEmpty())
        {
            prepareCloudLinkInBackground(list1);
        }
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)iterator.next();
            list = null;
            int k = 2;
            while (k > 0 && list == null) 
            {
                File file = shareableFileForItem(mediaitem);
                List list2 = list;
                if (file != null)
                {
                    list2 = list;
                    if (file.exists())
                    {
                        if (uriPreference == UriPreference.CONTENT)
                        {
                            list = new android.graphics.BitmapFactory.Options();
                            list.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(file.getAbsolutePath(), list);
                            int l = ((android.graphics.BitmapFactory.Options) (list)).outWidth;
                            int k1 = ((android.graphics.BitmapFactory.Options) (list)).outHeight;
                            list = mediaStoreHelper.addImageToMediaStore(context, file, file.getName(), l, k1, mediaitem.getDateCreatedMs(), mediaitem.getMIMEType(), 0);
                        } else
                        {
                            list = Uri.fromFile(file);
                        }
                        list2 = list;
                        if (list == null)
                        {
                            mediaStoreHelper.deleteFromMediaStoreByPath(android.provider.MediaStore.Files.getContentUri("external"), file.getAbsolutePath());
                            list2 = list;
                        }
                    }
                }
                k--;
                list = list2;
            }
            int i1;
            if (list != null)
            {
                k = j + 1;
                arraylist.add(list);
                i1 = i;
            } else
            {
                i1 = i + 1;
                k = j;
            }
            j = k;
            i = i1;
            if (progressListener != null)
            {
                progressListener.update(k, j1);
                j = k;
                i = i1;
            }
        } while (true);
        GLogger.v(TAG, "Prepared Share Files: %d complete, %d error out of %d", new Object[] {
            Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(j1)
        });
        return arraylist;
    }

    private File shareableFileForItem(MediaItem mediaitem)
    {
        if (uriPreference == UriPreference.THUMBNAIL)
        {
            return shareStore.prepareThumbnailForSharing(mediaitem, cutSize[0], cutSize[1]);
        }
        com.amazon.gallery.framework.data.store.Asset.AssetType assettype = com.amazon.gallery.framework.data.store.Asset.AssetType.JPG;
        if (GroupType.LENTICULAR == mediaitem.getGroupType() || mediaitem.getMIMEType().equals("image/gif"))
        {
            assettype = com.amazon.gallery.framework.data.store.Asset.AssetType.GIF;
        }
        return shareStore.prepareMediaItemForSharing(mediaitem, cutSize[0], cutSize[1], assettype);
    }

    public ArrayList prepareItems(List list)
    {
        if (uriPreference == UriPreference.CLOUD)
        {
            return prepareCloudLinkInBackground(list);
        }
        if (uriPreference == UriPreference.DIRECT_LINK)
        {
            return prepareDirectLinkInBackground(list);
        } else
        {
            return prepareLocalFilesInBackground(list);
        }
    }

    public void setProgressNotifier(ProgressNotifier progressnotifier)
    {
        progressListener = progressnotifier;
    }

    public void setUriPreference(UriPreference uripreference)
    {
        uriPreference = uripreference;
    }


}
