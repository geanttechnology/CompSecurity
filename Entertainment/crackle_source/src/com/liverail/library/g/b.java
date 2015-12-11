// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.g;

import com.liverail.library.b.a;
import java.util.ArrayList;

// Referenced classes of package com.liverail.library.g:
//            c

public class b
{

    public String a;
    public int b;
    public int c;
    public boolean d;
    public ArrayList e;

    public b()
    {
        c = -1;
        e = new ArrayList();
    }

    public c a(int i)
    {
        c c1;
        c c3;
        c3 = null;
        c1 = null;
        if (e == null) goto _L2; else goto _L1
_L1:
        c c2;
        int j;
        int k;
        k = e.size();
        j = 0;
        c2 = null;
_L6:
        if (j < k) goto _L4; else goto _L3
_L3:
        c3 = c1;
        if (c1 == null)
        {
            c3 = c1;
            if (c2 != null)
            {
                com.liverail.library.b.a.a((new StringBuilder("No creative found for desiredBitrate=")).append(i).append(" (using creative with minimum bitrate=").append(c2.b).append(")").toString());
                c3 = c2;
            }
        }
_L2:
        return c3;
_L4:
        c c4;
label0:
        {
            c4 = (c)e.get(j);
            if (c2 != null)
            {
                c3 = c2;
                if (c2.b <= c4.b)
                {
                    break label0;
                }
            }
            c3 = c4;
        }
        if (c4.b > i)
        {
            break; /* Loop/switch isn't completed */
        }
        c2 = c4;
        if (c1 != null)
        {
            if (c1.b >= c4.b)
            {
                break; /* Loop/switch isn't completed */
            }
            c2 = c4;
        }
_L7:
        j++;
        c1 = c2;
        c2 = c3;
        if (true) goto _L6; else goto _L5
_L5:
        c2 = c1;
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("[AdLinear type=")).append(a).append(" duration=").append(b);
        String s;
        if (c >= 0)
        {
            StringBuilder stringbuilder1 = (new StringBuilder(" skip=")).append(String.valueOf(c));
            if (d)
            {
                s = "%";
            } else
            {
                s = "";
            }
            s = stringbuilder1.append(s).toString();
        } else
        {
            s = "";
        }
        stringbuilder = stringbuilder.append(s);
        if (e != null)
        {
            s = (new StringBuilder(" assets=")).append(e.size()).toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).append("]").toString();
    }
}
