// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.internal.LinkedHashTreeMap;
import com.millennialmedia.google.gson.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class i extends com.millennialmedia.google.gson.i
{

    public static final j a = new j() {

        public final com.millennialmedia.google.gson.i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
        {
            if (a1.a == java/lang/Object)
            {
                return new i(b1, (byte)0);
            } else
            {
                return null;
            }
        }

    };
    private final com.millennialmedia.google.gson.b b;

    private i(com.millennialmedia.google.gson.b b1)
    {
        b = b1;
    }

    i(com.millennialmedia.google.gson.b b1, byte byte0)
    {
        this(b1);
    }

    public final Object a(a a1)
    {
        JsonToken jsontoken = a1.f();
        final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[JsonToken.values().length];
                try
                {
                    a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[JsonToken.STRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[JsonToken.NUMBER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[JsonToken.BOOLEAN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[JsonToken.NULL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (myobfuscated.ao._cls2.a[jsontoken.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            a1.a();
            for (; a1.e(); arraylist.add(a(a1))) { }
            a1.b();
            return arraylist;

        case 2: // '\002'
            LinkedHashTreeMap linkedhashtreemap = new LinkedHashTreeMap();
            a1.c();
            for (; a1.e(); linkedhashtreemap.put(a1.h(), a(a1))) { }
            a1.d();
            return linkedhashtreemap;

        case 3: // '\003'
            return a1.i();

        case 4: // '\004'
            return Double.valueOf(a1.l());

        case 5: // '\005'
            return Boolean.valueOf(a1.j());

        case 6: // '\006'
            a1.k();
            return null;
        }
    }

    public final void a(b b1, Object obj)
    {
        if (obj == null)
        {
            b1.e();
            return;
        }
        com.millennialmedia.google.gson.i j = b.a(obj.getClass());
        if (j instanceof i)
        {
            b1.c();
            b1.d();
            return;
        } else
        {
            j.a(b1, obj);
            return;
        }
    }

}
