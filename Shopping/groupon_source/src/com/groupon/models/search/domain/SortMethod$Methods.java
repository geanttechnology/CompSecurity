// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.models.search.domain:
//            SortMethod

public static class _cls9
{

    public static final SortMethod DISTANCE;
    public static final SortMethod PRICE_ASC;
    public static final SortMethod PRICE_DESC;
    public static final SortMethod RELEVANCE;
    public static final List values;

    static 
    {
        RELEVANCE = new SortMethod("relevance", null);
        PRICE_ASC = new SortMethod("price:asc", null);
        PRICE_DESC = new SortMethod("price:desc", null);
        DISTANCE = new SortMethod("distance", null);
        values = Collections.unmodifiableList(Arrays.asList(new SortMethod[] {
            RELEVANCE, PRICE_ASC, PRICE_DESC, DISTANCE
        }));
    }

    public _cls9()
    {
    }
}
