// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.support.v7.widget.bi;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            CouponCell, cu, cv

public final class ct extends bi
{

    final CouponCell k;
    final cv l;

    public ct(View view, cv cv)
    {
        super(view);
        k = (CouponCell)view;
        l = cv;
        k.setOnClickListener(new cu(this));
    }
}
