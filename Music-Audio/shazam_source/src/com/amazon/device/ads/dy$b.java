// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            dy, dq

static final class ception
{

    final HashMap a = new HashMap();
    String b;

    final void a(String s, String s1)
    {
        if (dq.b(s))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (s1 == null)
        {
            a.remove(s);
            return;
        } else
        {
            a.put(s, s1);
            return;
        }
    }

    final void a(String s, String s1, boolean flag)
    {
        if (flag)
        {
            a(s, s1);
        }
    }

    ception()
    {
    }
}
