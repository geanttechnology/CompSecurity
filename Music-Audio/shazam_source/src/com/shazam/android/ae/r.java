// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import com.shazam.android.j.q.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.shazam.android.ae:
//            j

public final class r
    implements j
{

    private final MessageFormat b;

    public r()
    {
        b = new MessageFormat("Package: {0}\nVersion: {1}\nOS: {2}\nManufacturer: {3}\nModel: {4}\nDate: {5}\n\n{6}", Locale.UK);
    }

    public final String a(a a1, Throwable throwable, Date date)
    {
        String s = a1.b;
        int i = a1.c;
        String s1 = a1.d;
        String s2 = a1.e;
        a1 = a1.f;
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        throwable = stringwriter.toString();
        return b.format(((Object) (new Object[] {
            s, String.valueOf(i), s1, s2, a1, date, throwable
        })));
    }
}
