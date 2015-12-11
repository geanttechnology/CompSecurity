// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;

import com.flurry.sdk.e;
import java.util.Map;

// Referenced classes of package com.flurry.android.ads:
//            FlurryGender

public final class FlurryAdTargeting extends e
{

    public FlurryAdTargeting()
    {
    }

    public void clearAge()
    {
        super.clearAge();
    }

    public void clearGender()
    {
        super.clearGender();
    }

    public void clearKeywords()
    {
        super.clearKeywords();
    }

    public void clearLocation()
    {
        super.clearLocation();
    }

    public void clearUserCookies()
    {
        super.clearUserCookies();
    }

    public void setAge(int i)
    {
        super.setAge(i);
    }

    public void setEnableTestAds(boolean flag)
    {
        super.setEnableTestAds(flag);
    }

    public void setGender(FlurryGender flurrygender)
    {
        int i;
        if (flurrygender == null)
        {
            i = FlurryGender.UNKNOWN.ordinal();
        } else
        {
            i = flurrygender.ordinal();
        }
        super.setGender(i);
    }

    public void setKeywords(Map map)
    {
        super.setKeywords(map);
    }

    public void setLocation(float f, float f1)
    {
        super.setLocation(f, f1);
    }

    public void setUserCookies(Map map)
    {
        super.setUserCookies(map);
    }
}
