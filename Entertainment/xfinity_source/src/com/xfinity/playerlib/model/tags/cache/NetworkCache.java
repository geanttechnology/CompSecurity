// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.cache;

import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.tags.cache:
//            TagsCache

public class NetworkCache extends TagsCache
{

    protected List getList(TagsRoot tagsroot)
    {
        return tagsroot.getNetworks();
    }
}
