// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public class fm
    implements fi
{

    private static final bm a = d.a(fm);
    private byte b[];

    public fm(byte abyte0[])
    {
        b = abyte0;
    }

    public final fa a()
    {
        a.b("Unpacking XML dictation results.");
        try
        {
            Object obj = new fp(b);
            ((fl) (obj)).a();
            if (((fl) (obj)).b())
            {
                return ((fl) (obj)).c();
            }
            if (a.b())
            {
                a.b((new StringBuilder("Could not parse XML dictation results: ")).append(((fl) (obj)).d()).append(". Trying to parse NLSML results.").toString());
            }
            fn fn1 = new fn(b);
            fn1.a();
            if (fn1.b())
            {
                return fn1.c();
            }
            obj = (new StringBuilder("Could not parse XML neither NLSML dictation results. Error from XML Parser: ")).append(((fl) (obj)).d()).append(". Error from NLSML Parser: ").append(fn1.d()).toString();
            if (a.e())
            {
                a.e(obj);
            }
            throw new IllegalArgumentException(((String) (obj)));
        }
        catch (IOException ioexception)
        {
            if (a.e())
            {
                a.a("Received IOException while parsing XML/NLSML.", ioexception);
            }
            throw new IllegalArgumentException("Received IOException while parsing XML/NLSML.", ioexception);
        }
    }

}
