// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            db, dj

final class dd
    implements android.view.View.OnClickListener
{

    final db a;

    dd(db db1)
    {
        a = db1;
        super();
    }

    public final void onClick(View view)
    {
        if (db.a(a) == null)
        {
            return;
        } else
        {
            db.a(a).c(a);
            return;
        }
    }
}
