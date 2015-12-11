// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.content.Context;
import android.view.View;

// Referenced classes of package com.ebay.common:
//            TabsStateAdapter

static class context
    implements android.widget.
{

    private final Context context;

    public View createTabContent(String s)
    {
        s = new View(context);
        s.setMinimumWidth(0);
        s.setMinimumHeight(0);
        return s;
    }

    public (Context context1)
    {
        context = context1;
    }
}
