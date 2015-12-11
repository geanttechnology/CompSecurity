// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import co.vine.android.VineLoggingException;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// Referenced classes of package co.vine.android.util:
//            CrashUtil

public class MediaUtil
{
    public static class GenerateThumbnailsRunnable
        implements Runnable
    {

        private final long duration;
        private final String lastFramePath;
        private final String thumbnailPath;
        private final String videoPath;

        public void run()
        {
            try
            {
                MediaUtil.generateThumbnails(duration, videoPath, thumbnailPath, lastFramePath);
                return;
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                throw new RuntimeException(filenotfoundexception);
            }
        }

        public GenerateThumbnailsRunnable(long l, String s, String s1, String s2)
        {
            duration = l;
            lastFramePath = s2;
            videoPath = s;
            thumbnailPath = s1;
        }
    }

    public static class MediaConnectionClient
        implements android.media.MediaScannerConnection.MediaScannerConnectionClient
    {

        public MediaScannerConnection connection;
        private final String mMimeType;
        private final String mPath;

        public void onMediaScannerConnected()
        {
            connection.scanFile(mPath, mMimeType);
            connection.disconnect();
        }

        public void onScanCompleted(String s, Uri uri)
        {
            SLog.d("Scan completed: {}, {}.", s, uri);
        }

        public MediaConnectionClient(String s, String s1)
        {
            mPath = s;
            mMimeType = s1;
        }
    }


    public MediaUtil()
    {
    }

    public static void generateThumbnails(long l, String s, String s1, String s2)
        throws FileNotFoundException
    {
        long l1 = System.currentTimeMillis();
        SLog.d("Use duration: {}.", Long.valueOf(l));
        Object aobj[];
        if (s2 != null)
        {
            aobj = new long[2];
            aobj[0] = 0L;
            aobj[1] = l;
        } else
        {
            aobj = new long[1];
            aobj[0] = 0L;
        }
        aobj = getVideoFrames(s, ((long []) (aobj)));
        SLog.b("Grabbing using MediaUtil took {}ms.", Long.valueOf(System.currentTimeMillis() - l1));
        if (aobj != null)
        {
            if (aobj.length == 0 || aobj[0] == null)
            {
                CrashUtil.log("Mayday, mayday! Failed to get thumbnails, this will fail and crash: {}.", new Object[] {
                    s
                });
            }
            aobj[0].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(s1));
            if (s2 != null)
            {
                if (aobj[1] != null)
                {
                    aobj[1].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(s2));
                } else
                {
                    CrashUtil.logException(new VineLoggingException("FAILED TO GENERATE GHOST IMAGE"));
                }
            }
        }
        if ((new File(s1)).exists())
        {
            break MISSING_BLOCK_LABEL_208;
        }
        CrashUtil.log("Retry generating thumbnail.");
        s = getVideoFrames(s, new long[] {
            0L
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        if (s.length != 1)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        s[0].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(s1));
        SLog.i("First Thumbnail generated.");
        return;
        try
        {
            throw new IllegalStateException();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashUtil.log("Failed to generate thumbnail.");
        }
        return;
    }

    public static Bitmap[] getVideoFrames(String s, long al[])
    {
        MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
        mediametadataretriever.setDataSource(s);
        s = new Bitmap[al.length];
        int j;
        long l;
        j = 0;
        l = -1L;
        int k = al.length;
        int i = 0;
_L6:
        if (i >= k) goto _L2; else goto _L1
_L1:
        long l1;
        long l2;
        long l3;
        l3 = al[i];
        l1 = l;
        l2 = l3;
        if (l3 != -1L) goto _L4; else goto _L3
_L3:
        l1 = l;
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        try
        {
            l1 = Long.parseLong(mediametadataretriever.extractMetadata(9));
            SLog.d("Got duration: {}.", Long.valueOf(l1));
            break MISSING_BLOCK_LABEL_209;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            try
            {
                mediametadataretriever.release();
            }
            // Misplaced declaration of an exception variable
            catch (long al[])
            {
                SLog.e("Failed to release.", al);
            }
            throw s;
        }
          goto _L5
_L4:
        s[j] = mediametadataretriever.getFrameAtTime(l2, 1);
        if (s[j] != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s[j] = mediametadataretriever.getFrameAtTime(l2, 3);
        j++;
        SLog.d("Got frame at {}ms.", Long.valueOf(l2));
        i++;
        l = l1;
          goto _L6
_L2:
        try
        {
            mediametadataretriever.release();
        }
        // Misplaced declaration of an exception variable
        catch (long al[])
        {
            SLog.e("Failed to release.", al);
            return s;
        }
        return s;
_L5:
        SLog.e("Failed to get frame.", s);
        try
        {
            mediametadataretriever.release();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SLog.e("Failed to release.", s);
        }
        return null;
        l2 = l1 * 1000L;
          goto _L4
    }

    public static void scanFile(Context context, File file, String s)
    {
        file = new MediaConnectionClient(file.getAbsolutePath(), s);
        context = new MediaScannerConnection(context, file);
        file.connection = context;
        context.connect();
    }
}
