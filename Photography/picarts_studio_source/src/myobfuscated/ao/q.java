// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.b;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import myobfuscated.an.a;

final class q extends i
{

    private final Map a;
    private final Map b;

    public q(Class class1)
    {
        a = new HashMap();
        b = new HashMap();
        String s;
        Enum aenum[];
        Enum enum;
        a a1;
        int j;
        int k;
        try
        {
            aenum = (Enum[])class1.getEnumConstants();
            k = aenum.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError();
        }
        j = 0;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        enum = aenum[j];
        s = enum.name();
        a1 = (a)class1.getField(s).getAnnotation(myobfuscated/an/a);
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = a1.a();
        a.put(s, enum);
        b.put(enum, s);
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_41;
_L1:
    }

    public final Object a(com.millennialmedia.google.gson.stream.a a1)
    {
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        } else
        {
            return (Enum)a.get(a1.i());
        }
    }

    public final void a(b b1, Object obj)
    {
        obj = (Enum)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (String)b.get(obj);
        }
        b1.b(((String) (obj)));
    }
}
