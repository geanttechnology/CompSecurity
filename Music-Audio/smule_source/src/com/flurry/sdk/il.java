// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.math.BigInteger;

// Referenced classes of package com.flurry.sdk:
//            ig, jd, iy

public final class il extends ig
{

    private static final Class a[];
    private Object b;

    public il(Boolean boolean1)
    {
        a(boolean1);
    }

    public il(Number number)
    {
        a(number);
    }

    public il(String s)
    {
        a(s);
    }

    private static boolean a(il il1)
    {
        if (il1.b instanceof Number)
        {
            il1 = (Number)il1.b;
            return (il1 instanceof BigInteger) || (il1 instanceof Long) || (il1 instanceof Integer) || (il1 instanceof Short) || (il1 instanceof Byte);
        } else
        {
            return false;
        }
    }

    private static boolean b(Object obj)
    {
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        obj = obj.getClass();
        Class aclass[] = a;
        int j = aclass.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (aclass[i].isAssignableFrom(((Class) (obj))))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public Number a()
    {
        if (b instanceof String)
        {
            return new jd((String)b);
        } else
        {
            return (Number)b;
        }
    }

    void a(Object obj)
    {
        if (obj instanceof Character)
        {
            b = String.valueOf(((Character)obj).charValue());
            return;
        }
        boolean flag;
        if ((obj instanceof Number) || b(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iy.a(flag);
        b = obj;
    }

    public String b()
    {
        if (p())
        {
            return a().toString();
        }
        if (o())
        {
            return n().toString();
        } else
        {
            return (String)b;
        }
    }

    public double c()
    {
        if (p())
        {
            return a().doubleValue();
        } else
        {
            return Double.parseDouble(b());
        }
    }

    public long d()
    {
        if (p())
        {
            return a().longValue();
        } else
        {
            return Long.parseLong(b());
        }
    }

    public int e()
    {
        if (p())
        {
            return a().intValue();
        } else
        {
            return Integer.parseInt(b());
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (il)obj;
        if (b != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((il) (obj)).b != null)
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!a(this) || !a(((il) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        if (a().longValue() != ((il) (obj)).a().longValue())
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
label0:
        {
            boolean flag;
label1:
            {
                if (!(b instanceof Number) || !(((il) (obj)).b instanceof Number))
                {
                    break label0;
                }
                double d1 = a().doubleValue();
                double d2 = ((il) (obj)).a().doubleValue();
                if (d1 != d2)
                {
                    flag = flag1;
                    if (!Double.isNaN(d1))
                    {
                        break label1;
                    }
                    flag = flag1;
                    if (!Double.isNaN(d2))
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            return flag;
        }
        return b.equals(((il) (obj)).b);
    }

    public boolean f()
    {
        if (o())
        {
            return n().booleanValue();
        } else
        {
            return Boolean.parseBoolean(b());
        }
    }

    public int hashCode()
    {
        if (b == null)
        {
            return 31;
        }
        if (a(this))
        {
            long l = a().longValue();
            return (int)(l ^ l >>> 32);
        }
        if (b instanceof Number)
        {
            long l1 = Double.doubleToLongBits(a().doubleValue());
            return (int)(l1 ^ l1 >>> 32);
        } else
        {
            return b.hashCode();
        }
    }

    Boolean n()
    {
        return (Boolean)b;
    }

    public boolean o()
    {
        return b instanceof Boolean;
    }

    public boolean p()
    {
        return b instanceof Number;
    }

    public boolean q()
    {
        return b instanceof String;
    }

    static 
    {
        a = (new Class[] {
            Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, java/lang/Integer, java/lang/Long, 
            java/lang/Short, java/lang/Float, java/lang/Double, java/lang/Byte, java/lang/Boolean, java/lang/Character
        });
    }
}
