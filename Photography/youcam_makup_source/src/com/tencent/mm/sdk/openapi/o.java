// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.Context;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            p, e

public class o
{

    private static o a = null;

    private o()
    {
    }

    public static e a(Context context, String s, boolean flag)
    {
        if (a == null)
        {
            a = new o();
        }
        return new p(context, s, flag);
    }

}
