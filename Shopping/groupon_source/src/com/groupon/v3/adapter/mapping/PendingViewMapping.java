// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.db.models.Pagination;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class PendingViewMapping extends Mapping
{

    public PendingViewMapping()
    {
        super(com/groupon/db/models/Pagination);
    }

    public View createView(Context context)
    {
        return LayoutInflater.from(context).inflate(0x7f030201, null);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}
