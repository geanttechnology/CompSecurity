// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.text.TextUtils;

// Referenced classes of package com.paypal.android.sdk:
//            cj, ch, ck, ac

public abstract class ci extends cj
{

    public ci(ch ch, ck ck, ac ac, String s)
    {
        this(ch, ck, ac, s, null);
    }

    public ci(ch ch, ck ck, ac ac, String s, String s1)
    {
        super(ch, ck, s1);
        if (!TextUtils.isEmpty(s))
        {
            a("Authorization", s);
        }
    }

    static 
    {
        com/paypal/android/sdk/ci.getSimpleName();
    }
}
