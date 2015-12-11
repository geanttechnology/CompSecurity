// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class dax
{

    public volatile int a;

    public dax()
    {
    }

    public final void a(int i)
    {
        boolean flag;
        if (i >= 0 && i <= 100 || i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        a = i;
    }
}
