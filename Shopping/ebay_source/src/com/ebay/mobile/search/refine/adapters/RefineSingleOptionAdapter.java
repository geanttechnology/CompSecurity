// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.adapters;

import android.content.Context;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.adapters:
//            RefineOptionAdapter

public class RefineSingleOptionAdapter extends RefineOptionAdapter
{

    public RefineSingleOptionAdapter(Context context, List list)
    {
        super(context, list);
    }

    public RefineSingleOptionAdapter(Context context, Object aobj[])
    {
        super(context, aobj);
    }

    protected int getViewResId()
    {
        return 0x7f0301e0;
    }

    public boolean showLeftArrowForPosition(int i)
    {
        return false;
    }
}
