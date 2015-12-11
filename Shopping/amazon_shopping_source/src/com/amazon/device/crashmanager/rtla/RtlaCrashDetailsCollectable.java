// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.rtla;

import com.amazon.device.crashmanager.CrashDetailsCollectable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager.rtla:
//            RtlaCrashDetails

public class RtlaCrashDetailsCollectable
    implements CrashDetailsCollectable
{

    private final RtlaCrashDetails mRtlaCrashDetails;

    public RtlaCrashDetailsCollectable(RtlaCrashDetails rtlacrashdetails)
    {
        validateCrashDetails(rtlacrashdetails);
        mRtlaCrashDetails = rtlacrashdetails;
    }

    private String defaultOnNull(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    private String formatWebLabs(List list)
    {
        if (list == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (list = list.iterator(); list.hasNext(); stringbuilder.append((String)list.next()).append(" ")) { }
        return stringbuilder.toString().trim();
    }

    private void validateCrashDetails(RtlaCrashDetails rtlacrashdetails)
    {
        if (rtlacrashdetails == null)
        {
            throw new IllegalArgumentException("RtlaCrashDetails must not be null.");
        } else
        {
            return;
        }
    }

    public Map collect(Throwable throwable)
    {
        throwable = mRtlaCrashDetails.getSessionId();
        String s = mRtlaCrashDetails.getUserAgent();
        String s1 = mRtlaCrashDetails.getPageType();
        String s2 = mRtlaCrashDetails.getSubPageType();
        LinkedList linkedlist = new LinkedList();
        if (mRtlaCrashDetails.getActiveWebLabs() != null)
        {
            linkedlist.addAll(mRtlaCrashDetails.getActiveWebLabs());
        }
        HashMap hashmap = new HashMap();
        hashmap.put("RtlaSessionId", defaultOnNull(throwable, "000-0000000-0000000"));
        if (s != null)
        {
            hashmap.put("RtlaUserAgent", s);
        }
        if (s1 != null)
        {
            hashmap.put("RtlaPageType", s1);
        }
        if (s2 != null)
        {
            hashmap.put("RtlaSubPageType", s2);
        }
        if (linkedlist != null && linkedlist.size() > 0)
        {
            hashmap.put("RtlaWebLabs", formatWebLabs(linkedlist));
        }
        return hashmap;
    }
}
