// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            aa

public final class dp extends aa
{

    private final float a;
    private int b;

    dp(float f, float f1, float f2)
    {
        super(f, f1);
        a = f2;
        b = 1;
    }

    final boolean a(float f, float f1, float f2)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (Math.abs(f1 - b()) > f)
            {
                break label0;
            }
            flag = flag1;
            if (Math.abs(f2 - a()) > f)
            {
                break label0;
            }
            f = Math.abs(f - a);
            if (f > 1.0F)
            {
                flag = flag1;
                if (f / a > 1.0F)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public final float c()
    {
        return a;
    }

    final int d()
    {
        return b;
    }

    final void e()
    {
        b = b + 1;
    }
}
