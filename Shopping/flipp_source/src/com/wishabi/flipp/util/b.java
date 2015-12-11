// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.database.Cursor;
import java.security.InvalidParameterException;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.util:
//            c, d

public final class b
    implements Iterable, Iterator
{

    static final boolean a;
    private Cursor b;
    private Cursor c;
    private boolean d;
    private d e;
    private int f[];
    private int g[];
    private Object h[];
    private int i[];

    public b(Cursor cursor, String as[], Cursor cursor1, String as1[])
    {
        b = cursor;
        c = cursor1;
        b.moveToFirst();
        c.moveToFirst();
        d = false;
        f = a(cursor, as);
        g = a(cursor1, as1);
        if (cursor.getCount() > 0)
        {
            cursor = a(cursor, f);
        } else
        {
            cursor = a(cursor1, g);
        }
        i = cursor;
        h = new Object[f.length * 2];
    }

    private static int a(Object aobj[], int ai[])
    {
        int k;
        boolean flag;
        flag = false;
        if (aobj.length % 2 != 0)
        {
            throw new IllegalArgumentException("you must specify an even number of values");
        }
        k = 0;
_L7:
label0:
        {
            byte byte0 = flag;
            if (k < aobj.length)
            {
                if (aobj[k] != null)
                {
                    break label0;
                }
                if (aobj[k + 1] == null)
                {
                    break MISSING_BLOCK_LABEL_192;
                }
                byte0 = -1;
            }
            return byte0;
        }
        if (aobj[k + 1] == null)
        {
            return 1;
        }
        ai[k / 2];
        JVM INSTR tableswitch 1 3: default 92
    //                   1 136
    //                   2 163
    //                   3 102;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_163;
_L1:
        throw new InvalidParameterException("Trying to join on unsupported type");
_L4:
        int j = ((String)(String)aobj[k]).compareTo((String)(String)aobj[k + 1]);
_L5:
        if (j != 0)
        {
            return j >= 0 ? 1 : -1;
        }
        break MISSING_BLOCK_LABEL_192;
_L2:
        j = ((Long)(Long)aobj[k]).compareTo((Long)(Long)aobj[k + 1]);
          goto _L5
        j = ((Float)(Float)aobj[k]).compareTo((Float)(Float)aobj[k + 1]);
          goto _L5
        k += 2;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static void a(Object aobj[], int ai[], Cursor cursor, int ai1[], int j)
    {
        int k;
        if (!a && j != 0 && j != 1)
        {
            throw new AssertionError();
        }
        k = 0;
_L2:
        if (k >= ai1.length)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        switch (ai[k])
        {
        default:
            throw new InvalidParameterException("Trying to join on unsupported type");

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_127;

        case 3: // '\003'
            aobj[k * 2 + j] = cursor.getString(ai1[k]);
            break;
        }
_L3:
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        aobj[k * 2 + j] = Long.valueOf(cursor.getLong(ai1[k]));
          goto _L3
        aobj[k * 2 + j] = Float.valueOf(cursor.getFloat(ai1[k]));
          goto _L3
    }

    private static int[] a(Cursor cursor, int ai[])
    {
        int ai1[] = new int[ai.length];
        for (int j = 0; j < ai.length; j++)
        {
            ai1[j] = cursor.getType(ai[j]);
        }

        return ai1;
    }

    private static int[] a(Cursor cursor, String as[])
    {
        int ai[] = new int[as.length];
        for (int j = 0; j < as.length; j++)
        {
            ai[j] = cursor.getColumnIndexOrThrow(as[j]);
        }

        return ai;
    }

    public final boolean hasNext()
    {
        boolean flag = false;
        if (!d) goto _L2; else goto _L1
_L1:
        c.a[e.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 75
    //                   2 103
    //                   3 129;
           goto _L3 _L4 _L5 _L6
_L3:
        throw new IllegalStateException((new StringBuilder("bad value for mCompareResult, ")).append(e).toString());
_L4:
        if (!b.isLast() || !c.isLast())
        {
            flag = true;
        }
_L8:
        return flag;
_L5:
        if (!b.isLast() || !c.isAfterLast())
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!b.isAfterLast() || !c.isLast())
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!b.isAfterLast() || !c.isAfterLast())
        {
            return true;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final Iterator iterator()
    {
        return this;
    }

    public final Object next()
    {
        if (!hasNext())
        {
            throw new IllegalStateException("you must only call next() when hasNext() is true");
        }
        if (!d) goto _L2; else goto _L1
_L1:
        c.a[e.ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 112
    //                   2 86
    //                   3 99;
           goto _L3 _L4 _L5 _L6
_L3:
        d = false;
_L2:
        if (!a && !hasNext())
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L5:
        b.moveToNext();
        continue; /* Loop/switch isn't completed */
_L6:
        c.moveToNext();
        continue; /* Loop/switch isn't completed */
_L4:
        b.moveToNext();
        c.moveToNext();
        if (true) goto _L3; else goto _L7
_L7:
        boolean flag;
        boolean flag1;
        if (!b.isAfterLast())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!c.isAfterLast())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag || !flag1) goto _L9; else goto _L8
_L8:
        a(h, i, b, f, 0);
        a(h, i, c, g, 1);
        a(h, i);
        JVM INSTR tableswitch -1 1: default 248
    //                   -1 268
    //                   0 278
    //                   1 288;
           goto _L10 _L11 _L12 _L13
_L10:
        d = true;
        return e;
_L11:
        e = d.b;
        continue; /* Loop/switch isn't completed */
_L12:
        e = d.c;
        continue; /* Loop/switch isn't completed */
_L13:
        e = d.a;
        continue; /* Loop/switch isn't completed */
_L9:
        if (flag)
        {
            e = d.b;
        } else
        {
            if (!a && !flag1)
            {
                throw new AssertionError();
            }
            e = d.a;
        }
        if (true) goto _L10; else goto _L14
_L14:
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("not implemented");
    }

    static 
    {
        boolean flag;
        if (!com/wishabi/flipp/util/b.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
