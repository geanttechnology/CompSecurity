// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.xfinity.playerlib.model.MerlinId;
import java.io.Serializable;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            Watchable, VideoFacade

public class WatchableKey
    implements Serializable
{

    private final MerlinId parentMerlinId;
    private final long videoId;

    public WatchableKey(MerlinId merlinid, long l)
    {
        parentMerlinId = merlinid;
        videoId = l;
    }

    public WatchableKey(Watchable watchable, VideoFacade videofacade)
    {
        parentMerlinId = watchable.getParentMerlinIdIfApplicable();
        videoId = videofacade.getVideoId();
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (WatchableKey)obj;
        if (videoId != ((WatchableKey) (obj)).videoId)
        {
            break; /* Loop/switch isn't completed */
        }
        if (parentMerlinId == null) goto _L4; else goto _L3
_L3:
        if (parentMerlinId.equals(((WatchableKey) (obj)).parentMerlinId)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((WatchableKey) (obj)).parentMerlinId == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public MerlinId getParentMerlinId()
    {
        return parentMerlinId;
    }

    public long getVideoId()
    {
        return videoId;
    }

    public int hashCode()
    {
        int i;
        if (parentMerlinId != null)
        {
            i = parentMerlinId.hashCode();
        } else
        {
            i = 0;
        }
        return i * 31 + (int)(videoId ^ videoId >>> 32);
    }

    public boolean isMovie()
    {
        return parentMerlinId.getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie);
    }
}
