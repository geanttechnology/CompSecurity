// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class bjn
{

    public long a;

    public bjn()
    {
    }

    public void a(long l)
    {
        if (a != 0L)
        {
            throw new RuntimeException("This instance is already timestamped");
        }
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        a = l;
    }
}
