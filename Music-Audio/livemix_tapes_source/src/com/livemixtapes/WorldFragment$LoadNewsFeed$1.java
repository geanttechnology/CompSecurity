// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            WorldFragment

class this._cls1
    implements Comparator
{

    final e this$1;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((HashMap)obj, (HashMap)obj1);
    }

    public int compare(HashMap hashmap, HashMap hashmap1)
    {
        hashmap = cess._mth3(this._cls1.this).convertUtcToDate((String)hashmap.get("timestamp"));
        hashmap1 = cess._mth3(this._cls1.this).convertUtcToDate((String)hashmap1.get("timestamp"));
        if (hashmap == null || hashmap1 == null)
        {
            return 0;
        } else
        {
            return hashmap1.compareTo(hashmap);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
