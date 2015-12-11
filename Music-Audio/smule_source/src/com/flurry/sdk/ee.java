// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

// Referenced classes of package com.flurry.sdk:
//            eb, cv, ds, r, 
//            ap, dr, dq, eh, 
//            ec

public class ee
{

    public static ec a(Context context, r r1, String s, ec.a a1, boolean flag, boolean flag1)
    {
        if (context != null && r1 != null)
        {
            if (TextUtils.isEmpty(s))
            {
                return new eb(context, r1, a1, flag);
            }
            if (cv.g(s))
            {
                ds ds1 = ds.c;
                if (r1.k().q())
                {
                    ds1 = ds.b;
                }
                new dr();
                context = dr.a(context, ds1, r1, a1);
                context.setVideoUri(Uri.parse(s));
                return context;
            }
            if (flag1)
            {
                return new eh(context, s, r1, a1, flag);
            }
        }
        return null;
    }
}
