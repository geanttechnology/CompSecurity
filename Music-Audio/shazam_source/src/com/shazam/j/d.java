// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.j;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import org.simpleframework.xml.p;

// Referenced classes of package com.shazam.j:
//            b, c

public final class d
    implements b
{

    private final p b;

    public d(p p1)
    {
        b = p1;
    }

    public final Object a(InputStream inputstream, Class class1)
    {
        try
        {
            inputstream = ((InputStream) (b.a(class1, inputstream)));
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
        try
        {
            s = ((String) (b.a(class1, s)));
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
        try
        {
            s = ((String) (b.a(type, s)));
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
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            b.a(obj, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new c(((Throwable) (obj)));
        }
        return bytearrayoutputstream.toString();
    }
}
