// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.a:
//            g, a

public class r extends g
{

    public r()
    {
        super(null);
    }

    public boolean a(Map map)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (((a)iterator.next()).a(map))
            {
                return true;
            }
        }

        return false;
    }

    public volatile a a_(Map map)
    {
        return super.a_(map);
    }
}
