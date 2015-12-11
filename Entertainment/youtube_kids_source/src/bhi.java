// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.telephony.TelephonyManager;

final class bhi extends bmr
{

    private bgv a;

    bhi(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        return (TelephonyManager)a.b.getSystemService("phone");
    }
}
