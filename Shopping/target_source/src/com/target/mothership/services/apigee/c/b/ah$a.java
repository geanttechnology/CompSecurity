// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import java.lang.reflect.Type;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            ah, i

public static class 
    implements k
{

    public ah a(l l1, Type type, j j1)
        throws p
    {
        type = new ah();
        l1 = l1.m();
        ah.a(type, (i)j1.a(l1, com/target/mothership/services/apigee/c/b/i));
        type.mOrderItem = a(l1, j1);
        return type;
    }

    public Object deserialize(l l1, Type type, j j1)
        throws p
    {
        return a(l1, type, j1);
    }

    public ()
    {
    }
}
