// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            b, af

private static final class a
{

    private final  a;

    public final boolean a()
    {
        if (!a...b)
        {
            return false;
        }
        if (a..containsKey("enableVideoAds"))
        {
            String s = (String)a..remove("enableVideoAds");
            a..put("enableVideoAds", s);
            return Boolean.parseBoolean(s);
        }
        if (a..containsKey("enableVideoAds"))
        {
            return Boolean.parseBoolean((String)a..get("enableVideoAds"));
        } else
        {
            return a...g;
        }
    }

    public ( )
    {
        a = ;
    }
}
