// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import com.baidu.autoupdatesdk.ICallback;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            y, u, z

public class a
{

    private a()
    {
    }

    public static void a(Context context)
    {
        context = y.a(context);
        u.d().a(context, null);
    }

    public static void a(Context context, ICallback icallback)
    {
        context = z.a(context);
        u.d().a(context, icallback);
    }
}
