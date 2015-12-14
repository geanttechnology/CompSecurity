// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import java.util.Comparator;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            SearchFragment

private class <init>
    implements Comparator
{

    final SearchFragment this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((HashMap)obj, (HashMap)obj1);
    }

    public int compare(HashMap hashmap, HashMap hashmap1)
    {
        return Integer.parseInt(hashmap.get("position").toString()) - Integer.parseInt(hashmap1.get("position").toString());
    }

    private ()
    {
        this$0 = SearchFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
