// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

public final class bdp
{

    private static final Map a = new bdq();
    private static final Map b = new bdr();
    private static final bnq c = (new bnr()).a("/document", new bdv()).a("/document/question", new bdu()).a("/document/question/options", new bdt()).a("/document/question/additional_beacon_urls", new bds()).a();
    private final bns d;

    public bdp(bns bns1)
    {
        d = (bns)b.a(bns1);
    }

    static Map a()
    {
        return a;
    }

    static String b(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.decode(s);
        }
    }

    static Map b()
    {
        return b;
    }

    public final bup a(String s)
    {
        s = new ByteArrayInputStream(s.getBytes());
        try
        {
            s = ((bur)d.a(s, c)).a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new bnn(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new bnn(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new bnn(s);
        }
        return s;
    }

}
