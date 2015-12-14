// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nuance.nmdp.speechkit.util.pdx:
//            PdxValue

public static final class a extends PdxValue
{

    private final List a;

    private boolean a(Object obj)
    {
        if (obj == null)
        {
            b.b(this, (new StringBuilder()).append("ignore this add action since the value is null: value[").append(obj).append("]").toString());
            return false;
        } else
        {
            return true;
        }
    }

    public final void add(int i)
    {
        a.add(new init>(i));
    }

    public final void add(PdxValue pdxvalue)
    {
        if (a(pdxvalue))
        {
            a.add(pdxvalue);
        }
    }

    public final void add(String s)
    {
        if (a(s))
        {
            a.add(new nit>(s));
        }
    }

    public final void add(byte abyte0[])
    {
        if (a(abyte0))
        {
            a.add(new it>(abyte0));
        }
    }

    public final PdxValue get(int i)
    {
        return (PdxValue)a.get(i);
    }

    public final List getValues()
    {
        return a;
    }

    public final int size()
    {
        return a.size();
    }

    public final String toString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[\n");
        String s1 = (new StringBuilder()).append(s).append("  ").toString();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); stringbuilder.append(",\n"))
        {
            PdxValue pdxvalue = (PdxValue)iterator.next();
            stringbuilder.append(s1);
            stringbuilder.append(pdxvalue.toString(s1));
        }

        stringbuilder.append(s);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public ()
    {
        this(null);
    }

    public <init>(List list)
    {
        super(3);
        a = new ArrayList();
        if (list != null)
        {
            a.addAll(list);
        }
    }
}
