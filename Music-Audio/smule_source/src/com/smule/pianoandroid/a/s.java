// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.a:
//            k, a

public class s extends k
{

    public s()
    {
        super(null);
    }

    public int a()
    {
        return 1;
    }

    public volatile List a(List list, Map map)
    {
        return super.a(list, map);
    }

    public boolean a(Map map)
    {
        boolean flag;
        flag = true;
        map = ((Map) (a(a, map).get(0)));
        if (!(map instanceof Number)) goto _L2; else goto _L1
_L1:
        if (((Number)map).longValue() != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        return flag;
_L2:
        if (!(map instanceof String))
        {
            break; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty((String)map))
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (map instanceof Boolean)
        {
            return ((Boolean)map).booleanValue();
        }
        if (map == null)
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public volatile a a_(Map map)
    {
        return super.a_(map);
    }
}
