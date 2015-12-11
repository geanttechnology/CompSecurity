// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models;

import java.util.List;

// Referenced classes of package com.rdio.android.api.models:
//            ApiModel

public abstract class BaseStation extends ApiModel
{
    public static class Restrictions
    {

        public int secondsUntilSkipsReset;
        public int skips;

        public Restrictions()
        {
        }
    }

    public static class StationPreset
    {

        public boolean enabled;
        public String name;

        public StationPreset()
        {
        }
    }


    public List availablePresets;
    public Restrictions restrictions;

    public BaseStation()
    {
    }
}
