// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.i;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package b.a.a.d:
//            t, x, d, a, 
//            u

final class c
    implements t, x
{

    private static final Map a = new HashMap();
    private final int b = 3;
    private final int c = 4;
    private final int d = 0;

    c()
    {
    }

    private d a(Locale locale)
    {
        Locale locale1;
        String s;
        locale1 = locale;
        if (locale == null)
        {
            locale1 = Locale.getDefault();
        }
        s = (new StringBuilder()).append(Integer.toString(d + (b << 4) + (c << 8))).append(locale1.toString()).toString();
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        d d1 = (d)a.get(s);
        locale = d1;
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        locale = null;
        d;
        JVM INSTR tableswitch 0 2: default 221
    //                   0 153
    //                   1 165
    //                   2 177;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_177;
_L5:
        if (!(locale instanceof SimpleDateFormat))
        {
            throw new IllegalArgumentException((new StringBuilder("No datetime pattern for locale: ")).append(locale1).toString());
        }
        break MISSING_BLOCK_LABEL_193;
        locale;
        map;
        JVM INSTR monitorexit ;
        throw locale;
_L2:
        locale = DateFormat.getDateInstance(b, locale1);
          goto _L5
_L3:
        locale = DateFormat.getTimeInstance(c, locale1);
          goto _L5
        locale = DateFormat.getDateTimeInstance(b, c, locale1);
          goto _L5
        locale = b.a.a.d.a.a(((SimpleDateFormat)locale).toPattern());
        a.put(s, locale);
        map;
        JVM INSTR monitorexit ;
        return locale;
    }

    public final int a()
    {
        return 40;
    }

    public final int a(u u1, String s, int i)
    {
        return a(u1.d).b.a(u1, s, i);
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int i, i j, Locale locale)
    {
        a(locale).a.a(stringbuffer, l, a1, i, j, locale);
    }

    public final void a(StringBuffer stringbuffer, aa aa, Locale locale)
    {
        a(locale).a.a(stringbuffer, aa, locale);
    }

    public final int b()
    {
        return 40;
    }

}
