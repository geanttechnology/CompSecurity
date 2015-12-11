// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class ji extends iy
{

    public String a;
    public boolean b;

    public ji()
    {
    }

    public final void a(iy iy1)
    {
        iy1 = (ji)iy1;
        if (!TextUtils.isEmpty(a))
        {
            iy1.a = a;
        }
        if (b)
        {
            iy1.b = b;
        }
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("description", a);
        hashmap.put("fatal", Boolean.valueOf(b));
        return a(hashmap);
    }
}
