// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.data.DataHolder;

public abstract class rl
{

    protected final DataHolder a;
    protected int b;
    private int c;

    public rl(DataHolder dataholder, int i)
    {
        a = (DataHolder)ady.a(dataholder);
        a(i);
    }

    protected int a(String s)
    {
        return a.a(s, b, c);
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
        ady.a(flag);
        b = i;
        c = a.a(b);
    }

    protected String b(String s)
    {
        return a.b(s, b, c);
    }

    protected byte[] c(String s)
    {
        return a.c(s, b, c);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof rl)
        {
            obj = (rl)obj;
            flag = flag1;
            if (adv.a(Integer.valueOf(((rl) (obj)).b), Integer.valueOf(b)))
            {
                flag = flag1;
                if (adv.a(Integer.valueOf(((rl) (obj)).c), Integer.valueOf(c)))
                {
                    flag = flag1;
                    if (((rl) (obj)).a == a)
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
        return adv.a(new Object[] {
            Integer.valueOf(b), Integer.valueOf(c), a
        });
    }
}
