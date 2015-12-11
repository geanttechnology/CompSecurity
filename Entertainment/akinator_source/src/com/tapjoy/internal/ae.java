// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.util.Log;
import java.util.HashMap;

// Referenced classes of package com.tapjoy.internal:
//            hw, hx

public final class ae
{

    public static void a(int i, String s, String s1, Throwable throwable)
    {
        if (s1 != null)
        {
            Log.println(i, s, s1);
        }
        if (throwable != null)
        {
            Log.println(i, s, Log.getStackTraceString(throwable));
        }
    }

    public static transient void a(int i, String s, String s1, Object aobj[])
    {
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
        if (s1 != null) goto _L2; else goto _L1
_L1:
        s1 = new hw(null, aobj, ((Throwable) (obj)));
_L4:
        a(i, s, s1.a(), s1.b());
        return;
_L2:
        if (aobj == null)
        {
            s1 = new hw(s1);
            continue; /* Loop/switch isn't completed */
        }
        StringBuffer stringbuffer = new StringBuffer(s1.length() + 50);
        int k = 0;
        int j = 0;
        do
        {
            if (k >= aobj.length)
            {
                break;
            }
            int l = s1.indexOf("{}", j);
            if (l == -1)
            {
                if (j == 0)
                {
                    s1 = new hw(s1, aobj, ((Throwable) (obj)));
                } else
                {
                    stringbuffer.append(s1.substring(j, s1.length()));
                    s1 = new hw(stringbuffer.toString(), aobj, ((Throwable) (obj)));
                }
                continue; /* Loop/switch isn't completed */
            }
            boolean flag;
            if (l != 0 && s1.charAt(l - 1) == '\\')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (l >= 2 && s1.charAt(l - 2) == '\\')
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    k--;
                    stringbuffer.append(s1.substring(j, l - 1));
                    stringbuffer.append('{');
                    j = l + 1;
                } else
                {
                    stringbuffer.append(s1.substring(j, l - 1));
                    hx.a(stringbuffer, aobj[k], new HashMap());
                    j = l + 2;
                }
            } else
            {
                stringbuffer.append(s1.substring(j, l));
                hx.a(stringbuffer, aobj[k], new HashMap());
                j = l + 2;
            }
            k++;
        } while (true);
        stringbuffer.append(s1.substring(j, s1.length()));
        if (k < aobj.length - 1)
        {
            s1 = new hw(stringbuffer.toString(), aobj, ((Throwable) (obj)));
        } else
        {
            s1 = new hw(stringbuffer.toString(), aobj, null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient void a(String s, String s1, Object aobj[])
    {
        a(6, s, s1, aobj);
    }
}
