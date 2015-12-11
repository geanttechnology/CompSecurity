// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            p, e, f, g, 
//            j, h

class i
{
    private static interface a
    {

        public abstract e a(Map map, p p);
    }


    private static Map a;

    static e a(String s, Map map, p p)
    {
        s = (a)a.get(s);
        if (s != null)
        {
            return s.a(map, p);
        } else
        {
            return null;
        }
    }

    static 
    {
        a = new HashMap();
        a.put("close", new a() {

            public e a(Map map, p p)
            {
                return new f(map, p);
            }

        });
        a.put("expand", new a() {

            public e a(Map map, p p)
            {
                return new g(map, p);
            }

        });
        a.put("usecustomclose", new a() {

            public e a(Map map, p p)
            {
                return new j(map, p);
            }

        });
        a.put("open", new a() {

            public e a(Map map, p p)
            {
                return new h(map, p);
            }

        });
    }
}
