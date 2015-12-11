// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.e.a;

import com.google.api.a.c.c.c;
import com.google.api.a.d.c.a;
import com.google.api.a.d.m;
import com.google.api.a.d.s;
import com.google.api.a.e.e;
import com.google.api.a.g.l;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

// Referenced classes of package com.google.api.a.c.e.a:
//            a

public abstract class b extends com.google.api.a.c.e.b
{

    private final Object jsonContent;

    public b(com.google.api.a.c.e.a.a a1, String s, String s1, Object obj, Class class1)
    {
        Object obj1 = null;
        if (obj == null)
        {
            obj1 = null;
        } else
        {
            a a2 = new a(a1.getJsonFactory(), obj);
            if (!Collections.unmodifiableSet(a1.getObjectParser().b).isEmpty())
            {
                obj1 = "data";
            }
            a2.b = ((String) (obj1));
            obj1 = a2;
        }
        super(a1, s, s1, ((com.google.api.a.d.i) (obj1)), class1);
        jsonContent = obj;
    }

    public com.google.api.a.c.e.a.a getAbstractGoogleClient()
    {
        return (com.google.api.a.c.e.a.a)super.getAbstractGoogleClient();
    }

    public volatile com.google.api.a.c.e.a getAbstractGoogleClient()
    {
        return getAbstractGoogleClient();
    }

    public Object getJsonContent()
    {
        return jsonContent;
    }

    protected c newExceptionOnError(s s)
    {
        return c.a(getAbstractGoogleClient().getJsonFactory(), s);
    }

    protected volatile IOException newExceptionOnError(s s)
    {
        return newExceptionOnError(s);
    }

    public final void queue(com.google.api.a.c.b.b b1, com.google.api.a.c.b.a.a a1)
    {
        super.queue(b1, com/google/api/a/c/c/b, a1);
    }

    public b set(String s, Object obj)
    {
        return (b)super.set(s, obj);
    }

    public volatile com.google.api.a.c.e.b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public b setDisableGZipContent(boolean flag)
    {
        return (b)super.setDisableGZipContent(flag);
    }

    public volatile com.google.api.a.c.e.b setDisableGZipContent(boolean flag)
    {
        return setDisableGZipContent(flag);
    }

    public b setRequestHeaders(m m)
    {
        return (b)super.setRequestHeaders(m);
    }

    public volatile com.google.api.a.c.e.b setRequestHeaders(m m)
    {
        return setRequestHeaders(m);
    }
}
