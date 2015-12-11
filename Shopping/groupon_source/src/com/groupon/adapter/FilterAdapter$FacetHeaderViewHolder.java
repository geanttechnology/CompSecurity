// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.adapter:
//            FilterAdapter

private static class arrow
{

    final ImageView arrow;
    final TextView headerSummary;
    final TextView headerText;
    final AtomicBoolean isAnimating = new AtomicBoolean();

    public (View view)
    {
        headerText = (TextView)view.findViewById(0x7f100292);
        headerSummary = (TextView)view.findViewById(0x7f100293);
        arrow = (ImageView)view.findViewById(0x7f100182);
    }
}
