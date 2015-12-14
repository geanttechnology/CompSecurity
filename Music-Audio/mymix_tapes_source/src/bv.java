// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class bv
{

    private int a;

    public bv(int i)
    {
        a = i;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj.getClass().getName().equals(getClass().getName()))
        {
            flag = flag1;
            if (((bv)obj).a == a)
            {
                flag = true;
            }
        }
        return flag;
    }
}
