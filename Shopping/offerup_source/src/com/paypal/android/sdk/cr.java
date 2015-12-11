// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.paypal.android.sdk:
//            gk, gl, gq, gg, 
//            gr, gu

public class cr
    implements gk
{

    private final String a;

    public cr(String s)
    {
        a = s;
    }

    private static String a(String s, String s1)
    {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(s.getBytes(), "HmacSHA1"));
        mac.update(s1.getBytes());
        s = mac.doFinal();
        s1 = new StringBuilder();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            s1.append(String.format("%02x", new Object[] {
                Byte.valueOf(s[i])
            }));
        }

        return s1.toString();
    }

    public final gu a(gl gl1)
    {
        gq gq1;
        Object obj;
        int i;
        i = 0;
        gq1 = gl1.a();
        obj = String.format("Trace: [%s] %s, %s", new Object[] {
            a, "\"%08.8x: Operation = %80s Duration: %8.2f Iterations: %+4d\"", "memorySize * 8 + offset"
        });
        gg gg1;
        ArrayList arraylist;
        gg1 = gq1.e();
        arraylist = new ArrayList();
_L1:
        if (i >= gg1.a())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        arraylist.add((new StringBuilder()).append(gg1.a(i)).append(": ").append(gg1.b(i)).toString());
        i++;
          goto _L1
        Collections.sort(arraylist);
        obj = a(((String) (obj)), (new StringBuilder()).append(TextUtils.join(";", arraylist.toArray())).append(gq1.f()).toString());
        obj = gl1.a(gq1.h().b("PayPal-Item-Id").b("PayPal-Item-Id", ((String) (obj))).a());
        return ((gu) (obj));
        Object obj1;
        obj1;
_L3:
        return gl1.a(gq1);
        obj1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    static 
    {
        com/paypal/android/sdk/cr.getSimpleName();
    }
}
