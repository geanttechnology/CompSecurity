// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package org.simpleframework.xml.d:
//            z, g, v, y, 
//            q, t, ac, h, 
//            j, ae, k, n, 
//            x, l, u, af, 
//            c, d, aj, s, 
//            e, f, r, ag

final class aa
    implements z
{

    public aa()
    {
    }

    public final ag a(Class class1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = class1.getName();
        if (!((String) (obj)).startsWith("java.lang")) goto _L2; else goto _L1
_L1:
        if (class1 != java/lang/Boolean) goto _L4; else goto _L3
_L3:
        obj = new g();
_L6:
        return ((ag) (obj));
_L4:
        if (class1 == java/lang/Integer)
        {
            return new v();
        }
        if (class1 == java/lang/Long)
        {
            return new y();
        }
        if (class1 == java/lang/Double)
        {
            return new q();
        }
        if (class1 == java/lang/Float)
        {
            return new t();
        }
        if (class1 == java/lang/Short)
        {
            return new ac();
        }
        if (class1 == java/lang/Byte)
        {
            return new h();
        }
        if (class1 == java/lang/Character)
        {
            return new j();
        }
        if (class1 == java/lang/String)
        {
            return new ae();
        }
        obj = obj1;
        if (class1 == java/lang/Class)
        {
            return new k();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!((String) (obj)).startsWith("java.util"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (class1 == java/util/Date)
        {
            return new n(class1);
        }
        if (class1 == java/util/Locale)
        {
            return new x();
        }
        if (class1 == java/util/Currency)
        {
            return new l();
        }
        if (class1 == java/util/GregorianCalendar)
        {
            return new u();
        }
        if (class1 == java/util/TimeZone)
        {
            return new af();
        }
        if (class1 == java/util/concurrent/atomic/AtomicInteger)
        {
            return new c();
        }
        obj = obj1;
        if (class1 == java/util/concurrent/atomic/AtomicLong)
        {
            return new d();
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!((String) (obj)).startsWith("java.net"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (class1 == java/net/URL)
        {
            return new aj();
        }
        if (true) goto _L6; else goto _L7
_L7:
        if (!((String) (obj)).startsWith("java.io"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (class1 == java/io/File)
        {
            return new s();
        }
        if (true) goto _L6; else goto _L8
_L8:
        if (!((String) (obj)).startsWith("java.sql"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (class1 == java/sql/Time)
        {
            return new n(class1);
        }
        if (class1 == java/sql/Date)
        {
            return new n(class1);
        }
        obj = obj1;
        if (class1 == java/sql/Timestamp)
        {
            return new n(class1);
        }
        if (true) goto _L6; else goto _L9
_L9:
        if (!((String) (obj)).startsWith("java.math"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (class1 == java/math/BigDecimal)
        {
            return new e();
        }
        obj = obj1;
        if (class1 == java/math/BigInteger)
        {
            return new f();
        }
        if (true) goto _L6; else goto _L10
_L10:
        Class class2 = class1.getSuperclass();
        obj = obj1;
        if (class2 != null)
        {
            if (class2.isEnum())
            {
                return new r(class1);
            }
            obj = obj1;
            if (class1.isEnum())
            {
                return new r(class1);
            }
        }
        if (true) goto _L6; else goto _L11
_L11:
    }
}
