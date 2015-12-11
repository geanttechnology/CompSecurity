// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Color;
import java.util.Arrays;
import org.json.JSONObject;

public final class avm
{

    float a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    String i;
    int j;
    int k;
    JSONObject l;

    public avm()
    {
        a();
    }

    static int a(String s)
    {
        boolean flag = false;
        int i1 = ((flag) ? 1 : 0);
        if (s != null)
        {
            i1 = ((flag) ? 1 : 0);
            if (s.length() == 9)
            {
                i1 = ((flag) ? 1 : 0);
                if (s.charAt(0) == '#')
                {
                    try
                    {
                        i1 = Integer.parseInt(s.substring(1, 3), 16);
                        int j1 = Integer.parseInt(s.substring(3, 5), 16);
                        int k1 = Integer.parseInt(s.substring(5, 7), 16);
                        i1 = Color.argb(Integer.parseInt(s.substring(7, 9), 16), i1, j1, k1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return 0;
                    }
                }
            }
        }
        return i1;
    }

    void a()
    {
        a = 1.0F;
        b = 0;
        c = 0;
        d = -1;
        e = 0;
        f = -1;
        g = 0;
        h = 0;
        i = null;
        j = -1;
        k = -1;
        l = null;
    }

    public final boolean equals(Object obj)
    {
        boolean flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag3;
        if (!(obj instanceof avm))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (avm)obj;
        boolean flag;
        boolean flag1;
        if (l == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((avm) (obj)).l == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag != flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l == null || ((avm) (obj)).l == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!ayf.a(l, ((avm) (obj)).l)) goto _L4; else goto _L3
_L3:
        flag2 = flag3;
        if (a == ((avm) (obj)).a)
        {
            flag2 = flag3;
            if (b == ((avm) (obj)).b)
            {
                flag2 = flag3;
                if (c == ((avm) (obj)).c)
                {
                    flag2 = flag3;
                    if (d == ((avm) (obj)).d)
                    {
                        flag2 = flag3;
                        if (e == ((avm) (obj)).e)
                        {
                            flag2 = flag3;
                            if (f == ((avm) (obj)).f)
                            {
                                flag2 = flag3;
                                if (h == ((avm) (obj)).h)
                                {
                                    flag2 = flag3;
                                    if (a.g(i, ((avm) (obj)).i))
                                    {
                                        flag2 = flag3;
                                        if (j == ((avm) (obj)).j)
                                        {
                                            flag2 = flag3;
                                            if (k == ((avm) (obj)).k)
                                            {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Float.valueOf(a), Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(h), i, Integer.valueOf(j), 
            Integer.valueOf(k), l
        });
    }
}
