// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Map;

// Referenced classes of package com.parse:
//            ParseDecoder, ParseObject

class KnownParseObjectDecoder extends ParseDecoder
{

    private Map fetchedObjects;

    public KnownParseObjectDecoder(Map map)
    {
        fetchedObjects = map;
    }

    protected ParseObject decodePointer(String s, String s1)
    {
        if (fetchedObjects != null && fetchedObjects.containsKey(s1))
        {
            return (ParseObject)fetchedObjects.get(s1);
        } else
        {
            return super.decodePointer(s, s1);
        }
    }
}
