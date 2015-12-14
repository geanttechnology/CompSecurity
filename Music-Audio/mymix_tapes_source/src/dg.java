// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public class dg
{

    private static final bm a = d.a(dg);

    private dg()
    {
    }

    public static df a(String s, short word0, String s1, byte abyte0[], String s2, bi bi, bi bi1, String s3, 
            Vector vector, dh dh)
    {
        if (a.b())
        {
            a.b("createManager");
        }
        if (s == null || s.length() == 0)
        {
            a.e("NullPointerException gatewayIP is NULL. ");
            throw new NullPointerException("gatewayIP must be provided!");
        }
        if (word0 <= 0)
        {
            a.e("IllegalArgumentException gatewayPort is invalid. ");
            throw new IllegalArgumentException("gatewayPort invalid value!");
        }
        if (s1 == null)
        {
            a.e("NullPointerException applicationId is NULL. ");
            throw new NullPointerException("Application id can not be null!");
        }
        if (abyte0 == null)
        {
            a.e("NullPointerException appKey is NULL. ");
            throw new NullPointerException("Application key can not be null!");
        }
        if (s2 == null)
        {
            a.e("NullPointerException uid is NULL. ");
            throw new NullPointerException("uid can not be null!");
        }
        if (bi == null)
        {
            a.e("NullPointerException inputCodec is NULL. ");
            throw new NullPointerException("inputCodec can not be null!");
        }
        if (bi1 == null)
        {
            a.e("NullPointerException outputCodec is NULL. ");
            throw new NullPointerException("outputCodec can not be null!");
        }
        if (dh == null)
        {
            a.e("NullPointerException managerListener is NULL. ");
            throw new NullPointerException("managerListener can not be null!");
        }
        if (vector != null)
        {
            for (int i = 0; i < vector.size(); i++)
            {
                cz cz1 = (cz)vector.elementAt(i);
                if (cz1.d() == cz.a.e || cz1.d() == cz.a.f || cz1.d() == cz.a.g || cz1.d() == cz.a.h || cz1.d() == cz.a.d || cz1.d() == cz.a.i || cz1.d() == cz.a.j)
                {
                    a.e((new StringBuilder("IllegalArgumentException Parameter type: ")).append(cz1.d()).append(" not allowed. ").toString());
                    throw new IllegalArgumentException((new StringBuilder("Parameter type: ")).append(cz1.d()).append(" not allowed. ").toString());
                }
            }

        }
        return new dl(s, word0, s1, abyte0, s2, bi, bi1, s3, vector, dh);
    }

}
