// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public class TimeLogger
{

    private String bg;
    private String bh;
    private boolean bi;
    ArrayList bj;
    ArrayList bk;

    public TimeLogger(String s, String s1)
    {
        reset(s, s1);
    }

    public void addSplit(String s)
    {
        if (bi)
        {
            return;
        } else
        {
            long l = SystemClock.elapsedRealtime();
            bj.add(Long.valueOf(l));
            bk.add(s);
            return;
        }
    }

    public void dumpToLog()
    {
        if (bi)
        {
            return;
        }
        Log.d(bg, (new StringBuilder()).append(bh).append(": begin").toString());
        long l1 = ((Long)bj.get(0)).longValue();
        int i = 1;
        long l = l1;
        for (; i < bj.size(); i++)
        {
            l = ((Long)bj.get(i)).longValue();
            String s = (String)bk.get(i);
            long l2 = ((Long)bj.get(i - 1)).longValue();
            Log.d(bg, (new StringBuilder()).append(bh).append(":      ").append(l - l2).append(" ms, ").append(s).toString());
        }

        Log.d(bg, (new StringBuilder()).append(bh).append(": end, ").append(l - l1).append(" ms").toString());
    }

    public void reset()
    {
        bi = false;
        if (bi)
        {
            return;
        }
        if (bj == null)
        {
            bj = new ArrayList();
            bk = new ArrayList();
        } else
        {
            bj.clear();
            bk.clear();
        }
        addSplit(null);
    }

    public void reset(String s, String s1)
    {
        bg = s;
        bh = s1;
        reset();
    }
}
