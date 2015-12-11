// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import com.jumio.mobile.sdk.enums.JumioDataCenter;

// Referenced classes of package jumiomobile:
//            an, cr, fl

public class dl extends an
{

    private static dl a;

    public dl()
    {
    }

    public static void a(Context context, String s, String s1, JumioDataCenter jumiodatacenter)
    {
        d().a();
        d().a("ImageDumpService", new cr());
        d().a(fl.d, new fl(context, s, s1, jumiodatacenter, null));
    }

    public static void b(Context context, String s)
    {
        ((fl)d().a(context, fl.d)).a(s);
    }

    public static an d()
    {
        jumiomobile/dl;
        JVM INSTR monitorenter ;
        dl dl1;
        if (a == null)
        {
            a = new dl();
        }
        dl1 = a;
        jumiomobile/dl;
        JVM INSTR monitorexit ;
        return dl1;
        Exception exception;
        exception;
        throw exception;
    }
}
