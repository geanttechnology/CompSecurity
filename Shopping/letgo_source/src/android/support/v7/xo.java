// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            xl, xm, xn

public class xo
{

    public xo()
    {
    }

    public xn a()
    {
        if (b() < 8)
        {
            return new xl();
        } else
        {
            return new xm();
        }
    }

    int b()
    {
        return android.os.Build.VERSION.SDK_INT;
    }
}
