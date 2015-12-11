// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import java.util.Collections;
import java.util.List;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            AdaptationSet

public class Period
{

    public final List adaptationSets;
    public final long durationMs;
    public final String id;
    public final long startMs;

    public Period(String s, long l, long l1, List list)
    {
        id = s;
        startMs = l;
        durationMs = l1;
        adaptationSets = Collections.unmodifiableList(list);
    }

    public int getAdaptationSetIndex(int i)
    {
        int k = adaptationSets.size();
        for (int j = 0; j < k; j++)
        {
            if (((AdaptationSet)adaptationSets.get(j)).type == i)
            {
                return j;
            }
        }

        return -1;
    }
}
