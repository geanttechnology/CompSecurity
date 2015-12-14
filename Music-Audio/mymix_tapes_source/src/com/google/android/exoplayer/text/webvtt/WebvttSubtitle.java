// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text.webvtt:
//            WebvttCue

public final class WebvttSubtitle
    implements Subtitle
{

    private final long cueTimesUs[];
    private final List cues;
    private final int numCues;
    private final long sortedCueTimesUs[];
    private final long startTimeUs;

    public WebvttSubtitle(List list, long l)
    {
        cues = list;
        startTimeUs = l;
        numCues = list.size();
        cueTimesUs = new long[numCues * 2];
        for (int i = 0; i < numCues; i++)
        {
            WebvttCue webvttcue = (WebvttCue)list.get(i);
            int j = i * 2;
            cueTimesUs[j] = webvttcue.startTime;
            cueTimesUs[j + 1] = webvttcue.endTime;
        }

        sortedCueTimesUs = Arrays.copyOf(cueTimesUs, cueTimesUs.length);
        Arrays.sort(sortedCueTimesUs);
    }

    public List getCues(long l)
    {
        ArrayList arraylist1 = null;
        WebvttCue webvttcue = null;
        Object obj = null;
        int i = 0;
        while (i < numCues) 
        {
            WebvttCue webvttcue1 = webvttcue;
            ArrayList arraylist = arraylist1;
            Object obj1 = obj;
            if (cueTimesUs[i * 2] <= l)
            {
                webvttcue1 = webvttcue;
                arraylist = arraylist1;
                obj1 = obj;
                if (l < cueTimesUs[i * 2 + 1])
                {
                    arraylist = arraylist1;
                    if (arraylist1 == null)
                    {
                        arraylist = new ArrayList();
                    }
                    webvttcue1 = (WebvttCue)cues.get(i);
                    if (webvttcue1.isNormalCue())
                    {
                        if (webvttcue == null)
                        {
                            obj1 = obj;
                        } else
                        if (obj == null)
                        {
                            obj1 = new SpannableStringBuilder();
                            ((SpannableStringBuilder) (obj1)).append(webvttcue.text).append("\n").append(webvttcue1.text);
                            webvttcue1 = webvttcue;
                        } else
                        {
                            ((SpannableStringBuilder) (obj)).append("\n").append(webvttcue1.text);
                            webvttcue1 = webvttcue;
                            obj1 = obj;
                        }
                    } else
                    {
                        arraylist.add(webvttcue1);
                        webvttcue1 = webvttcue;
                        obj1 = obj;
                    }
                }
            }
            i++;
            webvttcue = webvttcue1;
            arraylist1 = arraylist;
            obj = obj1;
        }
        if (obj != null)
        {
            arraylist1.add(new WebvttCue(((CharSequence) (obj))));
        } else
        if (webvttcue != null)
        {
            arraylist1.add(webvttcue);
        }
        if (arraylist1 != null)
        {
            return arraylist1;
        } else
        {
            return Collections.emptyList();
        }
    }

    public long getEventTime(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i < sortedCueTimesUs.length)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return sortedCueTimesUs[i];
    }

    public int getEventTimeCount()
    {
        return sortedCueTimesUs.length;
    }

    public long getLastEventTime()
    {
        if (getEventTimeCount() == 0)
        {
            return -1L;
        } else
        {
            return sortedCueTimesUs[sortedCueTimesUs.length - 1];
        }
    }

    public int getNextEventTimeIndex(long l)
    {
        int i;
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        i = Util.binarySearchCeil(sortedCueTimesUs, l, false, false);
        if (i < sortedCueTimesUs.length)
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public long getStartTime()
    {
        return startTimeUs;
    }
}
