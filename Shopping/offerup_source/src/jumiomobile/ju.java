// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.view.View;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;

// Referenced classes of package jumiomobile:
//            jx, jw, jy

public class ju
{

    private Activity a;
    private View b;
    private int c;
    private Object d;
    private Country e;
    private DocumentType f;
    private jw g;
    private jx h;
    private Object i;

    public ju(Activity activity)
    {
        a = null;
        b = null;
        c = -1;
        d = new Object();
        e = null;
        f = null;
        g = null;
        h = jx.a;
        i = new Object();
        a = activity;
    }

    static Activity a(ju ju1)
    {
        return ju1.a;
    }

    static void a(ju ju1, jx jx1)
    {
        ju1.a(jx1);
    }

    private void a(jx jx1)
    {
        synchronized (i)
        {
            h = jx1;
        }
        return;
        jx1;
        obj;
        JVM INSTR monitorexit ;
        throw jx1;
    }

    static DocumentType b(ju ju1)
    {
        return ju1.f;
    }

    static Country c(ju ju1)
    {
        return ju1.e;
    }

    static Object d(ju ju1)
    {
        return ju1.i;
    }

    static Object e(ju ju1)
    {
        return ju1.d;
    }

    static View f(ju ju1)
    {
        return ju1.b;
    }

    static int g(ju ju1)
    {
        return ju1.c;
    }

    static jw h(ju ju1)
    {
        return ju1.g;
    }

    public void a()
    {
        if (b != null)
        {
            b.setEnabled(false);
        }
        if (e == null || f == null || !f.isThirdPartyOcrDefined() || !e.b(a, f)) goto _L2; else goto _L1
_L1:
        a(jx.d);
        g.l();
_L4:
        return;
_L2:
        if (e != null && f != null && f.isThirdPartyOcrDefined())
        {
            a(jx.c);
            synchronized (d)
            {
                if (b != null && c != -1)
                {
                    b.findViewById(c).setVisibility(0);
                    b.invalidate();
                }
            }
            (new Thread(new jy(this, null))).start();
            return;
        }
        continue; /* Loop/switch isn't completed */
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (g == null) goto _L4; else goto _L3
_L3:
        a(jx.b);
        g.l();
        return;
    }

    public void a(int j)
    {
        synchronized (d)
        {
            c = j;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(View view)
    {
        synchronized (d)
        {
            b = view;
        }
        return;
        view;
        obj;
        JVM INSTR monitorexit ;
        throw view;
    }

    public void a(Country country)
    {
        e = country;
    }

    public void a(DocumentType documenttype)
    {
        f = documenttype;
    }

    public void a(jw jw1)
    {
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (h == jx.d)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        g = jw1;
_L2:
        return;
        jw1.l();
        if (true) goto _L2; else goto _L1
_L1:
        jw1;
        obj;
        JVM INSTR monitorexit ;
        throw jw1;
    }

    public jx b()
    {
        jx jx1 = jx.a;
        jx jx2;
        synchronized (i)
        {
            jx2 = h;
        }
        return jx2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean b(Country country)
    {
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (e != null && country != null) goto _L2; else goto _L1
_L4:
        obj;
        JVM INSTR monitorexit ;
        boolean flag;
        return flag;
_L2:
        flag = e.b().equals(country.b());
        continue; /* Loop/switch isn't completed */
        country;
        obj;
        JVM INSTR monitorexit ;
        throw country;
_L1:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean b(DocumentType documenttype)
    {
        boolean flag1 = false;
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (f == null) goto _L2; else goto _L1
_L1:
        if (documenttype != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        flag = flag1;
        if (f.getId() == documenttype.getId())
        {
            flag = true;
        }
        if (true) goto _L2; else goto _L5
_L5:
        documenttype;
        obj;
        JVM INSTR monitorexit ;
        throw documenttype;
    }
}
