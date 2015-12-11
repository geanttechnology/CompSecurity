// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import co.vine.android.api.VinePrivateMessage;
import co.vine.android.client.AppController;
import co.vine.android.player.VideoViewInterface;
import com.edisonwang.android.slog.FormattingTuple;
import com.edisonwang.android.slog.MessageFormatter;
import com.edisonwang.android.slog.SLog;
import java.util.HashMap;

public class SeekInfoManager
{
    public static class SeekInfo
    {

        public final int durationPadded;
        public final int maxLoops;
        public long startTime;

        public int getLoopsLeft()
        {
            return maxLoops - (int)Math.floor((System.currentTimeMillis() - startTime) / (long)durationPadded);
        }

        public String getLoopsLeftForDisplay()
        {
            return String.valueOf(getLoopsLeft());
        }

        public int getSeekTime()
        {
            if (!isExpired())
            {
                return (int)(System.currentTimeMillis() - startTime) % durationPadded;
            } else
            {
                return -1;
            }
        }

        public boolean hasLoopLimit()
        {
            return this != SeekInfoManager.NO_LOOP_LIMIT;
        }

        public boolean isExpired()
        {
            return hasLoopLimit() && getLoopsLeft() <= 0;
        }

        public String toString()
        {
            return MessageFormatter.format("Start time: {}, durationPadded {}, maxLoops{}, loopsLeft {}.", new Object[] {
                Long.valueOf(startTime), Integer.valueOf(durationPadded), Integer.valueOf(maxLoops), Integer.valueOf(getLoopsLeft())
            }).getMessage();
        }

        public SeekInfo(long l, int i, int j)
        {
            startTime = l;
            durationPadded = i;
            maxLoops = j;
        }
    }


    public static final SeekInfo NO_LOOP_LIMIT = new SeekInfo(System.currentTimeMillis() * 2L, 7000, 0x7fffffff);
    private final AppController mAppController;
    private final HashMap mDurations = new HashMap();
    private final HashMap mSeekInfoMap = new HashMap();

    public SeekInfoManager(AppController appcontroller)
    {
        mAppController = appcontroller;
    }

    public SeekInfo get(long l)
    {
        return (SeekInfo)mSeekInfoMap.get(Long.valueOf(l));
    }

    public SeekInfo getSeekInfo(VideoViewInterface videoviewinterface, VinePrivateMessage vineprivatemessage)
    {
        Object obj;
label0:
        {
label1:
            {
label2:
                {
                    obj = (SeekInfo)mSeekInfoMap.get(Long.valueOf(vineprivatemessage.messageId));
                    if (obj != null)
                    {
                        break label0;
                    }
                    if (vineprivatemessage.localStartTime == 0L)
                    {
                        break label1;
                    }
                    Integer integer = (Integer)mDurations.get(Long.valueOf(vineprivatemessage.messageId));
                    obj = integer;
                    if (integer == null)
                    {
                        if (videoviewinterface == null)
                        {
                            break label2;
                        }
                        videoviewinterface = Integer.valueOf(videoviewinterface.getDuration());
                        obj = videoviewinterface;
                        if (videoviewinterface.intValue() != -1)
                        {
                            mDurations.put(Long.valueOf(vineprivatemessage.messageId), videoviewinterface);
                            obj = videoviewinterface;
                        }
                    }
                    int i;
                    if (((Integer) (obj)).intValue() <= 0)
                    {
                        i = 7000;
                    } else
                    {
                        i = ((Integer) (obj)).intValue() + 100;
                    }
                    videoviewinterface = new SeekInfo(vineprivatemessage.localStartTime, i, vineprivatemessage.maxLoops);
                    SLog.d("Adding SeekInfo: {}.", videoviewinterface);
                    mSeekInfoMap.put(Long.valueOf(vineprivatemessage.messageId), videoviewinterface);
                    return videoviewinterface;
                }
                throw new IllegalStateException("Duration cannot be determined.");
            }
            return null;
        }
        return ((SeekInfo) (obj));
    }

    public SeekInfo markAsRead(int i, VinePrivateMessage vineprivatemessage)
    {
        SeekInfo seekinfo;
        long l;
        if (i <= 0)
        {
            i = 7000;
        } else
        {
            i += 100;
        }
        l = System.currentTimeMillis();
        vineprivatemessage.localStartTime = l;
        seekinfo = new SeekInfo(l, i, vineprivatemessage.maxLoops);
        SLog.d("Adding SeekInfo: {}.", seekinfo);
        mSeekInfoMap.put(Long.valueOf(vineprivatemessage.messageId), seekinfo);
        SLog.e("Mark as read.");
        mAppController.markMessageLoopViewed(vineprivatemessage);
        return seekinfo;
    }

}
