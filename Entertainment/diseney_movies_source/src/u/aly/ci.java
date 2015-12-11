// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package u.aly:
//            dk, da, cf, bz, 
//            cy

public class ci
{

    private final ByteArrayOutputStream a;
    private final dk b;
    private cy c;

    public ci()
    {
        this(((da) (new cs.a())));
    }

    public ci(da da1)
    {
        a = new ByteArrayOutputStream();
        b = new dk(a);
        c = da1.a(b);
    }

    public String a(bz bz1, String s)
        throws cf
    {
        try
        {
            bz1 = new String(a(bz1), s);
        }
        // Misplaced declaration of an exception variable
        catch (bz bz1)
        {
            throw new cf((new StringBuilder("JVM DOES NOT SUPPORT ENCODING: ")).append(s).toString());
        }
        return bz1;
    }

    public byte[] a(bz bz1)
        throws cf
    {
        a.reset();
        bz1.b(c);
        return a.toByteArray();
    }

    public String b(bz bz1)
        throws cf
    {
        return new String(a(bz1));
    }
}
