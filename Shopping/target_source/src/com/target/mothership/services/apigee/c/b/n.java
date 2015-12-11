// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.services.apigee.d.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            b

public class n
{
    public static class a
        implements k
    {

        public n a(l l1, Type type, j j)
            throws p
        {
            j = new f();
            type = (n)j.a(l1, type);
            n.a(type, (b)j.a(l1, com/target/mothership/services/apigee/c/b/b));
            j = l1.m();
            l1 = new ArrayList();
            if (j.a("orderItem"))
            {
                for (j = j.d("orderItem").iterator(); j.hasNext(); l1.add(com.target.mothership.services.apigee.d.d.a(((l)j.next()).m()))) { }
            }
            n.a(type, l1);
            return type;
        }

        public Object deserialize(l l1, Type type, j j)
            throws p
        {
            return a(l1, type, j);
        }

        public a()
        {
        }
    }


    private static final String YES = "Y";
    private b mAddress;
    private List mOrderItems;
    private String mOtherPhone;
    private String mPickUpEmail;
    private String mPickUpPersonName;
    private String mPickUpPhoneNumber;

    public n()
    {
    }

    static b a(n n1, b b1)
    {
        n1.mAddress = b1;
        return b1;
    }

    static List a(n n1, List list)
    {
        n1.mOrderItems = list;
        return list;
    }

    public String a()
    {
        return mPickUpPersonName;
    }

    public String b()
    {
        return mPickUpEmail;
    }

    public String c()
    {
        return mPickUpPhoneNumber;
    }

    public String d()
    {
        return mOtherPhone;
    }

    public List e()
    {
        return mOrderItems;
    }

    public b f()
    {
        return mAddress;
    }
}
