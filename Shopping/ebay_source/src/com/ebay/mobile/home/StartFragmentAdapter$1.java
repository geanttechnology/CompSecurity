// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragmentAdapter

class SpanSizeLookup extends android.support.v7.widget.izeLookup
{

    final StartFragmentAdapter this$0;

    public int getSpanSize(int i)
    {
        return ((Integer)StartFragmentAdapter.access$100(StartFragmentAdapter.this).get(i)).intValue();
    }

    SpanSizeLookup()
    {
        this$0 = StartFragmentAdapter.this;
        super();
    }
}
