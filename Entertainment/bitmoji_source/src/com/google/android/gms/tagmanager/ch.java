// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di

class ch extends aj
{

    private static final String ID;
    private static final String Wc;
    private static final String Wd;
    private static final String We;
    private static final String Wf;

    public ch()
    {
        super(ID, new String[] {
            Wc, Wd
        });
    }

    public boolean iy()
    {
        return true;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        Object obj = (com.google.android.gms.internal.d.a)map.get(Wc);
        com.google.android.gms.internal.d.a a1 = (com.google.android.gms.internal.d.a)map.get(Wd);
        if (obj == null || obj == di.ku() || a1 == null || a1 == di.ku())
        {
            return di.ku();
        }
        byte byte0 = 64;
        if (di.n((com.google.android.gms.internal.d.a)map.get(We)).booleanValue())
        {
            byte0 = 66;
        }
        map = (com.google.android.gms.internal.d.a)map.get(Wf);
        int i;
        if (map != null)
        {
            map = di.l(map);
            if (map == di.kp())
            {
                return di.ku();
            }
            int j = map.intValue();
            i = j;
            if (j < 0)
            {
                return di.ku();
            }
        } else
        {
            i = 1;
        }
        try
        {
            map = di.j(((com.google.android.gms.internal.d.a) (obj)));
            obj = di.j(a1);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return di.ku();
        }
        a1 = null;
        obj = Pattern.compile(((String) (obj)), byte0).matcher(map);
        map = a1;
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        map = a1;
        if (((Matcher) (obj)).groupCount() >= i)
        {
            map = ((Matcher) (obj)).group(i);
        }
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        return di.ku();
        map = di.r(map);
        return map;
    }

    static 
    {
        ID = a.ap.toString();
        Wc = b.bt.toString();
        Wd = b.bu.toString();
        We = b.cQ.toString();
        Wf = b.cK.toString();
    }
}
