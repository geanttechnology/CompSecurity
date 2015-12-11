// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.a;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.app:
//            cx, n

final class dd
    implements android.view.View.OnClickListener
{

    final cx a;

    dd(cx cx1)
    {
        a = cx1;
        super();
    }

    public final void onClick(View view)
    {
        while (a.getActivity() == null || cx.d(a) == null || cx.d(a).isEmpty()) 
        {
            return;
        }
        view = com.wishabi.flipp.content.a.a(cx.d(a));
        a.a(com/wishabi/flipp/app/n, com.wishabi.flipp.app.n.a(view, false, p.b));
    }
}
