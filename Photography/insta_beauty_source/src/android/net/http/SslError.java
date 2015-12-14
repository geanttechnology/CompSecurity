// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.net.http;


// Referenced classes of package android.net.http:
//            SslCertificate

public class SslError
{

    int a;
    SslCertificate b;

    public SslCertificate a()
    {
        return b;
    }

    public int b()
    {
        if (a != 0)
        {
            for (int i = 3; i >= 0; i--)
            {
                if ((a & 1 << i) != 0)
                {
                    return i;
                }
            }

        }
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("primary error: ").append(b()).append(" certificate: ").append(a()).toString();
    }
}
