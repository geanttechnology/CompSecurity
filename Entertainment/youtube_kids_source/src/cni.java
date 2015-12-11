// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cni
{

    public static final mj a = new cnj();
    public static final mj b = new cnk();

    public static int a(mp mp)
    {
        boolean flag = false;
        int i;
        if (mp instanceof ma)
        {
            mp = (ma)mp;
            i = ((flag) ? 1 : 0);
            if (((ma) (mp)).a != null)
            {
                i = ((ma) (mp)).a.a;
            }
        } else
        {
            i = ((flag) ? 1 : 0);
            if (mp instanceof mn)
            {
                mp = (mn)mp;
                i = ((flag) ? 1 : 0);
                if (((mn) (mp)).a != null)
                {
                    return ((mn) (mp)).a.a;
                }
            }
        }
        return i;
    }

}
