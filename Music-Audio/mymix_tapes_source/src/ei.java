// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public class ei
{

    private static final bm a = d.a(ei);

    private ei()
    {
    }

    public static eh a(df df, dk dk, Vector vector)
    {
        if (a.b())
        {
            a.b("createNMASResource");
        }
        if (df == null)
        {
            a.e("manager is null");
            throw new NullPointerException("manager can not be null!");
        }
        if (dk == null)
        {
            a.e("nmasListener is null");
            throw new NullPointerException("nmasListener can not be null!");
        }
        if (vector != null)
        {
            for (int i = 0; i < vector.size(); i++)
            {
                cz cz1 = (cz)vector.elementAt(i);
                if (cz1.d() == cz.a.c || cz1.d() == cz.a.d || cz1.d() == cz.a.e || cz1.d() == cz.a.f || cz1.d() == cz.a.g || cz1.d() == cz.a.h || cz1.d() == cz.a.i || cz1.d() == cz.a.j)
                {
                    a.e((new StringBuilder("IllegalArgumentException Parameter type: ")).append(cz1.d()).append(" not allowed. ").toString());
                    throw new IllegalArgumentException((new StringBuilder("Parameter type: ")).append(cz1.d()).append(" not allowed. ").toString());
                }
            }

        }
        return new dp((dl)df, dk, vector);
    }

}
