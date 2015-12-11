// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

// Referenced classes of package a.a:
//            bd, be, en

public final class bl
    implements bd
{

    public String a;

    public bl()
    {
        a = null;
        be.b();
        String s;
        try
        {
            s = ((TelephonyManager)be.b().getSystemService("phone")).getNetworkOperatorName();
        }
        catch (Exception exception)
        {
            exception = Build.BRAND;
        }
        a = s;
        (new StringBuilder("carrier == ")).append(a);
        en.b();
    }

    public final String a()
    {
        return "carrier";
    }

    public final volatile Object b()
    {
        return a;
    }
}
