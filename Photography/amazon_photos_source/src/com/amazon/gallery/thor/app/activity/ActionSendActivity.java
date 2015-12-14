// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.GalleryMetadataRetriever;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreImageHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreVideoHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.TagAwareMediaStoreSyncProviderImpl;
import com.amazon.gallery.framework.kindle.EmptyBeanFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadMediaItemsEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

public class ActionSendActivity extends BeanAwareActivity
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent ActionSendUploadAlreadyExists;
        public static final MetricsEvent ActionSendUploadAttempt;
        public static final MetricsEvent ActionSendUploadError;
        public static final MetricsEvent ActionSendUploadSuccess;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/app/activity/ActionSendActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            ActionSendUploadAttempt = new MetricsEvent("ActionSendUploadAttempt", 0);
            ActionSendUploadSuccess = new MetricsEvent("ActionSendUploadSuccess", 1);
            ActionSendUploadAlreadyExists = new MetricsEvent("ActionSendUploadAlreadyExists", 2);
            ActionSendUploadError = new MetricsEvent("ActionSendUploadError", 3);
            $VALUES = (new MetricsEvent[] {
                ActionSendUploadAttempt, ActionSendUploadSuccess, ActionSendUploadAlreadyExists, ActionSendUploadError
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/app/activity/ActionSendActivity.getName();
    private MediaItemDao mediaItemDao;
    private ComponentProfiler profiler;

    public ActionSendActivity()
    {
        this(((BeanFactory) (new EmptyBeanFactory())));
    }

    public ActionSendActivity(BeanFactory beanfactory)
    {
        super(beanfactory);
    }

    private void addPathToMediaStore(String s)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        s = new File(s);
        BitmapFactory.decodeFile(s.getAbsolutePath(), options);
        if (options.outMimeType != null && options.outMimeType.startsWith("image"))
        {
            (new MediaStoreImageHelper()).addImageToMediaStore(this, s, s.getName(), options.outWidth, options.outHeight, s.lastModified(), options.outMimeType, 0);
        } else
        {
            MediaStoreVideoHelper mediastorevideohelper = new MediaStoreVideoHelper();
            if (s.exists() && s.getAbsolutePath().length() > 0)
            {
                long l = getVideoDuration(s.getAbsolutePath());
                if (l > 0L)
                {
                    mediastorevideohelper.addVideoToMediaStore(this, s, s.getName(), options.outWidth, options.outHeight, s.lastModified(), options.outMimeType, l);
                } else
                {
                    toastFromBg(0x7f0e0186);
                    GLogger.e(TAG, "Error adding video to media store for upload - duration <= 0", new Object[0]);
                }
            } else
            {
                toastFromBg(0x7f0e0186);
                GLogger.e(TAG, "Error adding video to media store for upload - invalid file path", new Object[0]);
            }
        }
        ((TagAwareMediaStoreSyncProviderImpl)getApplicationBean(Keys.MEDIA_STORE_SYNC_PROVIDER)).syncMediaStore();
    }

    private MediaItem createMediaItemFromContentUri(Uri uri)
    {
        if ("media".equals(uri.getAuthority()))
        {
            uri = getPathFromContentUri(uri);
        } else
        {
            uri = getPathFromInputStream(uri);
        }
        return createMediaItemFromLocalPath(uri);
    }

    private MediaItem createMediaItemFromFileUri(Uri uri)
    {
        uri = createMediaItemFromLocalPath((new File(new URI(uri.toString()))).getCanonicalPath());
        return uri;
        uri;
        GLogger.ex(TAG, "Malformed URI", uri);
        profiler.trackEvent(MetricsEvent.ActionSendUploadError);
_L2:
        return null;
        uri;
        GLogger.ex(TAG, "IOException figuring out canonical path", uri);
        profiler.trackEvent(MetricsEvent.ActionSendUploadError);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private MediaItem createMediaItemFromLocalPath(String s)
    {
        Object obj;
        if (s == null)
        {
            toastFromBg(0x7f0e0186);
            GLogger.e(TAG, "Null path for media item; skipping upload", new Object[0]);
            profiler.trackEvent(MetricsEvent.ActionSendUploadError);
            obj = null;
        } else
        {
            GLogger.d(TAG, "Finding media item for file at local path: %s", new Object[] {
                s
            });
            Object obj1 = mediaItemDao.getItemsByLocalPath(s);
            obj = obj1;
            if (((MediaItemCollection) (obj1)).getMediaItems().isEmpty())
            {
                addPathToMediaStore(s);
                obj1 = mediaItemDao.getItemsByLocalPath(s);
                obj = obj1;
                if (((MediaItemCollection) (obj1)).getMediaItems().isEmpty())
                {
                    GLogger.e(TAG, "Could not add shared path to media store.", new Object[0]);
                    toastFromBg(0x7f0e0186);
                    profiler.trackEvent(MetricsEvent.ActionSendUploadError);
                    return null;
                }
            }
            obj1 = (MediaItem)((MediaItemCollection) (obj)).getMediaItems().get(0);
            obj = obj1;
            if (obj1 != null)
            {
                if (MediaItemUtil.isCloudMediaItem(((MediaItem) (obj1))))
                {
                    toastFromBg(0x7f0e017f);
                    GLogger.d(TAG, "MediaItem with path %s already exists in cloud, skipping...", new Object[] {
                        s
                    });
                    profiler.trackEvent(MetricsEvent.ActionSendUploadAlreadyExists);
                    return null;
                } else
                {
                    ((MediaItem) (obj1)).setSyncState(SyncState.PENDING_MANUAL);
                    mediaItemDao.saveSyncState(((MediaItem) (obj1)).getObjectId(), SyncState.PENDING_MANUAL, true);
                    return ((MediaItem) (obj1));
                }
            }
        }
        return ((MediaItem) (obj));
    }

    private MediaItem createMediaItemFromUri(Uri uri)
    {
        if (uri.getScheme().equals("file"))
        {
            return createMediaItemFromFileUri(uri);
        } else
        {
            return createMediaItemFromContentUri(uri);
        }
    }

    private File getFileFromInputStream(InputStream inputstream)
    {
        Object obj = null;
        File file = File.createTempFile("amazon-photos-shared-media", "", getCacheDir());
        obj = file;
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        obj = new byte[1024];
_L1:
        int i = inputstream.read(((byte []) (obj)));
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        fileoutputstream.write(((byte []) (obj)), 0, i);
          goto _L1
        Exception exception;
        exception;
        obj = file;
        fileoutputstream.close();
        obj = file;
        inputstream.close();
        obj = file;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            GLogger.e(TAG, "IOException trying to get File from InputStream", new Object[] {
                inputstream
            });
        }
        return ((File) (obj));
        fileoutputstream.flush();
        obj = file;
        fileoutputstream.close();
        obj = file;
        inputstream.close();
        return file;
    }

    private String getPathFromContentUri(Uri uri)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        Cursor cursor = getContentResolver().query(uri, new String[] {
            "_data", "bucket_display_name"
        }, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        obj = cursor;
        obj1 = cursor;
        toastFromBg(0x7f0e0186);
        obj = cursor;
        obj1 = cursor;
        GLogger.e(TAG, "Unable to parse URI %s", new Object[] {
            uri
        });
        obj = cursor;
        obj1 = cursor;
        profiler.trackEvent(MetricsEvent.ActionSendUploadError);
        if (cursor != null)
        {
            cursor.close();
        }
        uri = null;
_L3:
        return uri;
_L2:
        obj = cursor;
        obj1 = cursor;
        cursor.moveToFirst();
        obj = cursor;
        obj1 = cursor;
        String s = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        obj = s;
        uri = ((Uri) (obj));
        if (cursor != null)
        {
            cursor.close();
            return ((String) (obj));
        }
          goto _L3
        obj1;
        obj1 = obj;
        GLogger.d(TAG, "IllegalArgumentException querying for data column. Uri may not be a MediaStore item - will try opening input stream instead.", new Object[0]);
        obj1 = obj;
        uri = getPathFromInputStream(uri);
        obj1 = uri;
        uri = ((Uri) (obj1));
        if (obj == null) goto _L3; else goto _L4
_L4:
        ((Cursor) (obj)).close();
        return ((String) (obj1));
        uri;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw uri;
    }

    private String getPathFromInputStream(Uri uri)
    {
        uri = getFileFromInputStream(getContentResolver().openInputStream(uri));
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        if (uri.getAbsolutePath() != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        toastFromBg(0x7f0e0186);
        GLogger.e(TAG, "Error uploading for non-MediaStore Uri - getFileFromInputStream returned null", new Object[0]);
        profiler.trackEvent(MetricsEvent.ActionSendUploadError);
        return null;
        uri = createMediaItemFromLocalPath(uri.getAbsolutePath());
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        uri = uri.getLocalPath();
        return uri;
        uri;
        toastFromBg(0x7f0e0186);
        GLogger.ex(TAG, "FileNotFoundException occurred when uploading for non-MediaStore Uri", uri);
        profiler.trackEvent(MetricsEvent.ActionSendUploadError);
        return null;
    }

    private long getVideoDuration(String s)
    {
        Object obj;
        Object obj1;
        long l;
        l = 0L;
        obj = null;
        obj1 = null;
        s = new GalleryMetadataRetriever(s);
        long l1 = Long.parseLong(s.extractMetadata(9));
        l = l1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        s.release();
_L2:
        return l;
        obj;
        s = ((String) (obj1));
        obj1 = obj;
_L5:
        obj = s;
        GLogger.e(TAG, "IllegalArgumentException trying to get video duration - file path is invalid", new Object[] {
            obj1
        });
        if (s == null) goto _L2; else goto _L1
_L1:
        s.release();
        return 0L;
        s;
_L4:
        if (obj != null)
        {
            ((GalleryMetadataRetriever) (obj)).release();
        }
        throw s;
        obj1;
        obj = s;
        s = ((String) (obj1));
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
          goto _L5
        return l;
    }

    private void proceedWithUploads()
    {
        Object obj;
        Bundle bundle;
        String s;
        obj = getIntent();
        bundle = ((Intent) (obj)).getExtras();
        s = ((Intent) (obj)).getAction();
        if (!"android.intent.action.SEND_MULTIPLE".equals(s) && !"android.intent.action.SEND".equals(s)) goto _L2; else goto _L1
_L1:
        profiler.trackEvent(MetricsEvent.ActionSendUploadAttempt);
        if (!bundle.containsKey("android.intent.extra.STREAM")) goto _L2; else goto _L3
_L3:
        if (!(bundle.get("android.intent.extra.STREAM") instanceof ArrayList)) goto _L5; else goto _L4
_L4:
        obj = ((Intent) (obj)).getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (obj != null)
        {
            uploadFromUris(((List) (obj)));
        }
_L2:
        finish();
        return;
_L5:
        obj = (Uri)((Intent) (obj)).getParcelableExtra("android.intent.extra.STREAM");
        if (obj != null)
        {
            uploadFromUris(Collections.singletonList(obj));
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private void toastFromBg(final int resId)
    {
        runOnUiThread(new Runnable() {

            final ActionSendActivity this$0;
            final int val$resId;

            public void run()
            {
                Toast.makeText(ActionSendActivity.this, resId, 0).show();
            }

            
            {
                this$0 = ActionSendActivity.this;
                resId = i;
                super();
            }
        });
    }

    private void uploadFromUris(final List uris)
    {
        uris = new Thread() {

            final ActionSendActivity this$0;
            final List val$uris;

            public void run()
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = uris.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (Uri)iterator.next();
                    obj = createMediaItemFromUri(((Uri) (obj)));
                    if (obj != null && ((MediaItem) (obj)).getLocalPath() != null)
                    {
                        arraylist.add(obj);
                    }
                } while (true);
                uploadMediaItems(arraylist);
            }

            
            {
                this$0 = ActionSendActivity.this;
                uris = list;
                super();
            }
        };
        uris.setName(TAG);
        uris.setPriority(5);
        uris.start();
    }

    private void uploadMediaItems(List list)
    {
        if (!list.isEmpty())
        {
            GlobalMessagingBus.post(new UploadMediaItemsEvent(list, QueueType.MANUAL, UploadStrategy.ALL, TAG));
            toastFromBg(0x7f0e018c);
            profiler.trackEvent(MetricsEvent.ActionSendUploadSuccess);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 555 && j == -1)
        {
            proceedWithUploads();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mediaItemDao = (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO);
        profiler = new ComponentProfiler((Profiler)getApplicationBean(Keys.PROFILER), com/amazon/gallery/thor/app/activity/ActionSendActivity);
        if (((AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount())
        {
            proceedWithUploads();
            return;
        }
        if (BuildFlavors.isAosp())
        {
            bundle = new Intent(this, com/amazon/gallery/thor/app/activity/SignInActivity);
            bundle.putExtra("KEY_SIGN_IN_FOR_ACTION_SEND", true);
            startActivityForResult(bundle, 555);
            return;
        } else
        {
            Toast.makeText(this, 0x7f0e0090, 0).show();
            return;
        }
    }



}
