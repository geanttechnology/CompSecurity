// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import co.vine.android.util.InstanceCounter;
import com.edisonwang.android.slog.FormattingTuple;
import com.edisonwang.android.slog.MessageFormatter;
import com.edisonwang.android.slog.SLog;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils, AudioArray, RecordSessionVersion, RecordSegment, 
//            AudioData, VideoData

public class RecordSession
    implements Externalizable
{

    private static final InstanceCounter sInstanceCounter = new InstanceCounter(5);
    private static final int sLock[] = new int[0];
    private static final long serialVersionUID = 0x773660a9759c8145L;
    private AudioArray mAudioData;
    private int mAudioDataCount;
    private RecordConfigUtils.RecordConfig mConfig;
    private final ArrayList mSegments;
    private RecordSessionVersion mVersion;
    private byte mVideoData[];
    private int mVideoDataCount;

    public RecordSession()
    {
        mSegments = new ArrayList();
        mVideoDataCount = -1;
        mAudioDataCount = -1;
    }

    public RecordSession(RecordSessionVersion recordsessionversion)
    {
        mSegments = new ArrayList();
        mVideoDataCount = -1;
        mAudioDataCount = -1;
        synchronized (sLock)
        {
            mVersion = recordsessionversion;
            if (SLog.sLogsOn)
            {
                sInstanceCounter.onCreate(this);
            }
        }
        return;
        recordsessionversion;
        ai;
        JVM INSTR monitorexit ;
        throw recordsessionversion;
    }

    public static RecordSession newSession(RecordConfigUtils.RecordConfig recordconfig, RecordSessionVersion recordsessionversion)
    {
        RecordSession recordsession = new RecordSession(recordsessionversion);
        recordsession.mVideoData = new byte[RecordConfigUtils.getVideoBufferMax(recordconfig)];
        recordsession.mAudioData = new AudioArray(RecordConfigUtils.getMaxAudioBufferSize(recordconfig), recordsessionversion.getAudioArrayType());
        recordsession.mConfig = recordconfig;
        return recordsession;
    }

    public void add(RecordSegment recordsegment)
    {
        mSegments.add(recordsegment);
    }

    public int calculateAudioCount()
    {
        int i = 0;
        Iterator iterator = mSegments.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            RecordSegment recordsegment = (RecordSegment)iterator.next();
            if (!recordsegment.removed)
            {
                i += recordsegment.getCombinedAudioData().size;
            }
        } while (true);
        return i;
    }

    public int calculateVideoCount()
    {
        int i;
        i = 0;
        Iterator iterator = mSegments.iterator();
        do
        {
label0:
            {
                Object obj;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    obj = (RecordSegment)iterator.next();
                } while (((RecordSegment) (obj)).removed);
                obj = ((RecordSegment) (obj)).getVideoData().iterator();
                int j = i;
                do
                {
                    i = j;
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    VideoData videodata = (VideoData)((Iterator) (obj)).next();
                    if (videodata.size > 0)
                    {
                        j += videodata.size;
                    }
                } while (true);
            }
        } while (true);
        return i;
    }

    public AudioArray getAudioData()
    {
        return mAudioData;
    }

    public int getAudioDataCount()
    {
        if (mAudioDataCount == -1)
        {
            mAudioDataCount = calculateAudioCount();
        }
        return mAudioDataCount;
    }

    public RecordConfigUtils.RecordConfig getConfig()
    {
        return mConfig;
    }

    public ArrayList getSegments()
    {
        return mSegments;
    }

    public RecordSessionVersion getVersion()
    {
        if (mVersion == null)
        {
            mVersion = RecordSessionVersion.SW_MP4;
        }
        return mVersion;
    }

    public byte[] getVideoData()
    {
        return mVideoData;
    }

    public int getVideoDataCount()
    {
        if (mVideoDataCount == -1)
        {
            mVideoDataCount = calculateVideoCount();
        }
        return mVideoDataCount;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        Object obj = objectinput.readObject();
        if (obj instanceof byte[])
        {
            mVideoData = (byte[])(byte[])obj;
        } else
        {
            mVersion = (RecordSessionVersion)obj;
            mVideoData = (byte[])(byte[])objectinput.readObject();
        }
        mAudioData = new AudioArray(objectinput.readObject());
        mSegments.addAll((ArrayList)objectinput.readObject());
    }

    public void setAudioDataCount(int i)
    {
        if (SLog.sLogsOn && i != calculateAudioCount())
        {
            SLog.e("Audio Counts does not match: {} {}.", Integer.valueOf(i), Integer.valueOf(calculateAudioCount()));
        }
        mAudioDataCount = i;
    }

    public void setConfig(RecordConfigUtils.RecordConfig recordconfig)
    {
        mConfig = recordconfig;
    }

    public void setVideoDataCount(int i)
    {
        if (SLog.sLogsOn && i != calculateVideoCount())
        {
            SLog.e("Video Counts does not match: {} {}.", Integer.valueOf(i), Integer.valueOf(calculateVideoCount()));
        }
        mVideoDataCount = i;
    }

    public String toString()
    {
        return MessageFormatter.format("\nVideoData Count: {}, AudioData Count: {}, Segments: {}", Integer.valueOf(mVideoDataCount), Integer.valueOf(mAudioDataCount), Integer.valueOf(mSegments.size())).getMessage();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(mVersion);
        objectoutput.writeObject(mVideoData);
        objectoutput.writeObject(mAudioData.getData());
        objectoutput.writeObject(mSegments);
    }

}
