// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package android.support.v7:
//            aba, abc, ada, acm, 
//            abo, abb

class aeo
    implements aba
{

    private static aeo a;
    private static final Object b = new Object();
    private String c;
    private String d;
    private acm e;
    private abb f;

    private aeo(Context context)
    {
        this(((abb) (abc.a(context))), ((acm) (new ada())));
    }

    aeo(abb abb1, acm acm1)
    {
        f = abb1;
        e = acm1;
    }

    public static aba a(Context context)
    {
        synchronized (b)
        {
            if (a == null)
            {
                a = new aeo(context);
            }
            context = a;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean a(String s)
    {
        if (!e.a())
        {
            abo.b("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        String s1 = s;
        if (c != null)
        {
            s1 = s;
            if (d != null)
            {
                try
                {
                    s1 = (new StringBuilder()).append(c).append("?").append(d).append("=").append(URLEncoder.encode(s, "UTF-8")).toString();
                    abo.d((new StringBuilder()).append("Sending wrapped url hit: ").append(s1).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    abo.b("Error wrapping URL for testing.", s);
                    return false;
                }
            }
        }
        f.a(s1);
        return true;
    }

}
