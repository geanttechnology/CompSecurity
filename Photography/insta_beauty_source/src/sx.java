// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

public class sx
{

    public static void a(String s, String s1)
    {
        String s2 = "Chinese";
        if (!yp.b())
        {
            s2 = "English";
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s2, s1);
        FlurryAgent.logEvent(s, hashmap);
    }

    public static void a(String s, Map map)
    {
        FlurryAgent.logEvent(s, map);
    }
}
