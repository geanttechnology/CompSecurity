// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.Process;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.recorder:
//            AbstractCombiningRunnable, RecordingFile, RecordSession, AudioArray, 
//            RecordSegment, AudioData, HwVineFrameRecorder, CameraSetting, 
//            VideoData, BaseFinishProcessTask

public class HwCombiningRunnable extends AbstractCombiningRunnable
{

    private boolean hasLoggedException;
    private final BaseFinishProcessTask mAsyncTask;
    private final byte mAudioArray[];
    private final boolean mIsPreview;
    private String mLastFrameOnlyModePath;
    private ArrayList mSegments;
    private boolean mSingleSegment;
    private String mThumbnailPath;
    private long mTimeOffset;
    private final byte mVideoArray[];
    private String mVideoPath;
    private final HwVineFrameRecorder mVideoRecorder;

    public HwCombiningRunnable(RecordingFile recordingfile, RecordSegment recordsegment, HwVineFrameRecorder hwvineframerecorder, BaseFinishProcessTask basefinishprocesstask, boolean flag)
    {
        this(true, recordingfile.getSession().getAudioData().getDataByte(), recordingfile.getSession().getVideoData(), hwvineframerecorder, basefinishprocesstask);
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
    }

    public HwCombiningRunnable(RecordingFile recordingfile, boolean flag, AudioArray audioarray, byte abyte0[], ArrayList arraylist, HwVineFrameRecorder hwvineframerecorder, BaseFinishProcessTask basefinishprocesstask)
    {
        this(flag, audioarray.getDataByte(), abyte0, hwvineframerecorder, basefinishprocesstask);
        mSegments = arraylist;
        if (flag)
        {
            audioarray = recordingfile.getPreviewVideoPath();
        } else
        {
            audioarray = recordingfile.getVideoPath();
        }
        mVideoPath = audioarray;
        if (flag)
        {
            recordingfile = recordingfile.getPreviewThumbnailPath();
        } else
        {
            recordingfile = recordingfile.getThumbnailPath();
        }
        mThumbnailPath = recordingfile;
    }

    private HwCombiningRunnable(boolean flag, byte abyte0[], byte abyte1[], HwVineFrameRecorder hwvineframerecorder, BaseFinishProcessTask basefinishprocesstask)
    {
        mLastFrameOnlyModePath = null;
        mAudioArray = abyte0;
        mVideoArray = abyte1;
        mIsPreview = flag;
        mVideoRecorder = hwvineframerecorder;
        mTimeOffset = 0L;
        mAsyncTask = basefinishprocesstask;
    }

    public co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable combineVideos()
    {
        int l;
        long l1;
        long l2;
        long l3;
        long l4;
        Process.setThreadPriority(-8);
        ArrayList arraylist = mSegments;
        l = arraylist.size();
        l1 = 0L;
        l2 = 0L;
        SLog.d("Processing started: {}.", Integer.valueOf(l));
        long l7 = 0L;
        long l5 = 0L;
        l4 = l2;
        l3 = l1;
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_836;
        }
        byte abyte0[] = mAudioArray;
        int i = 0;
        l3 = l7;
        l4 = l5;
        while (i < l) 
        {
            RecordSegment recordsegment = (RecordSegment)arraylist.get(i);
            long l6 = System.currentTimeMillis();
            AudioData audiodata = recordsegment.getCombinedAudioData();
            ArrayList arraylist1;
            byte abyte1[];
            int j;
            int i1;
            int j1;
            long l8;
            long l10;
            try
            {
                if (audiodata.size > 0)
                {
                    SLog.d("Recording segment audio: {}, {}.", Integer.valueOf(audiodata.start), Integer.valueOf(audiodata.size));
                    mVideoRecorder.recordAudio(abyte0, audiodata.start, audiodata.size);
                }
            }
            catch (HwVineFrameRecorder.Exception exception)
            {
                if (!hasLoggedException || SLog.sLogsOn)
                {
                    hasLoggedException = true;
                    CrashUtil.logException(exception);
                }
            }
            l8 = l2 + (System.currentTimeMillis() - l6);
            arraylist1 = recordsegment.getVideoData();
            abyte1 = mVideoArray;
            l10 = System.currentTimeMillis();
            i1 = recordsegment.getCameraSetting().frameRate;
            j1 = arraylist1.size();
            l2 = 0L;
            j = 0;
            while (j < j1) 
            {
                VideoData videodata = (VideoData)arraylist1.get(j);
                l6 = l2;
                if (mSingleSegment)
                {
                    if (j == 0)
                    {
                        l2 = videodata.timestamp;
                    }
                    videodata.timestamp = videodata.timestamp - l2;
                    l6 = l2;
                }
                if (videodata.size >= 0)
                {
                    if (videodata.timestamp == 0L)
                    {
                        mTimeOffset = mVideoRecorder.getTimestamp();
                    }
                    l2 = videodata.timestamp + mTimeOffset;
                    int k = mVideoRecorder.getFrameNumber();
                    long l9 = mVideoRecorder.getTimestamp();
                    if (l2 - l9 > (long)(0xf4240 / i1))
                    {
                        SLog.d("*******Skipped frame*******");
                        mVideoRecorder.setTimestamp(l2);
                        k = mVideoRecorder.getFrameNumber();
                    } else
                    {
                        l2 = l9;
                    }
                    try
                    {
                        mVideoRecorder.writeEncodedImage(abyte1, videodata.start, videodata.size);
                        SLog.d("Successfully did video frame at {}, #{}.", Long.valueOf(l2), Integer.valueOf(k));
                    }
                    catch (HwVineFrameRecorder.Exception exception1)
                    {
                        SLog.e("Failed to record video frame at {}. #{}.", Long.valueOf(l2), Integer.valueOf(k));
                    }
                }
                j++;
                l2 = l6;
            }
            l6 = l1 + (System.currentTimeMillis() - l10);
            if (mAsyncTask != null)
            {
                mAsyncTask.publish((i * 10) / l + 90);
            }
            l2 = l4;
            l1 = l3;
            if (SLog.sLogsOn)
            {
                l2 = l4 + audiodata.getDurationNs() / 1000L;
                l1 = l3 + (long)((1000 / i1) * j1);
                SLog.d("Recorded segment with time: audio: {}, video: {}.", Long.valueOf(audiodata.getDurationNs() / 1000L), Integer.valueOf((1000 / i1) * j1));
            }
            i++;
            l4 = l2;
            l2 = l8;
            l3 = l1;
            l1 = l6;
        }
        SLog.d("Done with all segments. total time: audio: {}, video: {}.", Long.valueOf(l4), Long.valueOf(l3));
        mVideoRecorder.stopCombining();
        SLog.d("Video file renamed: {}, {}.", Boolean.valueOf((new File(mVideoRecorder.getOutput())).renameTo(new File(mVideoPath))), mVideoPath);
        l4 = l2;
        l3 = l1;
        if (mThumbnailPath == null)
        {
            break MISSING_BLOCK_LABEL_836;
        }
        l4 = l2;
        l3 = l1;
        if (!mVideoRecorder.hasData())
        {
            break MISSING_BLOCK_LABEL_836;
        }
        if (mSingleSegment && mLastFrameOnlyModePath == null) goto _L2; else goto _L1
_L1:
        if (mLastFrameOnlyModePath != null) goto _L4; else goto _L3
_L3:
        Object obj = mThumbnailPath;
_L5:
        obj = RecordingFile.getLastFramePathThumbnailFromThumbnailPath(((String) (obj)), mIsPreview);
_L6:
        obj = new co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable(mVideoRecorder.getLastTimestamp(), mVideoPath, mThumbnailPath, ((String) (obj)));
_L7:
        if (mAsyncTask != null)
        {
            mAsyncTask.publish(99);
        }
        SLog.b("Time used: video: {}, audio: {}, n: {}.", new Object[] {
            Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(l)
        });
        return ((co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable) (obj));
_L4:
        obj = mLastFrameOnlyModePath;
          goto _L5
_L2:
        obj = null;
          goto _L6
        obj;
        CrashUtil.log("Error flushing...", new Object[] {
            obj
        });
        obj = null;
          goto _L7
        obj;
        CrashUtil.log("Failed to generate thumbnail.");
        l3 = l1;
        l4 = l2;
        obj = null;
        l2 = l4;
        l1 = l3;
          goto _L7
    }
}
