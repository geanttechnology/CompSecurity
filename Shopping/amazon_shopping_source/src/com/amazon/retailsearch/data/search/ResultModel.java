// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;


// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultEvent

public abstract class ResultModel extends ResultEvent
{

    private final Object model;

    public ResultModel(Object obj)
    {
        model = obj;
    }

    public Object get()
    {
        return model;
    }
}
