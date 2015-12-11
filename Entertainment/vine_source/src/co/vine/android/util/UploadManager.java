// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Point;
import android.text.TextUtils;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineUpload;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.provider.VineUploadProvider;
import co.vine.android.recorder.HashAsyncTask;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.service.UploadProgressListener;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.PhotoImagesCache;
import co.vine.android.util.video.VideoCache;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package co.vine.android.util:
//            MediaUtility, SystemUtil, CrashUtil, VineProgressListener

public class UploadManager
{

    public static final String BC_INVALIDATE_CACHE = "co.vine.android.invalidateCache";
    public static final long EXPIRE_TIME = 0x5265c00L;
    private static final int SHARED_LOCK[] = new int[0];
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_INVALID = -1;
    public static final int STATUS_NEED_POST = 1;
    public static final int STATUS_NEED_UPLOAD = 0;
    private static final String SUB_PREF_HASH = "_hash.sub";
    private static final String SUB_PREF_POST = "_post.sub";
    private static final String SUB_PREF_THUMBNAIL = "_thumbnail_url.sub";
    private static final String SUB_PREF_VIDEO = "_video_url.sub";
    private static final String SUB_UPLOAD_TIME = "_upload_time.sub";
    public static final String TAG = "UploadManager";
    private static SharedPreferences mUploadPref;
    private final MediaUtility mMediaUtility;

    public UploadManager(Context context)
    {
        mMediaUtility = new MediaUtility(context);
    }

    public static void addOrUpdateUpload(Context context, String s, String s1, String s2, boolean flag, long l, long l1)
    {
        long l2 = AppController.getInstance(context).getActiveSessionReadOnly().getUserId();
        Object obj = getBaseUriBuilder().path("uploads/upload").appendEncodedPath(String.valueOf(l2)).appendQueryParameter("path", s).build();
        obj = context.getContentResolver().query(((android.net.Uri) (obj)), co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, null, null, null);
        ContentValues contentvalues = new ContentValues();
        if (obj == null || ((Cursor) (obj)).getCount() < 1)
        {
            String s3 = RecordConfigUtils.getThumbnailPath(s);
            contentvalues.put("path", s);
            contentvalues.put("thumbnail_path", s3);
            contentvalues.put("hash", s1);
            contentvalues.put("status", Integer.valueOf(0));
            if (flag)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            contentvalues.put("is_private", s);
            contentvalues.put("reference", s2);
            contentvalues.put("owner_id", Long.valueOf(l2));
            if (l1 > 0L)
            {
                contentvalues.put("message_row", Long.valueOf(l1));
            }
            if (l > 0L)
            {
                contentvalues.put("conversation_row_id", Long.valueOf(l));
            }
            s = getBaseUriBuilder().path("uploads/put_new_upload").build();
            context.getContentResolver().insert(s, contentvalues);
        } else
        {
            if (!TextUtils.isEmpty(s1))
            {
                contentvalues.put("hash", s1);
            }
            contentvalues.put("status", Integer.valueOf(0));
            s1 = getBaseUriBuilder().path("uploads/put_values").build();
            context.getContentResolver().update(s1, contentvalues, "path=?", new String[] {
                s
            });
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
    }

    public static String addToUploadQueue(Context context, RecordingFile recordingfile, String s, String s1, boolean flag, long l)
        throws Exception
    {
        File file;
        try
        {
            file = (new co.vine.android.recorder.RecordConfigUtils.RecordConfig(context)).processDir;
        }
        catch (Exception exception)
        {
            exception = context.getCacheDir();
        }
        return addToUploadQueue(context, file, recordingfile, s, s1, flag, l);
    }

    private static String addToUploadQueue(Context context, File file, RecordingFile recordingfile, String s, String s1, boolean flag, long l)
        throws Exception
    {
        String s3 = (new StringBuilder()).append(recordingfile.version.name()).append("_").append(System.currentTimeMillis()).toString();
        String s2 = RecordConfigUtils.copyForUpload(file, recordingfile.getVideoPath(), s3).getPath();
        file = RecordConfigUtils.copyForUpload(file, s, RecordConfigUtils.getThumbnailPath(s3)).getPath();
        context.startService(VineUploadService.getUploadIntent(context, s2, recordingfile.getHash(), file, s1, flag, l));
        return s2;
    }

    public static void clearSp()
    {
        synchronized (SHARED_LOCK)
        {
            mUploadPref.edit().clear().commit();
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void clearUploadCaptchas(Context context)
    {
        android.net.Uri.Builder builder = getBaseUriBuilder().path("uploads/put_values");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("captcha_url", "");
        context.getContentResolver().update(builder.build(), contentvalues, "1", null);
    }

    public static void deleteUploadRecord(Context context, String s)
    {
        android.net.Uri uri = getBaseUriBuilder().path("uploads/delete_upload").build();
        context.getContentResolver().delete(uri, "path=?", new String[] {
            s
        });
    }

    public static String generateFileName(Context context)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd/", Locale.US);
        return (new StringBuilder()).append(simpledateformat.format(new Date())).append(UUID.randomUUID()).append("_").append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode).toString();
    }

    public static LinkedHashMap getAllPaths(Context context)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        long l = AppController.getInstance(context).getActiveSessionReadOnly().getUserId();
        android.net.Uri uri = ContentUris.withAppendedId(co.vine.android.provider.VineUploads.Uploads.CONTENT_URI, l);
        context = context.getContentResolver().query(uri, co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, null, null, "_id ASC");
        if (context != null)
        {
            for (; context.moveToNext(); linkedhashmap.put(context.getString(1), Integer.valueOf(context.getInt(3)))) { }
            context.close();
        }
        return linkedhashmap;
    }

    private static android.net.Uri.Builder getBaseUriBuilder()
    {
        return (new android.net.Uri.Builder()).scheme("content").authority(VineUploadProvider.AUTHORITY);
    }

    public static String getHashSp(String s)
    {
        synchronized (SHARED_LOCK)
        {
            s = mUploadPref.getString((new StringBuilder()).append(s).append("_hash.sub").toString(), null);
        }
        return s;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static LinkedList getPendingPaths(Context context)
    {
        LinkedList linkedlist = new LinkedList();
        context = getAllPaths(context);
        Iterator iterator = context.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            int i = ((Integer)context.get(s)).intValue();
            if (i != 2 && i != -1)
            {
                linkedlist.add(s);
            }
        } while (true);
        return linkedlist;
    }

    public static HashMap getPendingPathsSp()
    {
        int ai[] = SHARED_LOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new HashMap();
        iterator = mUploadPref.getAll().keySet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (!isKey(s)) goto _L4; else goto _L3
_L3:
        int i;
        SLog.d("Key: {}", s);
        i = getStatusSp(s);
        if (!isUploadExpiredSp(s)) goto _L6; else goto _L5
_L5:
        i;
        JVM INSTR tableswitch 0 1: default 167
    //                   0 104
    //                   1 121;
           goto _L7 _L8 _L9
_L7:
        if (true) goto _L4; else goto _L10
_L10:
_L8:
        ((HashMap) (obj)).put(s, "cNotify");
          goto _L4
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
_L9:
        ((HashMap) (obj)).put(s, "aUpload");
          goto _L4
_L11:
        ((HashMap) (obj)).put(s, "cNotify");
          goto _L4
_L12:
        SLog.d("File does not exist any more (uploaded).");
        ((HashMap) (obj)).put(s, "bPost");
          goto _L4
_L2:
        ai;
        JVM INSTR monitorexit ;
        return ((HashMap) (obj));
_L6:
        i;
        JVM INSTR tableswitch 0 1: default 196
    //                   0 133
    //                   1 145;
           goto _L4 _L11 _L12
    }

    public static String getPostInfoSp(String s)
    {
        synchronized (SHARED_LOCK)
        {
            s = mUploadPref.getString((new StringBuilder()).append(s).append("_post.sub").toString(), null);
        }
        return s;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static Cursor getReferenceCursor(Context context, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            long l = AppController.getInstance(context).getActiveSessionReadOnly().getUserId();
            s = getBaseUriBuilder().path("uploads/reference").appendEncodedPath(String.valueOf(l)).appendQueryParameter("reference", s).build();
            return context.getContentResolver().query(s, co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, null, null, null);
        }
    }

    public static int getStatusSp(String s)
    {
        int i;
        synchronized (SHARED_LOCK)
        {
            i = mUploadPref.getInt(s, -1);
        }
        return i;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static VineUpload getUpload(Context context, String s)
    {
        long l = AppController.getInstance(context).getActiveSessionReadOnly().getUserId();
        Object obj1 = null;
        Object obj = null;
        Object obj2 = getBaseUriBuilder().path("uploads/upload").appendEncodedPath(String.valueOf(l)).appendQueryParameter("path", s).build();
        obj2 = context.getContentResolver().query(((android.net.Uri) (obj2)), co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, null, null, null);
        context = obj1;
        if (obj2 != null)
        {
            context = obj;
            if (((Cursor) (obj2)).moveToFirst())
            {
                context = VineUpload.fromCursor(s, ((Cursor) (obj2)));
            }
            ((Cursor) (obj2)).close();
        }
        return context;
    }

    public static long getUploadTimeSp(String s)
    {
        long l;
        synchronized (SHARED_LOCK)
        {
            l = mUploadPref.getLong((new StringBuilder()).append(s).append("_upload_time.sub").toString(), 0L);
        }
        return l;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String[] getUrisSp(String s)
    {
        int ai[] = SHARED_LOCK;
        ai;
        JVM INSTR monitorenter ;
        String s1 = mUploadPref.getString((new StringBuilder()).append(s).append("_video_url.sub").toString(), null);
        s = mUploadPref.getString((new StringBuilder()).append(s).append("_thumbnail_url.sub").toString(), null);
        return (new String[] {
            s1, s
        });
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static RecordSessionVersion getVersionFromPath(String s)
    {
        RecordSessionVersion recordsessionversion = RecordSessionVersion.SW_MP4;
        String s1 = (new File(s)).getName();
        if (s1.startsWith(RecordSessionVersion.HW.name()))
        {
            s = RecordSessionVersion.HW;
        } else
        {
            s = recordsessionversion;
            if (s1.startsWith(RecordSessionVersion.SW_WEBM.name()))
            {
                return RecordSessionVersion.SW_WEBM;
            }
        }
        return s;
    }

    public static void initUploadPref(Context context)
    {
        mUploadPref = context.getSharedPreferences("upload", 0);
    }

    public static boolean isEmptySp()
    {
        int ai[] = SHARED_LOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = mUploadPref.getAll();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!((Map) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_32;
        }
        ai;
        JVM INSTR monitorexit ;
        return true;
        obj = ((Map) (obj)).keySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_77;
            }
        } while (!isKey((String)((Iterator) (obj)).next()));
        ai;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
        ai;
        JVM INSTR monitorexit ;
        return true;
    }

    public static boolean isKey(String s)
    {
        return !s.endsWith(".sub");
    }

    public static boolean isUploadExpiredSp(String s)
    {
        return System.currentTimeMillis() - mUploadPref.getLong((new StringBuilder()).append(s).append("_upload_time.sub").toString(), 0L) > 0x5265c00L;
    }

    public static void prepopulateCache(Context context, String s, String s1, String s2)
    {
        SLog.d("Prepopulating cache. Video url: {} | Thumbnail url: {}", s1, s2);
        if (s1 != null)
        {
            prepopulateVideoCache(context, s, s1);
        }
        if (s2 != null)
        {
            prepopulateImageCache(context, RecordConfigUtils.getThumbnailPath(s), s2);
        }
        context.sendBroadcast(new Intent("co.vine.android.invalidateCache"), "co.vine.android.BROADCAST");
    }

    private static void prepopulateImageCache(Context context, String s, String s1)
    {
        Object obj = SystemUtil.getDisplaySize(context);
        obj = new PhotoImagesCache(context, Math.max(((Point) (obj)).x, ((Point) (obj)).y), 0);
        try
        {
            s = new FileInputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            CrashUtil.logException(context, "Error prepopulating the cache", new Object[0]);
            return;
        }
        ((PhotoImagesCache) (obj)).prepopulateThumbnailCacheForUrl(VineAccountHelper.getActiveSession(context, true).getUserId(), new ImageKey(s1), s1, s);
    }

    private static void prepopulateVideoCache(Context context, String s, String s1)
    {
        VideoCache videocache = new VideoCache(context, 0);
        try
        {
            s = new FileInputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            CrashUtil.logException(context, "Error prepopulating the cache", new Object[0]);
            return;
        }
        videocache.prepopulateVideoCacheForUrl(VineAccountHelper.getActiveSession(context, true).getUserId(), new VideoKey(s1), s1, s);
    }

    public static void removeFromUploadQueue(Context context, String s)
    {
        context.startService(VineUploadService.getDiscardIntent(context, s));
    }

    public static void setHash(Context context, VineUpload vineupload, String s)
    {
        vineupload.hash = s;
        vineupload = getBaseUriBuilder().path("uploads/put_hash").appendQueryParameter("path", vineupload.path).appendQueryParameter("hash", s).build();
        context.getContentResolver().update(vineupload, null, null, null);
    }

    public static void setPostInfo(Context context, VineUpload vineupload, co.vine.android.api.VineUpload.PostInfo postinfo)
    {
        SLog.d((new StringBuilder()).append("Setting post info for path=").append(vineupload.path).append(" with caption=").append(postinfo.caption).append(", twitter=").append(postinfo.postToTwitter).append(", facebook=").append(postinfo.postToFacebook).toString());
        vineupload.postInfo = postinfo.toString();
        vineupload = getBaseUriBuilder().path("uploads/put_post_info").appendQueryParameter("path", vineupload.path).appendQueryParameter("post_info", postinfo.toString()).build();
        context.getContentResolver().update(vineupload, null, null, null);
    }

    public static void setStatus(Context context, VineUpload vineupload, int i)
    {
        setStatus(context, vineupload, i, null);
    }

    public static void setStatus(Context context, VineUpload vineupload, int i, String s)
    {
        vineupload.status = i;
        vineupload = getBaseUriBuilder().path("uploads/put_status").appendQueryParameter("path", vineupload.path).appendQueryParameter("status", String.valueOf(i));
        if (!TextUtils.isEmpty(s))
        {
            vineupload.appendQueryParameter("captcha_url", s);
        }
        context.getContentResolver().update(vineupload.build(), null, null, null);
    }

    public static void setUploadMessageRowId(Context context, String s, long l)
    {
        s = getBaseUriBuilder().path("uploads/put_message_row_id").appendQueryParameter("path", s).appendQueryParameter("message_row_id", String.valueOf(l)).build();
        context.getContentResolver().update(s, null, null, null);
    }

    public static void setUploadTime(Context context, VineUpload vineupload)
    {
        vineupload.uploadTime = System.currentTimeMillis();
        long l = System.currentTimeMillis();
        vineupload = getBaseUriBuilder().path("uploads/put_upload_time").appendQueryParameter("path", vineupload.path).appendQueryParameter("upload_time", String.valueOf(l)).build();
        context.getContentResolver().update(vineupload, null, null, null);
    }

    public static void setUris(Context context, VineUpload vineupload, String as[])
    {
        vineupload.setUris(as);
        vineupload = getBaseUriBuilder().path("uploads/put_uris").appendQueryParameter("path", vineupload.path).appendQueryParameter("video_url", as[0]).appendQueryParameter("thumbnail_url", as[1]).build();
        context.getContentResolver().update(vineupload, null, null, null);
    }

    public static boolean uploadListIsEmpty(Context context)
    {
        boolean flag = true;
        boolean flag1 = true;
        context = context.getContentResolver().query(co.vine.android.provider.VineUploads.Uploads.CONTENT_URI, co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, null, null, null);
        if (context != null)
        {
            if (context.getCount() < 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            context.close();
        }
        return flag;
    }

    public String[] upload(co.vine.android.service.VineUploadService.ServiceAsyncTask serviceasynctask, UploadProgressListener uploadprogresslistener, String s, String s1, String s2, boolean flag, RecordSessionVersion recordsessionversion)
        throws Exception
    {
        this;
        JVM INSTR monitorenter ;
        File file = new File(s);
        if (file.exists()) goto _L2; else goto _L1
_L1:
        SLog.e("Files does not exist: {}", s);
        serviceasynctask = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return serviceasynctask;
_L2:
        Object obj = getUpload(serviceasynctask.getContext(), s2);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        try
        {
            throw new Exception("Upload record was null");
        }
        // Misplaced declaration of an exception variable
        catch (co.vine.android.service.VineUploadService.ServiceAsyncTask serviceasynctask) { }
        finally
        {
            this;
        }
        SLog.e("Upload failed: {}", s2, serviceasynctask);
        serviceasynctask = null;
        continue; /* Loop/switch isn't completed */
        s = HashAsyncTask.getMD5Checksum(s);
        obj = ((VineUpload) (obj)).hash;
        if (s.equals(obj))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_118;
        }
        SLog.e("Invalid hash: actual {}, expected {}.", s, obj);
        serviceasynctask = null;
        continue; /* Loop/switch isn't completed */
        CrashUtil.logException(new VineLoggingException((new StringBuilder()).append("Expected hash was invalid: ").append(((String) (obj))).toString()));
        if (!serviceasynctask.isCancelled())
        {
            break MISSING_BLOCK_LABEL_167;
        }
        SLog.d("Task is already cancelled.");
        serviceasynctask = null;
        continue; /* Loop/switch isn't completed */
        s = serviceasynctask.getContext();
        recordsessionversion = (new StringBuilder()).append(generateFileName(s)).append(recordsessionversion.videoOutputExtension).toString();
        s = uploadVideo(uploadprogresslistener, file, s, recordsessionversion, flag);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        throw new Exception("Failed to upload video.");
        throw serviceasynctask;
        if (!serviceasynctask.isCancelled())
        {
            break MISSING_BLOCK_LABEL_250;
        }
        SLog.d("Task is already cancelled.");
        serviceasynctask = null;
        continue; /* Loop/switch isn't completed */
        uploadprogresslistener = uploadThumbnail(uploadprogresslistener, new File(s1), serviceasynctask.getContext(), recordsessionversion);
        if (uploadprogresslistener != null)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        throw new Exception("Failed to upload thumbnail.");
        serviceasynctask = new String[2];
        serviceasynctask[0] = s;
        serviceasynctask[1] = uploadprogresslistener;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String uploadThumbnail(VineProgressListener vineprogresslistener, File file, Context context, String s)
        throws Exception
    {
        return mMediaUtility.getThumbnailUri(vineprogresslistener, s, file, context);
    }

    public String uploadVideo(VineProgressListener vineprogresslistener, File file, Context context, String s, boolean flag)
        throws Exception
    {
        return mMediaUtility.getVideoUri(vineprogresslistener, file, context, s, flag);
    }

}
