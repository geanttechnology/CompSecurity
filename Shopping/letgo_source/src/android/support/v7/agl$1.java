// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

// Referenced classes of package android.support.v7:
//            agl, afl, ago, agq, 
//            aeu

class d extends d
{

    final afl a;
    final aeu b;
    final Field c;
    final agq d;
    final boolean e;
    final agl f;

    void a(JsonReader jsonreader, Object obj)
        throws IOException, IllegalAccessException
    {
        jsonreader = ((JsonReader) (a.b(jsonreader)));
        if (jsonreader != null || !e)
        {
            c.set(obj, jsonreader);
        }
    }

    void a(JsonWriter jsonwriter, Object obj)
        throws IOException, IllegalAccessException
    {
        obj = c.get(obj);
        (new ago(b, a, d.b())).a(jsonwriter, obj);
    }

    public boolean a(Object obj)
        throws IOException, IllegalAccessException
    {
        while (!h || c.get(obj) == obj) 
        {
            return false;
        }
        return true;
    }

    ception(agl agl1, String s, boolean flag, boolean flag1, aeu aeu, Field field, agq agq1, 
            boolean flag2)
    {
        f = agl1;
        b = aeu;
        c = field;
        d = agq1;
        e = flag2;
        super(s, flag, flag1);
        a = agl.a(f, b, c, d);
    }
}
