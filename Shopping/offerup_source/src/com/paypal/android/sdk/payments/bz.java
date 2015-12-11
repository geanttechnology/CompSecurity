// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Bundle;
import com.paypal.android.sdk.ed;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bx

class bz
{

    bz()
    {
    }

    public static bx a(Bundle bundle)
    {
        String s = bundle.getString("authAccount");
        String s1 = bundle.getString("code");
        String s2 = bundle.getString("nonce");
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext();)
        {
            String s3 = (String)iterator.next();
            Object obj = bundle.get(s3);
            if (obj == null)
            {
                String.format("%s:null", new Object[] {
                    s3
                });
            } else
            {
                String.format("%s:%s (%s)", new Object[] {
                    s3, obj.toString(), obj.getClass().getName()
                });
            }
        }

        return new bx(s2, new ed(s1, null), s);
    }

    static 
    {
        com/paypal/android/sdk/payments/bz.getSimpleName();
    }
}
