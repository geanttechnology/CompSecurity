// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, k, j

public class o
    implements i
{

    public o()
    {
    }

    String a(Context context)
    {
        if (k.a("android.permission.READ_PHONE_STATE", context))
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public void a(Context context, j j1)
    {
        j1.a("RPSP", a(context));
        j1.a("AFLS", b(context));
        j1.a("ACLS", c(context));
        j1.a("UAPS", d(context));
    }

    String b(Context context)
    {
        if (k.a("android.permission.ACCESS_FINE_LOCATION", context))
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    String c(Context context)
    {
        if (k.a("android.permission.ACCESS_COARSE_LOCATION", context))
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    String d(Context context)
    {
        if (k.a("android.permission.GET_ACCOUNTS", context))
        {
            return "1";
        } else
        {
            return "0";
        }
    }
}
