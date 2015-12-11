// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.b.aa;
import com.wishabi.flipp.content.FlyerInfo;
import com.wishabi.flipp.util.q;

// Referenced classes of package com.wishabi.flipp.app:
//            by, bx

final class bz extends aa
{

    final by a;

    bz(by by1, int i, String s, Double double1, Double double2)
    {
        a = by1;
        super(i, s, double1, double2);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (FlyerInfo)obj;
        if (a.a.getActivity() != null)
        {
            if (obj == null)
            {
                bx.a(a.a, a.a.getString(0x7f0e00ce, new Object[] {
                    q.a()
                }));
            } else
            {
                bx.a(a.a, ((FlyerInfo) (obj)));
            }
            bx.c(a.a);
            bx.d(a.a);
        }
    }
}
