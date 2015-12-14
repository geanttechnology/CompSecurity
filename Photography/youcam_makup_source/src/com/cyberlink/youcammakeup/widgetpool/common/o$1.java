// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.database.DataSetObserver;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            o, t

class a extends DataSetObserver
{

    final o a;

    public void onChanged()
    {
        a.a.notifyDataSetChanged();
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
