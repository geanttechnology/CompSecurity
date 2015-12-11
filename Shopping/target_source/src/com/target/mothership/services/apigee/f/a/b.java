// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.common.params.AddressParams;
import java.lang.reflect.Type;

// Referenced classes of package com.target.mothership.services.apigee.f.a:
//            h

public class b extends h
{
    public static class a
        implements t
    {

        public l a(b b1, Type type, s s)
        {
            if (b.a(b1) == 1)
            {
                return b.b(b1);
            } else
            {
                return b.c(b1);
            }
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((b)obj, type, s);
        }

        public a()
        {
        }
    }


    public static final int FLAG_EXISTING_ADDRESS = 2;
    public static final int FLAG_NEW_ADDRESS = 1;
    private int mAddressFlag;
    private AddressParams mAddressParams;
    private com.target.mothership.common.params.b mCardParams;
    private String mExistingAddressId;

    public b(com.target.mothership.common.params.b b1)
    {
        mCardParams = b1;
        if (b1.e() != null)
        {
            mAddressFlag = 1;
            mAddressParams = b1.e();
            return;
        } else
        {
            mAddressFlag = 2;
            mExistingAddressId = b1.d();
            return;
        }
    }

    static int a(b b1)
    {
        return b1.mAddressFlag;
    }

    private o b()
    {
        o o1 = new o();
        a(o1, mCardParams, null);
        a(o1, mAddressParams);
        return o1;
    }

    static o b(b b1)
    {
        return b1.b();
    }

    private l c()
    {
        o o1 = new o();
        a(o1, mCardParams, null);
        a(o1, mExistingAddressId);
        return o1;
    }

    static l c(b b1)
    {
        return b1.c();
    }
}
