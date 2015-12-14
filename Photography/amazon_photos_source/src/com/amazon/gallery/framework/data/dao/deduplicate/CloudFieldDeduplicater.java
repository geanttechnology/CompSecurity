// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.AbstractDeduplicater;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.mixtape.utils.ISO8601;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class CloudFieldDeduplicater extends AbstractDeduplicater
{

    public static final String DEDUPE_NODE_PROJECTION[] = {
        "node_id", "content_md5", "content_size"
    };
    private static final String TAG = com/amazon/gallery/framework/data/dao/deduplicate/CloudFieldDeduplicater.getName();
    private static final ThreadLocal TEMP_ID_ARRAY = new ThreadLocal() {

        public volatile Object get()
        {
            return get();
        }

        public List get()
        {
            List list = (List)super.get();
            list.clear();
            return list;
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected List initialValue()
        {
            return new ArrayList();
        }

    };
    private final AuthenticationManager authManager;
    private ContentProviderClient contentProviderClient;
    private final ContentResolver contentResolver;
    private final SimpleDateFormat exifDateParser = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private final String mixtapeAuthority;
    private Uri nodeUri;

    public CloudFieldDeduplicater(MediaItemDao mediaitemdao, Context context, AuthenticationManager authenticationmanager)
    {
        super(mediaitemdao);
        authManager = authenticationmanager;
        contentResolver = context.getContentResolver();
        mixtapeAuthority = context.getResources().getString(0x7f0e02fb);
        onAccountRegistered();
        exifDateParser.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private long getMetadataDatetime(MediaItem mediaitem)
    {
        if (!"image/jpeg".equals(mediaitem.getMIMEType()))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        String s = (new ExifInterface(mediaitem.getLocalPath())).getAttribute("DateTime");
        if (s == null)
        {
            return 0L;
        }
        long l;
        synchronized (exifDateParser)
        {
            l = exifDateParser.parse(s).getTime();
        }
        return l;
        exception;
        mediaitem;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem) { }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem) { }
        GLogger.w(TAG, "error parsing exif of mediaItem", new Object[] {
            mediaitem
        });
        return 0L;
        if (mediaitem.getType() != MediaType.PHOTO)
        {
            return mediaitem.getDateCreatedUTCMs();
        } else
        {
            return 0L;
        }
    }

    private List getPossibleDuplicateMixtapeItems(MediaItem mediaitem, boolean flag)
    {
        List list = (List)TEMP_ID_ARRAY.get();
        if (mediaitem.getSyncState() == SyncState.SYNCED || mediaitem.getSyncState() == SyncState.SYNCING) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        MediaItem mediaitem1;
        obj1 = new File(mediaitem.getLocalPath());
        String as[];
        if (mediaitem.getType() == MediaType.PHOTO)
        {
            long l = getMetadataDatetime(mediaitem);
            int i;
            if (l != 0L)
            {
                String s = "kind= 'FILE' and status= 'AVAILABLE' and content_size= ? and image_width= ? and image_height= ? and name= ? and image_date_time_original= ? and is_image= 1";
                as = new String[5];
                as[0] = Long.toString(((File) (obj1)).length());
                as[1] = Integer.toString(mediaitem.getWidth());
                as[2] = Integer.toString(mediaitem.getHeight());
                as[3] = mediaitem.getName();
                as[4] = ISO8601.getUTCString(new Date(l));
                mediaitem = s;
            } else
            {
                obj = "kind= 'FILE' and status= 'AVAILABLE' and content_size= ? and image_width= ? and image_height= ? and name= ? and image_date_time_original IS NULL and is_image= 1";
                as = new String[4];
                as[0] = Long.toString(((File) (obj1)).length());
                as[1] = Integer.toString(mediaitem.getWidth());
                as[2] = Integer.toString(mediaitem.getHeight());
                as[3] = mediaitem.getName();
                mediaitem = ((MediaItem) (obj));
            }
        } else
        if (flag)
        {
            obj = "kind= 'FILE' and status= 'AVAILABLE' and content_size= ? and video_width= ? and video_height= ? and name= ? and is_video= 1 and video_creation_date= ?";
            as = new String[5];
            as[0] = Long.toString(((File) (obj1)).length());
            as[1] = Integer.toString(mediaitem.getWidth());
            as[2] = Integer.toString(mediaitem.getHeight());
            as[3] = mediaitem.getName();
            as[4] = ISO8601.getUTCString(new Date(getMetadataDatetime(mediaitem)));
            mediaitem = ((MediaItem) (obj));
        } else
        {
            obj = "kind= 'FILE' and status= 'AVAILABLE' and content_size= ? and video_width= ? and video_height= ? and name= ? and is_video= 1";
            as = new String[4];
            as[0] = Long.toString(((File) (obj1)).length());
            as[1] = Integer.toString(mediaitem.getWidth());
            as[2] = Integer.toString(mediaitem.getHeight());
            as[3] = mediaitem.getName();
            mediaitem = ((MediaItem) (obj));
        }
        obj1 = null;
        mediaitem1 = null;
        obj = null;
        mediaitem = contentProviderClient.query(nodeUri, DEDUPE_NODE_PROJECTION, mediaitem, as, (new SortOrder("node_id")).getOrderByString());
        obj = mediaitem;
        obj1 = mediaitem;
        mediaitem1 = mediaitem;
        i = mediaitem.getColumnIndex("node_id");
_L6:
        obj = mediaitem;
        obj1 = mediaitem;
        mediaitem1 = mediaitem;
        if (!mediaitem.moveToNext()) goto _L4; else goto _L3
_L3:
        obj = mediaitem;
        obj1 = mediaitem;
        mediaitem1 = mediaitem;
        list.add(CDSUtil.getObjectId(mediaitem.getString(i)));
        if (true) goto _L6; else goto _L5
_L5:
        mediaitem;
_L9:
        obj1 = obj;
        GLogger.ex(TAG, "could not create cursor when de-duping", mediaitem);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L2:
        return list;
_L4:
        if (mediaitem == null) goto _L2; else goto _L7
_L7:
        mediaitem.close();
        return list;
        mediaitem;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw mediaitem;
        mediaitem;
        obj = mediaitem1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public List getCloudDuplicates(MediaItem mediaitem)
    {
        this;
        JVM INSTR monitorenter ;
        List list = (List)resultArray.get();
        Iterator iterator;
        Object obj;
        boolean flag;
        if (mediaitem.getType() == MediaType.VIDEO && DateUtils.isAtStartOfDay(mediaitem.getDateCreatedUTCMs()))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        iterator = getPossibleDuplicateMixtapeItems(mediaitem, flag).iterator();
_L3:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_141;
            }
            obj = (ObjectID)iterator.next();
            obj = mediaItemDao.getItemById(((ObjectID) (obj)));
        } while (!MediaItemUtil.hasNoLocalParts(((MediaItem) (obj))));
        if (flag) goto _L2; else goto _L1
_L1:
        if (!DateUtils.isSameDay(mediaitem.getDateCreatedUTCMs(), ((MediaItem) (obj)).getDateCreatedUTCMs())) goto _L3; else goto _L2
_L2:
        list.add(obj);
          goto _L3
        mediaitem;
        throw mediaitem;
        this;
        JVM INSTR monitorexit ;
        return list;
    }

    public List getLocalDuplicates(MediaItem mediaitem)
    {
        List list = (List)resultArray.get();
        Object obj = mediaItemDao.getPossibleDuplicateLocalItems(mediaitem).getMediaItems();
        long l2 = mediaitem.getSize();
        long l1 = 0L;
        long l;
        if (mediaitem.getType() == MediaType.VIDEO)
        {
            l = mediaitem.getDateCreatedUTCMs();
        } else
        {
            String s = (String)mediaitem.getLocalMetadata().get("image_date_time_original");
            l = l1;
            if (s != null)
            {
                try
                {
                    l = ISO8601.getUnixTimestampFromString(s);
                }
                catch (ParseException parseexception)
                {
                    GLogger.wx(TAG, "failed to parse date for cloud item", parseexception);
                    l = l1;
                }
            }
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            MediaItem mediaitem1 = (MediaItem)((Iterator) (obj)).next();
            if (!MediaItemUtil.isCloudMediaItem(mediaitem1) && l2 == (new File(mediaitem1.getLocalPath())).length())
            {
                boolean flag;
                if (mediaitem1.getType() != MediaType.VIDEO || !DateUtils.isAtStartOfDay(mediaitem1.getDateCreatedUTCMs()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && l == getMetadataDatetime(mediaitem1) || !flag && DateUtils.isSameDay(mediaitem1.getDateCreatedUTCMs(), mediaitem.getDateCreatedUTCMs()))
                {
                    list.add(mediaitem1);
                }
            }
        } while (true);
        return list;
    }

    public void onAccountRegistered()
    {
        this;
        JVM INSTR monitorenter ;
        nodeUri = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(mixtapeAuthority, authManager.getAccountId());
        contentProviderClient = contentResolver.acquireContentProviderClient(nodeUri);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
