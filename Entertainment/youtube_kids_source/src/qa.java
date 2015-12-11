// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Locale;
import java.util.Map;

public class qa
    implements cri
{

    ctr a;
    public long b;
    boolean c;
    private final bkn d;
    private final bmi e;
    private final long f;
    private final String g;
    private String i;

    qa(bkn bkn1, ctr ctr1, bmi bmi1, long l, String s)
    {
        i = "0";
        d = bkn1;
        a = ctr1;
        e = bmi1;
        f = l;
        g = s;
    }

    private static String a(long l)
    {
        return String.format(Locale.US, "%.1f", new Object[] {
            Double.valueOf((double)l / 1000D)
        });
    }

    public final String a()
    {
        return qa.getSimpleName();
    }

    public final String a(Uri uri, String s)
    {
        uri = (Integer)qb.a.get(s);
        if (uri == null)
        {
            return null;
        }
        switch (uri.intValue())
        {
        default:
            return null;

        case 1: // '\001'
            return a(b);

        case 4: // '\004'
            return String.valueOf(d.g());

        case 2: // '\002'
            return g;

        case 5: // '\005'
            return a(e.b() - f);

        case 3: // '\003'
            if (c)
            {
                return "playing";
            } else
            {
                return "pause";
            }

        case 6: // '\006'
            break;
        }
        if (a != null)
        {
            return String.valueOf(a.g);
        } else
        {
            return i;
        }
    }
}
