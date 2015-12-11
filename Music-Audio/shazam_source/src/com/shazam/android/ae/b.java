// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import com.shazam.b.e.a;

final class b
{

    private static String a(Class class1)
    {
        String s;
        int i;
        if (!class1.isAnonymousClass())
        {
            return class1.getSimpleName();
        }
        s = class1.getName();
        if (!com.shazam.b.e.a.a(s))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        i = s.lastIndexOf(".");
        Object obj;
        obj = s;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = s;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = s.substring(i + 1);
        return ((String) (obj));
        return "NO_NAME";
        obj;
        obj = class1.getName();
        return ((String) (obj));
    }

    static String a(Object obj)
    {
        if (obj instanceof Class)
        {
            return a((Class)obj);
        } else
        {
            return a(obj.getClass());
        }
    }
}
