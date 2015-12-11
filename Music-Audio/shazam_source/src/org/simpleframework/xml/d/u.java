// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.util.Date;
import java.util.GregorianCalendar;

// Referenced classes of package org.simpleframework.xml.d:
//            ag, n

final class u
    implements ag
{

    private final n a;

    public u()
    {
        this(java/util/Date);
    }

    private u(Class class1)
    {
        a = new n(class1);
    }

    public final Object a(String s)
    {
        s = a.b(s);
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        if (s != null)
        {
            gregoriancalendar.setTime(s);
        }
        return gregoriancalendar;
    }

    public final String a(Object obj)
    {
        obj = (GregorianCalendar)obj;
        return a.a(((GregorianCalendar) (obj)).getTime());
    }
}
