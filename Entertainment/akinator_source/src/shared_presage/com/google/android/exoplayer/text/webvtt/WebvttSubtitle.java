// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.webvtt;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text.webvtt:
//            a

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
            a a1 = (a)list.get(i);
            int j = i * 2;
            cueTimesUs[j] = a1.a;
            cueTimesUs[j + 1] = a1.b;
        }

        sortedCueTimesUs = Arrays.copyOf(cueTimesUs, cueTimesUs.length);
        Arrays.sort(sortedCueTimesUs);
    }

    public final List getCues(long l)
    {
        Object obj1 = null;
        int i = 0;
        Object obj = null;
        ArrayList arraylist = null;
        while (i < numCues) 
        {
            if (cueTimesUs[i * 2] <= l && l < cueTimesUs[i * 2 + 1])
            {
                if (arraylist == null)
                {
                    arraylist = new ArrayList();
                }
                Object obj2 = (a)cues.get(i);
                if (((a) (obj2)).a())
                {
                    if (obj == null)
                    {
                        obj = obj1;
                        obj1 = obj2;
                    } else
                    if (obj1 == null)
                    {
                        obj1 = new SpannableStringBuilder();
                        ((SpannableStringBuilder) (obj1)).append(((a) (obj)).text).append("\n").append(((a) (obj2)).text);
                        obj2 = obj;
                        obj = obj1;
                        obj1 = obj2;
                    } else
                    {
                        ((SpannableStringBuilder) (obj1)).append("\n").append(((a) (obj2)).text);
                        obj2 = obj;
                        obj = obj1;
                        obj1 = obj2;
                    }
                } else
                {
                    arraylist.add(obj2);
                    obj2 = obj;
                    obj = obj1;
                    obj1 = obj2;
                }
            } else
            {
                Object obj3 = obj;
                obj = obj1;
                obj1 = obj3;
            }
            i++;
            obj2 = obj1;
            obj1 = obj;
            obj = obj2;
        }
        if (obj1 != null)
        {
            arraylist.add(new a(((CharSequence) (obj1))));
        } else
        if (obj != null)
        {
            arraylist.add(obj);
        }
        if (arraylist != null)
        {
            return arraylist;
        } else
        {
            return Collections.emptyList();
        }
    }

    public final long getEventTime(int i)
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

    public final int getEventTimeCount()
    {
        return sortedCueTimesUs.length;
    }

    public final long getLastEventTime()
    {
        if (getEventTimeCount() == 0)
        {
            return -1L;
        } else
        {
            return sortedCueTimesUs[sortedCueTimesUs.length - 1];
        }
    }

    public final int getNextEventTimeIndex(long l)
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

    public final long getStartTime()
    {
        return startTimeUs;
    }
}
