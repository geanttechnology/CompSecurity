// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e;

import com.google.api.a.g.ab;
import com.google.api.a.g.l;
import java.io.IOException;

// Referenced classes of package com.google.api.a.e:
//            c

public class b extends l
    implements Cloneable
{

    private c jsonFactory;

    public b()
    {
    }

    public b clone()
    {
        return (b)super.clone();
    }

    public volatile l clone()
    {
        return clone();
    }

    public volatile Object clone()
    {
        return clone();
    }

    public final c getFactory()
    {
        return jsonFactory;
    }

    public b set(String s, Object obj)
    {
        return (b)super.set(s, obj);
    }

    public volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final void setFactory(c c1)
    {
        jsonFactory = c1;
    }

    public String toPrettyString()
    {
        if (jsonFactory != null)
        {
            return jsonFactory.a(this, true);
        } else
        {
            return super.toString();
        }
    }

    public String toString()
    {
        if (jsonFactory != null)
        {
            String s;
            try
            {
                s = jsonFactory.a(this, false);
            }
            catch (IOException ioexception)
            {
                throw ab.a(ioexception);
            }
            return s;
        } else
        {
            return super.toString();
        }
    }
}
