// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;

public class ahl
{

    private ahm a;
    private boolean b;
    private boolean c;

    public ahl()
    {
        boolean flag1 = false;
        super();
        Bundle bundle = abi.n();
        boolean flag = flag1;
        if (bundle != null)
        {
            flag = flag1;
            if (bundle.getBoolean("gads:block_autoclicks", false))
            {
                flag = true;
            }
        }
        c = flag;
    }

    public ahl(boolean flag)
    {
        c = flag;
    }

    public void a()
    {
        b = true;
    }

    public void a(ahm ahm1)
    {
        a = ahm1;
    }

    public void a(String s)
    {
        acb.a("Action was blocked because no click was detected.");
        if (a != null)
        {
            a.a(s);
        }
    }

    public boolean b()
    {
        return !c || b;
    }
}
