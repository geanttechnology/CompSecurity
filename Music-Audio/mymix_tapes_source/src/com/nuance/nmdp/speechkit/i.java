// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import bf;
import cv;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            GenericResult

final class i
    implements GenericResult
{

    private String a;

    i()
    {
    }

    static String a(i j)
    {
        return j.a;
    }

    static String a(i j, String s)
    {
        j.a = s;
        return s;
    }

    final bf a()
    {
        return new bf() {

            private i a;

            public final boolean a()
            {
                return false;
            }

            public final boolean a(Object obj)
            {
                obj = (cv)obj;
                i.a(a, ((cv) (obj)).f("status"));
                return i.a(a) != null;
            }

            public final volatile Object b()
            {
                return a;
            }

            
            {
                a = i.this;
                super();
            }
        };
    }

    public final String getQueryResult()
    {
        return a;
    }
}
