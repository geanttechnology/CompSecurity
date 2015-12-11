// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.collection;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.ansel.fetch.tools.collection:
//            MultiSkipListMap

class stFactory
    implements stFactory
{

    public List newList()
    {
        return new ArrayList(1);
    }

    stFactory()
    {
    }
}
