// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.profile;

import com.amazon.insights.UserProfile;
import com.amazon.insights.core.util.StringUtil;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultUserProfile
    implements UserProfile, Comparable
{

    private final Map dimensions = new ConcurrentHashMap();

    public DefaultUserProfile()
    {
    }

    public UserProfile addDimensionAsString(String s, String s1)
    {
        if (!StringUtil.isBlank(s))
        {
            dimensions.put(s, s1);
        }
        return this;
    }

    public int compareTo(DefaultUserProfile defaultuserprofile)
    {
        if (defaultuserprofile != null) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (defaultuserprofile == this)
        {
            return 0;
        }
        defaultuserprofile = defaultuserprofile.dimensions;
        if (dimensions == defaultuserprofile)
        {
            break; /* Loop/switch isn't completed */
        }
        if (dimensions == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (defaultuserprofile == null)
        {
            return 1;
        }
        if (dimensions.equals(defaultuserprofile))
        {
            break; /* Loop/switch isn't completed */
        }
        int i = dimensions.hashCode();
        int j = defaultuserprofile.hashCode();
        if (i < j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i > j)
        {
            return 1;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((DefaultUserProfile)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof UserProfile)
            {
                if (compareTo((DefaultUserProfile)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public Map getDimensions()
    {
        return Collections.unmodifiableMap(dimensions);
    }

    public int hashCode()
    {
        int i;
        if (dimensions == null)
        {
            i = 0;
        } else
        {
            i = dimensions.hashCode();
        }
        return 1 + i;
    }
}
