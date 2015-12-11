// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class jk extends iy
{

    public String a;
    public String b;
    public String c;

    public jk()
    {
    }

    public final void a(iy iy1)
    {
        iy1 = (jk)iy1;
        if (!TextUtils.isEmpty(a))
        {
            iy1.a = a;
        }
        if (!TextUtils.isEmpty(b))
        {
            iy1.b = b;
        }
        if (!TextUtils.isEmpty(c))
        {
            iy1.c = c;
        }
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("network", a);
        hashmap.put("action", b);
        hashmap.put("target", c);
        return a(hashmap);
    }
}
