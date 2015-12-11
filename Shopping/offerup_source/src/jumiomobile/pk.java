// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.jumio.mobile.sdk.environment.Environment;

// Referenced classes of package jumiomobile:
//            am, pj, pl, ab

public class pk
    implements am
{

    private Context a;
    private final Object b = new Object();
    private pj c;

    public pk()
    {
    }

    static Object a(pk pk1)
    {
        return pk1.b;
    }

    static pj a(pk pk1, pj pj1)
    {
        pk1.c = pj1;
        return pj1;
    }

    private void a(pj pj1)
    {
        PreferenceManager.getDefaultSharedPreferences(a).edit().putInt("device_category", pj1.ordinal()).commit();
    }

    static pj b(pk pk1)
    {
        return pk1.c;
    }

    static void b(pk pk1, pj pj1)
    {
        pk1.a(pj1);
    }

    private void d()
    {
        c = e();
        if (c == null)
        {
            (new Thread(new pl(this), "BenchmarkThread")).start();
        }
    }

    private pj e()
    {
        int i = PreferenceManager.getDefaultSharedPreferences(a).getInt("device_category", -1);
        if (i == -1)
        {
            return null;
        } else
        {
            pj pj1 = pj.values()[i];
            ab.a("BenchmarkService", (new StringBuilder("Loading previously stored value ")).append(pj1.toString()).toString());
            return pj1;
        }
    }

    public void a(Context context)
    {
        Environment.loadBenchmarkLib();
        a = context;
        d();
    }

    public boolean a()
    {
        return a != null;
    }

    public void b()
    {
        Object obj = PreferenceManager.getDefaultSharedPreferences(a);
        if (((SharedPreferences) (obj)).contains("device_category"))
        {
            ab.a("BenchmarkService", "Reset stored value");
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).remove("device_category");
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
    }

    public pj c()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
_L1:
        pj pj1 = c;
        if (pj1 != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        b.wait();
          goto _L1
        Object obj1;
        obj1;
        ab.a(((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1 = c;
        obj;
        JVM INSTR monitorexit ;
        return ((pj) (obj1));
    }
}
