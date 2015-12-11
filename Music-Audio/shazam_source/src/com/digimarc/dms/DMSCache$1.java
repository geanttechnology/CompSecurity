// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import java.util.LinkedHashMap;

// Referenced classes of package com.digimarc.dms:
//            DMSCache

class t> extends LinkedHashMap
{

    private static final long serialVersionUID = 1L;
    final DMSCache this$0;
    final int val$capacity;

    protected boolean removeEldestEntry(java.util.ache._cls1 _pcls1)
    {
        return size() > val$capacity;
    }

    (float f, boolean flag, int j)
    {
        this$0 = final_dmscache;
        val$capacity = j;
        super(I.this, f, flag);
    }
}
