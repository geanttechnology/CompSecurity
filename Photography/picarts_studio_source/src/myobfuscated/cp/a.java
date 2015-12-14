// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cp;

import com.socialin.android.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import myobfuscated.cb.c;

// Referenced classes of package myobfuscated.cp:
//            d, b, c

public final class a
{

    public static boolean a;
    List b;
    ArrayList c;
    private int d;

    public a()
    {
        d = 2;
        b = Collections.emptyList();
        c = new ArrayList();
    }

    private boolean b(String s, String s1, c c1, String s2)
    {
        myobfuscated.cp.d d1;
        if (b.isEmpty())
        {
            b = new ArrayList();
        } else
        {
            int i = 0;
            while (i < b.size()) 
            {
                myobfuscated.cp.d d2 = (myobfuscated.cp.d)b.get(i);
                if (d2.a.equals(s))
                {
                    d2.d = new WeakReference(c1);
                    return false;
                }
                i++;
            }
        }
        d1 = new myobfuscated.cp.d();
        d1.a = s;
        d1.b = s1;
        d1.d = new WeakReference(c1);
        d1.c = s2;
        b.add(d1);
        return true;
    }

    public final void a(String s)
    {
        for (int i = 0; i < c.size(); i++)
        {
            b b1 = (b)c.get(i);
            if (b1.b.equals(s))
            {
                b1.cancel(true);
                c.remove(b1);
            }
        }

    }

    public final boolean a(String s, String s1, c c1, String s2)
    {
        return a(s, s1, c1, s2, null);
    }

    public final boolean a(String s, String s1, c c1, String s2, myobfuscated.cp.c c2)
    {
        int i = 0;
_L8:
        if (i >= c.size()) goto _L2; else goto _L1
_L1:
        b b1 = (b)c.get(i);
        if (!b1.b.equals(s)) goto _L4; else goto _L3
_L3:
        b1.a = new WeakReference(c1);
        b1.c = new WeakReference(c2);
        i = 1;
_L6:
        if (i != 0)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L6; else goto _L5
_L5:
        if (c.size() >= d)
        {
            b(s, s1, c1, s2);
            return false;
        }
        try
        {
            (new File(s1)).mkdirs();
        }
        catch (Exception exception) { }
        s = new b(c1, s, this, c2);
        c.add(s);
        s.a(new String[] {
            s1, s2
        });
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static 
    {
        a = d.b;
    }
}
