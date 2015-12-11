// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import com.crittercism.app.CrittercismNDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package a.a:
//            ed, fb, aa, x, 
//            ak, al, ae, ep, 
//            ef, cp, ay, cs, 
//            en, ai, ar, ea, 
//            dl, dj, dv, dn, 
//            ad, el, eg, v, 
//            em, ej, df, ek, 
//            ax, eu, y

public final class eb extends ed
{

    public ConditionVariable a;
    public ar b;
    private ConditionVariable c;
    private ae d;
    private Context e;
    private x f;
    private y g;
    private v h;
    private List i;
    private boolean j;
    private boolean k;
    private Exception l;

    public eb(ae ae1, Context context, x x1, y y, v v1)
    {
        c = new ConditionVariable();
        a = new ConditionVariable();
        i = new ArrayList();
        j = false;
        b = null;
        l = null;
        d = ae1;
        e = context;
        f = x1;
        g = y;
        h = v1;
        k = false;
    }

    private void a(File file)
    {
        Object obj1 = e;
        Object obj = new fb(((Context) (obj1)));
        obj1 = ((Context) (obj1)).getSharedPreferences("com.crittercism.optmz.config", 0);
        if (((SharedPreferences) (obj1)).contains("interval"))
        {
            obj.d = ((SharedPreferences) (obj1)).getInt("interval", 10);
            if (((SharedPreferences) (obj1)).contains("kill"))
            {
                obj.c = ((SharedPreferences) (obj1)).getBoolean("kill", false);
                if (((SharedPreferences) (obj1)).contains("persist"))
                {
                    obj.b = ((SharedPreferences) (obj1)).getBoolean("persist", false);
                    Object obj2;
                    ay ay1;
                    ay ay2;
                    ay ay3;
                    boolean flag;
                    if (((SharedPreferences) (obj1)).contains("enabled"))
                    {
                        obj.a = ((SharedPreferences) (obj1)).getBoolean("enabled", false);
                    } else
                    {
                        obj = null;
                    }
                } else
                {
                    obj = null;
                }
            } else
            {
                obj = null;
            }
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            aa.A().a(((fb) (obj)));
        }
        flag = k;
        f.z();
        if (!aa.A().t)
        {
            obj = ak.a(e);
            obj1 = f.x();
            obj2 = f.s();
            ay1 = f.t();
            ay2 = f.v();
            obj1 = new al(e, h, ((ay) (obj1)), ((ay) (obj2)), ay1, ay2, d.m());
            obj2 = aa.A();
            obj2.y = ((al) (obj1));
            (new ep(((Runnable) (obj1)), "TXN Thread")).start();
            ((aa) (obj2)).a(((ak) (obj)));
        }
        flag = k;
        obj = aa.A();
        if (!((aa) (obj)).t)
        {
            if (file != null && file.exists())
            {
                file.isFile();
            }
            obj1 = f;
            obj1 = f.s();
            obj2 = f.t();
            ay1 = f.u();
            ay2 = f.v();
            ay3 = f.q();
            if (file != null)
            {
                ef.a = true;
                ((aa) (obj)).e.open();
                ay3.a(new cp(file, ((ay) (obj1)), ay1, ((ay) (obj2)), ay2));
                file.delete();
                f.w().a();
            } else
            {
                ((aa) (obj)).e.open();
                ai.a(f);
            }
            ay1.a();
            ((ay) (obj2)).a();
            ay2.a();
            ((ay) (obj1)).a(ay1);
        }
        a.open();
        f.s().a(cs.a);
        if (!aa.A().t && d.f())
        {
            en.b();
            try
            {
                CrittercismNDK.a(e, d.p());
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                (new StringBuilder("Exception installing ndk library: ")).append(file.getClass().getName());
                en.b();
            }
        }
        f();
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        j = true;
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
        boolean flag = j;
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
        int i1;
        i1 = 0;
        obj = new File((new StringBuilder()).append(e.getFilesDir().getAbsolutePath()).append("/").append(d.p()).toString());
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
        int j1 = obj.length;
        while (i1 < j1) 
        {
            File file = obj[i1];
            file.isFile();
            file.delete();
            i1++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void f()
    {
        if (!aa.A().t)
        {
            boolean flag = k;
            ay ay1 = f.n();
            ay ay2 = f.o();
            ay ay3 = f.p();
            ay ay4 = f.q();
            ay ay5 = f.r();
            el el1 = f.y();
            d.k();
            b = new ar(h);
            if (!d.d())
            {
                ay1.a(b);
                ea ea1 = new ea(e);
                ea1.a(ay1, new dl(), d.n(), "/v0/appload/", d.k(), h, new dj());
                ea1.a(ay2, new dv(), d.k(), "/android_v2/handle_exceptions", null, h, new dn());
                ea1.a(ay4, new dv(), d.k(), "/android_v2/handle_ndk_crashes", null, h, new dn());
                ea1.a(ay5, new dv(), d.k(), "/android_v2/handle_crashes", null, h, new dn());
                ea1.a(ay3, new dv(), d.k(), "/android_v2/handle_exceptions", null, new ad(h, d), new dn());
                ea1.a();
            }
            if (el1.b())
            {
                aa.A().B();
                return;
            }
        }
    }

    public final void a()
    {
        Object obj;
        en.b();
        obj = new File((new StringBuilder()).append(e.getFilesDir().getAbsolutePath()).append("/com.crittercism/pending").toString());
        if (!((File) (obj)).exists() || ((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        en.b();
_L8:
        Object obj1 = aa.A();
        ((aa) (obj1)).w.a();
        obj = h.l();
        ((aa) (obj1)).d.open();
        obj1 = g;
        Context context = e;
        ((em) (obj)).a(((y) (obj1)));
        ef.a = ef.a(e).booleanValue();
        ef.a(e, false);
        if (!((em) (obj)).b())
        {
            ej ej1 = new ej(e);
            int i1 = ej1.a();
            ej1.a.edit().putInt("numAppLoads", i1 + 1).commit();
            aa.A().A = ej1;
            ((em) (obj)).a().a(g, df.j.a(), df.j.b());
        }
        k = ((em) (obj)).b();
        obj = e();
        if (!k) goto _L4; else goto _L3
_L3:
        boolean flag = k;
        if (aa.A().t) goto _L6; else goto _L5
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        if (((File) (obj)).exists())
        {
            ((File) (obj)).isFile();
        }
        (new ay(e, ax.a)).a();
        (new ay(e, ax.b)).a();
        (new ay(e, ax.c)).a();
        (new ay(e, ax.d)).a();
        (new ay(e, ax.e)).a();
        (new ay(e, ax.f)).a();
        (new ay(e, ax.h)).a();
        (new ay(e, ax.g)).a();
        (new ay(e, ax.k)).a();
        if (obj == null) goto _L6; else goto _L7
_L7:
        ((File) (obj)).delete();
_L6:
        fb.b(e);
_L9:
        c();
        for (obj = i.iterator(); ((Iterator) (obj)).hasNext(); ((Runnable)((Iterator) (obj)).next()).run()) { }
        break MISSING_BLOCK_LABEL_527;
        obj;
        (new StringBuilder("Exception in run(): ")).append(((Exception) (obj)).getMessage());
        en.b();
        en.c();
        l = ((Exception) (obj));
        c.open();
        return;
_L2:
        eu.a(((File) (obj)));
          goto _L8
        obj;
        c.open();
        throw obj;
_L4:
        a(((File) (obj)));
          goto _L9
        c.open();
        return;
          goto _L8
    }

    public final boolean a(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        if (d()) goto _L2; else goto _L1
_L1:
        i.add(runnable);
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
        c.block();
    }
}
