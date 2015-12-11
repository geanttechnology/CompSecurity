// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            b, c, aw, r, 
//            ap

public class co
{

    public static void a(aw aw, Map map, Context context, r r, ap ap, int i)
    {
        if (context == null || r == null || ap == null)
        {
            return;
        } else
        {
            aw = new b(aw, map, context, r, ap);
            map = new c();
            map.a = aw;
            map.b = i;
            map.b();
            return;
        }
    }
}
