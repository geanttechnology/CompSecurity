// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class e
{

    protected final DataHolder a;
    protected int b;
    private int c;

    public e(DataHolder dataholder, int i)
    {
        a = (DataHolder)x.a(dataholder);
        a(i);
    }

    protected void a(int i)
    {
        boolean flag;
        if (i >= 0 && i < a.g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.a(flag);
        b = i;
        c = a.a(b);
    }

    public boolean a(String s)
    {
        return a.a(s);
    }

    protected boolean b(String s)
    {
        return a.b(s, b, c);
    }

    protected String c(String s)
    {
        return a.a(s, b, c);
    }

    protected boolean d(String s)
    {
        return a.d(s, b, c);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof e)
        {
            obj = (e)obj;
            flag = flag1;
            if (w.a(Integer.valueOf(((e) (obj)).b), Integer.valueOf(b)))
            {
                flag = flag1;
                if (w.a(Integer.valueOf(((e) (obj)).c), Integer.valueOf(c)))
                {
                    flag = flag1;
                    if (((e) (obj)).a == a)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            Integer.valueOf(b), Integer.valueOf(c), a
        });
    }
}
