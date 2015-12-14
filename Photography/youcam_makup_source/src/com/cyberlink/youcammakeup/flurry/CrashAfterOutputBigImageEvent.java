// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class CrashAfterOutputBigImageEvent extends BaseEvent
{

    public CrashAfterOutputBigImageEvent(String s, String s1, String s2, String s3)
    {
        super("Crash Info After Output Big Image");
        String s4 = s;
        if (s == null)
        {
            s4 = "";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        s2 = s3;
        if (s3 == null)
        {
            s2 = "";
        }
        s3 = new HashMap();
        s3.put("Manufacturer", s4);
        s3.put("Brand", s);
        s3.put("Model", s1);
        s3.put("Ram", s2);
        s3.put("FullDesc", (new StringBuilder()).append("Manufacturer:").append(s4).append(", Brand:").append(s).append(", Model:").append(s1).append(", ram:").append(s2).toString());
        a(s3);
    }
}
