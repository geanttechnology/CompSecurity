// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public class bur
{

    private amx a;
    private List b;

    public bur()
    {
        a = new amx();
        b = new ArrayList();
    }

    public final bup a()
    {
        bup bup1;
        try
        {
            a.a = (amy[])b.toArray(new amy[0]);
            bup1 = new bup((amx)eun.a(new amx(), eun.a(a)));
        }
        catch (eum eum1)
        {
            return bup.a;
        }
        return bup1;
    }

    public final bur a(but but1)
    {
        try
        {
            List list = b;
            but1 = new buv(but1.a);
            int i = b.size();
            ((buv) (but1)).a.i = i;
            but1 = but1.a();
            list.add((amy)eun.a(new amy(), eun.a(but1.a)));
        }
        // Misplaced declaration of an exception variable
        catch (but but1)
        {
            return this;
        }
        return this;
    }
}
