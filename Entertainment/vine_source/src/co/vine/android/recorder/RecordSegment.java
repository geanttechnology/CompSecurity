// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.edisonwang.android.slog.SLog;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.recorder:
//            VideoData, AudioData, RecordSession, RecordSessionVersion, 
//            AudioArray, RecordConfigUtils, CameraSetting

public class RecordSegment
    implements Externalizable
{

    private static final long serialVersionUID = 0x62d905fb96c6389cL;
    public Drawable drawable;
    public int index;
    private ArrayList mAudioData;
    private CameraSetting mSetting;
    private String mThumbnailPath;
    private ArrayList mVideoData;
    public boolean removed;
    public long startTimestamp;
    public String videoPath;

    public RecordSegment()
    {
    }

    public RecordSegment(long l)
    {
        mVideoData = new ArrayList();
        mAudioData = new ArrayList();
        mThumbnailPath = "";
        startTimestamp = l;
    }

    public RecordSegment(RecordSegment recordsegment)
    {
        mSetting = recordsegment.mSetting;
        mThumbnailPath = recordsegment.mThumbnailPath;
        removed = recordsegment.removed;
        index = recordsegment.index;
        drawable = recordsegment.drawable;
        videoPath = recordsegment.videoPath;
        startTimestamp = recordsegment.startTimestamp;
        mVideoData = new ArrayList();
        VideoData videodata;
        for (Iterator iterator = recordsegment.mVideoData.iterator(); iterator.hasNext(); mVideoData.add(new VideoData(videodata)))
        {
            videodata = (VideoData)iterator.next();
        }

        mAudioData = new ArrayList();
        AudioData audiodata;
        for (recordsegment = recordsegment.mAudioData.iterator(); recordsegment.hasNext(); mAudioData.add(new AudioData(audiodata)))
        {
            audiodata = (AudioData)recordsegment.next();
        }

    }

    public static ArrayList applyEditedChanges(RecordSession recordsession, ArrayList arraylist)
    {
        return applyEditedChanges(recordsession, recordsession.getSegments(), null, null, arraylist);
    }

    private static ArrayList applyEditedChanges(RecordSession recordsession, ArrayList arraylist, byte abyte0[], AudioArray audioarray, ArrayList arraylist1)
    {
        ArrayList arraylist2;
        ArrayList arraylist3;
        boolean flag;
        if (abyte0 == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SLog.i("Apply changes, on source: {}.", Boolean.valueOf(flag));
        arraylist2 = new ArrayList();
        arraylist3 = new ArrayList();
        if (arraylist1 != null)
        {
            byte abyte1[] = recordsession.getVideoData();
            AudioArray audioarray1 = recordsession.getAudioData();
            if (flag)
            {
                abyte0 = new byte[abyte1.length];
            }
            ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0);
            if (recordsession.getVersion().getAudioArrayType() == AudioArray.AudioArrayType.SHORT)
            {
                int i;
                if (flag)
                {
                    abyte0 = new short[audioarray1.length];
                } else
                {
                    abyte0 = audioarray.getDataShort();
                }
                abyte0 = ShortBuffer.wrap(abyte0);
            } else
            {
                if (flag)
                {
                    abyte0 = new byte[audioarray1.length];
                } else
                {
                    abyte0 = audioarray.getDataByte();
                }
                abyte0 = ByteBuffer.wrap(abyte0);
            }
            if (flag)
            {
                for (i = 0; i < arraylist.size(); i++)
                {
                    ((RecordSegment)arraylist.get(i)).index = i;
                }

            }
            int j = 0;
            long l1 = -1L;
            for (Iterator iterator = arraylist1.iterator(); iterator.hasNext();)
            {
                Object obj = (RecordSegment)iterator.next();
                if (!((RecordSegment) (obj)).removed)
                {
                    Object obj1;
                    long l2;
                    long l3;
                    long l4;
                    if (flag)
                    {
                        audioarray = ((AudioArray) (obj));
                    } else
                    {
                        audioarray = new RecordSegment(((RecordSegment) (obj)));
                    }
                    arraylist2.add(audioarray);
                    SLog.d("Adding segment: {}.", Integer.valueOf(((RecordSegment) (obj)).index));
                    obj1 = audioarray.getCombinedAudioData();
                    obj = audioarray.getVideoData();
                    l4 = -1L;
                    l3 = 0L;
                    audioarray1.putInto(abyte0, ((AudioData) (obj1)).start, ((AudioData) (obj1)).size);
                    SLog.d("Audio Buffers from {} with size {}.", Integer.valueOf(((AudioData) (obj1)).start), Integer.valueOf(((AudioData) (obj1)).size));
                    obj1.start = j;
                    j += ((AudioData) (obj1)).size;
                    obj1 = ((ArrayList) (obj)).iterator();
                    l2 = l1;
                    l1 = l4;
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break;
                        }
                        VideoData videodata = (VideoData)((Iterator) (obj1)).next();
                        if (videodata.size >= 0)
                        {
                            int k = videodata.start;
                            if (l1 == -1L)
                            {
                                l1 = videodata.timestamp;
                                if (l2 == -1L)
                                {
                                    l2 = 0L;
                                    videodata.timestamp = 0L;
                                } else
                                {
                                    videodata.timestamp = l2;
                                }
                            } else
                            {
                                long l5 = videodata.timestamp;
                                videodata.timestamp = (videodata.timestamp - l1) + l3;
                                l1 = l5;
                            }
                            SLog.d("Modifying timestamp from {} to {}.", Long.valueOf(l1), Long.valueOf(videodata.timestamp));
                            l3 = videodata.timestamp;
                            videodata.start = bytebuffer.position();
                            bytebuffer.put(abyte1, k, videodata.size);
                        }
                    } while (true);
                    l1 = Math.max(RecordConfigUtils.getTimeStampInNsFromSampleCounted(j), (((ArrayList) (obj)).size() * 0xf4240) / audioarray.getCameraSetting().frameRate) - 0xf4240 / audioarray.getCameraSetting().frameRate;
                    SLog.d("Next timestamp: {}", Long.valueOf(l1));
                } else
                {
                    arraylist3.add(obj);
                }
            }

            j = abyte0.position();
            int l = bytebuffer.position();
            SLog.d("Buffer limits: {}, {}.", Integer.valueOf(j), Integer.valueOf(l));
            if (flag)
            {
                bytebuffer.position(0);
                bytebuffer.get(abyte1);
                abyte0.position(0);
                audioarray1.getFrom(abyte0);
                recordsession.setAudioDataCount(j);
                recordsession.setVideoDataCount(l);
            }
            arraylist1.removeAll(arraylist3);
            if (arraylist != null)
            {
                arraylist.clear();
                arraylist.addAll(arraylist1);
            }
        }
        if (flag)
        {
            return arraylist3;
        } else
        {
            return arraylist2;
        }
    }

    public static ArrayList applyForEditedChanges(RecordSession recordsession, byte abyte0[], AudioArray audioarray, ArrayList arraylist)
    {
        return applyEditedChanges(recordsession, null, abyte0, audioarray, arraylist);
    }

    public void addAudioData(AudioData audiodata)
    {
        mAudioData.add(audiodata);
    }

    public CameraSetting getCameraSetting()
    {
        return mSetting;
    }

    public AudioData getCombinedAudioData()
    {
        if (mAudioData.size() == 0)
        {
            return new AudioData(0, 0);
        }
        if (mAudioData.size() > 1)
        {
            int i = 0;
            for (Iterator iterator = mAudioData.iterator(); iterator.hasNext();)
            {
                i += ((AudioData)iterator.next()).size;
            }

            AudioData audiodata = new AudioData(((AudioData)mAudioData.get(0)).start, i);
            mAudioData.clear();
            mAudioData.add(audiodata);
        }
        return (AudioData)mAudioData.get(0);
    }

    public Drawable getDrawableCopy(Context context)
    {
        if (drawable != null)
        {
            return new BitmapDrawable(context.getResources(), ((BitmapDrawable)drawable).getBitmap());
        } else
        {
            BitmapDrawable bitmapdrawable = new BitmapDrawable(context.getResources(), getThumbnailPath());
            drawable = new BitmapDrawable(context.getResources(), bitmapdrawable.getBitmap());
            return bitmapdrawable;
        }
    }

    public String getThumbnailPath()
    {
        return mThumbnailPath;
    }

    public ArrayList getVideoData()
    {
        return mVideoData;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        mSetting = (CameraSetting)objectinput.readObject();
        mThumbnailPath = (String)objectinput.readObject();
        mVideoData = (ArrayList)objectinput.readObject();
        mAudioData = new ArrayList();
        mAudioData.add((AudioData)objectinput.readObject());
    }

    public RecordSegment setCameraSetting(CameraSetting camerasetting)
    {
        mSetting = camerasetting;
        return this;
    }

    public void setThumbnailPath(String s)
    {
        mThumbnailPath = s;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(mSetting);
        objectoutput.writeObject(mThumbnailPath);
        objectoutput.writeObject(mVideoData);
        objectoutput.writeObject(getCombinedAudioData());
    }
}
