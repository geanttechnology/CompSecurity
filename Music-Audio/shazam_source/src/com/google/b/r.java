// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.a;
import com.google.b.b.f;
import java.math.BigInteger;

// Referenced classes of package com.google.b:
//            l

public final class r extends l
{

    private static final Class b[];
    public Object a;

    public r(Boolean boolean1)
    {
        a(boolean1);
    }

    public r(Number number)
    {
        a(number);
    }

    public r(String s)
    {
        a(s);
    }

    private void a(Object obj)
    {
        boolean flag;
        flag = false;
        if (obj instanceof Character)
        {
            a = String.valueOf(((Character)obj).charValue());
            return;
        }
        if (obj instanceof Number) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof String)) goto _L4; else goto _L3
_L3:
        int i = 1;
_L7:
        if (i == 0) goto _L5; else goto _L2
_L2:
        flag = true;
_L5:
        com.google.b.b.a.a(flag);
        a = obj;
        return;
_L4:
        Class class1 = obj.getClass();
        Class aclass[] = b;
        int j = aclass.length;
        i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            if (aclass[i].isAssignableFrom(class1))
            {
                i = 1;
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        i = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static boolean a(r r1)
    {
        if (r1.a instanceof Number)
        {
            r1 = (Number)r1.a;
            return (r1 instanceof BigInteger) || (r1 instanceof Long) || (r1 instanceof Integer) || (r1 instanceof Short) || (r1 instanceof Byte);
        } else
        {
            return false;
        }
    }

    public final Number a()
    {
        if (a instanceof String)
        {
            return new f((String)a);
        } else
        {
            return (Number)a;
        }
    }

    public final String b()
    {
        if (a instanceof Number)
        {
            return a().toString();
        }
        if (a instanceof Boolean)
        {
            return ((Boolean)a).toString();
        } else
        {
            return (String)a;
        }
    }

    public final double c()
    {
        if (a instanceof Number)
        {
            return a().doubleValue();
        } else
        {
            return Double.parseDouble(b());
        }
    }

    public final long d()
    {
        if (a instanceof Number)
        {
            return a().longValue();
        } else
        {
            return Long.parseLong(b());
        }
    }

    public final int e()
    {
        if (a instanceof Number)
        {
            return a().intValue();
        } else
        {
            return Integer.parseInt(b());
        }
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (r)obj;
        if (a != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((r) (obj)).a != null)
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!a(this) || !a(((r) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        if (a().longValue() != ((r) (obj)).a().longValue())
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if ((a instanceof Number) && (((r) (obj)).a instanceof Number))
        {
            double d1 = a().doubleValue();
            double d2 = ((r) (obj)).a().doubleValue();
            if (d1 != d2 && (!Double.isNaN(d1) || !Double.isNaN(d2)))
            {
                return false;
            }
        } else
        {
            return a.equals(((r) (obj)).a);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final boolean f()
    {
        if (a instanceof Boolean)
        {
            return ((Boolean)a).booleanValue();
        } else
        {
            return Boolean.parseBoolean(b());
        }
    }

    public final int hashCode()
    {
        if (a == null)
        {
            return 31;
        }
        if (a(this))
        {
            long l1 = a().longValue();
            return (int)(l1 ^ l1 >>> 32);
        }
        if (a instanceof Number)
        {
            long l2 = Double.doubleToLongBits(a().doubleValue());
            return (int)(l2 ^ l2 >>> 32);
        } else
        {
            return a.hashCode();
        }
    }

    static 
    {
        b = (new Class[] {
            Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, java/lang/Integer, java/lang/Long, 
            java/lang/Short, java/lang/Float, java/lang/Double, java/lang/Byte, java/lang/Boolean, java/lang/Character
        });
    }
}
