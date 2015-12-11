// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class oz
    implements bxr
{

    private final bdc a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;

    public oz(bdc bdc1, TelephonyManager telephonymanager, PackageManager packagemanager)
    {
        boolean flag1 = true;
        super();
        a = (bdc)b.a(bdc1);
        b.a(telephonymanager);
        b.a(packagemanager);
        bdc1 = new Intent("android.intent.action.DIAL");
        b = telephonymanager.getPhoneType();
        c = telephonymanager.getSimState();
        boolean flag;
        if (!TextUtils.isEmpty(telephonymanager.getNetworkOperator()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        if (packagemanager.resolveActivity(bdc1, 0) != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    public final void a(bxu bxu1)
    {
        Object obj;
        b.b();
        obj = a.f;
        Object obj1 = a.a;
        String s = ((bdi) (obj1)).a;
        obj1 = ((bdi) (obj1)).c();
        String s1 = String.valueOf("xml_vast2");
        bxu1.s = (new StringBuilder(String.valueOf(s).length() + 27 + String.valueOf(obj1).length() + String.valueOf(s1).length())).append("sdkv=").append(s).append("&video_format=").append(((String) (obj1))).append("&output=").append(s1).toString();
        bxu1.m = a.d;
        bxu1.p = a.b.g();
        bxu1.o = a.a();
        bxu1.v = b;
        bxu1.w = c;
        bxu1.x = d;
        bxu1.y = e;
        obj;
        JVM INSTR monitorenter ;
        if (((ctw) (obj)).c())
        {
            bxu1.r = ((ctw) (obj)).e();
            bxu1.q = ((ctw) (obj)).d();
            bxu1.t = ((ctw) (obj)).f();
            if (((ctw) (obj)).g() != null)
            {
                bxu1.u = ((ctw) (obj)).g().a.g;
            }
        }
        obj;
        JVM INSTR monitorexit ;
        obj = a.e;
        if (obj != null)
        {
            bxu1.n = ((bme) (obj)).b();
        }
        return;
        bxu1;
        obj;
        JVM INSTR monitorexit ;
        throw bxu1;
    }
}
