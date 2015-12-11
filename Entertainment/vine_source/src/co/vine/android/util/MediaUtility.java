// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import co.vine.android.api.VineParserReader;
import co.vine.android.client.Amazon;
import co.vine.android.client.VineAPI;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.network.HttpOperation;
import co.vine.android.network.ThreadedHttpOperationClient;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.util.image.ImageUtils;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.util.UUID;

// Referenced classes of package co.vine.android.util:
//            Util, UploadManager, MeasureOutputStream, VineProgressListener

public class MediaUtility
{
    private static class FileInfo
    {

        public File file;
        public String filename;
        public String uploadKey;

        public FileInfo(String s, File file1, String s1)
        {
            filename = s;
            file = file1;
            uploadKey = s1;
        }
    }


    public static final int MEDIA = 2;
    public static final int S3 = 1;
    private final String mAmazonBucket;
    private final Context mContext;
    private final String mMediaUrl;

    public MediaUtility(Context context)
    {
        mContext = context;
        mMediaUrl = VineAPI.getInstance(context).getMediaUrl();
        mAmazonBucket = Amazon.getBucket(context);
    }

    public static int getUploadType(Context context)
    {
        while (!VineAccountHelper.isLoggedIn(context, true) || "s3".equals(Util.getDefaultSharedPrefs(context).getString("server_upload_type", "media"))) 
        {
            return 1;
        }
        return 2;
    }

    public String getPhotoUri(Uri uri, String s, Context context)
        throws Exception
    {
        Object obj = null;
        String s2 = (new StringBuilder()).append("avatars/").append(UUID.randomUUID()).append(".jpg").toString();
        String s1 = obj;
        if (uri != null)
        {
            s1 = obj;
            if (!TextUtils.isEmpty(uri.toString()))
            {
                uri = upload(null, s2, new File(ImageUtils.getRealPathFromImageUri(context, uri)), s, "avatars");
                s1 = obj;
                if (uri != null)
                {
                    s1 = ((FileInfo) (uri)).uploadKey;
                }
            }
        }
        return s1;
    }

    public String getThumbnailUri(VineProgressListener vineprogresslistener, String s, File file, Context context)
        throws Exception
    {
        vineprogresslistener = upload(vineprogresslistener, (new StringBuilder()).append("thumbs/").append(s).append(".jpg").toString(), file, mAmazonBucket, "thumbs");
        if (vineprogresslistener != null)
        {
            return ((FileInfo) (vineprogresslistener)).uploadKey;
        } else
        {
            return null;
        }
    }

    public String getVideoUri(VineProgressListener vineprogresslistener, File file, Context context, String s, boolean flag)
        throws Exception
    {
        vineprogresslistener = upload(vineprogresslistener, (new StringBuilder()).append("videos/").append(s).toString(), file, mAmazonBucket, "videos", flag);
        if (vineprogresslistener != null)
        {
            return ((FileInfo) (vineprogresslistener)).uploadKey;
        } else
        {
            return null;
        }
    }

    public FileInfo upload(VineProgressListener vineprogresslistener, String s, File file, String s1, String s2)
        throws Exception
    {
        return upload(vineprogresslistener, s, file, s1, s2, false);
    }

    public FileInfo upload(VineProgressListener vineprogresslistener, String s, File file, String s1, String s2, boolean flag)
        throws Exception
    {
        SLog.d("Upload started for {}.", file);
        getUploadType(mContext);
        JVM INSTR tableswitch 1 2: default 36
    //                   1 38
    //                   2 38;
           goto _L1 _L2 _L2
_L1:
        return null;
_L2:
        SLog.d((new StringBuilder()).append("Uploading key: ").append(s).toString());
        s1 = UploadManager.getVersionFromPath(file.getPath());
        if (s.endsWith(((RecordSessionVersion) (s1)).videoOutputExtension))
        {
            s = VineAPI.buildUponUrl(mMediaUrl, new Object[] {
                "upload", "videos", (new StringBuilder()).append(file.getName()).append(((RecordSessionVersion) (s1)).videoOutputExtension).toString()
            });
            if (flag)
            {
                VineAPI.addParam(s, "private", "1");
            }
            vineprogresslistener = new MeasureOutputStream(file, ((RecordSessionVersion) (s1)).mimeType, vineprogresslistener);
            s1 = VineParserReader.createParserReader(16);
            vineprogresslistener = HttpOperation.createMediaPutRequest(ThreadedHttpOperationClient.getInstance(mContext), s, s1, vineprogresslistener, VineAPI.getInstance(mContext)).execute();
            if (vineprogresslistener.isOK())
            {
                SLog.d("Upload {} successful.", ((HttpOperation) (vineprogresslistener)).uploadKey);
                return new FileInfo(file.getName(), file, ((HttpOperation) (vineprogresslistener)).uploadKey);
            }
            SLog.d("{} {} {}", s, Integer.valueOf(((HttpOperation) (vineprogresslistener)).statusCode), ((HttpOperation) (vineprogresslistener)).statusPhrase);
        } else
        if (s.endsWith("jpg"))
        {
            SLog.d("Upload image through media.");
            s = VineAPI.buildUponUrl(mMediaUrl, new Object[] {
                "upload", s2, (new StringBuilder()).append(file.getName()).append(".jpg").toString()
            });
            if (flag)
            {
                VineAPI.addParam(s, "private", "1");
            }
            vineprogresslistener = new MeasureOutputStream(file, "image/jpeg", vineprogresslistener);
            s1 = VineParserReader.createParserReader(16);
            vineprogresslistener = HttpOperation.createMediaPutRequest(ThreadedHttpOperationClient.getInstance(mContext), s, s1, vineprogresslistener, VineAPI.getInstance(mContext)).execute();
            if (vineprogresslistener.isOK())
            {
                SLog.d("Upload {} successful.", ((HttpOperation) (vineprogresslistener)).uploadKey);
                return new FileInfo(file.getName(), file, ((HttpOperation) (vineprogresslistener)).uploadKey);
            }
            SLog.e("{} {} {}", new Object[] {
                s, Integer.valueOf(((HttpOperation) (vineprogresslistener)).statusCode), ((HttpOperation) (vineprogresslistener)).statusPhrase
            });
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
