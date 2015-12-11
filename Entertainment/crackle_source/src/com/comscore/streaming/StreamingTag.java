// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.streaming;

import com.comscore.utils.Date;
import java.util.HashMap;

// Referenced classes of package com.comscore.streaming:
//            StreamSense, StreamSenseState, StreamSenseEventType, StreamSenseClip

public class StreamingTag
{

    private StreamSense a;
    private long b;
    private long c;
    private int d;
    private HashMap e;
    private boolean f;

    public StreamingTag()
    {
        d = 0;
        b = 0L;
        c = 0L;
        e = null;
        f = false;
        a = new StreamSense();
        a.setLabel("ns_st_it", "r");
    }

    private HashMap a(HashMap hashmap)
    {
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        if (!hashmap1.containsKey("ns_st_ci"))
        {
            hashmap1.put("ns_st_ci", "0");
        }
        if (!hashmap1.containsKey("c3"))
        {
            hashmap1.put("c3", "*null");
        }
        if (!hashmap1.containsKey("c4"))
        {
            hashmap1.put("c4", "*null");
        }
        if (!hashmap1.containsKey("c6"))
        {
            hashmap1.put("c6", "*null");
        }
        return hashmap1;
    }

    private void a(long l)
    {
        if (a.getState() != StreamSenseState.IDLE && a.getState() != StreamSenseState.PAUSED)
        {
            a.notify(StreamSenseEventType.END, b(l));
        } else
        if (a.getState() == StreamSenseState.PAUSED)
        {
            a.notify(StreamSenseEventType.END, c);
            return;
        }
    }

    private void a(long l, HashMap hashmap)
    {
        a(l);
        d = d + 1;
        HashMap hashmap1 = new HashMap();
        hashmap1.put("ns_st_cn", String.valueOf(d));
        hashmap1.put("ns_st_pn", "1");
        hashmap1.put("ns_st_ct", "vc");
        hashmap1.put("ns_st_tp", "0");
        a.setClip(hashmap1);
        a.getClip().setLabels(hashmap);
        e = hashmap;
        b = l;
        c = 0L;
        a.notify(StreamSenseEventType.PLAY, c);
    }

    private boolean a(String s, HashMap hashmap, HashMap hashmap1)
    {
        boolean flag1 = true;
        if (s != null)
        {
            boolean flag;
            if (hashmap != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (hashmap1 == null)
            {
                flag1 = false;
            }
            if (flag1 & flag)
            {
                hashmap = (String)hashmap.get(s);
                s = (String)hashmap1.get(s);
                if (hashmap != null && s != null)
                {
                    return hashmap.equals(s);
                }
            }
        }
        return false;
    }

    private long b(long l)
    {
        if (b > 0L && l >= b)
        {
            c = c + (l - b);
        } else
        {
            c = 0L;
        }
        return c;
    }

    private boolean b(HashMap hashmap)
    {
        return a("ns_st_ci", e, hashmap) && a("c3", e, hashmap) && a("c4", e, hashmap) && a("c6", e, hashmap);
    }

    public void playAdvertisement()
    {
        long l = Date.unixTime();
        a(l);
        d = d + 1;
        HashMap hashmap = a(((HashMap) (null)));
        hashmap.put("ns_st_cn", String.valueOf(d));
        hashmap.put("ns_st_pn", "1");
        hashmap.put("ns_st_ct", "va");
        hashmap.put("ns_st_tp", "1");
        hashmap.put("ns_st_ad", "1");
        a.setClip(hashmap);
        c = 0L;
        a.notify(StreamSenseEventType.PLAY, c);
        b = l;
        f = false;
    }

    public void playContentPart(HashMap hashmap)
    {
        long l;
        l = Date.unixTime();
        hashmap = a(hashmap);
        if (!f) goto _L2; else goto _L1
_L1:
        if (b(hashmap)) goto _L4; else goto _L3
_L3:
        a(l, hashmap);
_L6:
        f = true;
        return;
_L4:
        a.getClip().setLabels(hashmap);
        if (a.getState() != StreamSenseState.PLAYING)
        {
            b = l;
            a.notify(StreamSenseEventType.PLAY, c);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        a(l, hashmap);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void stop()
    {
        long l = Date.unixTime();
        a.notify(StreamSenseEventType.PAUSE, b(l));
    }
}
