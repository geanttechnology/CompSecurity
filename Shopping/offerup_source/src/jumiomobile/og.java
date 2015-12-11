// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Referenced classes of package jumiomobile:
//            ai, ob, oa, hu, 
//            ab

class og extends ai
{

    final oa e;
    private ArrayList f;
    private int g;

    public og(oa oa1, ArrayList arraylist, int i)
    {
        e = oa1;
        super();
        f = arraylist;
        g = i;
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.TRUE;
    }

    protected void a(Boolean boolean1)
    {
        ob.a[oa.a(e).c.ordinal()];
        JVM INSTR tableswitch 1 2: default 184
    //                   1 105
    //                   2 112;
           goto _L1 _L2 _L3
_L1:
        oa.a(e, f, g);
_L4:
        if (!oa.e(e).isEmpty())
        {
            oa.c(e, (ai)oa.f(e).remove(0));
            oa.d(e, oa.g(e));
        }
        return;
_L2:
        e.f();
_L3:
        oa.a(e, (Country)oa.a(e).d().get(oa.a(e).w), oa.a(e).v.getId(), oa.a(e).v.getDocumentVariant());
          goto _L1
        boolean1;
        ab.a(boolean1);
          goto _L4
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
