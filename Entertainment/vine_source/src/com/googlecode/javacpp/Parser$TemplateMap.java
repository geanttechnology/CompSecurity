// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.util.LinkedHashMap;

// Referenced classes of package com.googlecode.javacpp:
//            Parser

static class defaults extends LinkedHashMap
{

    LinkedHashMap defaults;

    String get(String s)
    {
        String s1 = (String)super.get(s);
        if (s1 == null && defaults != null)
        {
            return (String)defaults.get(s);
        } else
        {
            return s1;
        }
    }

    ( )
    {
        defaults = null;
        defaults = ;
    }
}
