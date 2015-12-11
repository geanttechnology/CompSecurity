// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.internal.eg;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Plus

public static final class 
{

    String Ds;
    final Set Dt = new HashSet();

    public transient  addActivityTypes(String as[])
    {
        eg.b(as, "activityTypes may not be null.");
        for (int i = 0; i < as.length; i++)
        {
            Dt.add(as[i]);
        }

        return this;
    }

    public Dt build()
    {
        return new Dt(this, null);
    }

    public Dt setServerClientId(String s)
    {
        Ds = s;
        return this;
    }

    public ()
    {
    }
}
