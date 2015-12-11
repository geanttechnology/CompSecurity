// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import android.os.Build;
import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseEventType;
import com.gotv.crackle.Application;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.model.MediaDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle.util:
//            Log

public class ComscoreTracker
{
    private static final class EventType extends Enum
    {

        private static final EventType $VALUES[];
        public static final EventType Buffer;
        public static final EventType End;
        public static final EventType Pause;
        public static final EventType Play;

        public static EventType valueOf(String s)
        {
            return (EventType)Enum.valueOf(com/gotv/crackle/util/ComscoreTracker$EventType, s);
        }

        public static EventType[] values()
        {
            return (EventType[])$VALUES.clone();
        }

        static 
        {
            Buffer = new EventType("Buffer", 0);
            Play = new EventType("Play", 1);
            Pause = new EventType("Pause", 2);
            End = new EventType("End", 3);
            $VALUES = (new EventType[] {
                Buffer, Play, Pause, End
            });
        }

        private EventType(String s, int i)
        {
            super(s, i);
        }
    }


    private static StreamSense sStreamSense;
    private String TAG;
    private IAdContext mAdContext;
    private double mCurrentAdDuration;
    private boolean mCurrentClipIsMediaItem;
    private double mLastAdPausePosition;
    private EventType mLastEvent;
    private MediaDetailsItem mMediaItem;
    private String mMediaItemURL;
    private int mPartNumberOfMediaItem;
    private List mSlotsMidroll;
    private List mSlotsPostroll;
    private List mSlotsPreroll;
    private double mTimeRecentlyObserved;
    private int mTotalParts;

    public ComscoreTracker(MediaDetailsItem mediadetailsitem, String s, IAdContext iadcontext)
    {
        TAG = "ComscoreTracker";
        mMediaItem = mediadetailsitem;
        mMediaItemURL = s;
        mPartNumberOfMediaItem = 1;
        mAdContext = iadcontext;
        Log.d(TAG, "comscore setPlaylist");
        sStreamSense.setPlaylist(null);
    }

    private IAdInstance findAdInstance(String s, int i)
    {
label0:
        {
            s = mAdContext.getSlotByCustomId(s);
            if (s == null)
            {
                break label0;
            }
            s = s.getAdInstances().iterator();
            IAdInstance iadinstance;
            do
            {
                if (!s.hasNext())
                {
                    break label0;
                }
                iadinstance = (IAdInstance)s.next();
            } while (iadinstance.getAdId() != i);
            return iadinstance;
        }
        return null;
    }

    private String getCrackleHostName()
    {
        String s = Application.getInstance().getLocalization().getCurrentCountryCode().toLowerCase();
        if (s.equals("us"))
        {
            return "crackle.com";
        } else
        {
            return (new StringBuilder()).append("crackle.com.").append(s).toString();
        }
    }

    private String hashmapToString(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(");
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); stringbuilder.append(String.format(" %s: %s", new Object[] {
    (String)entry.getKey(), (String)entry.getValue()
})))
        {
            entry = (java.util.Map.Entry)hashmap.next();
        }

        stringbuilder.append(" )");
        return stringbuilder.toString();
    }

    public static void initialize()
    {
        sStreamSense = new StreamSense();
    }

    private void setClipToAdInstance(IAdInstance iadinstance)
    {
        int i = 1;
        boolean flag1 = true;
        Iterator iterator = mSlotsPreroll.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Iterator iterator1 = ((ISlot)iterator.next()).getAdInstances().iterator();
            int j = i;
            do
            {
                i = j;
                if (!iterator1.hasNext())
                {
                    break;
                }
                if ((IAdInstance)iterator1.next() == iadinstance)
                {
                    mPartNumberOfMediaItem = 1;
                    setClipToAdInstance(iadinstance, j, 1, true, false, false);
                    return;
                }
                j++;
            } while (true);
        } while (true);
        if (iadinstance == null)
        {
            setClipToAdInstance(null, i, mPartNumberOfMediaItem, false, false, false);
            return;
        }
        i++;
        boolean flag = true;
        iterator = mSlotsMidroll.iterator();
        int k = ((flag1) ? 1 : 0);
        while (iterator.hasNext()) 
        {
            for (Iterator iterator2 = ((ISlot)iterator.next()).getAdInstances().iterator(); iterator2.hasNext();)
            {
                if ((IAdInstance)iterator2.next() == iadinstance)
                {
                    mPartNumberOfMediaItem = k + 1;
                    setClipToAdInstance(iadinstance, i, k, false, true, false);
                    return;
                }
                i++;
            }

            if (flag)
            {
                flag = false;
            } else
            {
                k++;
            }
        }
        mPartNumberOfMediaItem = k;
        iterator = mSlotsPostroll.iterator();
        do
        {
label0:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                Iterator iterator3 = ((ISlot)iterator.next()).getAdInstances().iterator();
                int l = i;
                do
                {
                    i = l;
                    if (!iterator3.hasNext())
                    {
                        break;
                    }
                    if ((IAdInstance)iterator3.next() == iadinstance)
                    {
                        setClipToAdInstance(iadinstance, l, k, false, false, true);
                        return;
                    }
                    l++;
                } while (true);
            }
        } while (true);
        Log.w(TAG, "Could not find the ad instance!");
        return;
    }

    private void setClipToAdInstance(IAdInstance iadinstance, int i, int j, boolean flag, boolean flag1, boolean flag2)
    {
        String s = getCrackleHostName();
        double d;
        String s1;
        String s2;
        String s3;
        String s4;
        HashMap hashmap;
        int k;
        if (iadinstance != null)
        {
            s1 = null;
        } else
        {
            s1 = mMediaItemURL;
        }
        s4 = mMediaItem.getID();
        if (iadinstance != null)
        {
            d = iadinstance.getActiveCreativeRendition().getDuration();
        } else
        {
            d = Integer.parseInt(mMediaItem.getDurationInSeconds());
        }
        k = (int)(d * 1000D);
        s3 = mMediaItem.getEpisodeFancy();
        s2 = mMediaItem.getParentChannelName();
        hashmap = new HashMap();
        hashmap.put("c3", s);
        hashmap.put("c4", "crackle");
        hashmap.put("c6", "*null");
        if (iadinstance != null)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        hashmap.put("ns_st_ad", s);
        if (s4 != null)
        {
            s = s4;
        } else
        {
            s = "";
        }
        hashmap.put("ns_st_ci", s);
        hashmap.put("ns_st_cl", String.format("%d", new Object[] {
            Integer.valueOf(k)
        }));
        hashmap.put("ns_st_cn", String.format("%d", new Object[] {
            Integer.valueOf(i)
        }));
        if (flag)
        {
            s = "va11";
        } else
        if (flag1)
        {
            s = "va12";
        } else
        if (flag2)
        {
            s = "va13";
        } else
        {
            s = "vc12";
        }
        hashmap.put("ns_st_ct", s);
        if (s1 == null || s1.length() <= 0)
        {
            s1 = "none";
        }
        hashmap.put("ns_st_cu", s1);
        if (s3 != null)
        {
            s = s3;
        } else
        {
            s = "";
        }
        hashmap.put("ns_st_ep", s);
        hashmap.put("ns_st_ge", mMediaItem.getGenre());
        hashmap.put("ns_st_pn", String.format("%d", new Object[] {
            Integer.valueOf(j)
        }));
        if (s2 != null)
        {
            s = s2;
        } else
        {
            s = "";
        }
        hashmap.put("ns_st_pr", s);
        hashmap.put("ns_st_pu", "crackle");
        hashmap.put("ns_st_tp", String.format("%d", new Object[] {
            Integer.valueOf(mTotalParts)
        }));
        hashmap.put("ns_ap_pn", "android");
        hashmap.put("ns_ap_device", Build.DEVICE);
        if (mCurrentClipIsMediaItem && iadinstance == null)
        {
            trackPlay();
        } else
        {
            trackEnd();
            Log.d(TAG, (new StringBuilder()).append("comscore setclip: ").append(hashmapToString(hashmap)).toString());
            sStreamSense.setClip(hashmap);
            if (iadinstance != null)
            {
                trackPlay(0L);
            } else
            {
                trackPlay();
            }
        }
        if (iadinstance != null)
        {
            mCurrentAdDuration = k;
        }
        if (iadinstance == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mCurrentClipIsMediaItem = flag;
        mLastAdPausePosition = 0.0D;
    }

    private void trackAdPause(ISlot islot)
    {
        double d = islot.getPlayheadTime();
        islot = islot.getAdInstances().iterator();
        do
        {
            double d1;
label0:
            {
                if (islot.hasNext())
                {
                    d1 = ((IAdInstance)islot.next()).getActiveCreativeRendition().getDuration();
                    if (d >= d1)
                    {
                        break label0;
                    }
                }
                mLastAdPausePosition = 1000D * d;
                trackPause((long)mLastAdPausePosition);
                return;
            }
            d -= d1;
        } while (true);
    }

    private void trackEnd(long l)
    {
        if (mLastEvent != EventType.End)
        {
            Log.d(TAG, (new StringBuilder()).append("comscore trackEnd: ").append(l).append("ms").toString());
            sStreamSense.notify(StreamSenseEventType.END, l);
            mLastEvent = EventType.End;
        }
    }

    private void trackPause(long l)
    {
        if (mLastEvent != EventType.Pause)
        {
            Log.d(TAG, (new StringBuilder()).append("comscore trackPause: ").append(l).append("ms").toString());
            sStreamSense.notify(StreamSenseEventType.PAUSE, l);
            mLastEvent = EventType.Pause;
        }
    }

    private void trackPlay(long l)
    {
        if (mLastEvent != EventType.Play)
        {
            Log.d(TAG, (new StringBuilder()).append("comscore trackPlay: ").append(l).append("ms").toString());
            sStreamSense.notify(StreamSenseEventType.PLAY, l);
            mLastEvent = EventType.Play;
        }
    }

    public void setClipToAdInstance(String s, int i)
    {
        s = findAdInstance(s, i);
        if (s != null)
        {
            setClipToAdInstance(((IAdInstance) (s)));
        }
    }

    public void setClipToMediaItem()
    {
        setClipToAdInstance(null);
    }

    public void setSlots(List list, List list1, List list2)
    {
        mSlotsPreroll = list;
        mSlotsMidroll = list1;
        mSlotsPostroll = list2;
        int i;
        if (list1 == null)
        {
            i = 1;
        } else
        {
            i = list1.size() + 1;
        }
        mTotalParts = i;
    }

    public void setTimeRecentlyObserved(double d)
    {
        mTimeRecentlyObserved = d;
    }

    public void trackAdResume()
    {
        trackPlay((long)mLastAdPausePosition);
        mLastAdPausePosition = 0.0D;
    }

    public void trackBuffer()
    {
    }

    public void trackEnd()
    {
        if (!mCurrentClipIsMediaItem)
        {
            if (mLastEvent == EventType.Pause && mLastAdPausePosition > 0.0D)
            {
                trackEnd((long)mLastAdPausePosition);
                return;
            } else
            {
                trackEnd((long)mCurrentAdDuration);
                return;
            }
        } else
        {
            trackEnd((long)mTimeRecentlyObserved);
            return;
        }
    }

    public void trackPause()
    {
        trackPause(((ISlot) (null)));
    }

    public void trackPause(ISlot islot)
    {
        if (mCurrentClipIsMediaItem || islot == null)
        {
            trackPause((long)mTimeRecentlyObserved);
            return;
        } else
        {
            trackAdPause(islot);
            return;
        }
    }

    public void trackPlay()
    {
        trackPlay((long)mTimeRecentlyObserved);
    }
}
