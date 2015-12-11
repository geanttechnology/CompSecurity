// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Method;

// Referenced classes of package u.aly:
//            be, u, bj

public class y
{

    private static final String a = "uptr";
    private static final String b = "dntr";

    public y()
    {
    }

    public static be a(Context context)
    {
        be be1;
        long al[];
        long l;
        long l1;
        try
        {
            be1 = new be();
            al = b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.e("MobclickAgent", "sdk less than 2.2 has get no traffic");
            return null;
        }
        if (al[0] > 0L && al[1] > 0L) goto _L2; else goto _L1
_L2:
        context = u.a(context);
        l = context.getLong("uptr", -1L);
        l1 = context.getLong("dntr", -1L);
        context.edit().putLong("uptr", al[1]).putLong("dntr", al[0]).commit();
        break MISSING_BLOCK_LABEL_94;
_L4:
        be1.c((int)al[0]);
        be1.a((int)al[1]);
        return be1;
_L1:
        return null;
        if (l <= 0L || l1 <= 0L)
        {
            return null;
        }
        al[0] = al[0] - l1;
        al[1] = al[1] - l;
        if (al[0] <= 0L || al[1] <= 0L)
        {
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static long[] b(Context context)
        throws Exception
    {
        Object obj = Class.forName("android.net.TrafficStats");
        Method method = ((Class) (obj)).getMethod("getUidRxBytes", new Class[] {
            Integer.TYPE
        });
        obj = ((Class) (obj)).getMethod("getUidTxBytes", new Class[] {
            Integer.TYPE
        });
        int i = context.getApplicationInfo().uid;
        if (i == -1)
        {
            return null;
        } else
        {
            return (new long[] {
                ((Long)method.invoke(null, new Object[] {
                    Integer.valueOf(i)
                })).longValue(), ((Long)((Method) (obj)).invoke(null, new Object[] {
                    Integer.valueOf(i)
                })).longValue()
            });
        }
    }
}
