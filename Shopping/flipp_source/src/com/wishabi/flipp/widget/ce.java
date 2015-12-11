// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import com.wishabi.flipp.app.dn;

// Referenced classes of package com.wishabi.flipp.widget:
//            cd

final class ce
    implements android.view.View.OnClickListener
{

    final int a;
    final cd b;

    ce(cd cd1, int i)
    {
        b = cd1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        if (cd.a(b) != null)
        {
            cd.a(b).a(a);
        }
    }
}
