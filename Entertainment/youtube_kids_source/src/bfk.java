// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Map;

public class bfk
    implements cri
{

    private final bmi a;
    private final bme b;
    private final bkn c;
    private final bnm d;
    private final String e;

    public bfk(String s, bmi bmi1, bme bme1, bkn bkn1, bnm bnm1)
    {
        String s1 = String.valueOf("a.");
        s = String.valueOf(s);
        if (s.length() != 0)
        {
            s = s1.concat(s);
        } else
        {
            s = new String(s1);
        }
        e = s;
        a = bmi1;
        b = bme1;
        c = bkn1;
        d = bnm1;
    }

    public final String a()
    {
        return bfk.getSimpleName();
    }

    public final String a(Uri uri, String s)
    {
        uri = (Integer)bfj.a.get(s);
        if (uri == null)
        {
            return null;
        }
        switch (uri.intValue())
        {
        default:
            return null;

        case 12: // '\f'
            if (c != null)
            {
                return String.valueOf(c.g());
            } else
            {
                return "0";
            }

        case 25: // '\031'
            if (b == null)
            {
                bmo.c("userPresenceTracker is not supported and should not expect receiving LACT macro");
                return "-1";
            } else
            {
                return String.valueOf(b.b());
            }

        case 31: // '\037'
            return e;

        case 33: // '!'
            if (d != null)
            {
                return Integer.toString(Math.round(100F * d.a()));
            } else
            {
                return "0";
            }

        case 34: // '"'
            return Long.toString(a.a());
        }
    }
}
