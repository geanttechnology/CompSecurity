// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import com.target.mothership.services.apigee.d.d;
import com.target.mothership.util.o;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            b

public class w
{
    public static class a
        implements k
    {

        public w a(l l1, Type type, j j1)
            throws p
        {
            j1 = new f();
            type = (w)j1.a(l1, type);
            w.a(type, (b)j1.a(l1, com/target/mothership/services/apigee/c/b/b));
            j1 = l1.m();
            l1 = new ArrayList();
            if (j1.a("orderItem"))
            {
                for (j1 = j1.d("orderItem").iterator(); j1.hasNext(); l1.add(com.target.mothership.services.apigee.d.d.a(((l)j1.next()).m()))) { }
            }
            w.a(type, l1);
            return type;
        }

        public Object deserialize(l l1, Type type, j j1)
            throws p
        {
            return a(l1, type, j1);
        }

        public a()
        {
        }
    }


    private static final String YES = "Y";
    private b mAddress;
    private String mDayPhone;
    private String mDigitalDownloadToEmail;
    private String mDigitalDownloadToName;
    private String mExpectedDeliveryDateString;
    private String mGiftCardFromName;
    private String mGiftCardToEmail;
    private String mGiftCardToMobile;
    private String mGiftCardToName;
    private List mOrderItems;
    private String mPickUpPersonName;
    private String mQuantityString;
    private String mShipModeCode;
    private String mShipModeDescription;
    private String mShipModeId;
    private String mShipmentNumberString;
    private String mSignatureRequiredString;

    public w()
    {
    }

    static b a(w w1, b b1)
    {
        w1.mAddress = b1;
        return b1;
    }

    static List a(w w1, List list)
    {
        w1.mOrderItems = list;
        return list;
    }

    public List a()
    {
        return mOrderItems;
    }

    public String b()
    {
        return mPickUpPersonName;
    }

    public String c()
    {
        return mShipModeCode;
    }

    public String d()
    {
        return mShipModeDescription;
    }

    public String e()
    {
        return mShipModeId;
    }

    public String f()
    {
        return mShipmentNumberString;
    }

    public boolean g()
    {
        return com.target.mothership.util.o.g(mSignatureRequiredString) && mSignatureRequiredString.equalsIgnoreCase("Y");
    }

    public String h()
    {
        return mQuantityString;
    }

    public String i()
    {
        return mDayPhone;
    }

    public b j()
    {
        return mAddress;
    }

    public String k()
    {
        return mGiftCardFromName;
    }

    public String l()
    {
        return mGiftCardToName;
    }

    public String m()
    {
        return mGiftCardToEmail;
    }

    public String n()
    {
        return mGiftCardToMobile;
    }

    public String o()
    {
        return mDigitalDownloadToEmail;
    }

    public String p()
    {
        return mDigitalDownloadToName;
    }
}
