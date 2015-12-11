// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.telephony.TelephonyManager;

// Referenced classes of package a.a:
//            bd, be, en

public final class bv
    implements bd
{

    public Integer a;

    public bv()
    {
        a = Integer.valueOf(0);
        be.b();
        String s;
        try
        {
            s = ((TelephonyManager)be.b().getSystemService("phone")).getNetworkOperator();
        }
        catch (Exception exception)
        {
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a = Integer.valueOf(Integer.parseInt(s.substring(3)));
        (new StringBuilder("mobileNetworkCode == ")).append(a);
        en.b();
        return;
    }

    public final String a()
    {
        return "mobile_network_code";
    }

    public final volatile Object b()
    {
        return a;
    }
}
