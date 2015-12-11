// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.b;

import android.util.Log;
import java.util.HashMap;
import org.b.a.b;
import org.b.a.c;

final class a extends b
{

    a(String s)
    {
        b = s;
    }

    private void a(int i, String s, Throwable throwable)
    {
        if (a(i))
        {
            b(i, s, throwable);
        }
    }

    private transient void a(int i, String s, Object aobj[])
    {
        if (!a(i)) goto _L2; else goto _L1
_L1:
        Object obj;
        if (aobj == null || aobj.length == 0)
        {
            obj = null;
        } else
        {
            obj = aobj[aobj.length - 1];
            if (obj instanceof Throwable)
            {
                obj = (Throwable)obj;
            } else
            {
                obj = null;
            }
        }
        if (s != null) goto _L4; else goto _L3
_L3:
        s = new org.b.a.a(null, aobj, ((Throwable) (obj)));
_L6:
        b(i, ((org.b.a.a) (s)).b, ((org.b.a.a) (s)).c);
_L2:
        return;
_L4:
        if (aobj == null)
        {
            s = new org.b.a.a(s);
            continue; /* Loop/switch isn't completed */
        }
        StringBuilder stringbuilder = new StringBuilder(s.length() + 50);
        int k = 0;
        int j = 0;
        do
        {
            if (k >= aobj.length)
            {
                break;
            }
            int l = s.indexOf("{}", j);
            if (l == -1)
            {
                if (j == 0)
                {
                    s = new org.b.a.a(s, aobj, ((Throwable) (obj)));
                } else
                {
                    stringbuilder.append(s.substring(j, s.length()));
                    s = new org.b.a.a(stringbuilder.toString(), aobj, ((Throwable) (obj)));
                }
                continue; /* Loop/switch isn't completed */
            }
            boolean flag;
            if (l != 0 && s.charAt(l - 1) == '\\')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (l >= 2 && s.charAt(l - 2) == '\\')
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    k--;
                    stringbuilder.append(s.substring(j, l - 1));
                    stringbuilder.append('{');
                    j = l + 1;
                } else
                {
                    stringbuilder.append(s.substring(j, l - 1));
                    org.b.a.c.a(stringbuilder, aobj[k], new HashMap());
                    j = l + 2;
                }
            } else
            {
                stringbuilder.append(s.substring(j, l));
                org.b.a.c.a(stringbuilder, aobj[k], new HashMap());
                j = l + 2;
            }
            k++;
        } while (true);
        stringbuilder.append(s.substring(j, s.length()));
        if (k < aobj.length - 1)
        {
            s = new org.b.a.a(stringbuilder.toString(), aobj, ((Throwable) (obj)));
        } else
        {
            s = new org.b.a.a(stringbuilder.toString(), aobj, null);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean a(int i)
    {
        return Log.isLoggable(b, i);
    }

    private void b(int i, String s, Throwable throwable)
    {
        String s1 = s;
        if (throwable != null)
        {
            s1 = (new StringBuilder()).append(s).append('\n').append(Log.getStackTraceString(throwable)).toString();
        }
        Log.println(i, b, s1);
    }

    public final void a(String s)
    {
        a(2, s, ((Throwable) (null)));
    }

    public final void a(String s, Object obj)
    {
        a(3, s, new Object[] {
            obj
        });
    }

    public final void a(String s, Object obj, Object obj1)
    {
        a(3, s, new Object[] {
            obj, obj1
        });
    }

    public final void a(String s, Throwable throwable)
    {
        a(2, s, throwable);
    }

    public final transient void a(String s, Object aobj[])
    {
        a(2, s, aobj);
    }

    public final void b(String s)
    {
        a(6, s, ((Throwable) (null)));
    }

    public final void b(String s, Throwable throwable)
    {
        a(6, s, throwable);
    }

    public final transient void b(String s, Object aobj[])
    {
        a(3, s, aobj);
    }

    public final boolean b()
    {
        return a(3);
    }

    public final transient void c(String s, Object aobj[])
    {
        a(4, s, aobj);
    }

    public final transient void d(String s, Object aobj[])
    {
        a(5, s, aobj);
    }

    public final transient void e(String s, Object aobj[])
    {
        a(6, s, aobj);
    }
}
