// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.os.Process;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MediaUtil;
import com.edisonwang.android.slog.SLog;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

// Referenced classes of package co.vine.android.recorder:
//            AbstractCombiningRunnable, AudioArray, RecordingFile, RecordSession, 
//            RecordSegment, SwVineFrameRecorder, VineFrameGrabber, AudioData, 
//            CameraSetting, BaseFinishProcessTask, VideoData

public class SwCombiningRunnable extends AbstractCombiningRunnable
{

    private int errorCount;
    private boolean hasLoggedException;
    private final BaseFinishProcessTask mAsyncTask;
    private final short mAudioArray[];
    private Bitmap mBitmap;
    private String mLastFrameOnlyModePath;
    private String mLastFramePath;
    private ArrayList mSegments;
    private boolean mSingleSegment;
    private com.googlecode.javacv.cpp.opencv_core.IplImage mTempFrame;
    private String mThumbnailPath;
    private long mTimeOffset;
    private final byte mVideoArray[];
    private String mVideoPath;
    private final SwVineFrameRecorder mVideoRecorder;
    public int mVideoSize;

    private SwCombiningRunnable(AudioArray audioarray, byte abyte0[], SwVineFrameRecorder swvineframerecorder, BaseFinishProcessTask basefinishprocesstask, Bitmap bitmap, com.googlecode.javacv.cpp.opencv_core.IplImage iplimage)
    {
        short aword0[] = null;
        super();
        errorCount = 0;
        mLastFrameOnlyModePath = null;
        if (audioarray != null)
        {
            aword0 = audioarray.getDataShort();
        }
        mAudioArray = aword0;
        mVideoArray = abyte0;
        mBitmap = bitmap;
        mTempFrame = iplimage;
        mVideoRecorder = swvineframerecorder;
        mTimeOffset = 0L;
        mAsyncTask = basefinishprocesstask;
    }

    public SwCombiningRunnable(RecordingFile recordingfile, RecordSegment recordsegment, SwVineFrameRecorder swvineframerecorder, BaseFinishProcessTask basefinishprocesstask, Bitmap bitmap, com.googlecode.javacv.cpp.opencv_core.IplImage iplimage, boolean flag)
    {
        this(recordingfile.getSession().getAudioData(), recordingfile.getSession().getVideoData(), swvineframerecorder, basefinishprocesstask, bitmap, iplimage);
        mSegments = new ArrayList();
        mSegments.add(recordsegment);
        mSingleSegment = true;
        mVideoPath = recordingfile.getSegmentVideoPath();
        recordsegment.videoPath = mVideoPath;
        mThumbnailPath = recordingfile.getSegmentThumbnailPath();
        if (flag)
        {
            mLastFrameOnlyModePath = recordingfile.getPreviewThumbnailPath();
        }
        mLastFramePath = initLastFramePath(true);
    }

    public SwCombiningRunnable(RecordingFile recordingfile, boolean flag, AudioArray audioarray, byte abyte0[], ArrayList arraylist, SwVineFrameRecorder swvineframerecorder, BaseFinishProcessTask basefinishprocesstask, 
            Bitmap bitmap, com.googlecode.javacv.cpp.opencv_core.IplImage iplimage)
    {
        String s;
        if (flag)
        {
            s = recordingfile.getPreviewVideoPath();
        } else
        {
            s = recordingfile.getVideoPath();
        }
        if (flag)
        {
            recordingfile = recordingfile.getPreviewThumbnailPath();
        } else
        {
            recordingfile = recordingfile.getThumbnailPath();
        }
        this(s, ((String) (recordingfile)), audioarray, abyte0, arraylist, swvineframerecorder, basefinishprocesstask, bitmap, iplimage);
        mLastFramePath = initLastFramePath(flag);
    }

    public SwCombiningRunnable(String s, String s1, AudioArray audioarray, byte abyte0[], ArrayList arraylist, SwVineFrameRecorder swvineframerecorder, BaseFinishProcessTask basefinishprocesstask, 
            Bitmap bitmap, com.googlecode.javacv.cpp.opencv_core.IplImage iplimage)
    {
        this(audioarray, abyte0, swvineframerecorder, basefinishprocesstask, bitmap, iplimage);
        mSegments = arraylist;
        mVideoPath = s;
        mThumbnailPath = s1;
    }

    private String initLastFramePath(boolean flag)
    {
        if (!mSingleSegment || mLastFrameOnlyModePath != null)
        {
            String s;
            if (mLastFrameOnlyModePath == null)
            {
                s = mThumbnailPath;
            } else
            {
                s = mLastFrameOnlyModePath;
            }
            return RecordingFile.getLastFramePathThumbnailFromThumbnailPath(s, flag);
        } else
        {
            return null;
        }
    }

    private void saveThumbnail(int i, int j, int k)
    {
        if (!mVideoRecorder.hasData()) goto _L2; else goto _L1
_L1:
        String s = mLastFramePath;
        int l;
        boolean flag;
        flag = false;
        l = ((flag) ? 1 : 0);
        long l1 = System.currentTimeMillis();
        l = ((flag) ? 1 : 0);
        Object obj = new VineFrameGrabber(mVideoPath);
        l = ((flag) ? 1 : 0);
        ((VineFrameGrabber) (obj)).start();
        int i1 = 0;
_L24:
        l = ((flag) ? 1 : 0);
        Object obj2 = ((VineFrameGrabber) (obj)).grab();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        int j1 = i1 + 1;
        if (j1 != 2 && i != 1) goto _L6; else goto _L5
_L5:
        l = ((flag) ? 1 : 0);
        opencv_imgproc.cvCvtColor(((com.googlecode.javacv.cpp.opencv_core.CvArr) (obj2)), mTempFrame, 2);
        l = ((flag) ? 1 : 0);
        mBitmap.copyPixelsFromBuffer(mTempFrame.getByteBuffer());
        l = ((flag) ? 1 : 0);
        mBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(mThumbnailPath));
        l = ((flag) ? 1 : 0);
        SLog.i("First Thumbnail generated.");
          goto _L6
_L4:
        l = ((flag) ? 1 : 0);
        ((VineFrameGrabber) (obj)).stop();
        l = ((flag) ? 1 : 0);
        ((VineFrameGrabber) (obj)).release();
        i1 = 1;
        i = 1;
        l = i1;
        SLog.d("Grabbing using openCV took {}ms.", Long.valueOf(System.currentTimeMillis() - l1));
        l = i;
        if (true)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        l = i1;
        obj = new File(null, "firstFrame.jpg");
        l = i1;
        FileUtils.copyFile(new File(mThumbnailPath), ((File) (obj)));
        l = i1;
        obj = ((File) (obj)).getPath().replace("/storage/emulated/0/", "/sdcard/");
        l = i1;
        SLog.d((new StringBuilder()).append("Thumbnail copied to ").append(((String) (obj))).toString());
        l = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        l = i1;
        obj = new File(null, "lastFrame.jpg");
        l = i1;
        FileUtils.copyFile(new File(s), ((File) (obj)));
        l = i1;
        obj = ((File) (obj)).getPath().replace("/storage/emulated/0/", "/sdcard/");
        l = i1;
        SLog.d((new StringBuilder()).append("Last Frame copied to ").append(((String) (obj))).toString());
        l = i;
_L26:
        if (l != 0) goto _L8; else goto _L7
_L7:
        long l2;
        try
        {
            l1 = System.currentTimeMillis();
            l2 = (long)((((double)j * 1.0D) / (double)k) * 1000D * 1000D);
            SLog.d("Use duration: {}.", Long.valueOf(l2));
            obj2 = mVideoPath;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashUtil.log("Error saving thumbnail...", new Object[] {
                obj
            });
            return;
        }
        if (s == null) goto _L10; else goto _L9
_L9:
        obj = new long[2];
        obj[0] = 0L;
        obj[1] = l2;
_L27:
        obj = MediaUtil.getVideoFrames(((String) (obj2)), ((long []) (obj)));
        SLog.d("Grabbing using MediaUtil took {}ms.", Long.valueOf(System.currentTimeMillis() - l1));
        if (obj == null) goto _L8; else goto _L11
_L11:
        obj[0].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(mThumbnailPath));
        if (s == null || obj[1] == null)
        {
            break MISSING_BLOCK_LABEL_537;
        }
        obj[1].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(s));
        if (true) goto _L8; else goto _L12
_L12:
        obj = new File(null, "firstFrame2.jpg");
        FileUtils.copyFile(new File(mThumbnailPath), ((File) (obj)));
        obj = ((File) (obj)).getPath().replace("/storage/emulated/0/", "/sdcard/");
        SLog.d((new StringBuilder()).append("Thumbnail copied to ").append(((String) (obj))).toString());
        if (s == null) goto _L8; else goto _L13
_L13:
        obj = new File(null, "lastFrame2.jpg");
        FileUtils.copyFile(new File(s), ((File) (obj)));
        obj = ((File) (obj)).getPath().replace("/storage/emulated/0/", "/sdcard/");
        SLog.d((new StringBuilder()).append("Last Frame copied to ").append(((String) (obj))).toString());
_L8:
        if ((new File(mThumbnailPath)).exists()) goto _L15; else goto _L14
_L14:
        CrashUtil.log("Retry generating thumbnail.");
        obj = MediaUtil.getVideoFrames(mVideoPath, new long[] {
            0L
        });
        if (obj == null) goto _L17; else goto _L16
_L16:
        if (obj.length != 1) goto _L17; else goto _L18
_L18:
        obj[0].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(mThumbnailPath));
        SLog.i("First Thumbnail generated.");
_L15:
        if ((new File(mThumbnailPath)).exists()) goto _L2; else goto _L19
_L19:
        CrashUtil.log("Retry generating thumbnail.");
        obj = MediaUtil.getVideoFrames(mVideoPath, new long[] {
            0L
        });
        if (obj == null) goto _L21; else goto _L20
_L20:
        if (obj.length != 1) goto _L21; else goto _L22
_L22:
        obj[0].compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(mThumbnailPath));
        SLog.i("First Thumbnail generated.");
_L2:
        return;
_L28:
        i1 = j1;
        if (i > j1) goto _L24; else goto _L23
_L23:
        i1 = j1;
        if (j1 == 1) goto _L24; else goto _L25
_L25:
        l = ((flag) ? 1 : 0);
        opencv_imgproc.cvCvtColor(((com.googlecode.javacv.cpp.opencv_core.CvArr) (obj2)), mTempFrame, 2);
        l = ((flag) ? 1 : 0);
        mBitmap.copyPixelsFromBuffer(mTempFrame.getByteBuffer());
        l = ((flag) ? 1 : 0);
        mBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(s));
        l = ((flag) ? 1 : 0);
        SLog.i("Last Thumbnail generated.");
        i1 = j1;
          goto _L24
        obj;
        CrashUtil.log("Error creating thumbnail using default method...", new Object[] {
            obj
        });
          goto _L26
        obj;
        l = i1;
        SLog.d("Failed to copy.", ((Throwable) (obj)));
        l = i;
          goto _L26
_L10:
        obj = new long[1];
        obj[0] = 0L;
          goto _L27
        Object obj1;
        obj1;
        SLog.d("Failed to copy.", ((Throwable) (obj1)));
          goto _L8
_L17:
        throw new IllegalStateException();
        obj1;
        CrashUtil.log("Failed to generate thumbnail.");
          goto _L15
_L21:
        throw new IllegalStateException();
        obj1;
        CrashUtil.log("Failed to generate thumbnail.");
        return;
_L6:
        if (s != null) goto _L28; else goto _L4
    }

    public co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable combineVideos()
    {
        float f;
        ArrayList arraylist;
        int i;
        int j;
        int k;
        int l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        Process.setThreadPriority(-8);
        arraylist = mSegments;
        l1 = arraylist.size();
        l2 = 0L;
        l3 = 0L;
        i = 0;
        SLog.d("Processing started: {}.", Integer.valueOf(l1));
        f = (1.0F / (float)l1) * 5F;
        l7 = 0L;
        l6 = 0L;
        j = 0;
        k = 30;
        l4 = l3;
        l5 = l2;
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        int l;
        l = 0;
        l4 = l7;
        l5 = l6;
_L10:
        if (l >= l1) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj2;
        byte abyte0[];
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        long l11;
        obj2 = (RecordSegment)arraylist.get(l);
        i2 = (int)(((float)l / (float)l1) * 10F) + 90;
        obj = null;
        l6 = l3;
        if (mAudioArray != null)
        {
            l6 = System.currentTimeMillis();
            Object obj1 = ((RecordSegment) (obj2)).getCombinedAudioData();
            long l8;
            try
            {
                if (((AudioData) (obj1)).size > 0)
                {
                    obj = ShortBuffer.wrap(mAudioArray, ((AudioData) (obj1)).start, ((AudioData) (obj1)).size);
                    if (mSingleSegment)
                    {
                        short aword0[] = new short[((AudioData) (obj1)).size];
                        ((ShortBuffer) (obj)).get(aword0);
                        obj = ShortBuffer.wrap(aword0);
                    }
                    SLog.d("Recording segment audio: {}, {}.", Integer.valueOf(((AudioData) (obj1)).start), Integer.valueOf(((AudioData) (obj1)).size));
                    mVideoRecorder.record(new Buffer[] {
                        obj
                    });
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (!hasLoggedException || SLog.sLogsOn)
                {
                    hasLoggedException = true;
                    CrashUtil.logException(((Throwable) (obj)));
                }
            }
            l6 = l3 + (System.currentTimeMillis() - l6);
            obj = obj1;
        }
        obj1 = ((RecordSegment) (obj2)).getVideoData();
        abyte0 = mVideoArray;
        l11 = System.currentTimeMillis();
        k1 = ((RecordSegment) (obj2)).getCameraSetting().frameRate;
        j2 = ((ArrayList) (obj1)).size();
        l3 = 0L;
        mVideoSize = 0;
        if (mAsyncTask != null)
        {
            mAsyncTask.publish((int)((float)i2 + f));
        }
        i1 = 0;
        if (i1 >= j2)
        {
            break MISSING_BLOCK_LABEL_868;
        }
        obj2 = (VideoData)((ArrayList) (obj1)).get(i1);
        mVideoSize = mVideoSize + ((VideoData) (obj2)).size;
        l8 = l3;
        if (mSingleSegment)
        {
            if (i1 == 0)
            {
                l3 = ((VideoData) (obj2)).timestamp;
            }
            obj2.timestamp = ((VideoData) (obj2)).timestamp - l3;
            l8 = l3;
        }
        if (((VideoData) (obj2)).size >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        j1 = j;
_L8:
        i1++;
        j = j1;
        l3 = l8;
        i = k;
        if (true) goto _L6; else goto _L5
_L6:
        break MISSING_BLOCK_LABEL_309;
_L5:
        mVideoRecorder.setFrameRate(k1);
        if (((VideoData) (obj2)).timestamp == 0L)
        {
            mTimeOffset = mVideoRecorder.getTimestamp();
        }
        l3 = ((VideoData) (obj2)).timestamp + mTimeOffset;
        j = mVideoRecorder.getFrameNumber();
        long l10 = mVideoRecorder.getTimestamp();
        if (l3 - l10 > (long)(0xf4240 / k1))
        {
            SLog.d("*******Skipped frame*******");
            j = mVideoRecorder.setTimestampAndGetFrameNumber(l3);
        } else
        {
            l3 = l10;
        }
        k = i;
        mVideoRecorder.writeEncodedImage(abyte0, ((VideoData) (obj2)).start, ((VideoData) (obj2)).size, ((VideoData) (obj2)).keyFrame);
        i++;
        k = i;
        SLog.d("Successfully did video frame at {}, #{}.", Long.valueOf(l3), Integer.valueOf(j));
_L9:
        j1 = j;
        k = i;
        if (mAsyncTask != null)
        {
            mAsyncTask.publish((int)((float)i2 + (((float)(i1 + 1) * f) / (float)j2 + f)));
            j1 = j;
            k = i;
        }
        if (true) goto _L8; else goto _L7
_L7:
        SwVineFrameRecorder.Exception exception2;
        exception2;
        SLog.e("Failed to record video frame at {}. #{}.", Long.valueOf(l3), Integer.valueOf(j));
        i = k;
        mVideoRecorder.writeEncodedImage(abyte0, ((VideoData) (obj2)).start, ((VideoData) (obj2)).size, ((VideoData) (obj2)).keyFrame);
        k++;
        i = k;
        SLog.d("Retry successful #{}.", Integer.valueOf(j));
        i = k;
          goto _L9
        exception2;
        SLog.e("Retry again: #{}.", Integer.valueOf(j));
        l3 += 1000L / (long)k1;
        j = Math.round(((long)k1 * l3) / 1000L);
        mVideoRecorder.setTimestamp(l3);
        obj2.timestamp = l3;
        k = i;
        mVideoRecorder.writeEncodedImage(abyte0, ((VideoData) (obj2)).start, ((VideoData) (obj2)).size, ((VideoData) (obj2)).keyFrame);
        i++;
        k = i;
        try
        {
            SLog.d("Retry Retry successful #{}.", Integer.valueOf(j));
        }
        catch (SwVineFrameRecorder.Exception exception1)
        {
            errorCount = errorCount + 1;
            SLog.e("Retry failed: {}.", Integer.valueOf(errorCount));
            i = k;
        }
          goto _L9
        long l9 = l2 + (System.currentTimeMillis() - l11);
        if (mAsyncTask != null)
        {
            mAsyncTask.publish(((l + 1) * 10) / l1 + 90);
        }
        l3 = l5;
        l2 = l4;
        if (obj != null)
        {
            l3 = l5;
            l2 = l4;
            if (SLog.sLogsOn)
            {
                l3 = l5 + ((AudioData) (obj)).getDurationNs() / 1000L;
                l2 = l4 + (long)((1000 / k1) * j2);
                SLog.d("Recorded segment with time: audio: {}, video: {}.", Long.valueOf(((AudioData) (obj)).getDurationNs() / 1000L), Integer.valueOf((1000 / k1) * j2));
            }
        }
        SLog.d("Video Count: {}.", Integer.valueOf(i));
        l++;
        l5 = l3;
        l3 = l6;
        k = k1;
        l4 = l2;
        l2 = l9;
          goto _L10
_L4:
        boolean flag;
        SLog.d("Done with all segments. total time: audio: {}, video: {}.", Long.valueOf(l5), Long.valueOf(l4));
        flag = false;
        mVideoRecorder.stop();
        flag = true;
_L12:
        boolean flag2 = flag;
        if (flag)
        {
            flag2 = flag;
            if (mVideoPath != null)
            {
                boolean flag1 = (new File(mVideoRecorder.getFilename())).renameTo(new File(mVideoPath));
                flag2 = flag1;
                if (!flag1)
                {
                    CrashUtil.log("Error renaming to final fn.");
                    flag2 = flag1;
                }
            }
        }
        SLog.d("Combining finished: {}", Boolean.valueOf(flag2));
        l4 = l3;
        l5 = l2;
        if (mThumbnailPath != null)
        {
            saveThumbnail(i, j, k);
            l5 = l2;
            l4 = l3;
        }
_L2:
        if (mAsyncTask != null)
        {
            mAsyncTask.publish(99);
        }
        SLog.d("Processing thread finished: failed {} frames.", Integer.valueOf(errorCount));
        SLog.d("Time used: video: {}, audio: {}, n: {}.", Long.valueOf(l5), Long.valueOf(l4), Integer.valueOf(l1));
        return null;
        SwVineFrameRecorder.Exception exception;
        exception;
        CrashUtil.log("Error flushing...", new Object[] {
            exception
        });
        if (true) goto _L12; else goto _L11
_L11:
    }
}
