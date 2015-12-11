// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import java.util.LinkedHashMap;

// Referenced classes of package com.xfinity.playerlib.model:
//            EditorialProgram, MerlinId

public class EditorialMovie extends EditorialProgram
{

    public EditorialMovie()
    {
    }

    public MerlinId.Namespace getMerlinIdNamespace()
    {
        return MerlinId.Namespace.Movie;
    }

    public boolean isMovie()
    {
        return true;
    }

    public void parse(LinkedHashMap linkedhashmap)
    {
        String s = (String)linkedhashmap.get("entityMerlinId");
        String s1 = (String)linkedhashmap.get("entityType");
        String s2 = (String)linkedhashmap.get("name");
        String s3 = (String)linkedhashmap.get("videoBrand");
        setProviderCode((String)linkedhashmap.get("videoProviderCode"));
        setTitle(s2);
        setMerlinId(new MerlinId(MerlinId.Namespace.valueOf(s1), Long.valueOf(s)));
        setBrand(s3);
    }
}
