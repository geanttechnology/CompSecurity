// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.f.b:
//            l

public static class 
    implements k
{

    public com.target.mothership.services.apigee.f.b.l a(l l1, Type type, j j)
        throws p
    {
        type = new com.target.mothership.services.apigee.f.b.l();
        l1 = l1.m();
        if (l1.a("protocolData"))
        {
            l1 = l1.b("protocolData").n().iterator();
            do
            {
                if (!l1.hasNext())
                {
                    break;
                }
                j = ((l)l1.next()).m();
                if (j.a("name") && j.a("value"))
                {
                    l.a(type).put(j.b("name").c(), j.b("value").c());
                }
            } while (true);
        }
        return type;
    }

    public Object deserialize(l l1, Type type, j j)
        throws p
    {
        return a(l1, type, j);
    }

    public ()
    {
    }
}
