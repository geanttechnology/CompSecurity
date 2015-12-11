// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import java.util.List;
import java.util.Stack;

// Referenced classes of package jumiomobile:
//            ai, oa, hu, ab, 
//            ob

class oe extends ai
{

    final oa e;

    private oe(oa oa1)
    {
        e = oa1;
        super();
    }

    oe(oa oa1, ob ob)
    {
        this(oa1);
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.TRUE;
    }

    protected void a(Boolean boolean1)
    {
        try
        {
            if (oa.a(e).c == hu.g)
            {
                e.f();
            }
            oa.a(e, (Country)oa.a(e).d().get(oa.a(e).w), oa.a(e).v.getId(), oa.a(e).v.getDocumentVariant());
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            ab.a(boolean1);
        }
        if (!oa.b(e).isEmpty())
        {
            oa.a(e, (ai)oa.c(e).remove(0));
            oa.b(e, oa.d(e));
        }
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
