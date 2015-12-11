// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

// Referenced classes of package com.amazon.dee.result.bif:
//            EntityResolutionResult

public class ResolvedEntities
{

    private final ImmutableMap mResolutionsPerAuthority;

    public ResolvedEntities(Map map)
    {
        mResolutionsPerAuthority = ImmutableMap.copyOf(map);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ResolvedEntities)
        {
            obj = (ResolvedEntities)obj;
            return Objects.equal(mResolutionsPerAuthority, ((ResolvedEntities) (obj)).mResolutionsPerAuthority);
        } else
        {
            return false;
        }
    }

    public EntityResolutionResult getEntityResolutionResult(String s)
    {
        return (EntityResolutionResult)mResolutionsPerAuthority.get(s);
    }

    public Map getResolutionsPerAuthority()
    {
        return mResolutionsPerAuthority;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mResolutionsPerAuthority
        });
    }

    public String toString()
    {
        return (new StringBuilder("[Resolutions per Authority=")).append(mResolutionsPerAuthority).append("]").toString();
    }
}
