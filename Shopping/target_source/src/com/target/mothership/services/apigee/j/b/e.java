// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.j.b:
//            a

public class e
{
    public static class a
    {

        private String mAddressId;
        private List mAddressLines;
        private String mCity;
        private String mEveningPhone;
        private String mFirstName;
        private String mLastName;
        private String mMiddleName;
        private String mStateOrProvinceName;
        private String mZipCode;

        public String a()
        {
            return mFirstName;
        }

        public String b()
        {
            return mLastName;
        }

        public String c()
        {
            return mMiddleName;
        }

        public String d()
        {
            return mAddressId;
        }

        public List e()
        {
            return mAddressLines;
        }

        public String f()
        {
            return mCity;
        }

        public String g()
        {
            return mStateOrProvinceName;
        }

        public String h()
        {
            return mZipCode;
        }

        public String i()
        {
            return mEveningPhone;
        }

        public a()
        {
        }
    }

    public static class b
        implements k
    {

        public e a(l l1, Type type, j j1)
            throws p
        {
            j1 = new f();
            type = (e)j1.a(l1, type);
            e.a(type, (a)j1.a(l1, com/target/mothership/services/apigee/j/b/e$a));
            j1 = l1.m();
            l1 = new ArrayList();
            if (j1.a("orderItem"))
            {
                for (j1 = j1.d("orderItem").iterator(); j1.hasNext(); l1.add(com.target.mothership.services.apigee.j.b.a.b(((l)j1.next()).m()))) { }
            }
            e.a(type, l1);
            return type;
        }

        public Object deserialize(l l1, Type type, j j1)
            throws p
        {
            return a(l1, type, j1);
        }

        public b()
        {
        }
    }


    private static final String YES = "Y";
    private a mAddress;
    private String mGiftCardToEmail;
    private String mGiftCardToName;
    private String mGiftCardToPhone;
    private String mIsEligibleToChangeStorePickUp;
    private String mIsPickUpExtended;
    private List mOrderItems;
    private String mOtherPhone;
    private String mPickUpEmail;
    private String mPickUpPersonName;
    private String mPickUpPhoneNumber;

    public e()
    {
    }

    static a a(e e1, a a1)
    {
        e1.mAddress = a1;
        return a1;
    }

    static List a(e e1, List list)
    {
        e1.mOrderItems = list;
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
        return mIsEligibleToChangeStorePickUp;
    }

    public String e()
    {
        return mIsPickUpExtended;
    }

    public String f()
    {
        return mGiftCardToName;
    }

    public String g()
    {
        return mGiftCardToEmail;
    }

    public String h()
    {
        return mGiftCardToPhone;
    }

    public List i()
    {
        return mOrderItems;
    }

    public a j()
    {
        return mAddress;
    }
}
