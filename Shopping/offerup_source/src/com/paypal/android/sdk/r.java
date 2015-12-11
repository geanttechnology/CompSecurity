// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.content.Intent;
import java.util.Collection;

// Referenced classes of package com.paypal.android.sdk:
//            t, s

public final class r extends t
{

    private static final Collection a = new s();

    public r()
    {
    }

    public static Intent a()
    {
        return a("com.paypal.android.lib.authenticator.activity.v1.TouchActivity", "com.paypal.android.lib.authenticator.activity.v1.TouchActivity");
    }

    public static boolean a(String s1)
    {
        return !a.contains(s1);
    }

    public final boolean a(Context context, boolean flag)
    {
        boolean flag1 = a(context, "com.paypal.android.lib.authenticator.activity.v1.TouchActivity", "com.paypal.android.lib.authenticator.activity.v1.TouchActivity");
        return b(context, flag) && flag1;
    }

}
