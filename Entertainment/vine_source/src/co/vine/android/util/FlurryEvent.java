// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import com.flurry.android.FlurryAgent;
import java.util.HashMap;

public class FlurryEvent
{

    private final String mEventName;
    public HashMap mInfo;

    public FlurryEvent(String s)
    {
        mEventName = s;
    }

    public static void log(String s)
    {
        FlurryAgent.logEvent(s);
    }

    public static void log(String s, String s1, Object obj)
    {
        (new FlurryEvent(s)).add(s1, obj).log();
    }

    public static void log(String s, String s1, Object obj, String s2, Object obj1)
    {
        (new FlurryEvent(s)).add(s1, obj).add(s2, obj1).log();
    }

    public FlurryEvent add(String s, Object obj)
    {
        if (mInfo == null)
        {
            mInfo = new HashMap();
        }
        mInfo.put(s, String.valueOf(obj));
        return this;
    }

    public void log()
    {
        if (mInfo != null)
        {
            FlurryAgent.logEvent(mEventName, mInfo);
            return;
        } else
        {
            FlurryAgent.logEvent(mEventName);
            return;
        }
    }
}
