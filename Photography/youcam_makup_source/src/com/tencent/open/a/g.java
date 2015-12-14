// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.os.Environment;

// Referenced classes of package com.tencent.open.a:
//            h

public final class g
{

    public static boolean a()
    {
        String s = Environment.getExternalStorageState();
        return "mounted".equals(s) || "mounted_ro".equals(s);
    }

    public static h b()
    {
        if (!a())
        {
            return null;
        } else
        {
            return h.b(Environment.getExternalStorageDirectory());
        }
    }
}
