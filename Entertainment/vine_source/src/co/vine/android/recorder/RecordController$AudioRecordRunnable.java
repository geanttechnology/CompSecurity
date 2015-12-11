// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.media.AudioRecord;
import android.os.Process;
import co.vine.android.service.ResourceService;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            RecordController, RecordConfigUtils, AudioArray, AudioData, 
//            RecordSegment, BasicVineRecorder

public class <init>
    implements Runnable
{

    public boolean forceQuit;
    public volatile boolean isInitialized;
    private AudioArray mAudioDataBuffer;
    private final AudioRecord mAudioRecord;
    private int mCount;
    private final String mOutput;
    final RecordController this$0;

    private void record(RecordSegment recordsegment, AudioArray audioarray, int i)
    {
        audioarray.putInto(RecordController.access$500(RecordController.this), mCount, i);
        recordsegment.addAudioData(new AudioData(mCount, i));
        mCount = mCount + i;
    }

    public void run()
    {
        mCount mcount;
        Process.setThreadPriority(-19);
        SLog.d("mAudioRecord.startRecording()");
        if (RecordController.access$600(RecordController.this))
        {
            mcount = this._fld0;
        } else
        {
            mcount = this._fld0;
        }
        mAudioDataBuffer = ResourceService.getAudioDataBuffer(mcount);
        SLog.d("Buffer size {}.", Integer.valueOf(mAudioDataBuffer.length));
        isInitialized = false;
        while (mAudioRecord.getState() == 0) 
        {
            try
            {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception) { }
        }
        isInitialized = true;
        CrashUtil.log("mAudioRecord.isInitialized: {}.", new Object[] {
            mOutput
        });
        mAudioRecord.startRecording();
_L5:
        if ((RecordController.access$700(RecordController.this) || RecordController.access$800(RecordController.this) > RecordController.access$300(RecordController.this)) && !RecordController.access$900(RecordController.this) && !forceQuit) goto _L2; else goto _L1
_L1:
        ResourceService.releaseAudioBuffer(mcount);
        SLog.d("AudioThread Finished, release mAudioRecord");
        mAudioRecord.stop();
        mAudioRecord.release();
        isInitialized = false;
        CrashUtil.log("mAudioRecord released: {} {} {}.", new Object[] {
            Boolean.valueOf(RecordController.access$700(RecordController.this)), Boolean.valueOf(RecordController.access$900(RecordController.this)), mOutput
        });
        return;
_L2:
        int i;
        updateTimestamp();
        i = mAudioDataBuffer.readFrom(mAudioRecord, mAudioDataBuffer.length);
        if (i != -3)
        {
            break; /* Loop/switch isn't completed */
        }
        SLog.d((new StringBuilder()).append("Audio Record in invalid state: (valid = 3) ").append(mAudioRecord.getState()).toString());
        if (true) goto _L1; else goto _L3
_L3:
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        if (RecordController.access$1000(RecordController.this))
        {
            i = (int)Math.min((double)(RecordController.access$800(RecordController.this) - RecordController.access$300(RecordController.this)) * 0.0441D + 1.0D, i);
        }
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = RecordController.access$1100(RecordController.this);
        if (obj != null && RecordController.access$1200(RecordController.this))
        {
            record(((RecordSegment) (obj)), mAudioDataBuffer, i);
            RecordController.access$1302(RecordController.this, ((RecordSegment) (obj)));
        } else
        {
            RecordSegment recordsegment1 = RecordController.access$1300(RecordController.this);
            RecordSegment recordsegment = recordsegment1;
            if (recordsegment1 == null)
            {
                recordsegment = RecordController.access$1400(RecordController.this);
            }
            if (RecordController.access$800(RecordController.this) > RecordController.access$300(RecordController.this))
            {
                if (recordsegment == null)
                {
                    SLog.e("Recording have not started yet? {} vs {}.", Long.valueOf(RecordController.access$800(RecordController.this)), Long.valueOf(RecordController.access$300(RecordController.this)));
                } else
                {
                    record(recordsegment, mAudioDataBuffer, i);
                }
            }
        }
        if (mParent == null) goto _L1; else goto _L4
_L4:
        obj = mParent.getConfig();
        if (obj != null && RecordController.access$300(RecordController.this) < (long)(((this._cls0) (obj)).ation * 1000)) goto _L5; else goto _L1
    }

    public void updateTimestamp()
    {
        if (RecordController.access$200(RecordController.this) != null)
        {
            int i = RecordConfigUtils.getTimeStampInNsFromSampleCounted(mCount);
            if (RecordController.access$300(RecordController.this) != (long)i)
            {
                RecordController.access$302(RecordController.this, i);
                RecordController.access$402(RecordController.this, System.nanoTime());
            }
        }
    }

    private (String s, int i)
    {
        this$0 = RecordController.this;
        super();
        mAudioRecord = new AudioRecord(1, 44100, 16, 2, RecordConfigUtils.AUDIO_RUNNABLE_SAMPLE_SIZE);
        mCount = i;
        mOutput = s;
    }

    mOutput(String s, int i, mOutput moutput)
    {
        this(s, i);
    }
}
