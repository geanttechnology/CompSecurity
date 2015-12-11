// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import com.crittercism.app.CrittercismNDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package crittercism.android:
//            cq, ba, ay, av, 
//            be, bj, cn, az, 
//            de, dg, da, au, 
//            df, cz, cb, dc, 
//            dd, bi, h, dk, 
//            bs, bt, aw

public final class co extends cq
{

    private ConditionVariable a;
    private ba b;
    private Context c;
    private av d;
    private aw e;
    private au f;
    private List g;
    private boolean h;
    private boolean i;
    private Exception j;

    public co(ba ba1, Context context, av av1, aw aw, au au1)
    {
        a = new ConditionVariable();
        g = new ArrayList();
        h = false;
        j = null;
        b = ba1;
        c = context;
        d = av1;
        e = aw;
        f = au1;
        i = false;
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        h = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = h;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private File e()
    {
        Object obj;
        int k;
        k = 0;
        obj = new File((new StringBuilder()).append(c.getFilesDir().getAbsolutePath()).append("/").append(b.getNativeDumpPath()).toString());
        if (((File) (obj)).exists() && ((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((obj = ((File) (obj)).listFiles()) != null)
        {
            if (obj.length != 1)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = obj[0];
            ((File) (obj)).isFile();
            if (((File) (obj)).isFile())
            {
                return ((File) (obj));
            }
        }
        continue; /* Loop/switch isn't completed */
        if (obj.length <= 1) goto _L1; else goto _L3
_L3:
        int l = obj.length;
        while (k < l) 
        {
            File file = obj[k];
            file.isFile();
            file.delete();
            k++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void f()
    {
        if (!ay.t().u)
        {
            boolean flag = i;
            bj bj1 = d.j();
            bj bj2 = d.k();
            bj bj3 = d.l();
            bj bj4 = d.m();
            bj bj5 = d.n();
            de de1 = d.r();
            b.a();
            bj1.a(new be());
            if (!b.delaySendingAppLoad())
            {
                cn cn1 = new cn(c);
                cn1.a(bj1, new cd.a(), b.a(), f);
                cn1.a(bj2, new ci.a(), b.a(), f);
                cn1.a(bj4, new ci.a(), b.a(), f);
                cn1.a(bj5, new ci.a(), b.a(), f);
                cn1.a(bj3, new ci.a(), b.a(), new az(f, b));
                cn1.a();
            }
            if (de1.b())
            {
                ay.t().y();
                return;
            }
        }
    }

    public final void a()
    {
        Object obj;
        dg.b();
        obj = new File((new StringBuilder()).append(c.getFilesDir().getAbsolutePath()).append("/com.crittercism/pending").toString());
        if (!((File) (obj)).exists() || ((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        dg.b();
_L9:
        Object obj1;
        obj1 = ay.t();
        ((ay) (obj1)).y.a();
        obj = f.i();
        ((ay) (obj1)).e.open();
        obj1 = e;
        Context context = c;
        ((df) (obj)).a(((aw) (obj1)));
        cz.a = cz.a(c).booleanValue();
        cz.a(c, false);
        if (!((df) (obj)).c())
        {
            ((df) (obj)).a().a(e, cb.h.a(), cb.h.b());
            ((df) (obj)).b().a(e, cb.k.a(), cb.k.b());
        }
        i = ((df) (obj)).c();
        obj1 = e();
        if (!i) goto _L4; else goto _L3
_L3:
        boolean flag = i;
        if (ay.t().u) goto _L6; else goto _L5
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        if (((File) (obj1)).exists())
        {
            ((File) (obj1)).isFile();
        }
        (new bj(c, bi.a)).a();
        (new bj(c, bi.b)).a();
        (new bj(c, bi.c)).a();
        (new bj(c, bi.d)).a();
        (new bj(c, bi.e)).a();
        (new bj(c, bi.f)).a();
        (new bj(c, bi.h)).a();
        (new bj(c, bi.g)).a();
        if (obj1 == null) goto _L6; else goto _L7
_L7:
        ((File) (obj1)).delete();
_L6:
        crittercism.android.h.b(c);
_L20:
        c();
        for (obj = g.iterator(); ((Iterator) (obj)).hasNext(); ((Runnable)((Iterator) (obj)).next()).run()) { }
          goto _L8
        obj;
        (new StringBuilder("Exception in run(): ")).append(((Exception) (obj)).getMessage());
        dg.b();
        dg.c();
        j = ((Exception) (obj));
        a.open();
        return;
_L2:
        dk.a(((File) (obj)));
          goto _L9
        Exception exception;
        exception;
        a.open();
        throw exception;
_L4:
        Object obj2;
        obj2 = c;
        exception = new h(((Context) (obj2)));
        obj2 = ((Context) (obj2)).getSharedPreferences("com.crittercism.optmz.config", 0);
        if (!((SharedPreferences) (obj2)).contains("interval")) goto _L11; else goto _L10
_L10:
        exception.d = ((SharedPreferences) (obj2)).getInt("interval", 10);
        if (!((SharedPreferences) (obj2)).contains("kill")) goto _L13; else goto _L12
_L12:
        exception.c = ((SharedPreferences) (obj2)).getBoolean("kill", false);
        if (!((SharedPreferences) (obj2)).contains("persist"))
        {
            break MISSING_BLOCK_LABEL_877;
        }
        exception.b = ((SharedPreferences) (obj2)).getBoolean("persist", false);
        if (!((SharedPreferences) (obj2)).contains("enabled"))
        {
            break MISSING_BLOCK_LABEL_882;
        }
        exception.a = ((SharedPreferences) (obj2)).getBoolean("enabled", false);
_L22:
        Object obj3;
        bj bj1;
        bj bj2;
        bj bj3;
        boolean flag1;
        for (; exception == null; exception = null)
        {
            break MISSING_BLOCK_LABEL_611;
        }

        ay.t().a(exception);
        flag1 = i;
        d.s();
        flag1 = i;
        exception = ay.t();
        if (((ay) (exception)).u) goto _L15; else goto _L14
_L14:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_659;
        }
        if (((File) (obj1)).exists())
        {
            ((File) (obj1)).isFile();
        }
        obj3 = d;
        obj3 = d.o();
        bj1 = d.p();
        bj2 = d.q();
        bj3 = d.m();
        if (obj1 == null) goto _L17; else goto _L16
_L16:
        cz.a = true;
        ((ay) (exception)).f.open();
        bj3.a(new bs(((File) (obj1)), ((bj) (obj3)), bj2, bj1));
        ((File) (obj1)).delete();
_L21:
        bj2.a();
        bj1.a();
        ((bj) (obj3)).a(bj2);
_L15:
        d.o().a(bt.a);
        if (ay.t().u || !b.isNdkCrashReportingEnabled()) goto _L19; else goto _L18
_L18:
        dg.b();
        CrittercismNDK.installNdkLib(c, b.getNativeDumpPath());
_L19:
        f();
          goto _L20
_L17:
        ((ay) (exception)).f.open();
          goto _L21
        exception;
        (new StringBuilder("Exception installing ndk library: ")).append(exception.getClass().getName());
        dg.b();
          goto _L19
_L8:
        a.open();
        return;
_L11:
        exception = null;
          goto _L22
_L13:
        exception = null;
          goto _L22
        exception = null;
          goto _L22
    }

    public final boolean a(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        if (d()) goto _L2; else goto _L1
_L1:
        g.add(runnable);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        runnable;
        throw runnable;
    }

    public final void b()
    {
        a.block();
    }
}
