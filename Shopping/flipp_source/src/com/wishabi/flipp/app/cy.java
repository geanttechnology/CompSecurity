// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.b.al;
import com.wishabi.flipp.content.af;

// Referenced classes of package com.wishabi.flipp.app:
//            cx

final class cy extends al
{

    final cx a;

    cy(cx cx1, long l, String s, Context context)
    {
        a = cx1;
        super(l, s, context);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (af)obj;
        cx.a(a, ((af) (obj)));
    }
}
