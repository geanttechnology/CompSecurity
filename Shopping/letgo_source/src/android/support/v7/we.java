// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            wb, wc, wf, vn

public abstract class we
{

    protected final wb a;
    private final wf b;
    private final List c = new ArrayList();

    protected we(wf wf, vn vn)
    {
        x.a(wf);
        b = wf;
        wf = new wb(this, vn);
        wf.k();
        a = wf;
    }

    protected void a(wb wb1)
    {
    }

    protected void b(wb wb1)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((wc)iterator.next()).a(this, wb1)) { }
    }

    public wb j()
    {
        wb wb1 = a.a();
        b(wb1);
        return wb1;
    }

    public wb k()
    {
        return a;
    }

    public List l()
    {
        return a.c();
    }

    protected wf m()
    {
        return b;
    }
}
