// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import com.wishabi.flipp.app.dn;

// Referenced classes of package com.wishabi.flipp.widget:
//            a

final class e
    implements android.view.View.OnLongClickListener
{

    final int a;
    final a b;

    e(a a1, int i)
    {
        b = a1;
        a = i;
        super();
    }

    public final boolean onLongClick(View view)
    {
        if (com.wishabi.flipp.widget.a.a(b) == null)
        {
            return false;
        } else
        {
            return com.wishabi.flipp.widget.a.a(b).a();
        }
    }
}
