// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;

// Referenced classes of package com.flurry.sdk:
//            kc

public abstract class ka
{

    protected String g;

    public ka(String s)
    {
        g = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Event must have a name!");
        } else
        {
            g = s;
            return;
        }
    }

    public String a()
    {
        return g;
    }

    public void b()
    {
        kc.a().a(this);
    }
}
