// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.j;

import com.google.b.f;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.j:
//            b, c

public final class a
    implements b
{

    private final f b;

    public a(f f1)
    {
        b = f1;
    }

    private static void a(String s)
    {
        if ("".equals(s))
        {
            throw new c("Could not deserialize empty string");
        } else
        {
            return;
        }
    }

    public final Object a(InputStream inputstream, Class class1)
    {
        try
        {
            inputstream = ((InputStream) (b.a(new com.google.b.d.a(new InputStreamReader(inputstream, "UTF-8")), class1)));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new c(inputstream);
        }
        return inputstream;
    }

    public final Object a(String s, Class class1)
    {
        a(s);
        try
        {
            s = ((String) (b.a(s, class1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new c(s);
        }
        return s;
    }

    public final Object a(String s, Type type)
    {
        a(s);
        try
        {
            s = ((String) (b.a(s, type)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new c(s);
        }
        return s;
    }

    public final String a(Object obj)
    {
        try
        {
            obj = b.b(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new c(((Throwable) (obj)));
        }
        return ((String) (obj));
    }
}
