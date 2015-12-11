// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfy
    implements cpu
{

    public List a;
    public String b;
    private bfu c;

    public bfy()
    {
        a = new ArrayList();
        c = bfu.a;
    }

    public final bfx a()
    {
        ArrayList arraylist = new ArrayList();
        bgc bgc1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); arraylist.add(bgc1.a()))
        {
            bgc1 = ((bfz)iterator.next()).a();
            bgc1.l = c;
            bgc1.n = b;
        }

        return new bfx(arraylist);
    }

    public final bfy a(bfu bfu1)
    {
        c = (bfu)b.a(bfu1);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}
