// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfh
    implements cri
{

    public buz a;
    public bfz b;
    public Pattern c;
    public csg d;
    public bcw e;
    public boolean f;
    public long g;
    private final String i;
    private final Random j;
    private final bde k;
    private String l;
    private String m;

    bfh(String s, Random random, bde bde1)
    {
        d = null;
        e = null;
        j = random;
        random = String.valueOf("a.");
        s = String.valueOf(s);
        if (s.length() != 0)
        {
            s = random.concat(s);
        } else
        {
            s = new String(random);
        }
        i = s;
        k = bde1;
        bde1.a();
    }

    private boolean a(Uri uri)
    {
        return c != null && c.matcher(uri.toString()).find();
    }

    public final String a()
    {
        return bfh.getSimpleName();
    }

    public final String a(Uri uri, String s)
    {
        s = (Integer)bfj.a.get(s);
        if (s == null)
        {
            return null;
        }
        switch (s.intValue())
        {
        case 4: // '\004'
        case 10: // '\n'
        case 12: // '\f'
        case 16: // '\020'
        case 17: // '\021'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 31: // '\037'
        case 33: // '!'
        case 34: // '"'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        default:
            return null;

        case 49: // '1'
            if (e != null)
            {
                return e.a.a();
            } else
            {
                return "";
            }

        case 1: // '\001'
            if (a != null && a.g() != null)
            {
                return a.g().toString();
            } else
            {
                return "";
            }

        case 2: // '\002'
            return Integer.toString(j.nextInt(0x55d4a7f) + 0x989680);

        case 3: // '\003'
            return "00:00:00.000";

        case 5: // '\005'
            return TextUtils.join(",", a.U);

        case 6: // '\006'
            if (a != null)
            {
                return a.R;
            } else
            {
                return "";
            }

        case 7: // '\007'
            if (a != null)
            {
                return Integer.toString(a.k * 1000);
            } else
            {
                return "0";
            }

        case 8: // '\b'
            if (a != null)
            {
                return a.Q;
            } else
            {
                return "";
            }

        case 9: // '\t'
            if (a != null && !TextUtils.isEmpty(a.c))
            {
                return a.c;
            } else
            {
                return "0";
            }

        case 11: // '\013'
            if (b != null)
            {
                return Integer.toString(b.a.c.d);
            } else
            {
                return "0";
            }

        case 13: // '\r'
            return "0";

        case 14: // '\016'
            if (m != null)
            {
                return m;
            } else
            {
                return "";
            }

        case 15: // '\017'
            if (l != null)
            {
                return l;
            } else
            {
                return "";
            }

        case 18: // '\022'
            return "detailpage";

        case 19: // '\023'
            if (a != null && a.i != null)
            {
                return a.i.e;
            } else
            {
                return "0";
            }

        case 20: // '\024'
            if (a != null)
            {
                uri = a;
                if (((buz) (uri)).V != null)
                {
                    uri = bvb.c;
                } else
                if (uri.f())
                {
                    uri = bvb.b;
                } else
                {
                    uri = bvb.a;
                }
                return ((bvb) (uri)).d;
            } else
            {
                return "0";
            }

        case 21: // '\025'
            if (a != null)
            {
                return "2";
            } else
            {
                return "0";
            }

        case 26: // '\032'
            if (b != null && b.a.c == bfr.b)
            {
                return Long.toString(TimeUnit.MILLISECONDS.toSeconds(b.a.b));
            } else
            {
                return "0";
            }

        case 27: // '\033'
            return "0";

        case 28: // '\034'
            if (d != null)
            {
                return String.valueOf(d.a.g);
            } else
            {
                return "0";
            }

        case 29: // '\035'
            return "0";

        case 30: // '\036'
            if (a != null && a.S != null)
            {
                return a.S;
            } else
            {
                return "";
            }

        case 32: // ' '
            return "0";

        case 35: // '#'
            if (a != null && !a.d())
            {
                return "1";
            } else
            {
                return "0";
            }

        case 37: // '%'
            return "DROID";

        case 38: // '&'
            return android.os.Build.VERSION.RELEASE;

        case 39: // '\''
            return "UNWN";

        case 36: // '$'
            if (a(uri) && k.b != null)
            {
                return k.b;
            } else
            {
                return "";
            }

        case 40: // '('
            return "MBL";

        case 41: // ')'
            return i;

        case 42: // '*'
            return "a";

        case 43: // '+'
            return "android";

        case 44: // ','
            return Build.MODEL;

        case 45: // '-'
            if (a(uri) && k.b != null)
            {
                return k.b;
            } else
            {
                return "none";
            }

        case 50: // '2'
            if (a != null && g > 0L)
            {
                return String.format(Locale.US, "%.1f", new Object[] {
                    Double.valueOf((double)g / 1000D)
                });
            } else
            {
                return "0.0";
            }

        case 51: // '3'
            if (a != null)
            {
                return a.g;
            } else
            {
                return "";
            }

        case 52: // '4'
            break;
        }
        if (a != null)
        {
            if (f)
            {
                return "playing";
            } else
            {
                return "pause";
            }
        } else
        {
            return "";
        }
    }

    public final void a(String s, String s1)
    {
        l = s1;
        m = s;
    }
}
