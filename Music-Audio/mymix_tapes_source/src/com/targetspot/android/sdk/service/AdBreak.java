// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdSegment

public class AdBreak
{
    public static class SegmentPosition
    {

        public int beginning;
        public int position;
        public AdSegment segment;

        public SegmentPosition()
        {
            segment = null;
            beginning = 0;
            position = 0;
        }
    }


    int duration;
    List segments;
    String todRequest;
    int validHour[];

    public AdBreak(int i, int ai[])
    {
        segments = new ArrayList();
        todRequest = "";
        duration = i;
        validHour = ai;
    }

    public void addSegment(AdSegment adsegment)
    {
        int i = -1;
        do
        {
            int j = i + 1;
            if (j < segments.size())
            {
                i = j;
                if (((AdSegment)segments.get(j)).getOrder() > adsegment.getOrder())
                {
                    segments.add(j, adsegment);
                    return;
                }
            } else
            {
                segments.add(adsegment);
                return;
            }
        } while (true);
    }

    public int getDuration()
    {
        return duration;
    }

    public int getPosition(AdSegment adsegment, int i)
    {
        int j = 0;
        for (Iterator iterator = segments.iterator(); iterator.hasNext();)
        {
            AdSegment adsegment1 = (AdSegment)iterator.next();
            if (adsegment1 == adsegment)
            {
                return j + i;
            }
            j += adsegment1.getDurationMillis();
        }

        return 0;
    }

    public boolean getSegment(int i, SegmentPosition segmentposition)
    {
        int j = 0;
        for (Iterator iterator = segments.iterator(); iterator.hasNext();)
        {
            AdSegment adsegment = (AdSegment)iterator.next();
            if (i < adsegment.getDurationMillis() + j)
            {
                segmentposition.segment = adsegment;
                segmentposition.beginning = j;
                segmentposition.position = i - j;
                return true;
            }
            j += adsegment.getDurationMillis();
        }

        return false;
    }

    public List getSegments()
    {
        return segments;
    }

    public String getTOD()
    {
        return todRequest;
    }

    public int[] getValidHour()
    {
        return validHour;
    }

    public boolean nextSegment(SegmentPosition segmentposition)
    {
        boolean flag2 = false;
        boolean flag = false;
        int i = 0;
        Iterator iterator = segments.iterator();
        do
        {
            AdSegment adsegment;
label0:
            {
                boolean flag1 = flag2;
                if (iterator.hasNext())
                {
                    adsegment = (AdSegment)iterator.next();
                    if (!flag)
                    {
                        break label0;
                    }
                    segmentposition.segment = adsegment;
                    segmentposition.beginning = i;
                    segmentposition.position = 0;
                    flag1 = true;
                }
                return flag1;
            }
            int j = i + adsegment.getDurationMillis();
            i = j;
            if (adsegment == segmentposition.segment)
            {
                flag = true;
                i = j;
            }
        } while (true);
    }

    protected void setTOD(String s)
    {
        todRequest = s;
    }
}
